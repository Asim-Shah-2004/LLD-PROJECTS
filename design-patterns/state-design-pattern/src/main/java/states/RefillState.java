package states;

import context.VendingMachine;

public class RefillState implements VendingMachineState{

    @Override
    public VendingMachineState insertCoin(VendingMachine machine, int coin) {
        System.out.println("Please wait for the current transaction to complete");
        return this;
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine machine) {
        System.out.println("Please wait for the current transaction to complete");
        return this;
    }

    @Override
    public VendingMachineState selectItem(VendingMachine machine) {
        System.out.println("Please wait for the current transaction to complete");
        return this;
    }

    @Override
    public VendingMachineState dispense(VendingMachine machine) {
        System.out.println("Please wait for the current transaction to complete");
        return this;
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        machine.itemCount += quantity;
        System.out.println("Machine refilled with " + quantity + " items");
        return machine.getNoCoinState();
    }
}
