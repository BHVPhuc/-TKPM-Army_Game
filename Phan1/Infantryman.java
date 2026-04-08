import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Infantryman implements Soldier {
    private int health = 100;
    private int attack = 15;
    private List<DeathObserver> observers = new ArrayList<>();

    @Override
    public int hit() {
        System.out.print("Infantryman hit " + attack + " -> ");
        return attack;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.print("Infantryman wardOff " + strength + " -> ");
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