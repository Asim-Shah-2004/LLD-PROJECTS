package factory;

import flyweight.AsteroidFlyWeight;
import java.util.HashMap;

public class AsteroidFlyWeightFactory {
    private static final HashMap<String, AsteroidFlyWeight> flyWeightMap = new HashMap<>();

    public static AsteroidFlyWeight getFlyWeight(String size, String texture, int width, int height, String shape) {
        String key = size + texture + width + height + shape;
        if (flyWeightMap.containsKey(key)) {
            return flyWeightMap.get(key);
        } else {
            AsteroidFlyWeight asteroidFlyWeight = new AsteroidFlyWeight(size, texture, width, height, shape);
            flyWeightMap.put(key, asteroidFlyWeight);
            return asteroidFlyWeight;
        }
    }
    
}
