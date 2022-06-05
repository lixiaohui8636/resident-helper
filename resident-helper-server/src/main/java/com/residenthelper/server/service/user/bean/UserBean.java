package com.residenthelper.server.service.user.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Lee
 * @Date: 6/9/21
 * @Desc:
 */
@Entity
@Table(name = "the_user", schema = "resident_helper", catalog = "")
public class UserBean implements Serializable {
    private static final long serialVersionUID = 8491700805675378223L;

    public static enum Status{
        ENABLED,DELETED
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "wechat_open_id")
    private String wechatOpenId;
    @Basic
    @Column(name = "nick_name")
    private String nickName;
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
    private Status status;
    @Basic
    @Column(name = "create_time")
    private Date createTime;
    @Basic
    @Column(name = "update_time")
    private Date updateTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
        final StringBuilder sb = new StringBuilder("UserBean{");
        sb.append("id=").append(id);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", wechatOpenId='").append(wechatOpenId).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", homeFloor='").append(homeFloor).append('\'');
        sb.append(", homeUnit='").append(homeUnit).append('\'');
        sb.append(", homeNumber='").append(homeNumber).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }
}
