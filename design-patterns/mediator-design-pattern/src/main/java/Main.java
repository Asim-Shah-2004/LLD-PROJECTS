import mediator.ChatMediator;
import colleague.ChatColleague;

public class Main {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediator();
        ChatColleague chatColleague1 = new ChatColleague(chatMediator, "Asim");
        ChatColleague chatColleague2 = new ChatColleague(chatMediator, "John");
        ChatColleague chatColleague3 = new ChatColleague(chatMediator, "Doe");
        chatColleague1.send("Hello", "John");
        chatColleague2.sendAll("Hello");
        chatColleague3.receive("Hello");
    }
}
