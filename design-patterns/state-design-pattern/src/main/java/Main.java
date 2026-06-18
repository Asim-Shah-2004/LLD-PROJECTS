package states;

import context.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(5, 10);

        machine.insertCoin(5);
        machine.insertCoin(5);
        machine.selectItem();
        machine.dispense();
        machine.returnCoin();

        machine.refill(10);

    }
}
