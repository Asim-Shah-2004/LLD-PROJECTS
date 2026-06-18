package flyweight;

public class AsteroidFlyWeight {
    String size;
    String texture;
    int width;
    int height;
    String shape;

    public AsteroidFlyWeight(String size, String texture, int width, int height, String shape) {
        this.size = size;
        this.texture = texture;
        this.width = width;
        this.height = height;
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Asteroid [size=" + size + ", texture=" + texture + ", width=" + width + ", height=" + height + ", shape="
                + shape + "]";
    }

}