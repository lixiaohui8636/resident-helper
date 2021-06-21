// Copyright 2016 ubestkid Inc. All rights reserved.

package com.residenthelper.server.common;

/**
 * Description
 *
 * @author Snakecon (snakecon@gmail.com)
 */
public enum ApiErrorCode {
    LOGIN_FAILED(100001L,"登录失败"),
    USER_NOT_EXISTED(100002L,"用户不存在"),
    USER_IS_BLACK(100003L,"用户已被拉黑"),

    PHONE_NOT_VALID(300001L, "手机号不合法"),
    SMS_CODE_NOT_VALID(300002L, "验证码错误"),


    SYSTEM_ERROR(-100002L, "系统错误"),
    SYSTEM_PARAM_ERROR(-100003L, "参数错误"),
    REQUEST_LIMIT(-100004L, "访问限制");

    private long errorCode;
    private String message;

    ApiErrorCode(long errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public static ApiErrorCode parse(int intValue) {
        for (ApiErrorCode errorCode : ApiErrorCode.values()) {
            if (errorCode.errorCode == intValue) {
                return errorCode;
            }
        }
        return null;
    }
}
