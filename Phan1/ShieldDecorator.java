public class ShieldDecorator extends EquipmentDecorator {

    public ShieldDecorator(Soldier decoratedSoldier) {
        super(decoratedSoldier);
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("Shield wardOff -5 ->");
        return decoratedSoldier.wardOff(strength - 5);
    }
}
