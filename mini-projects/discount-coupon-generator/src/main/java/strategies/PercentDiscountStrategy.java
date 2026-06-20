public class PercentDiscountStrategy implements DiscountStrategy{
    private double percent;

    public PercentDiscountStrategy(double percent){
        this.percent = percent;
    }

    @Override
    public double calculate(double amount){
        return amount * percent / 100;
    }
}
