public class PercentDiscountStrategyWithCap implements DiscountStrategy{
    private double percent;
    private double maxDiscount;

    public PercentDiscountStrategyWithCap(double percent, double maxDiscount){
        this.percent = percent;
        this.maxDiscount = maxDiscount;
    }

    @Override
    public double calculate(double amount){
        double discount = amount * percent / 100;
        if(discount > maxDiscount){
            discount = maxDiscount;
        }
        return discount;
    }
}
