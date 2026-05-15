package com.ram.Composite.practice.OnlineShoppingCartSystem.Leaf;

import com.ram.Composite.practice.OnlineShoppingCartSystem.Component.ProductComponent;

public class Product extends ProductComponent {

    private final String name;
    private final float price;
    private final String category;

    public Product(String name, float price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public void displayDetails() {
        displayDetails(0);
    }

    @Override
    public void displayDetails(int depth) {

        String indent = "   ".repeat(depth);

        System.out.println(
                indent + "Product: " + name + "\n"
                        + indent + "Price: " + price + "\n"
                        + indent + "Category: " + category + "\n"
        );
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}