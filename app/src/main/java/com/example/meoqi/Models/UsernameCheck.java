package com.example.meoqi.Models;

public class UsernameCheck {
    boolean unique;

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    @Override
    public String toString() {
        return "UsernameCheck{" +
                "unique=" + unique +
                '}';
    }
}
