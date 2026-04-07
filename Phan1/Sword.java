public class Sword extends EquipmentDecorator {
    int durability = 5;

    public Sword(Soldier decoratedSoldier) {
        super(decoratedSoldier);
    }

    @Override
    public int hit() {
        System.out.format("Sword hit +%d ->", durability);

        int postDamage = decoratedSoldier.hit() + 5;

        durability = Math.max(durability - 1, 0);

        if (durability == 0) {
            System.out.print("Sword is broken! -> ");
        }

        return postDamage;
    }
}
