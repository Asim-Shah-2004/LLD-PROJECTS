package states;

import context.VendingMachine;

public class SoldState implements VendingMachineState {

    @Override
    public VendingMachineState insertCoin(VendingMachine machine, int coin) {
        System.out.println("Machine is out of stock. Cannot insert coin. Returning " + coin + " coins.");
        return this;
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine machine) {
        System.out.println("No coins to return.");
        return this;
    }

    @Override
    public VendingMachineState selectItem(VendingMachine machine) {
        System.out.println("Machine is out of stock.");
        return this;
    }

    @Override
    public VendingMachineState dispense(VendingMachine machine) {
        System.out.println("Machine is out of stock.");
        return this;
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        machine.itemCount += quantity;
        System.out.println("Machine refilled with " + quantity + " items");
        return machine.getNoCoinState();
    }
}
