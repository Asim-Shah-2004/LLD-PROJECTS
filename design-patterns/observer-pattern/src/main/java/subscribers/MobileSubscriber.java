package subscribers;

import channel.YtChannel;
import interfaces.*;

public class MobileSubscriber implements Observable{

    private String name;
    private YtChannel channel;

    public MobileSubscriber(String name,YtChannel channel){
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update() {
        System.out.println("A new Video "+channel.getLatestVideo()+" was uploaded");
    }

}