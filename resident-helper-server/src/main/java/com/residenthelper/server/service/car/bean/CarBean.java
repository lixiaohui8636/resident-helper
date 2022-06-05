package com.residenthelper.server.service.car.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiaohui
 * @date 6/2/22
 */
@Entity
@Table(name = "the_car", schema = "resident_helper", catalog = "")
public class CarBean implements Serializable {
    private static final long serialVersionUID = 5088403343125376160L;

    public static enum Status{
        ENABLED,DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(name = "car_number")
    private String carNumber;
    @Basic
    @Column(name = "car_name")
    private String carName;
    @Basic
    @Column(name = "car_phone")
    private String carPhone;
    @Basic
    @Column(name = "home_floor")
    private String homeFloor;
    @Basic
    @Column(name = "home_unit")
    private String homeUnit;
    @Basic
    @Column(name = "home_number")
    private String homeNumber;

    @Basic
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CarBean.Status status;
    @Basic
    @Column(name = "create_time")
    private Date createTime;
    @Basic
    @Column(name = "update_time")
    private Date updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarBean{");
        sb.append("id=").append(id);
        sb.append(", carNumber='").append(carNumber).append('\'');
        sb.append(", carName='").append(carName).append('\'');
        sb.append(", carPhone='").append(carPhone).append('\'');
        sb.append(", homeFloor='").append(homeFloor).append('\'');
        sb.append(", homeUnit='").append(homeUnit).append('\'');
        sb.append(", homeNumber='").append(homeNumber).append('\'');
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }
}
