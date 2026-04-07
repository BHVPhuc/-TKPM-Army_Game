import java.util.function.Function;

public abstract class EquipmentDecorator implements Soldier {
    protected Soldier decoratedSoldier;

    public EquipmentDecorator(Soldier decoratedSoldier) {
        this.decoratedSoldier = decoratedSoldier;
    }

    @Override
    public int hit() {
        return decoratedSoldier.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return decoratedSoldier.wardOff(strength);
    }

    @Override
    public void addEquipment(Function<Soldier, EquipmentDecorator> decoratorFactory) {
        decoratedSoldier.addEquipment(decoratorFactory);
    }
}
