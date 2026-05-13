package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order;

import java.util.List;

public class Invoice {
    private List<Item> order;
    private float totalPrice;

    public Invoice(List<Item> order, float totalPrice) {
        this.order = order;
        this.totalPrice = totalPrice;
    }

    public void display(){
        for(Item item: order){
            System.out.println(item.getName() + " : " + item.getPrice() + "\n");
        }

        System.out.println("Total Price before GST : " + totalPrice);
        System.out.println("Final Price to be paid : " + (totalPrice * (18/100)));
    }
}
