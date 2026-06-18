package context;

import states.*;

public class VendingMachine {

    private VendingMachineState currentState;

    private NoCoinState noCoinState;
    private InsertCoinState insertCoinState;
    private DispenseState dispenseState;
    private SoldState soldState;

    public int itemCount;
    public int itemPrice;
    public int insertedCoins;

    public VendingMachine(int itemCount, int itemPrice) {
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;

        noCoinState = new NoCoinState();
        insertCoinState = new InsertCoinState();
        dispenseState = new DispenseState();
        soldState = new SoldState();

        if(itemCount>0){
            currentState = noCoinState;
        }
        else{
            currentState = soldState;
        }

    }

    public VendingMachineState getNoCoinState() {
        return noCoinState;
    }

    public VendingMachineState getInsertCoinState() {
        return insertCoinState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getSoldState() {
        return soldState;
    }

    public void insertCoin(int coins){
        currentState = currentState.insertCoin(this, coins);
    }

    public void returnCoin(){
        currentState = currentState.returnCoin(this);
    }

    public void selectItem(){
        currentState = currentState.selectItem(this);
    }

    public void dispense(){
        currentState = currentState.dispense(this);
    }

    public void refill(int quantity){
        currentState = currentState.refill(this, quantity);
    }

}