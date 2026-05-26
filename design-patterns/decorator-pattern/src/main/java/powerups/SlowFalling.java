package powerups;

import interfaces.Character;
import interfaces.Decorator;

public class SlowFalling implements Decorator{

    private Character ch;

    public SlowFalling(Character ch) {
        this.ch = ch;
    }

    @Override
    public String getAbilities() {
        return ch.getAbilities() + "Slow falling boost";
    }
    
}