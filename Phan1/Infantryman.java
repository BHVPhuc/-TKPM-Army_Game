public class Infantryman implements Soldier {
    private int health = 100;
    private int attack = 15;

    @Override
    public int hit() {
        System.out.println("Infantryman hit ->");
        return attack;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("Infantryman wardOff ->");
        health -= strength;
        if (health <= 0) {
            health = 0;
            return false;
        }
        return true;
    }
}