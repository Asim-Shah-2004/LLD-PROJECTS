package subsystem;

public class CoolingSystem {

    public enum FanSpeed { OFF, LOW, MEDIUM, HIGH, TURBO }

    private boolean active;
    private double targetTempCelsius;
    private FanSpeed fanSpeed;
    private boolean airPurifierOn;
    private int filterHealthPercent;

    public CoolingSystem() {
        this.active = false;
        this.targetTempCelsius = 24.0;
        this.fanSpeed = FanSpeed.OFF;
        this.airPurifierOn = false;
        this.filterHealthPercent = 85;
    }

    public void activate() {
        this.active = true;
        System.out.println("[CoolingSystem] HVAC unit activated.");
        if (filterHealthPercent < 20) {
            System.out.println("[CoolingSystem] ⚠ WARNING: Air filter below 20% — replace soon.");
        }
    }

    public void deactivate() {
        setFanSpeed(FanSpeed.OFF);
        this.active = false;
        this.airPurifierOn = false;
        System.out.println("[CoolingSystem] HVAC unit deactivated.");
    }

    public void setTargetTemperature(double celsius) {
        if (!active) throw new IllegalStateException("Cooling system is not active.");
        if (celsius < 16 || celsius > 30) throw new IllegalArgumentException("Temp range: 16-30°C.");
        this.targetTempCelsius = celsius;
        System.out.println("[CoolingSystem] Target temperature → " + celsius + "°C.");
    }

    public void setFanSpeed(FanSpeed speed) {
        this.fanSpeed = speed;
        System.out.println("[CoolingSystem] Fan speed → " + speed + ".");
    }

    public void enableAirPurifier() {
        if (!active) throw new IllegalStateException("Cooling system is not active.");
        this.airPurifierOn = true;
        System.out.println("[CoolingSystem] Air purifier ON (HEPA + Activated Carbon).");
    }

    public boolean isActive()           { return active; }
    public double getTargetTemp()       { return targetTempCelsius; }
    public FanSpeed getFanSpeed()       { return fanSpeed; }
}
