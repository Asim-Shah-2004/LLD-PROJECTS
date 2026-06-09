package observable;

import java.util.ArrayList;
import java.util.List;
import notification.Notification;
import observer.Observer;

public class NotificationObserverable implements Observable{

    private List<Observer> observers = new ArrayList<>();
    private Notification notification;

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer ob : observers){
            ob.update();
        }
    }

    public String getNotification() {
        return notification.getContent();
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
        notifyObservers();
    }

}


