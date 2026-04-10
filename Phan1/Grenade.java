public class Grenade extends EquipmentDecorator {
    public Grenade(Soldier soldier) {
        super(soldier);
    }

    @Override
    public Era getEra() {
        return Era.WORLD_WAR;
    }

    @Override
    public int hit() {
        int d = super.hit();
        System.out.println("   + [Grenade] Bạo kích! (+10)");
        return d + 10;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("   > [Grenade] Chặn bớt 5 sát thương!");
        return super.wardOff(Math.max(0, strength - 5));
    }
}