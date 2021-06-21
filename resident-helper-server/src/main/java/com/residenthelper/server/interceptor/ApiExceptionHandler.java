// Copyright 2016 ubestkid Inc. All rights reserved.

package com.residenthelper.server.interceptor;


import com.residenthelper.server.common.ApiErrorCode;
import com.residenthelper.server.common.ApiException;
import com.residenthelper.server.common.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description.
 *
 * @author Snakecon (snakecon@gmail.com).
 */
@ControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ApiResponse handleException(Exception exception) {
        log.error("Error occured.", exception);
        if (exception instanceof ApiException) {
            return new ApiResponse.ApiResponseBuilder<>()
                    .withApiException((ApiException) exception)
                    .build();
        }
        Throwable cause = exception.getCause();
        if(cause != null && cause instanceof ApiException){
            return new ApiResponse.ApiResponseBuilder()
                    .withApiException((ApiException) cause)
                    .build();
        }
        return new ApiResponse.ApiResponseBuilder()
                .withApiErrorCode(ApiErrorCode.SYSTEM_ERROR)
                .withErrorMessage(exception.getMessage())
                .withResult(exception)
                .build();
    }
}
