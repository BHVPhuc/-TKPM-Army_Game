import java.util.function.Function;

public interface ArmyFactory {
    Era getEra();
    Soldier createInfantryman();
    Soldier createHorseman();
    Function<Soldier, EquipmentDecorator> getPrimaryWeapon();
    Function<Soldier, EquipmentDecorator> getSecondaryWeapon();
    Function<Soldier, EquipmentDecorator> getArmor();
}