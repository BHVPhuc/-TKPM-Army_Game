public class Shield extends EquipmentDecorator {

    private int defense = 5;

    public Shield(Soldier decoratedSoldier) {
        super(decoratedSoldier);
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.format("Shield wardOff %d ->", defense);

        int postDamage = Math.max(strength - defense, 0);

        defense = Math.max(defense - 1, 0);

        if (defense == 0) {
            System.out.print("Shield is broken! -> ");
        }

        return decoratedSoldier.wardOff(postDamage);
    }
}
