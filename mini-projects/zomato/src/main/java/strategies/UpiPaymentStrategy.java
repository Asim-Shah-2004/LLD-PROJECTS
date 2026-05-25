package strategies;

public class UpiPaymentStrategy implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Paying via UPI");
    }
    
}