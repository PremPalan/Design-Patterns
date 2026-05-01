package com.ram.command.practice.RestaurantOrderManagementSystem.Reciever;

import com.ram.command.practice.RestaurantOrderManagementSystem.Order.Order;
import com.ram.command.practice.RestaurantOrderManagementSystem.RestaurantManagement;

import java.util.HashMap;
import java.util.Map;

public class BillingSystem {
    private float totalBill = 0;
    Map<Integer,Float> bill = new HashMap<>();

    public void addToBill(Order order, RestaurantManagement orderManager) {
        int tableNo = order.getTableNo();
        if(bill.containsKey(tableNo)){
            bill.replace(tableNo, (bill.get(tableNo) + order.getTotalPrice()));
        }else{
            bill.put(tableNo, order.getTotalPrice());
        }
    }

    public float getTotalBill(Integer tableNo){
        return bill.get(tableNo);
    }
}
