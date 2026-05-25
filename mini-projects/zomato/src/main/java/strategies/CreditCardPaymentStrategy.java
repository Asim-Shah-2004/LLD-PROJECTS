package strategies;

public class CreditCardPaymentStrategy implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("PAYING VIA CARD");
    }

}