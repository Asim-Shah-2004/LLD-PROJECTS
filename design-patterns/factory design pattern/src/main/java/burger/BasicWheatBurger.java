package burger;

public class BasicWheatBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing basic wheat burger");
    }
}