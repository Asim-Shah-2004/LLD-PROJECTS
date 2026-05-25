package managers;

import java.util.ArrayList;
import java.util.List;
import models.*;

public class RestaurantManager {

    private List<Restaurant> restaurants = new ArrayList<>();
    private static RestaurantManager instance = null;


    private RestaurantManager() {
    }

    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> listRestaurant() {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            result.add(restaurant);
        }
        return result;
    }
    
}