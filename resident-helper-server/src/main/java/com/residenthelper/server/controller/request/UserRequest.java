package com.residenthelper.server.controller.request;

/**
 * @Author: Lee
 * @Date: 6/21/21
 * @Desc:
 */
public class UserRequest {
    private String phone;
    private String smsCode;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
