package com.residenthelper.server.controller;

import com.residenthelper.server.common.ApiException;
import com.residenthelper.server.common.ApiResponse;
import com.residenthelper.server.controller.request.UserRequest;
import com.residenthelper.server.service.user.UserService;
import com.residenthelper.server.service.user.bean.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Lee
 * @Date: 6/21/21
 * @Desc:
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginWithPhone")
    public ApiResponse loginWithPhone(@RequestBody UserRequest userRequest) throws ApiException {
        UserDto userDto = userService.loginByPhone(userRequest.getPhone(), userRequest.getSmsCode());
        return ApiResponse.ApiResponseBuilder
                .anApiResponseBuilder(userDto)
                .build();
    }
}
