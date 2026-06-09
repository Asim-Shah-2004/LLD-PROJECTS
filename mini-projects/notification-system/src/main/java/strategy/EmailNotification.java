package strategy;

public class EmailNotification implements NotificationStrategy{

    @Override
    public void sendNotification(String content) {
        System.out.println("Email Notification" + content);
    }

}