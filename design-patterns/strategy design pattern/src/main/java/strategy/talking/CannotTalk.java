package strategy.talking;

public class CannotTalk implements Talking{

    @Override
    public void talk() {
        System.out.println("Cannot Talk");
    }

}
