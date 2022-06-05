package com.residenthelper.server.service.user.bean;

import com.residenthelper.server.util.CommonUtil;

import java.io.Serializable;

/**
 * @author lixiaohui
 * @date 6/2/22
 */
public class UserDto {
    private String token;
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static class User implements Serializable {
        private static final long serialVersionUID = 1017846021497616892L;
        private long userId;
        private String nickName;
        private String encryptPhone;

        public User() {
        }

        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getEncryptPhone() {
            return encryptPhone;
        }

        public void setEncryptPhone(String encryptPhone) {
            this.encryptPhone = encryptPhone;
        }
    }


    public static final class UserDtoBuilder {
        private String token;
        private long userId;
        private String nickName;
        private String encryptPhone;

        private UserDtoBuilder() {
        }

        public static UserDtoBuilder anUserDto() {
            return new UserDtoBuilder();
        }

        public UserDtoBuilder withToken(String token) {
            this.token = token;
            return this;
        }

        public UserDtoBuilder withUser(UserBean userBean){
            this.userId = userBean.getId();
            this.nickName = userBean.getNickName();
            this.encryptPhone = CommonUtil.phoneEncrypt(userBean.getPhone());
            return this;
        }

        public UserDto build() {
            UserDto userDto = new UserDto();
            userDto.setToken(token);
            User user = new User();
            user.setUserId(userId);
            user.setNickName(nickName);
            user.setEncryptPhone(encryptPhone);
            userDto.setUser(user);
            return userDto;
        }
    }
}
