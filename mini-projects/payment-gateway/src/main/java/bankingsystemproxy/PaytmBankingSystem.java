package bankingsystemproxy;

import java.util.Random;

public class PaytmBankingSystem implements BankingSystem {
    private Random rand = new Random();

    public PaytmBankingSystem() {}

    @Override
    public boolean processPayment(double amount) {
        int r = rand.nextInt(100);
        return r < 80;
    }
}
