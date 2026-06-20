public abstract class Coupon {

    Coupon next;

    public Coupon setNext(Coupon next){
        this.next = next;
        return next;
    }

    public Coupon getNext(){
        return next;
    }

    public String name(){
        return this.getClass().getSimpleName();
    }

    public void applyDiscount(Cart cart){
        if(isApplicable(cart)){
            double discount = getDiscount(cart);
            cart.applyDiscount(discount);
            if(!isCombinable()) return;
        }

        if(next != null){
            next.applyDiscount(cart);
        }
    }

    public abstract boolean isApplicable(Cart c);
    public abstract double getDiscount(Cart c);
    public abstract boolean isCombinable();

}
