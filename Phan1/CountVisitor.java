public class CountVisitor implements Visitor {
    private int infantryCount = 0;
    private int horseCount = 0;

    @Override
    public void visit(SoldierGroup group) {
        // Đệ quy vào từng thành viên của nhóm
        for (Soldier member : group.getMembers()) {
            member.accept(this);
        }
    }

    @Override
    public void visit(ProxySoldier proxy) {
        // Bóc lớp Decorator để tìm lính gốc bên trong
        Soldier inner = proxy.getRealSoldier();
        while (inner instanceof EquipmentDecorator) {
            inner = ((EquipmentDecorator) inner).getDecoratedSoldier();
        }
        // Gọi accept trên lính gốc để đếm đúng loại
        inner.accept(this);
    }

    @Override
    public void visit(Infantryman infantryman) {
        infantryCount++;
    }

    @Override
    public void visit(Horseman horseman) {
        horseCount++;
    }

    // Getters để lấy kết quả sau khi duyệt
    public int getInfantryCount() {
        return infantryCount;
    }

    public int getHorseCount() {
        return horseCount;
    }

    public void printReport() {
        System.out.println("📊 Báo cáo quân số:");
        System.out.println("  - Bộ binh (Infantryman): " + infantryCount);
        System.out.println("  - Kỵ binh (Horseman):    " + horseCount);
        System.out.println("  - Tổng cộng:             " + (infantryCount + horseCount));
    }
}
