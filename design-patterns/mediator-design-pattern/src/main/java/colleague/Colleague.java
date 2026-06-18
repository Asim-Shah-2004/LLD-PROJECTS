package colleague;
import mediator.Mediator;

public abstract class Colleague {

    Mediator mediator;
    String name;

    Colleague(Mediator mediator, String name){
        this.mediator = mediator;
        this.name = name;
        mediator.register(this);
    }

    public abstract void send(String message,String to);
    public abstract void sendAll(String message);
    public abstract void receive(String message);
    
    public String getName(){
        return this.name;
    }
}
