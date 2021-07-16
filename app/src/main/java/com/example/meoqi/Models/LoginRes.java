package com.example.meoqi.Models;

import com.google.gson.annotations.SerializedName;

public class LoginRes {
    String token;

    @SerializedName("response")
    User user;

    @Override
    public String toString() {
        return "LoginRes{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }

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
}
