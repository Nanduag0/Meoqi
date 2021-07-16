package com.example.meoqi.Models;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class EventData {

    private EventArtist[] artists_performing;
    private EventFood[] food;
    private EventDrink[] drinks;
    private EventGoodie[] goodies;
    @SerializedName("ticket_types")
    private ArrayList<TicketType> ticketTypes;
    private String[] guest_list;
    private String[] images;
    private String[] categories;
    private String _id;
    private String name;
    private String description;
    private Address address;
    private Date start_date;
    private Date end_date;
    private String promotion;

    private int entry_fee;
    private String currency;

    public ArrayList<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(ArrayList<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public EventGoodie[] getGoodies() {
        return goodies;
    }

    public void setGoodies(EventGoodie[] goodies) {
        this.goodies = goodies;
    }

    public EventFood[] getFoods() {
        return food;
    }

    public void setFoods(EventFood[] food) {
        this.food = food;
    }

    public EventDrink[] getDrinks() {
        return drinks;
    }

    public void setDrinks(EventDrink[] drinks) {
        this.drinks = drinks;
    }

    public EventArtist[] getArtists_performing() {
        return artists_performing;
    }

    public void setArtists_performing(EventArtist[] artists_performing) {
        this.artists_performing = artists_performing;
    }

    public String[] getGuest_list() {
        return guest_list;
    }

    public void setGuest_list(String[] guest_list) {
        this.guest_list = guest_list;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public int getEntry_fee() {
        return entry_fee;
    }

    public void setEntry_fee(int entry_fee) {
        this.entry_fee = entry_fee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "EventData{" +
                "artists_performing=" + Arrays.toString(artists_performing) +
                ", food=" + Arrays.toString(food) +
                ", drinks=" + Arrays.toString(drinks) +
                ", goodies=" + Arrays.toString(goodies) +
                ", ticketTypes=" + ticketTypes +
                ", guest_list=" + Arrays.toString(guest_list) +
                ", images=" + Arrays.toString(images) +
                ", categories=" + Arrays.toString(categories) +
                ", _id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", promotion='" + promotion + '\'' +
                ", entry_fee=" + entry_fee +
                ", currency='" + currency + '\'' +
                '}';
    }
}
