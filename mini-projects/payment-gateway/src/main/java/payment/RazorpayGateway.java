package payment;

import bankingsystemproxy.RazorpayBankingSystem;
import models.PaymentRequest;

public class RazorpayGateway extends PaymentGateway {
    public RazorpayGateway() {
        this.bankingSystem = new RazorpayBankingSystem();
    }

    @Override
    protected boolean validatePayment(PaymentRequest request) {
        System.out.println("[Razorpay] Validating payment for " + request.sender + ".");
        if (request.amount <= 0) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean initiatePayment(PaymentRequest request) {
        System.out.println("[Razorpay] Initiating payment of " + request.amount
                + " " + request.currency + " for " + request.sender + ".");
        return bankingSystem.processPayment(request.amount);
    }

    @Override
    protected boolean confirmPayment(PaymentRequest request) {
        System.out.println("[Razorpay] Confirming payment for " + request.sender + ".");
        return true;
    }
}
