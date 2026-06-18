package states;

import context.VendingMachine;

public class NoCoinState implements VendingMachineState{
    
    @Override
    public VendingMachineState insertCoin(VendingMachine machine, int coin) {
        machine.insertedCoins += coin;        
        System.out.println("Coins inserted: " + coin);
        return machine.getInsertCoinState();
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine machine) {
        System.out.println("Please insert coins first");
        return machine.getNoCoinState();
    }

    @Override
    public VendingMachineState selectItem(VendingMachine machine) {
        System.out.println("Please insert coins first");
        return machine.getNoCoinState();
    }

    @Override
    public VendingMachineState dispense(VendingMachine machine) {
        System.out.println("Please insert coins first");
        return machine.getNoCoinState();        
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        machine.itemCount += quantity;
        System.out.println("Machine refilled with " + quantity + " items");
        return machine.getNoCoinState();
    }
}
