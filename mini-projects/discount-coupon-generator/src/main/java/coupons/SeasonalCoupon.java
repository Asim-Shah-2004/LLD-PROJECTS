public class SeasonalCoupon extends Coupon {
    DiscountStrategy ds;
    public SeasonalCoupon(){
        this.ds = StrategyManager.getStrategy(StrategyType.FLAT,20);
    }
    public boolean isApplicable(Cart c){
        return true;
    }
    public double getDiscount(Cart c){
        return ds.calculate(c.getTotalPrice());
    }
    public boolean isCombinable(){
        return true;
    }
}
