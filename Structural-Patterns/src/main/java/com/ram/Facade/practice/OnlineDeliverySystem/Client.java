package com.ram.Facade.practice.OnlineDeliverySystem;

import com.ram.Facade.practice.OnlineDeliverySystem.Facade.FoodDeliveryFacade;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        FoodDeliveryFacade facade = new FoodDeliveryFacade();

        facade.placeOrder(
                List.of("Pizza", "Burger"),
                499
        );
    }
}