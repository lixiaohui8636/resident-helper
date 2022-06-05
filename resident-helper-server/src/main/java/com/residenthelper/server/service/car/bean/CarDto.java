package com.residenthelper.server.service.car.bean;

import java.io.Serializable;

/**
 * @author lixiaohui
 * @date 6/2/22
 */
public class CarDto implements Serializable {
    private String carNumber;
    private String carName;
    private String carPhone;
    private String homeFloor;
    private String homeUnit;
    private String homeNumber;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPhone() {
        return carPhone;
    }

    public void setCarPhone(String carPhone) {
        this.carPhone = carPhone;
    }

    public String getHomeFloor() {
        return homeFloor;
    }

    public void setHomeFloor(String homeFloor) {
        this.homeFloor = homeFloor;
    }

    public String getHomeUnit() {
        return homeUnit;
    }

    public void setHomeUnit(String homeUnit) {
        this.homeUnit = homeUnit;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }


    public static final class CarDtoBuilder {
        private String carNumber;
        private String carName;
        private String carPhone;
        private String homeFloor;
        private String homeUnit;
        private String homeNumber;

        private CarDtoBuilder() {
        }

        public static CarDtoBuilder aCarDto() {
            return new CarDtoBuilder();
        }

        public CarDtoBuilder withCarBean(CarBean carBean) {
            this.carNumber = carBean.getCarNumber();
            this.carName = carBean.getCarName();
            this.carPhone = carBean.getCarPhone();
            this.homeFloor = carBean.getHomeFloor();
            this.homeUnit = carBean.getHomeUnit();
            this.homeNumber = carBean.getHomeNumber();
            return this;
        }

        public CarDto build() {
            CarDto carDto = new CarDto();
            carDto.setCarNumber(carNumber);
            carDto.setCarName(carName);
            carDto.setCarPhone(carPhone);
            carDto.setHomeFloor(homeFloor);
            carDto.setHomeUnit(homeUnit);
            carDto.setHomeNumber(homeNumber);
            return carDto;
        }
    }
}
