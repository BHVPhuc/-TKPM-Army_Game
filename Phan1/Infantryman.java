public class Infantryman implements Soldier {
    private int health = 100;
    private int attack = 15;

    @Override
    public int hit() {
        System.out.print("Infantryman hit " + attack + " -> ");
        return attack;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.print("Infantryman wardOff " + strength + " -> ");
        health -= strength;
        if (health <= 0) {
            health = 0;
            return false;
        }
        return true;
    }
}