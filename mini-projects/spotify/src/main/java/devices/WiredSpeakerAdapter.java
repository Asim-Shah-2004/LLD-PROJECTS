package devices;

import external.WiredSpeakerAPI;

public class WiredSpeakerAdapter implements AudioOutputDevice{
    WiredSpeakerAPI wiredSpeakerAPI;

    public WiredSpeakerAdapter(WiredSpeakerAPI wiredSpeakerAPI){
        this.wiredSpeakerAPI = wiredSpeakerAPI;
    }

    public void playSound(){
        wiredSpeakerAPI.playViaSpeaker();
    }

}
