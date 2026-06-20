import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> items;
    boolean isLoyaltyMember;
    double originalPrice;
    double finalPrice = -1.0;

    public Cart() {
        items = new ArrayList<>();
        isLoyaltyMember = false;
    }

    public void addProduct(Product p) {
        addProduct(p, 1);
    }

    public void addProduct(Product p, int quantity){
        items.add(new CartItem(p, quantity));
    }

    public void setLoyaltyMember(boolean isLoyaltyMember){
        this.isLoyaltyMember = isLoyaltyMember;
    }

    public double getTotalPrice(){
        double total = 0;
        for(CartItem item : items){
            total += item.getPrice();
        }
        return total;
    }

    public double getCurrentTotal() {
        return finalPrice < 0 ? getTotalPrice() : finalPrice;
    }

    public void applyDiscount(double discountAmt){
        if (finalPrice < 0) {
            finalPrice = getTotalPrice();
        }
        finalPrice -= discountAmt;
    }
}
