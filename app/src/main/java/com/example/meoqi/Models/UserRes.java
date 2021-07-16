package com.example.meoqi.Models;

import com.google.gson.annotations.SerializedName;

public class UserRes {
    String success;

    @SerializedName("response")
    User user;

    @Override
    public String toString() {
        return "UserRes{" +
                "success='" + success + '\'' +
                ", user=" + user +
                '}';
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
