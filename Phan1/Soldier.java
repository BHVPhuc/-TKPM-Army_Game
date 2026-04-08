import java.util.function.Function;

public interface Soldier {
    int hit();
    boolean wardOff(int strength);
    void addEquipment(Function<Soldier, EquipmentDecorator> decoratorFactory);
    void accept(Visitor v);
    void addObserver(DeathObserver observer);
}
