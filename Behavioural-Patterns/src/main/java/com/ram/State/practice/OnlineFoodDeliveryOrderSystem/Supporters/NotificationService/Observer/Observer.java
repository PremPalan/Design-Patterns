package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;

public interface Observer {
    void update(OrderState state);
}
