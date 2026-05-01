package com.ram.command.practice.RestaurantOrderManagementSystem.Reciever;

import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.*;
import com.ram.command.practice.RestaurantOrderManagementSystem.Order.Order;
import com.ram.command.practice.RestaurantOrderManagementSystem.RestaurantManagement;

public class InventorySystem {

    int pizza = 10, burger = 10, pasta = 10, coffee = 10, coke = 50, fries = 20;

    public void reserveInventory(Order order, RestaurantManagement orderManager) throws Exception {
        if(order.getItem() instanceof Pizza){
            if(order.getQuantity() > pizza){
                throw new Exception("Not enough pizzas");
            }else{
                pizza-= order.getQuantity();
            }
        }else if(order.getItem() instanceof Burger){
            if(order.getQuantity() > burger){
                throw new Exception("Not enough pizzas");
            }else{
                burger-= order.getQuantity();
            }
        }else if(order.getItem() instanceof Pasta){
            if(order.getQuantity() > pasta){
                throw new Exception("Not enough pizzas");
            } else{
                pasta-= order.getQuantity();
            }
        }else if(order.getItem() instanceof Coffee){
            if(order.getQuantity() > coffee){
                throw new Exception("Not enough pizzas");
            } else{
                coffee-= order.getQuantity();
            }
        }else if(order.getItem() instanceof Coke){
            if(order.getQuantity() > coke){
                throw new Exception("Not enough pizzas");
            } else{
                coke-= order.getQuantity();
            }
        } else if(order.getItem() instanceof Fries){
            if(order.getQuantity() > fries){
                throw new Exception("Not enough pizzas");
            }else{
                fries-= order.getQuantity();
            }
        }
    }
}
