import java.util.function.Function;

public class MedievalFactory implements ArmyFactory {
    @Override
    public Era getEra() { return Era.MEDIEVAL; }

    @Override
    public Soldier createInfantryman() {
        return new ProxySoldier(new Infantryman(getEra()));
    }

    @Override
    public Soldier createHorseman() {
        return new ProxySoldier(new Horseman(getEra()));
    }

    @Override
    public Function<Soldier, EquipmentDecorator> getPrimaryWeapon() { return Sword::new; }

    @Override
    public Function<Soldier, EquipmentDecorator> getSecondaryWeapon() { return Spear::new; }

    @Override
    public Function<Soldier, EquipmentDecorator> getArmor() { return Armor::new; }
}