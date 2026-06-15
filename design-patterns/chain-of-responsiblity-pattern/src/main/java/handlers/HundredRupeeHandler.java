package handlers;

public class HundredRupeeHandler extends Handler{
    
    private int noteCount;

    public HundredRupeeHandler(int noteCount){
        this.noteCount = noteCount;
    }

    @Override
    void dispense(int amount) {
        int notesNeeded = amount / 100;
        
        if(notesNeeded <= noteCount){
            System.out.println(notesNeeded + " x 100 notes dispensed");
            amount = amount % 100;
        }
        
        if(amount > 0){
            System.out.println("Cannot dispense more");
        }
    }
}
