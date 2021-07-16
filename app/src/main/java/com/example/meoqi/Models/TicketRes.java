package com.example.meoqi.Models;

public class TicketRes {
    String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "TicketRes{" +
                "success='" + success + '\'' +
                '}';
    }
}
