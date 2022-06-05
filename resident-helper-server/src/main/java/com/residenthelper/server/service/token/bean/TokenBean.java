package com.residenthelper.server.service.token.bean;

import java.io.Serializable;

/**
 * @author lixiaohui
 * @date 6/2/22
 */
public class TokenBean implements Serializable {
    private static final long serialVersionUID = -1158518037754736009L;
    private String token;
    private long userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TokenBean{");
        sb.append("token='").append(token).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
