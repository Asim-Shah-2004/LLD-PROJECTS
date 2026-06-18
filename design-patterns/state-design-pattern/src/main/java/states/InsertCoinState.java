package states;

import context.VendingMachine;

public class InsertCoinState implements VendingMachineState{
    
    @Override
    public VendingMachineState insertCoin(VendingMachine machine, int coin) {
        machine.insertedCoins += coin;        
        System.out.println("Coins inserted: " + coin);
        return machine.getInsertCoinState();
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine machine) {
        System.out.println("Returning coins: " + machine.insertedCoins);
        machine.insertedCoins = 0;
        return machine.getNoCoinState();
    }

    @Override
    public VendingMachineState selectItem(VendingMachine machine) {
        if(machine.insertedCoins >= machine.itemPrice){
            machine.itemCount--;
            machine.insertedCoins -= machine.itemPrice;
            System.out.println("Item dispensed");
            return machine.getDispenseState();
        }
        else{
            System.out.println("Please insert more coins");
            return machine.getInsertCoinState();
        }
    }

    @Override
    public VendingMachineState dispense(VendingMachine machine) {
        System.out.println("Please select an item first");
        return machine.getInsertCoinState();        
    }

    @Override
    public VendingMachineState refill(VendingMachine machine, int quantity) {
        machine.itemCount += quantity;
        System.out.println("Machine refilled with " + quantity + " items");
        return machine.getInsertCoinState();
    }
}
