package com.example.meoqi.Models;

import java.util.ArrayList;

public class User {
    String _id;
    String username,first_name,last_name;
    ArrayList<UserTicket> tickets;

    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", tickets=" + tickets +
                '}';
    }

    public ArrayList<UserTicket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<UserTicket> tickets) {
        this.tickets = tickets;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
