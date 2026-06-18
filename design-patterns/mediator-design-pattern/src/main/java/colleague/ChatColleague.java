package colleague;
import mediator.Mediator;

public class ChatColleague extends Colleague{
    
    public ChatColleague(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message, String to) {
        mediator.sendTo(message, to, name);
    }

    @Override
    public void sendAll(String message) {
        mediator.sendAll(message, name);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message: " + message);
    }
}
