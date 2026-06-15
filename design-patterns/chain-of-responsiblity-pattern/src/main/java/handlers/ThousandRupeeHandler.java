package handlers;

public class ThousandRupeeHandler extends Handler{
    
    private int noteCount;

    public ThousandRupeeHandler(int noteCount){
        this.noteCount = noteCount;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 1000;
        
        if(notesNeeded <= noteCount){
            System.out.println(notesNeeded + " x 1000 notes dispensed");
            amount = amount % 1000;
        }
        
        if(amount > 0 && getHandler() != null){
            getHandler().dispense(amount);
        }
    }
}
