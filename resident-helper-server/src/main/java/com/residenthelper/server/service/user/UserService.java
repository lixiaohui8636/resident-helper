package com.residenthelper.server.service.user;

import com.residenthelper.server.common.ApiException;
import com.residenthelper.server.service.user.bean.UserBean;

/**
 * @Author: Lee
 * @Date: 6/10/21
 * @Desc:
 */
public interface UserService {
    public UserBean loginByPhone(String phone, String verifyCode) throws ApiException;
    public UserBean findUserByPhone(String phone) throws ApiException;
    public boolean zhuxiaoUser(long userId);
}
