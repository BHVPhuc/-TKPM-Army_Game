public class BioWeapon extends EquipmentDecorator {
    public BioWeapon(Soldier soldier) {
        super(soldier);
    }

    @Override
    public Era getEra() {
        return Era.SCIENCE_FICTION;
    }

    @Override
    public int hit() {
        int d = super.hit();
        System.out.println("   + [BioWeapon] Bạo kích! (+10)");
        return d + 10;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("   > [BioWeapon] Chặn bớt 5 sát thương!");
        return super.wardOff(Math.max(0, strength - 5));
    }
}