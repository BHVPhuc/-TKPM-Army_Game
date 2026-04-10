public class Rifle extends EquipmentDecorator {
    public Rifle(Soldier soldier) {
        super(soldier);
    }

    @Override
    public Era getEra() {
        return Era.WORLD_WAR;
    }

    @Override
    public int hit() {
        int d = super.hit();
        System.out.println("   + [Rifle] Bạo kích! (+10)");
        return d + 10;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("   > [Rifle] Chặn bớt 5 sát thương!");
        return super.wardOff(Math.max(0, strength - 5));
    }
}