package com.residenthelper.server.service.sms;

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
    public void sendSms(SmsEvent smsEvent, String phone);

    /**
     * 验证手机验证码
     * @param smsEvent 事件
     * @param phone 手机号
     * @param smsCode 验证码
     * @return
     */
    public boolean verifySmsCode(SmsEvent smsEvent, String phone, String smsCode);
}
