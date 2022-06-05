package com.residenthelper.server.service.token;

import com.residenthelper.server.common.ApiErrorCode;
import com.residenthelper.server.common.ApiException;
import com.residenthelper.server.service.cache.CacheableService;
import com.residenthelper.server.util.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author lixiaohui
 * @date 6/2/22
 */
@Component
public class TokenServiceImpl extends CacheableService implements TokenService {
    private static final int EXPIRE_MINUTES = 2 * 24 * 60;
    private static final String UID_SUFFIX = "resident:server:usertoken:uid:";
    private static final String TOKEN_SUFFIX = "resident:server:usertoken:token:";

    @Override
    public String generateToken(long userId) throws ApiException {

        String uidKey = UID_SUFFIX + userId;

        String oldToken = (String) getRedisCache(uidKey);
        //删除旧的token
        if (!StringUtils.isEmpty(oldToken)) {
            String oldTokenKey = TOKEN_SUFFIX + oldToken;
            deleteRedisCache(oldTokenKey);
        }
        String uuid = UUID.randomUUID().toString() + userId;
        String token = Md5Util.encrypt32(uuid);

        String tokenKey = TOKEN_SUFFIX + token;

        setRedisCache(uidKey, token, EXPIRE_MINUTES);
        setRedisCache(tokenKey, userId, EXPIRE_MINUTES);
        return token;
    }

    @Override
    public long findUserIdByToken(String token) throws ApiException {
        String tokenKey = TOKEN_SUFFIX + token;
        Long userId = (Long) getRedisCache(tokenKey);
        if (userId == null || userId <= 0) {
            throw new ApiException(ApiErrorCode.USER_TOKEN_EXPIRED);
        }
        return userId;
    }
}
