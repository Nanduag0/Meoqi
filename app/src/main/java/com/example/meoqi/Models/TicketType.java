package com.example.meoqi.Models;

import com.google.gson.annotations.SerializedName;

public class TicketType {
    String _id,currency;
    Double price;

    @SerializedName("id")
    Ticket ticket;


    @Override
    public String toString() {
        return "TicketType{" +
                "id='" + _id + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", ticket=" + ticket +
                '}';
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String get_Id() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
