public class NPC implements Clonable {
    private int health;
    private int power;
    private String name;

    public NPC(int health, int power, String name) {
        this.health = health;
        this.power = power;
        this.name = name;
    }

    NPC(NPC other){
        this.health = other.health;
        this.power = other.power;
        this.name = other.name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    @Override
    public Clonable clone() {
        return new NPC(this);
    }

}
