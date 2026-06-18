import context.AsteroidContext;
import flyweight.AsteroidFlyWeight;
import factory.AsteroidFlyWeightFactory;

public class Main {
    public static void main(String[] args) {
        AsteroidFlyWeightFactory factory = new AsteroidFlyWeightFactory();
        AsteroidFlyWeight asteroid1 = factory.getFlyWeight("small", "rocky", 10, 10, "irregular");
        AsteroidFlyWeight asteroid2 = factory.getFlyWeight("small", "rocky", 10, 10, "irregular");
        AsteroidFlyWeight asteroid3 = factory.getFlyWeight("large", "icy", 20, 20, "spherical");
        AsteroidContext asteroidContext1 = new AsteroidContext(1, 1, 1, 1, asteroid1);
        AsteroidContext asteroidContext2 = new AsteroidContext(2, 2, 2, 2, asteroid2);
        AsteroidContext asteroidContext3 = new AsteroidContext(3, 3, 3, 3, asteroid3);
        System.out.println(asteroidContext1);
        System.out.println(asteroidContext2);
        System.out.println(asteroidContext3);
    }
}
