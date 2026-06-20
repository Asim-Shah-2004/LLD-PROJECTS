public class FlatDiscountStrategy implements DiscountStrategy{
    private double flatDiscount;

    public FlatDiscountStrategy(double flatDiscount){
        this.flatDiscount = flatDiscount;
    }

    @Override
    public double calculate(double amount){
        return flatDiscount;
    }
}
