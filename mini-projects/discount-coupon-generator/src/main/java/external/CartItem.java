public class CartItem {
    Product p;
    int quantity;

    //Constructor for CartItem class
    public CartItem(Product p, int quantity) {
        this.p = p;
        this.quantity = quantity;
    }

    public double getPrice(){
        return p.getPrice() * quantity;
    }

    public String getName(){
        return p.getName();
    }

}
