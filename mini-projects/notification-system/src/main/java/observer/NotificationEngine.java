package observer;

import java.util.ArrayList;
import java.util.List;
import observable.NotificationObserverable;
import strategy.NotificationStrategy;

public class NotificationEngine implements Observer{

    private NotificationObserverable notificationObserverable;
    private List<NotificationStrategy> notificationStrategies = new ArrayList<>();

    
    public NotificationEngine(NotificationObserverable notificationObserverable) {
        this.notificationObserverable = notificationObserverable;
    }

    public void addNotificationStrategy(NotificationStrategy notificationStrategy){
        notificationStrategies.add(notificationStrategy);
    }

    @Override
    public void update() {
        String notificationContent = notificationObserverable.getNotification();
        for(NotificationStrategy ns : notificationStrategies){
            ns.sendNotification(notificationContent);
        }
    }
    
}