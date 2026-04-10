import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Horseman implements Soldier {
    private int health = 100;
    private int attack = 20;
    private List<DeathObserver> observers = new ArrayList<>();
    private Era era;

    public Horseman(Era era) {
        this.era = era;
    }

    @Override
    public Era getEra() {
        return era;
    }

    @Override
    public int hit() {
        System.out.println("Horseman hit " + attack + " -> ");
        return attack;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println("Horseman wardOff " + strength + " -> ");
        health -= strength;
        if (health <= 0) {
            health = 0;
            for (DeathObserver obs : observers) {
                obs.onDeath(this);
            }
            return false;
        }
        return true;
    }

    @Override
    public void addObserver(DeathObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void addEquipment(Function<Soldier, EquipmentDecorator> decoratorFactory) {
        System.out.println("Cảnh báo: Không thể nạp trang bị trực tiếp cho lính không có Proxy/Group!");
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
