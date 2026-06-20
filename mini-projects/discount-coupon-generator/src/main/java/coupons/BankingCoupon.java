public class BankingCoupon extends Coupon {
    String bank;
    double minSpend,percent,offset;
    DiscountStrategy discountStrategy;

    public BankingCoupon() {
        this("HDFC", 5000, 10, 100);
    }

    public BankingCoupon(String bank,double minSpend,double percent,double offset){
        this.bank = bank;
        this.minSpend = minSpend;
        this.percent = percent;
        this.offset = offset;
        this.discountStrategy = StrategyManager.getStrategy(StrategyType.PERCENT_WITH_CAP,percent,offset);
    }

    @Override
    public boolean isApplicable(Cart c){
        if(c.getTotalPrice()>=minSpend){
            return true;
        }
        return false;
    }
    @Override
    public double getDiscount(Cart c){
        return discountStrategy.calculate(c.getTotalPrice());
    }
    @Override
    public boolean isCombinable(){
        return true;
    }
}
