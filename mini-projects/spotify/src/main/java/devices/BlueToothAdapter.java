package devices;

import external.BlueToothAPI;

public class BlueToothAdapter implements AudioOutputDevice{

    BlueToothAPI blueToothAPI;

    public BlueToothAdapter(BlueToothAPI blueToothAPI){
        this.blueToothAPI = blueToothAPI;
    }

    @Override
    public void playSound() {
        blueToothAPI.playViaBluetooth();
    }
    
}
