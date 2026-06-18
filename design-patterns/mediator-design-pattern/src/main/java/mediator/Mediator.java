package mediator;

import colleague.Colleague;

public interface Mediator {
    void sendAll(String message, String from);

    void sendTo(String message, String to, String from);

    void register(Colleague colleague);
}