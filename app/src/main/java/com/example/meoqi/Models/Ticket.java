package com.example.meoqi.Models;

public class Ticket {
    String name,description,food,drinks,goodies;
    String _id;

    @Override
    public String toString() {
        return "Ticket{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", food='" + food + '\'' +
                ", drinks='" + drinks + '\'' +
                ", goodies='" + goodies + '\'' +
                ", _id='" + _id + '\'' +
                '}';
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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public String getGoodies() {
        return goodies;
    }

    public void setGoodies(String goodies) {
        this.goodies = goodies;
    }
}
