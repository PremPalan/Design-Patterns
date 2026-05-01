package com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems;

import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Item.Item;

public class Pizza implements Item {
    private final String name;

    public Pizza(String name) {
        this.name = name;
    }

    public float getPrice() {
        return 321.41F;
    }

    public String getName() {
        return name;
    }
}
