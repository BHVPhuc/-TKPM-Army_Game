public class SwordDecorator extends EquipmentDecorator {
    public SwordDecorator(Soldier decoratedSoldier) {
        super(decoratedSoldier);
    }

    @Override
    public int hit() {
        return decoratedSoldier.hit() + 5;
    }

    @Override
    public String getDescription() {
        return decoratedSoldier.getDescription() + " with sword";
    }
}
