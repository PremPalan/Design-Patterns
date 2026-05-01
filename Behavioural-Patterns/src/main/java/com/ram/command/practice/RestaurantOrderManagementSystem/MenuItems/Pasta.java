package com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems;

import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Item.Item;

public class Pasta implements Item {
    private final String name;

    public Pasta(String name) {
        this.name = name;
    }

    public float getPrice() {
        return 221.20F;
    }

    public String getName() {
        return name;
    }
}
