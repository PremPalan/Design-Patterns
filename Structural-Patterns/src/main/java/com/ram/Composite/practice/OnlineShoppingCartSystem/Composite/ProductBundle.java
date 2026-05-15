package com.ram.Composite.practice.OnlineShoppingCartSystem.Composite;

import com.ram.Composite.practice.OnlineShoppingCartSystem.Component.ProductComponent;

import java.util.ArrayList;
import java.util.List;

public class ProductBundle extends ProductComponent {

    private String name;
    private List<ProductComponent> products;

    public ProductBundle(String name) {
        this.name = name;
        products = new ArrayList<>();
    }

    @Override
    public void displayDetails() {
        displayDetails(0);
    }

    @Override
    public void displayDetails(int depth) {

        String indent = "   ".repeat(depth);

        System.out.println(indent + "Bundle: " + name);

        for (ProductComponent product : products) {
            product.displayDetails(depth + 1);
        }
    }

    @Override
    public float getPrice() {

        float totalPrice = 0;

        for (ProductComponent product : products) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    @Override
    public int getItemCount() {

        int size = 0;

        for (ProductComponent item : products) {
            size += item.getItemCount();
        }

        return size;
    }

    public void addComponent(ProductComponent product) {
        products.add(product);
    }

    public void removeComponent(ProductComponent product) {
        products.remove(product);
    }
}