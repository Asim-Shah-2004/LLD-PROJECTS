package burger;

public class PremiumWheatBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing premium wheat burger");
    }
}