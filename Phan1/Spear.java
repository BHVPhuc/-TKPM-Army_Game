public class Spear extends EquipmentDecorator {
    public Spear(Soldier soldier) {
        super(soldier);
    }

    @Override
    public Era getEra() {
        return Era.MEDIEVAL;
    }

    @Override
    public int hit() {
        int d = super.hit();
        System.out.println("   + [Spear] Bạo kích! (+10)");
        return d + 10;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("   > [Spear] Chặn bớt 5 sát thương!");
        return super.wardOff(Math.max(0, strength - 5));
    }
}