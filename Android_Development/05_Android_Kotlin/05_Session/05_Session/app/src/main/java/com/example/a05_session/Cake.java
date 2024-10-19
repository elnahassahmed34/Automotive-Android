package com.example.a05_session;

public class Cake {
    private String name;
    private int price;
    private String description;

    // Constructor
    public Cake(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Optional: toString() method for debugging purposes
    @Override
    public String toString() {
        return "Cake{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
