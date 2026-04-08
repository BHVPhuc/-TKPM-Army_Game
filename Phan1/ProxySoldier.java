import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class ProxySoldier implements Soldier {
    private Soldier _proxySoldier;

    // Sử dụng Set để lưu tên class của các trang bị đang mang, giúp ngăn trùng lặp
    private Set<String> equippedItems;

    public ProxySoldier(Soldier realSoldier) {
        this._proxySoldier = realSoldier;
        this.equippedItems = new HashSet<>();
    }

    // Tự động lấy tên class của Decorator làm key chặn trùng lặp
    // Không cần truyền String thủ công → gọn hơn, ít lỗi hơn
    public void addEquipment(Function<Soldier, EquipmentDecorator> decoratorFactory) {
        EquipmentDecorator decorated = decoratorFactory.apply(this._proxySoldier);
        String equipmentName = decorated.getClass().getSimpleName();

        if (equippedItems.contains(equipmentName)) {
            System.out.println("Trang bị [" + equipmentName + "] đã tồn tại! Bỏ qua để tránh trùng lặp.");
            return;
        }

        this._proxySoldier = decorated;
        equippedItems.add(equipmentName);
        System.out.println("Đã trang bị thành công: " + equipmentName);
    }

    @Override
    public int hit() {
        return _proxySoldier.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return _proxySoldier.wardOff(strength);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void addObserver(DeathObserver observer) {
        _proxySoldier.addObserver(observer);
    }

    // Getters cho Visitor truy cập cấu trúc bên trong
    public Soldier getRealSoldier() {
        return _proxySoldier;
    }

    public Set<String> getEquippedItems() {
        return equippedItems;
    }
}
