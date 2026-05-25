package burger;

public class NormalBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing normal burger");
    }
}