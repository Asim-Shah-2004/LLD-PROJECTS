package strategy;

public class SmsNotification implements NotificationStrategy{

    @Override
    public void sendNotification(String content) {
        System.out.println("SMS SENT"+content);
    }

}