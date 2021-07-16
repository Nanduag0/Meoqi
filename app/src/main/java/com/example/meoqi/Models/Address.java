package com.example.meoqi.Models;

public class Address {

    String country,state,city,location;

    public Address() {
    }

    public Address(String country, String state, String city, String location) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
