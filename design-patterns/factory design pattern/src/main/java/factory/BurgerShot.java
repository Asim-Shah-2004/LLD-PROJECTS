package factory;

import burger.*;
import garlicbread.*;

public class BurgerShot implements FoodFactory{

    @Override
    public Burger createBurger(String type) {
        if(type=="basic"){
            return new BasicBurger();
        }else if(type=="normal"){
            return new NormalBurger();
        }else{
            return new PremiumBurger();
        }
    }

    @Override
    public GarlicBread createGarlicBread(String type) {
        if(type=="basic"){
            return new BasicGarlicBread();
        }else{
            return new CheeseGarlicBread();
        }
    }


}