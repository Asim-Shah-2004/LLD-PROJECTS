package decorator;

import notification.Notification;

public abstract class NotificationDecorator implements Notification{
    protected Notification notification;

    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }   
    
}