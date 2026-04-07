public class ShieldDecorator extends EquipmentDecorator {


    public ShieldDecorator(Soldier decoratedSoldier) {
        super(decoratedSoldier);
    }

    @Override
    public boolean wardOff(int strength) {
        return decoratedSoldier.wardOff(strength - 5);
    }

    @Override
    public String getDescription() {
        return decoratedSoldier.getDescription() + " with shield";
    }
}
