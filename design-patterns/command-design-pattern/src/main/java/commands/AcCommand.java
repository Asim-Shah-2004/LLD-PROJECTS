package commands;

import appliances.Ac;

public class AcCommand implements Command{

    Ac ac;

    public AcCommand(Ac ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.on();
    }

    @Override
    public void undo() {
        ac.off();
    }

}