package models;

import java.util.List;
import strategies.*;

public abstract class Order {

    private static int nextOrderId = 0;

    protected int orderId;
    protected User user;
    protected Restaurant restaurant;
    protected List<MenuItem> items;
    protected PaymentStrategy paymentStrategy;
    protected double total;
    protected String scheduled;

    public Order() {
        this.user = null;
        this.restaurant = null;
        this.paymentStrategy = null;
        this.total = 0.0;
        this.scheduled = "";
        this.orderId = ++nextOrderId;
    }

    public boolean processPayment(double amount){
        if(paymentStrategy==null) return false;
        paymentStrategy.pay(amount);
        return true;
    }

    public abstract String getType();

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }
}