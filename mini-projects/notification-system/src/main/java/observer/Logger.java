package observer;

import observable.NotificationObserverable;

public class Logger implements Observer{

    private NotificationObserverable notificationObserverable;


    public Logger(NotificationObserverable notificationObserverable) {
        this.notificationObserverable = notificationObserverable;
    }

    @Override
    public void update() {
        System.out.println("Logged : "+notificationObserverable.getNotification());
    }
    
}