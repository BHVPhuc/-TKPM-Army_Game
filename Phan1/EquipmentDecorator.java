abstract class EquipmentDecorator implements Soldier {
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
    public String getDescription() {
        return decoratedSoldier.getDescription();
    }
}
