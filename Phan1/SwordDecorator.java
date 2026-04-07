public class SwordDecorator extends EquipmentDecorator {
    public SwordDecorator(Soldier decoratedSoldier) {
        super(decoratedSoldier);
    }

    @Override
    public int hit() {
        System.out.println("Sword hit +5 ->");
        return decoratedSoldier.hit() + 5;
    }
}
