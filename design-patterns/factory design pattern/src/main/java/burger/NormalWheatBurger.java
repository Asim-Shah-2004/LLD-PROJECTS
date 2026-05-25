package burger;

public class NormalWheatBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing normal wheat burger");
    }
}