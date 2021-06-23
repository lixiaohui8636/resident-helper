package com.residenthelper.server.controller.request;

import com.residenthelper.server.service.sms.SmsEvent;

/**
 * @Author: Lee
 * @Date: 6/23/21
 * @Desc:
 */
public class VerifyRequest {
    private String phone;
    private SmsEvent smsEvent;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SmsEvent getSmsEvent() {
        return smsEvent;
    }

    public void setSmsEvent(SmsEvent smsEvent) {
        this.smsEvent = smsEvent;
    }
}
