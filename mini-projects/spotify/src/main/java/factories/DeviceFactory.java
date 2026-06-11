package factories;

import devices.*;
import enums.DeviceType;
import external.*;

public class DeviceFactory {
    public AudioOutputDevice creatDevice(DeviceType dt){
        switch (dt) {
            case BLUETOOTH:
                return new BlueToothAdapter(new BlueToothAPI());
            case WIRED_SPEAKER:
                return new WiredSpeakerAdapter(new WiredSpeakerAPI());
            case HEADPHONE:
                return new HeadphoneAdapter(new HeadphoneAPI());
            default:
                return null;
        }
    }
}
