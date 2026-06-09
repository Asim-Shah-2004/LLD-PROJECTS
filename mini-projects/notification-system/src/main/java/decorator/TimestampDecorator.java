package decorator;

import notification.Notification;

public class TimestampDecorator extends NotificationDecorator{


    public TimestampDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public String getContent() {
        return "[2026-01-01:00:00:00]"+notification.getContent(); 
    }
    
}