public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addProduct(new Product("Laptop", "Electronics", 100000));
        cart.addProduct(new Product("Mouse", "Electronics", 500));
        cart.addProduct(new Product("Keyboard", "Electronics", 1000));
        cart.addProduct(new Product("Monitor", "Electronics", 15000));
        cart.addProduct(new Product("Headphones", "Electronics", 5000));
        cart.addProduct(new Product("Webcam", "Electronics", 2000));
        cart.addProduct(new Product("Speaker", "Electronics", 3000));
        cart.addProduct(new Product("Microphone", "Electronics", 4000));
        cart.addProduct(new Product("Printer", "Electronics", 5000));
        cart.addProduct(new Product("Scanner", "Electronics", 6000));


        CouponManager manager = CouponManager.getInstance();
        manager.registerCoupon(new SeasonalCoupon());
        manager.registerCoupon(new LoyaltyCoupon());
        manager.registerCoupon(new BankingCoupon());

        manager.getApplicable(cart);
        manager.applyAll(cart);

        System.out.println("Original Price: " + cart.getTotalPrice());
        System.out.println("Final Price: " + cart.getCurrentTotal());
        System.out.println("Discount: " + (cart.getTotalPrice() - cart.getCurrentTotal()));
    }
}
