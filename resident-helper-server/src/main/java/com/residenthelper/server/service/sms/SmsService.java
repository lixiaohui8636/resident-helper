package com.residenthelper.server.service.sms;

import com.residenthelper.server.common.ApiException;

/**
 * @Author: Lee
 * @Date: 6/21/21
 * @Desc:
 */
public interface SmsService {

    /**
     * 发送验证码
     * @param smsEvent 事件
     * @param phone 手机号
     */
    public void sendSms(SmsEvent smsEvent, String phone) throws ApiException;

    /**
     * 验证手机验证码
     * @param smsEvent 事件
     * @param phone 手机号
     * @param smsCode 验证码
     * @return
     */
    public void verifySmsCode(SmsEvent smsEvent, String phone, String smsCode) throws ApiException;
}
