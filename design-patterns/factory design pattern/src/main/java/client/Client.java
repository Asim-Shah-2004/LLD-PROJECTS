package client;

import burger.Burger;
import factory.*;
import garlicbread.GarlicBread;

public class Client {
    public static void main(String[] args) {
        FoodFactory burgerShot = new BurgerShot();
        FoodFactory burgerKing = new BurgerKing();
        Burger b1 = burgerShot.createBurger("basic");
        GarlicBread g1 = burgerKing.createGarlicBread("cheese");
        b1.prepare();
        g1.prepare();
    }
}