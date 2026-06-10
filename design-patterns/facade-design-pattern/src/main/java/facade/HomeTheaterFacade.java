package facade;

import subsystem.Amplifier;
import subsystem.CoolingSystem;
import subsystem.CoolingSystem.FanSpeed;
import subsystem.Projector;
import subsystem.Projector.AspectRatio;
import subsystem.Projector.Resolution;
import subsystem.SmartLighting;
import subsystem.SmartLighting.Scene;
import subsystem.StreamingPlayer;

public class HomeTheaterFacade {

    private final Amplifier       amplifier;
    private final Projector       projector;
    private final StreamingPlayer player;
    private final SmartLighting   lighting;
    private final CoolingSystem   cooling;

    public HomeTheaterFacade() {
        this.amplifier = new Amplifier();
        this.projector = new Projector();
        this.player    = new StreamingPlayer();
        this.lighting  = new SmartLighting();
        this.cooling   = new CoolingSystem();
    }

    public HomeTheaterFacade(Amplifier amp, Projector proj,
                             StreamingPlayer player,
                             SmartLighting light, CoolingSystem cool) {
        this.amplifier = amp;
        this.projector = proj;
        this.player    = player;
        this.lighting  = light;
        this.cooling   = cool;
    }

    public final void start(String movieTitle) {
        printBanner("STARTING HOME THEATER — \"" + movieTitle + "\"");

        cooling.activate();
        cooling.setTargetTemperature(22.0);
        cooling.setFanSpeed(FanSpeed.LOW);
        cooling.enableAirPurifier();

        lighting.armSystem();
        lighting.setScene(Scene.MOVIE);

        amplifier.powerOn();
        amplifier.setInputSource("HDMI-1");
        amplifier.enableSurroundSound();
        amplifier.setVolume(45);

        projector.turnOn();
        projector.selectHdmiInput(1);
        projector.setResolution(Resolution.UHD_4K);
        projector.setAspectRatio(AspectRatio.RATIO_21_9);

        player.boot();
        player.loadMedia(movieTitle);
        player.enableSubtitles("en");
        player.play();

        printBanner("ENJOY THE SHOW! 🎬");
    }

    public final void stop() {
        printBanner("SHUTTING DOWN HOME THEATER");

        player.shutdown();
        projector.turnOff();
        amplifier.powerOff();
        lighting.disarmSystem();
        cooling.deactivate();

        printBanner("GOODBYE 👋");
    }

    private void printBanner(String message) {
        String line = "═".repeat(message.length() + 4);
        System.out.println("\n╔" + line + "╗");
        System.out.println("║  " + message + "  ║");
        System.out.println("╚" + line + "╝\n");
    }
}
