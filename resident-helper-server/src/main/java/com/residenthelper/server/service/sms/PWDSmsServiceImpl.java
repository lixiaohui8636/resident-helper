package com.residenthelper.server.service.sms;

import com.residenthelper.server.common.ApiErrorCode;
import com.residenthelper.server.common.ApiException;
import com.residenthelper.server.common.CacheService;
import com.residenthelper.server.util.Md5Util;
import org.springframework.stereotype.Service;

/**
 * @Author: Lee
 * @Date: 6/21/21
 * @Desc: 使用用户名密码替换验证码
 */
@Service
public class PWDSmsServiceImpl extends CacheService implements SmsService {


    @Override
    public void sendSms(SmsEvent smsEvent, String phone) throws ApiException {

    }

    @Override
    public void verifySmsCode(SmsEvent smsEvent, String phone, String smsCode) throws ApiException{
        String pwd = Md5Util.encrypt16("lxhnb" + phone);
        if(!pwd.equalsIgnoreCase(smsCode)){
            throw new ApiException(ApiErrorCode.SMS_CODE_NOT_VALID);
        }
    }

    public static void main(String[] args) {
        System.out.println(Md5Util.encrypt16("lxhnb13100698636"));
    }
}
