package states;

import context.VendingMachine;

public interface VendingMachineState {
    VendingMachineState insertCoin(VendingMachine machine,int coin);
    VendingMachineState selectItem(VendingMachine machine);
    VendingMachineState returnCoin(VendingMachine machine);
    VendingMachineState dispense(VendingMachine machine);
    VendingMachineState refill(VendingMachine machine,int quantity);
}

