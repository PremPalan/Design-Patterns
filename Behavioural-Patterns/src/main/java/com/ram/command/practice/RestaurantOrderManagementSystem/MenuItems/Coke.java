package com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems;

import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Item.Item;

public class Coke implements Item {

    private final String name;

    public Coke(String name) {
        this.name = name;
    }

    public float getPrice() {
        return 40.00F;
    }

    public String getName() {
        return name;
    }
}
