package context;

import flyweight.AsteroidFlyWeight;

public class AsteroidContext {
    int posX;
    int posY;
    int speedX;
    int speedY;
    AsteroidFlyWeight asteroidFlyWeight;

    public AsteroidContext(int posX, int posY, int speedX, int speedY, AsteroidFlyWeight asteroidFlyWeight) {
        this.posX = posX;
        this.posY = posY;
        this.speedX = speedX;
        this.speedY = speedY;
        this.asteroidFlyWeight = asteroidFlyWeight;
    }

    @Override
    public String toString() {
        return "Asteroid [posX=" + posX + ", posY=" + posY + ", speedX=" + speedX + ", speedY=" + speedY + ", asteroidFlyWeight="
                + asteroidFlyWeight + "]";
    }
    
}
