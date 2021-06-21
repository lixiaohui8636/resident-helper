package com.residenthelper.server.service.user.bean;

import javax.persistence.Entity;
import javax.persistence.Table;
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
    public static enum Roler{
        /**超管*/
        ROOT,
        /**小区管理员*/
        ADMIN,
        /**居民*/
        RESIDENT
    }

    public static enum Status{
        /**正在状态*/
        ENABLE,
        /**已注销*/
        ZHUXIAO,
        /**黑名单*/
        BLACK
    }

    /**
     * 唯一ID
     */
    private long id;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 微信openId
     */
    private String wechatOpenId;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态
     */
    private Status status;

    private Date createTime;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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


    public static final class UserBeanBuilder {
        private String phone;
        private String wechatOpenId;
        private String nickName;
        private String avatar;

        private UserBeanBuilder() {
        }

        public static UserBeanBuilder anUserBean() {
            return new UserBeanBuilder();
        }

        public UserBeanBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBeanBuilder withWechatOpenId(String wechatOpenId) {
            this.wechatOpenId = wechatOpenId;
            return this;
        }

        public UserBeanBuilder withNickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public UserBeanBuilder withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public UserBean build() {
            UserBean userBean = new UserBean();
            userBean.setPhone(phone);
            userBean.setWechatOpenId(wechatOpenId);
            userBean.setNickName(nickName);
            userBean.setAvatar(avatar);
            userBean.setStatus(Status.ENABLE);
            return userBean;
        }
    }
}
