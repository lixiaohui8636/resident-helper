package com.residenthelper.server.service.car;

import com.residenthelper.server.repository.CarRepository;
import com.residenthelper.server.service.car.bean.CarBean;
import com.residenthelper.server.service.car.bean.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lixiaohui
 * @date 6/2/22
 */
@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarRepository carRepository;

    @Override
    public void addCar(CarBean carBean) {
        carRepository.save(carBean);
    }

    @Override
    public CarDto queryCar(String carNumber) {
        carNumber = "%"+carNumber+"%";
        CarBean carBean = carRepository.findCarByLike(carNumber);
        if(carBean == null){
            return null;
        }
        return CarDto.CarDtoBuilder.aCarDto()
                .withCarBean(carBean)
                .build();
    }
}
