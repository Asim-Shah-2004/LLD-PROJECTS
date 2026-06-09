package strategy;

public class PushNotification implements NotificationStrategy{

    @Override
    public void sendNotification(String content) {
        System.out.println("Push Notification Sent" + content);
    }

}