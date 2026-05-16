package strategy.flying;

public class CannotFly implements Flying{

    @Override
    public void fly() {
        System.out.println("Cannot Fly");
    }

}
