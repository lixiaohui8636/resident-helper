package com.residenthelper.server.service.user;

import com.residenthelper.server.common.ApiException;
import com.residenthelper.server.service.user.bean.UserBean;
import com.residenthelper.server.service.user.bean.UserDto;

/**
 * @Author: Lee
 * @Date: 6/10/21
 * @Desc:
 */
public interface UserService {
    public UserDto loginByPhone(String phone, String verifyCode) throws ApiException;
    public UserBean findUserByPhone(String phone) throws ApiException;
    public UserBean findUserByToken(String token) throws ApiException;
    public boolean zhuxiaoUser(long userId);
}
