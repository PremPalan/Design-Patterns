package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Context;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;

public class FoodOrder {
    private OrderState state;

    public void setState(OrderState state) {
        this.state = state;
    }

    public void handleRequest(){
        state.handleRequest();
    }
}
