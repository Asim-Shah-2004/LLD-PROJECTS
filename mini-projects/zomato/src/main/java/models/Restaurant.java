package models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant{
    private static int nextRestaurantId = 0;
    private int RestaurantId;
    private String name;
    private String location;
    private List<MenuItem> menu = new ArrayList<>();

    public Restaurant(String name,String location){
        this.name = name;
        this.location = location;
        this.RestaurantId = ++nextRestaurantId;
    }

    public int getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(int RestaurantId) {
        this.RestaurantId = RestaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

}
