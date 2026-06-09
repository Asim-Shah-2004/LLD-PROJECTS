package decorator;

import notification.Notification;

public class SignatureDecorator extends NotificationDecorator{

    String signature;

    public SignatureDecorator(Notification notification,String signature) {
        super(notification);
        this.signature = signature;
    }

    @Override
    public String getContent() {
        return notification.getContent()+signature;
    }
    
}