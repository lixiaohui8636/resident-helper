// Copyright 2016 ubestkid Inc. All rights reserved.

package com.residenthelper.server.common;

/**
 * Description
 *
 * @author Snakecon (snakecon@gmail.com)
 */
public class ApiException extends Exception {

    private ApiErrorCode apiErrorCode;

    public ApiErrorCode getApiErrorCode() {
        return apiErrorCode;
    }

    public void setApiErrorCode(ApiErrorCode apiErrorCode) {
        this.apiErrorCode = apiErrorCode;
    }

    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(ApiErrorCode apiErrorCode) {
        super(apiErrorCode.getMessage());
        this.apiErrorCode = apiErrorCode;
    }

    public ApiException(ApiErrorCode apiErrorCode, Throwable cause) {
        super(apiErrorCode.getMessage(), cause);
        this.apiErrorCode = apiErrorCode;
    }

}
