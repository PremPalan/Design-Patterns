package com.ram.Command.practice.RestaurantOrderManagementSystem.MenuItems;

import com.ram.Command.practice.RestaurantOrderManagementSystem.MenuItems.Item.Item;

public class Fries implements Item {
    private final String name;

    public Fries(String name) {
        this.name = name;
    }

    public float getPrice() {
        return 89.32F;
    }

    public String getName() {
        return name;
    }
}
