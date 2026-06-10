package controllers;

import commands.Command;
import java.util.ArrayList;
import java.util.List;

public class Remote{
    List<Command> commands = new ArrayList<>();
    List<Boolean> isPressed = new ArrayList<>();
    
    public Remote(int numberOfButtons) {
        for (int i = 0; i < numberOfButtons; i++) {
            commands.add(null);
            isPressed.add(false);
        }
    }

    public void setCommand(Command command,int index) {
        commands.set(index, command);
        isPressed.set(index, false);
    }

    public void pressButton(int index){
        if (commands.get(index) == null) {
            System.out.println("No command assigned to button " + index);
            return;
        }

        if(isPressed.get(index)==false){
            commands.get(index).execute();
        }else{
            commands.get(index).undo();
        }
        isPressed.set(index, !isPressed.get(index));
    }
}