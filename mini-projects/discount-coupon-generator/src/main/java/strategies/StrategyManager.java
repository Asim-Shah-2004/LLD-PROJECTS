public class StrategyManager {
    public static DiscountStrategy getStrategy(StrategyType type, double param1) {
        return getStrategy(type, param1, 0.0);
    }

    public static DiscountStrategy getStrategy(StrategyType type, double param1, double param2){
        switch(type){
            case PERCENT:
                return new PercentDiscountStrategy(param1);
            case FLAT:
                return new FlatDiscountStrategy(param1);
            case PERCENT_WITH_CAP:
                return new PercentDiscountStrategyWithCap(param1, param2);
            default:
                return null;
        }
    }
}