package powerups;

import interfaces.Character;
import interfaces.Decorator;

public class GunBoost implements Decorator{

    private Character ch;

    public GunBoost(Character ch) {
        this.ch = ch;
    }

    @Override
    public String getAbilities() {
        return ch.getAbilities() + "Gun boost";
    }
    
}