package com.example.meoqi.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EventArtist {

    String name,id,role,from,to;
    ArrayList<Image> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "EventArtist{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", images=" + images +
                '}';
    }
}
