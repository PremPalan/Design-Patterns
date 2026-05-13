package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order;

public class Item {
    private final String name;
    private final float price;

    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
