package com.residenthelper.server.service.sms;

import com.residenthelper.server.common.ApiErrorCode;
import com.residenthelper.server.common.ApiException;
import com.residenthelper.server.common.CacheService;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: Lee
 * @Date: 6/21/21
 * @Desc: 短信服务
 */
//@Service
public class SmsServiceImpl extends CacheService implements SmsService {
    public static final String SMS_CACHE_SUFFIX = "resident:sms:";
    public static final int SMS_CACHE_EXPIRE_MINUTES = 5;

    @Override
    public void sendSms(SmsEvent smsEvent, String phone) throws ApiException {
        //发送验证码
        String verifyCode = "123456";

        //存储到redis
        String cacheKey = SMS_CACHE_SUFFIX + phone + ":" + smsEvent;
        saveRedisCache(cacheKey, verifyCode, SMS_CACHE_EXPIRE_MINUTES);
    }

    @Override
    public void verifySmsCode(SmsEvent smsEvent, String phone, String smsCode) throws ApiException{
        String cacheKey = SMS_CACHE_SUFFIX + phone + ":" + smsEvent;
        String verifyCode = (String) getRedisCache(cacheKey);
        if(StringUtils.isEmpty(verifyCode) || !smsCode.equals(verifyCode)){
            throw new ApiException(ApiErrorCode.SMS_CODE_NOT_VALID);
        }
    }
}
