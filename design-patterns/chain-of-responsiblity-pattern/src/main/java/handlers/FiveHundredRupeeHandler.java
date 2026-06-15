package handlers;

public class FiveHundredRupeeHandler extends Handler{
    
    private int noteCount;

    public FiveHundredRupeeHandler(int noteCount){
        this.noteCount = noteCount;
    }

    @Override
    void dispense(int amount) {
        int notesNeeded = amount / 500;
        
        if(notesNeeded <= noteCount){
            System.out.println(notesNeeded + " x 500 notes dispensed");
            amount = amount % 500;
        }
        
        if(amount > 0 && getHandler() != null){
            getHandler().dispense(amount);
        }
    }
}
