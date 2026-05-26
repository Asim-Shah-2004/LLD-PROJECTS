package channel;

import interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class YtChannel implements Observer{

    private List<Observable> subscribers = new ArrayList<>();
    private String name;
    private String latestVideo;

    public YtChannel(String name){
        this.name = name;
    }

    @Override
    public void add(Observable ob) {
        subscribers.add(ob);
    }

    @Override
    public void delete(Observable ob) {
        subscribers.remove(ob);
    }

    @Override
    public void notifyObservable() {
        for(Observable ob : subscribers){
            ob.update();
        }
    }

    public void uploadVideo(String video){
        latestVideo = video;
        notifyObservable();
    }

    public String getLatestVideo(){
        return latestVideo;
    }

}