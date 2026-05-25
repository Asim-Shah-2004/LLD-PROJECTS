package factory;

import burger.Burger;
import garlicbread.GarlicBread;

public interface FoodFactory{
    Burger createBurger(String type);
    GarlicBread createGarlicBread(String type);
}