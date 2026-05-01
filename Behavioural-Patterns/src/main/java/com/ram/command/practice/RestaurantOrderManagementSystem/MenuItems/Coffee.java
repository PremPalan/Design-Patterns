package com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems;

import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Item.Item;

public class Coffee implements Item {

    private final String name;

    public Coffee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return 55.61F;
    }
}
