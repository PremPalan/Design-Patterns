package com.ram.Composite.practice.OnlineShoppingCartSystem;

import com.ram.Composite.practice.OnlineShoppingCartSystem.Composite.ProductBundle;
import com.ram.Composite.practice.OnlineShoppingCartSystem.Leaf.Product;

public class Main {

    public static void main(String[] args) {

        // Individual products
        Product laptop = new Product(
                "Laptop",
                75000,
                "Electronics"
        );

        Product mouse = new Product(
                "Gaming Mouse",
                2500,
                "Accessories"
        );

        Product keyboard = new Product(
                "Mechanical Keyboard",
                5500,
                "Accessories"
        );

        Product headset = new Product(
                "Gaming Headset",
                4000,
                "Audio"
        );

        Product webcam = new Product(
                "Webcam",
                3500,
                "Camera"
        );

        // Gaming Bundle
        ProductBundle gamingBundle = new ProductBundle("Gaming Bundle");

        gamingBundle.addComponent(mouse);
        gamingBundle.addComponent(keyboard);
        gamingBundle.addComponent(headset);

        // Streaming Bundle
        ProductBundle streamingBundle = new ProductBundle("Streaming Bundle");

        streamingBundle.addComponent(webcam);

        // Mega Bundle
        ProductBundle megaBundle = new ProductBundle("Mega Electronics Bundle");

        megaBundle.addComponent(laptop);
        megaBundle.addComponent(gamingBundle);
        megaBundle.addComponent(streamingBundle);

        // Display hierarchy
        megaBundle.displayDetails();

        // Display total price
        System.out.println("\nTotal Price: ₹" + megaBundle.getPrice());

        // Display total items
        System.out.println("Total Items: " + megaBundle.getItemCount());
    }
}
