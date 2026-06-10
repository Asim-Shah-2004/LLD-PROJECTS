package subsystem;

public class SmartLighting {

    public enum Scene { BRIGHT, MOVIE, AMBIENT, OFF }

    private boolean systemArmed;
    private int brightnessPercent;
    private int colorTemperatureKelvin;
    private Scene activeScene;

    public SmartLighting() {
        this.systemArmed = false;
        this.brightnessPercent = 100;
        this.colorTemperatureKelvin = 4000;
        this.activeScene = Scene.BRIGHT;
    }

    public void armSystem() {
        this.systemArmed = true;
        System.out.println("[SmartLighting] System armed. All zones online.");
    }

    public void disarmSystem() {
        setScene(Scene.OFF);
        this.systemArmed = false;
        System.out.println("[SmartLighting] System disarmed.");
    }

    public void setBrightness(int percent) {
        if (!systemArmed) throw new IllegalStateException("Lighting system is not armed.");
        if (percent < 0 || percent > 100) throw new IllegalArgumentException("Brightness 0-100.");
        this.brightnessPercent = percent;
        System.out.println("[SmartLighting] Brightness → " + percent + "%.");
    }

    public void setColorTemperature(int kelvin) {
        if (!systemArmed) throw new IllegalStateException("Lighting system is not armed.");
        if (kelvin < 2700 || kelvin > 6500) throw new IllegalArgumentException("Kelvin range: 2700-6500.");
        this.colorTemperatureKelvin = kelvin;
        System.out.println("[SmartLighting] Color temp → " + kelvin + "K.");
    }

    public void setScene(Scene scene) {
        this.activeScene = scene;
        switch (scene) {
            case MOVIE:
                brightnessPercent = 5;
                colorTemperatureKelvin = 2700;
                System.out.println("[SmartLighting] Scene: MOVIE — dim warm glow.");
                break;
            case AMBIENT:
                brightnessPercent = 40;
                colorTemperatureKelvin = 3200;
                System.out.println("[SmartLighting] Scene: AMBIENT.");
                break;
            case BRIGHT:
                brightnessPercent = 100;
                colorTemperatureKelvin = 5500;
                System.out.println("[SmartLighting] Scene: BRIGHT — full daylight.");
                break;
            case OFF:
                brightnessPercent = 0;
                System.out.println("[SmartLighting] All lights OFF.");
                break;
        }
    }

    public boolean isArmed()      { return systemArmed; }
    public Scene getActiveScene() { return activeScene; }
}
