package com.residenthelper.server.service.user;

import com.residenthelper.server.common.ApiErrorCode;
import com.residenthelper.server.common.ApiException;
import com.residenthelper.server.repository.UserRepository;
import com.residenthelper.server.service.sms.SmsEvent;
import com.residenthelper.server.service.sms.SmsService;
import com.residenthelper.server.service.user.bean.UserBean;
import com.residenthelper.server.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Lee
 * @Date: 6/21/21
 * @Desc: 用户操作类
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    SmsService smsService;

    /**
     * 登录/注册
     * @param phone
     * @param verifyCode
     * @return
     */
    @Override
    public UserBean loginByPhone(String phone, String verifyCode) throws ApiException{
        //验证手机合法性
        boolean verifyPhone = CommonUtil.isValidPhone(phone);
        if (!verifyPhone) {
            throw new ApiException(ApiErrorCode.PHONE_NOT_VALID);
        }
        //验证手机号和验证码的匹配性
        boolean verifySmsCode = smsService.verifySmsCode(SmsEvent.LOGIN, phone, verifyCode);
        if(!verifySmsCode){
            throw new ApiException(ApiErrorCode.SMS_CODE_NOT_VALID);
        }
        //1.查找是否已存在用户
        UserBean userBean = userRepository.findUserBeanByPhone(phone);

        if(userBean == null){
            //如果不存在，则新增一个用户，返回用户信息
            userBean = UserBean.UserBeanBuilder.anUserBean()
                    .withNickName("手机用户xxxx")
                    .withPhone(phone)
                    .build();
            //存储用户到数据库
            userRepository.save(userBean);
            //再次查询用户，验证保存结果
            userBean = userRepository.findUserBeanByPhone(phone);
            if(userBean == null){
                //存储失败，抛出异常
                throw new ApiException(ApiErrorCode.LOGIN_FAILED);
            }
        }
        return userBean;
    }

    /**
     * 查找用户
     * @param phone
     * @return
     */
    @Override
    public UserBean findUserByPhone(String phone) throws ApiException{
        UserBean userBean = userRepository.findUserBeanByPhone(phone);
        if(userBean == null){
            throw new ApiException(ApiErrorCode.USER_NOT_EXISTED);
        }
        if(userBean.getStatus() == UserBean.Status.BLACK){
            throw new ApiException(ApiErrorCode.USER_IS_BLACK);
        }
        return userBean;
    }

    /**
     * 提交注销
     * @param userId
     * @return
     */
    @Override
    public boolean zhuxiaoUser(long userId) {
        return false;
    }
}
