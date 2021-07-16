package com.example.meoqi.Models;

public class EventsModel  {

    String eventName;
    String date;
    String month;

    //int image_id;
    int image_id2;

    String image_id;

    public EventsModel(String eventName, String date, String month, String image_id, int image_id2) {
        this.eventName = eventName;
        this.date = date;
        this.month = month;
        this.image_id = image_id;
        this.image_id2 = image_id2;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public int getImage_id2() {
        return image_id2;
    }

    public void setImage_id2(int image_id2) {
        this.image_id2 = image_id2;
    }
}
