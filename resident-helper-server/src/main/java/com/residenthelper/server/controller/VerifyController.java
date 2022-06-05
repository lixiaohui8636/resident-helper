package com.residenthelper.server.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Lee
 * @Date: 6/23/21
 * @Desc:
 */
@RestController
public class VerifyController {
    //@Autowired
    //private SmsService smsService;
    //
    //@RequestMapping(value = "/sendSms")
    //public ApiResponse sendSmsCode(@RequestBody VerifyRequest verifyRequest) throws ApiException{
    //    String phone = verifyRequest.getPhone();
    //    SmsEvent smsEvent = verifyRequest.getSmsEvent();
    //    if(!CommonUtil.isValidPhone(phone)){
    //        throw new ApiException(ApiErrorCode.PHONE_NOT_VALID);
    //    }
    //    if(smsEvent == null){
    //        throw new ApiException(ApiErrorCode.SYSTEM_PARAM_ERROR);
    //    }
    //    smsService.sendSms(verifyRequest.getSmsEvent(), phone);
    //    return ApiResponse.ApiResponseBuilder
    //            .anApiResponseBuilder("success")
    //            .build();
    //}
}
