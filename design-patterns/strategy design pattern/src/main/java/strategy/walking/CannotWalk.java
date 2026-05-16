package strategy.walking;

public class CannotWalk implements Walking{

    @Override
    public void walk() {
        System.out.println("Cannot Walk");
    }

}