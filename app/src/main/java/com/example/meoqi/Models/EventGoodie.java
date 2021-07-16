package com.example.meoqi.Models;

import com.google.gson.annotations.SerializedName;

public class EventGoodie {
    String _id;

    @SerializedName("id")
    Goodie goodie;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Goodie getGoodie() {
        return goodie;
    }

    public void setGoodie(Goodie goodie) {
        this.goodie = goodie;
    }

    @Override
    public String toString() {
        return "EventGoodie{" +
                "_id='" + _id + '\'' +
                ", goodie=" + goodie +
                '}';
    }
}
