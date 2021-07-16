package com.example.meoqi.Models;

import com.google.gson.annotations.SerializedName;

public class EventFood {
    String _id;

    @SerializedName("id")
    Food food;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "EventFood{" +
                "_id='" + _id + '\'' +
                ", food=" + food +
                '}';
    }
}
