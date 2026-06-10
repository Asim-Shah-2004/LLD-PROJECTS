import appliances.Ac;
import appliances.Fan;
import appliances.Light;
import commands.AcCommand;
import commands.FanCommand;
import commands.LightCommand;
import controllers.Remote;

public class Main {

    public static void main(String[] args) {

        // ── Setup: 3-button remote, one appliance each ────────────────────────
        Ac ac       = new Ac();
        Fan fan     = new Fan();
        Light light = new Light();

        Remote remote = new Remote(3);
        remote.setCommand(new AcCommand(ac),       0);
        remote.setCommand(new FanCommand(fan),     1);
        remote.setCommand(new LightCommand(light), 2);

        // ── Case 1: Press each button once → all appliances turn ON ───────────
        System.out.println("========== Case 1: First press — all ON ==========");
        remote.pressButton(0);   // Ac on
        remote.pressButton(1);   // Fan on
        remote.pressButton(2);   // Light on

        // ── Case 2: Press each button again → all appliances turn OFF ─────────
        System.out.println("\n========== Case 2: Second press — all OFF ==========");
        remote.pressButton(0);   // Ac off
        remote.pressButton(1);   // Fan off
        remote.pressButton(2);   // Light off

        // ── Case 3: Toggle single appliance multiple times ────────────────────
        System.out.println("\n========== Case 3: Toggle Light 4 times ==========");
        for (int i = 0; i < 4; i++) {
            remote.pressButton(2);
        }

        // ── Case 4: Independent toggles — each button has its own state ───────
        System.out.println("\n========== Case 4: Independent button states ==========");
        remote.pressButton(0);   // Ac on
        remote.pressButton(0);   // Ac off
        remote.pressButton(1);   // Fan on  (fan state unaffected by Ac presses)
        remote.pressButton(2);   // Light on (light still off after Case 3 ended on OFF)

        // ── Case 5: Reassign a button to a different command ──────────────────
        System.out.println("\n========== Case 5: Reassign button 0 to a second Light ==========");
        Light bedroomLight = new Light();
        remote.setCommand(new LightCommand(bedroomLight), 0);
        remote.pressButton(0);   // bedroom Light on
        remote.pressButton(0);   // bedroom Light off

        // ── Case 6: Null slot guard ───────────────────────────────────────────
        System.out.println("\n========== Case 6: Press unassigned button ==========");
        Remote sparseRemote = new Remote(3);
        sparseRemote.setCommand(new LightCommand(new Light()), 1);
        sparseRemote.pressButton(0);   // slot 0 is null → prints warning, not crash
        sparseRemote.pressButton(1);   // Light on
        sparseRemote.pressButton(2);   // slot 2 is null → prints warning, not crash

        // ── Case 7: Shared receiver across two remotes ────────────────────────
        System.out.println("\n========== Case 7: Shared Ac across two remotes ==========");
        Ac sharedAc    = new Ac();
        Remote remote1 = new Remote(1);
        Remote remote2 = new Remote(1);
        remote1.setCommand(new AcCommand(sharedAc), 0);
        remote2.setCommand(new AcCommand(sharedAc), 0);
        remote1.pressButton(0);   // Ac on  (via remote1)
        remote2.pressButton(0);   // Ac on  (remote2 has its own isPressed state)

        // ── Case 8: Large remote — stress test ────────────────────────────────
        System.out.println("\n========== Case 8: 10-button remote ==========");
        Remote bigRemote = new Remote(10);
        for (int i = 0; i < 10; i++) {
            bigRemote.setCommand(new LightCommand(new Light()), i);
        }
        System.out.println("-- Turning all 10 lights ON --");
        for (int i = 0; i < 10; i++) bigRemote.pressButton(i);
        System.out.println("-- Turning all 10 lights OFF --");
        for (int i = 0; i < 10; i++) bigRemote.pressButton(i);

        System.out.println("\n========== All cases completed. ==========");
    }
}