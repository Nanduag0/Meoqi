package com.example.meoqi.Models;

import com.google.gson.annotations.SerializedName;

public class EventDrink {
    String _id;

    @SerializedName("id")
    Drink drink;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "EventDrink{" +
                "_id='" + _id + '\'' +
                ", drink=" + drink +
                '}';
    }
}
