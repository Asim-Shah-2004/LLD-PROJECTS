
import characters.Mario;
import interfaces.Character;
import powerups.GunBoost;
import powerups.HeightBoost;
import powerups.SlowFalling;


public class Main{
    public static void main(String[] args) {
        Character c1 = new HeightBoost(new GunBoost(new SlowFalling(new Mario())));
        System.out.println(c1.getAbilities());
    }
}