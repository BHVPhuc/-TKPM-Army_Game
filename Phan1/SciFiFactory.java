import java.util.function.Function;

public class SciFiFactory implements ArmyFactory {
    @Override
    public Era getEra() { return Era.SCIENCE_FICTION; }

    @Override
    public Soldier createInfantryman() {
        return new ProxySoldier(new Infantryman(getEra()));
    }

    @Override
    public Soldier createHorseman() {
        return new ProxySoldier(new Horseman(getEra()));
    }

    @Override
    public Function<Soldier, EquipmentDecorator> getPrimaryWeapon() { return LaserSword::new; }

    @Override
    public Function<Soldier, EquipmentDecorator> getSecondaryWeapon() { return BioWeapon::new; }

    @Override
    public Function<Soldier, EquipmentDecorator> getArmor() { return NanoArmor::new; }
}