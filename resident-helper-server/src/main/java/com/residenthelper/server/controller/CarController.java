package com.residenthelper.server.controller;

import com.residenthelper.server.common.ApiResponse;
import com.residenthelper.server.service.car.CarService;
import com.residenthelper.server.service.car.bean.CarBean;
import com.residenthelper.server.service.car.bean.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lixiaohui
 * @date 6/2/22
 */
@RestController
@RequestMapping(value = "/api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping(value = "/add")
    public ApiResponse addCar(@RequestBody CarDto carDto){
        CarBean carBean = new CarBean();
        carBean.setCarNumber(carDto.getCarNumber());
        carBean.setCarName(carDto.getCarName());
        carBean.setCarPhone(carDto.getCarPhone());
        carBean.setHomeFloor(carDto.getHomeFloor());
        carBean.setHomeUnit(carDto.getHomeUnit());
        carBean.setHomeNumber(carDto.getHomeNumber());
        carBean.setStatus(CarBean.Status.ENABLED);
        carBean.setCreateTime(new Date());
        carBean.setUpdateTime(new Date());
        carService.addCar(carBean);
        return ApiResponse.ApiResponseBuilder
                .anApiResponseBuilder(carDto)
                .build();
    }

    @PostMapping(value = "/query")
    public ApiResponse queryCar(@RequestBody CarDto carDto){
        CarDto res = carService.queryCar(carDto.getCarNumber());
        return ApiResponse.ApiResponseBuilder
                .anApiResponseBuilder(res)
                .build();
    }

}
