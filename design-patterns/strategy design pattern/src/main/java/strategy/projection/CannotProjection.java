package strategy.projection;

public class CannotProjection implements Projection{

    @Override
    public void project() {
        System.out.println("Cannot Project");
    }

}
