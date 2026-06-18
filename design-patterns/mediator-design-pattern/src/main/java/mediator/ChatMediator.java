package mediator;

import java.util.HashMap;
import colleague.Colleague;

public class ChatMediator implements Mediator {

    HashMap<String, Colleague> colleagueMap;

    public ChatMediator() {
        colleagueMap = new HashMap<>();
    }

    @Override
    public void sendAll(String message, String from) {
        for (String user : colleagueMap.keySet()) {
            if (!user.equals(from)) {
                colleagueMap.get(user).receive(message);
            }
        }
    }

    @Override
    public void sendTo(String message, String to, String from) {
        if (colleagueMap.containsKey(to)) {
            colleagueMap.get(to).receive(message);
        }
    }

    @Override
    public void register(Colleague colleague) {
        colleagueMap.put(colleague.getName(), colleague);
    }

}
