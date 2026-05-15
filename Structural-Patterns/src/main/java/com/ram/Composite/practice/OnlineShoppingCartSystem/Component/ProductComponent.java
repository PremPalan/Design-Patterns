package com.ram.Composite.practice.OnlineShoppingCartSystem.Component;

public abstract class ProductComponent {

    public abstract void displayDetails();

    public abstract void displayDetails(int depth);

    public abstract float getPrice();

    public abstract int getItemCount();
}