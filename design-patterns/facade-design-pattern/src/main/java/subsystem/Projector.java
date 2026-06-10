package subsystem;

public class Projector {

    public enum AspectRatio { RATIO_16_9, RATIO_4_3, RATIO_21_9 }
    public enum Resolution  { HD_720P, FHD_1080P, UHD_4K }

    private boolean on;
    private boolean lampWarmedUp;
    private Resolution resolution;
    private AspectRatio aspectRatio;
    private int hdmiInput;

    public Projector() {
        this.on = false;
        this.lampWarmedUp = false;
        this.resolution = Resolution.FHD_1080P;
        this.aspectRatio = AspectRatio.RATIO_16_9;
        this.hdmiInput = 1;
    }

    public void turnOn() {
        this.on = true;
        System.out.println("[Projector] Lamp igniting... warming up (takes ~30s in real life).");
        this.lampWarmedUp = true;
        System.out.println("[Projector] Lamp ready. Projecting.");
    }

    public void turnOff() {
        System.out.println("[Projector] Cooling down lamp before shutdown...");
        this.lampWarmedUp = false;
        this.on = false;
        System.out.println("[Projector] Shut down.");
    }

    public void setResolution(Resolution res) {
        if (!on) throw new IllegalStateException("Projector is off.");
        this.resolution = res;
        System.out.println("[Projector] Resolution set to: " + res + ".");
    }

    public void setAspectRatio(AspectRatio ratio) {
        if (!on) throw new IllegalStateException("Projector is off.");
        this.aspectRatio = ratio;
        System.out.println("[Projector] Aspect ratio set to: " + ratio + ".");
    }

    public void selectHdmiInput(int input) {
        if (input < 1 || input > 4) throw new IllegalArgumentException("HDMI input must be 1-4.");
        this.hdmiInput = input;
        System.out.println("[Projector] HDMI input switched to port " + input + ".");
    }

    public boolean isOn() { return on; }
    public Resolution getResolution() { return resolution; }
}
