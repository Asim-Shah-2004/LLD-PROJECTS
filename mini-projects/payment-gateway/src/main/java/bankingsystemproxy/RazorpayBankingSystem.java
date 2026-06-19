package bankingsystemproxy;

import java.util.Random;

public class RazorpayBankingSystem implements BankingSystem {
    private Random rand = new Random();

    public RazorpayBankingSystem() {}

    @Override
    public boolean processPayment(double amount) {
        System.out.println("[BankingSystem-Razorpay] Processing payment of " + amount + "...");
        int r = rand.nextInt(100);
        return r < 90;
    }
}
