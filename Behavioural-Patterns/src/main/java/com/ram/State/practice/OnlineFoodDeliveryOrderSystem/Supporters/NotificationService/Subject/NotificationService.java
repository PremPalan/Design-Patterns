package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Subject;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private OrderState orderState;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(OrderState state) {
        for (Observer observer : observers){
            observer.update(state);
        }
    }

    public void setOrderState(OrderState state){
        this.orderState = state;
        notifyObserver(orderState);
    }
}
