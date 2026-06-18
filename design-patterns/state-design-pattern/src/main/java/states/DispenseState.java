package states;

import context.VendingMachine;

public class DispenseState implements VendingMachineState{

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
        System.out.println("Dispensing item");
        
        machine.insertedCoins = 0;
        if (machine.itemCount > 0) {
            return machine.getNoCoinState();
        } else {
            return machine.getSoldState();
        }
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        System.out.println("Please wait for the current transaction to complete");
        return this;
    }
}
