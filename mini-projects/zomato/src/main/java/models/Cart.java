package models;

import java.util.ArrayList;
import java.util.List;

public class Cart{
    private Restaurant restaurant;
    private List<MenuItem> items;

    public Cart(){
        restaurant = null;
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        if(restaurant==null){
            System.out.println("add a restaurant");
            return;
        }
        items.add(item);
    }

    public double getCost(){
        double cost = 0.0;
        for(MenuItem item : items){
            cost+=item.getPrice();
        }
        return cost;
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
}