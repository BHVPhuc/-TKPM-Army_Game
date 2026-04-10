import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SoldierGroup implements Soldier {
    private List<Soldier> members = new ArrayList<>();
    private List<DeathObserver> observers = new ArrayList<>();
    private String groupName;

    public SoldierGroup(String groupName) {
        this.groupName = groupName;
    }

    public void addMember(Soldier soldier) {
        members.add(soldier);
        // Ngay lập tức gắn observers của Group vào soldier mới
        for (DeathObserver obs : observers) {
            soldier.addObserver(obs);
        }
    }

    public void removeMember(Soldier soldier) {
        members.remove(soldier);
    }

    @Override
    public int hit() {
        System.out.println("--- [" + groupName + "] Tổng tiến công! ---");
        return members.stream().mapToInt(Soldier::hit).sum();
    }

    @Override
    public boolean wardOff(int strength) {
        if (members.isEmpty()) return false;
        
        System.out.println("--- [" + groupName + "] Chịu sát thương tổng: " + strength + " ---");
        int dividedStrength = strength / members.size();
        System.out.println("Mỗi thành viên gánh: " + dividedStrength);
        
        boolean allSurvived = true;
        for (Soldier soldier : members) {
            if (!soldier.wardOff(dividedStrength)) {
                allSurvived = false;
            }
        }
        return allSurvived;
    }

    @Override
    public void addEquipment(Function<Soldier, EquipmentDecorator> decoratorFactory) {
        System.out.println("=== Phân phối trang bị cho toàn bộ [" + groupName + "] ===");
        for (Soldier soldier : members) {
            soldier.addEquipment(decoratorFactory);
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void addObserver(DeathObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
        for (Soldier soldier : members) {
            soldier.addObserver(observer);
        }
    }

    @Override
    public Era getEra() {
        return members.isEmpty() ? Era.MEDIEVAL : members.get(0).getEra();
    }

    // Getters cho Visitor truy cập cấu trúc bên trong
    public List<Soldier> getMembers() {
        return members;
    }

    public String getGroupName() {
        return groupName;
    }
}
