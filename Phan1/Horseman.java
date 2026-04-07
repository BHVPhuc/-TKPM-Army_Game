public class Horseman implements Soldier {
    private int health = 100;
    private int attack = 20;

    @Override
    public int hit() {
        System.out.println("Horseman hit ->");
        return attack;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("Horseman wardOff ->");
        health -= strength;
        if (health <= 0) {
            health = 0;
            return false;
        }
        return true;
    }
}
