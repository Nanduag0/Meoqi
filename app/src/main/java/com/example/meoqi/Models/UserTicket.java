package com.example.meoqi.Models;

public class UserTicket {
    String _id,price,currency,user,referalID,people,transactionID;
    Event1 event;
    Ticket type;

    @Override
    public String toString() {
        return "UserTicket{" +
                "_id='" + _id + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                ", user='" + user + '\'' +
                ", referalID='" + referalID + '\'' +
                ", people='" + people + '\'' +
                ", transactionID='" + transactionID + '\'' +
                ", event=" + event +
                ", type=" + type +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getReferalID() {
        return referalID;
    }

    public void setReferalID(String referalID) {
        this.referalID = referalID;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Event1 getEvent() {
        return event;
    }

    public void setEvent(Event1 event) {
        this.event = event;
    }

    public Ticket getType() {
        return type;
    }

    public void setType(Ticket type) {
        this.type = type;
    }
}
