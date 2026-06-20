public class LoyaltyCoupon extends Coupon {
    DiscountStrategy ds;
    public LoyaltyCoupon(){
        this.ds = StrategyManager.getStrategy(StrategyType.PERCENT,10);
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
