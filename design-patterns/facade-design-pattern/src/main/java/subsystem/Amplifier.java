package subsystem;

public class Amplifier {

    private boolean powered;
    private int volume;
    private String inputSource;
    private boolean surroundSound;

    public Amplifier() {
        this.powered = false;
        this.volume = 0;
        this.inputSource = "NONE";
        this.surroundSound = false;
    }

    public void powerOn() {
        this.powered = true;
        System.out.println("[Amplifier] Powering on... self-test passed.");
    }

    public void powerOff() {
        this.volume = 0;
        this.powered = false;
        System.out.println("[Amplifier] Volume faded to 0. Powering off.");
    }

    public void setVolume(int level) {
        if (!powered) throw new IllegalStateException("Amplifier is not powered on.");
        if (level < 0 || level > 100) throw new IllegalArgumentException("Volume must be 0-100.");
        this.volume = level;
        System.out.println("[Amplifier] Volume set to " + level + ".");
    }

    public void setInputSource(String source) {
        if (!powered) throw new IllegalStateException("Amplifier is not powered on.");
        this.inputSource = source;
        System.out.println("[Amplifier] Input source switched to: " + source + ".");
    }

    public void enableSurroundSound() {
        if (!powered) throw new IllegalStateException("Amplifier is not powered on.");
        this.surroundSound = true;
        System.out.println("[Amplifier] Dolby Surround Sound ENABLED.");
    }

    public void disableSurroundSound() {
        this.surroundSound = false;
        System.out.println("[Amplifier] Surround Sound DISABLED.");
    }

    public boolean isPowered() { return powered; }
    public int getVolume()     { return volume; }
    public String getInputSource() { return inputSource; }
}
