public class LaserSword extends EquipmentDecorator {
    public LaserSword(Soldier soldier) {
        super(soldier);
    }

    @Override
    public Era getEra() {
        return Era.SCIENCE_FICTION;
    }

    @Override
    public int hit() {
        int d = super.hit();
        System.out.println("   + [LaserSword] Bạo kích! (+10)");
        return d + 10;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("   > [LaserSword] Chặn bớt 5 sát thương!");
        return super.wardOff(Math.max(0, strength - 5));
    }
}