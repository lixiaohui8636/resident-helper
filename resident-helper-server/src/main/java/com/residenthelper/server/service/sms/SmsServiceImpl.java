package com.residenthelper.server.service.sms;

import com.residenthelper.server.common.CacheService;
import org.springframework.stereotype.Service;

/**
 * @Author: Lee
 * @Date: 6/21/21
 * @Desc: 短信服务
 */
@Service
public class SmsServiceImpl extends CacheService implements SmsService {


    @Override
    public void sendSms(SmsEvent smsEvent, String phone) {

    }

    @Override
    public boolean verifySmsCode(SmsEvent smsEvent, String phone, String smsCode) {
        return false;
    }
}
