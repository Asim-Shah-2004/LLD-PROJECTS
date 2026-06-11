package managers;

import factories.*;
import devices.AudioOutputDevice;
import enums.DeviceType;

public class DeviceManager {
    public AudioOutputDevice connect(DeviceType dt){
        DeviceFactory df = new DeviceFactory();
        AudioOutputDevice aod = df.creatDevice(dt);
        return aod;
    }
}
