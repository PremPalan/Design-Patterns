package com.ram.Command.practice.RestaurantOrderManagementSystem.MenuItems;

import com.ram.Command.practice.RestaurantOrderManagementSystem.MenuItems.Item.Item;

public class Burger implements Item {
    private final String name;

    public Burger(String name) {
        this.name = name;
    }

    public float getPrice() {
        return 109.41F;
    }

    public String getName() {
        return name;
    }
}
