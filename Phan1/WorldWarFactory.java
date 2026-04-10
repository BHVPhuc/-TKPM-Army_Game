import java.util.function.Function;

public class WorldWarFactory implements ArmyFactory {
    @Override
    public Era getEra() { return Era.WORLD_WAR; }

    @Override
    public Soldier createInfantryman() {
        return new ProxySoldier(new Infantryman(getEra()));
    }

    @Override
    public Soldier createHorseman() {
        return new ProxySoldier(new Horseman(getEra()));
    }

    @Override
    public Function<Soldier, EquipmentDecorator> getPrimaryWeapon() { return Rifle::new; }

    @Override
    public Function<Soldier, EquipmentDecorator> getSecondaryWeapon() { return Grenade::new; }

    @Override
    public Function<Soldier, EquipmentDecorator> getArmor() { return Helmet::new; }
}