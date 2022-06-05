package com.residenthelper.server.service.token;

import com.residenthelper.server.common.ApiException;

/**
 * @author lixiaohui
 * @date 6/2/22
 */
public interface TokenService {
    public String generateToken(long userId) throws ApiException;

    public long findUserIdByToken(String token) throws ApiException;

}
