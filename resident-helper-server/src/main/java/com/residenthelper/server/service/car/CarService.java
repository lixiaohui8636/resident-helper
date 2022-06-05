package com.residenthelper.server.service.car;

import com.residenthelper.server.service.car.bean.CarBean;
import com.residenthelper.server.service.car.bean.CarDto;

/**
 * @author lixiaohui
 * @date 6/2/22
 */
public interface CarService {
    public void addCar(CarBean carBean);
    public CarDto queryCar(String carNumber);
}
