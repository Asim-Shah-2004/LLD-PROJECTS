package powerups;

import interfaces.Character;
import interfaces.Decorator;

public class HeightBoost implements Decorator{

    private Character ch;
    
    public HeightBoost(Character ch) {
        this.ch = ch;
    }

    @Override
    public String getAbilities() {
        return ch.getAbilities() + "Height boost";
    }
    
}