package devices;

import external.HeadphoneAPI;

public class HeadphoneAdapter implements AudioOutputDevice{
    HeadphoneAPI headphoneAPI;

    public HeadphoneAdapter(HeadphoneAPI headphoneAPI){
        this.headphoneAPI = headphoneAPI;
    }

    public void playSound(){
        headphoneAPI.playViaHeadphone();
    }

}
