package services;

import java.util.ArrayList;
import java.util.List;
import notification.*;
import observable.NotificationObserverable;

public class NotificationService{
    private NotificationObserverable observerable;
    private static NotificationService instance;
    private List<Notification> notifications = new ArrayList<>();

    private NotificationService(){
        observerable = new NotificationObserverable();
    }

    public static NotificationService getInstance(){
        if(instance == null){
            instance = new NotificationService();  
        }
        return instance;
    }

    public NotificationObserverable getObservable(){
        return observerable;
    }

    public void sendNotification(Notification notification){
        notifications.add(notification);
        observerable.setNotification(notification);
    }

}