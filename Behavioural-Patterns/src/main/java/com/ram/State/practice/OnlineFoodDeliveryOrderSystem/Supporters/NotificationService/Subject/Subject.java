package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Subject;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(OrderState state);
}
