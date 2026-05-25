package factory;

import burger.*;
import garlicbread.*;

public class BurgerKing implements FoodFactory{

    @Override
    public Burger createBurger(String type) {
        if(type=="basic"){
            return new BasicWheatBurger();
        }else if(type=="normal"){
            return new NormalWheatBurger();
        }else{
            return new PremiumWheatBurger();
        }
    }

    @Override
    public GarlicBread createGarlicBread(String type) {
        if(type=="basic"){
            return new WheatBasicGarlicBread();
        }else{
            return new WheatCheeseGarlicBread();
        }
    }

}
