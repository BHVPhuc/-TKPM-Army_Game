public class NanoArmor extends EquipmentDecorator {
    public NanoArmor(Soldier soldier) {
        super(soldier);
    }

    @Override
    public Era getEra() {
        return Era.SCIENCE_FICTION;
    }

    @Override
    public int hit() {
        int d = super.hit();
        System.out.println("   + [NanoArmor] Bạo kích! (+10)");
        return d + 10;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("   > [NanoArmor] Chặn bớt 5 sát thương!");
        return super.wardOff(Math.max(0, strength - 5));
    }
}