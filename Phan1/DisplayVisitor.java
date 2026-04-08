import java.util.Set;

public class DisplayVisitor implements Visitor {
    private int indent = 0;

    private String getIndent() {
        return "  ".repeat(indent);
    }

    @Override
    public void visit(SoldierGroup group) {
        System.out.println(getIndent() + "📦 Nhóm: " + group.getGroupName());
        indent++;
        for (Soldier member : group.getMembers()) {
            member.accept(this);
        }
        indent--;
    }

    @Override
    public void visit(ProxySoldier proxy) {
        // Lấy tên loại lính gốc bên trong (bóc qua các lớp Decorator)
        Soldier inner = proxy.getRealSoldier();
        while (inner instanceof EquipmentDecorator) {
            inner = ((EquipmentDecorator) inner).getDecoratedSoldier();
        }

        String typeName = inner.getClass().getSimpleName();
        Set<String> equipment = proxy.getEquippedItems();

        String equipStr = equipment.isEmpty() ? "Không có" : String.join(", ", equipment);
        System.out.println(getIndent() + "🪖 " + typeName + " | Trang bị: [" + equipStr + "]");
    }

    @Override
    public void visit(Infantryman infantryman) {
        System.out.println(getIndent() + "🪖 Infantryman (trực tiếp, không qua Proxy)");
    }

    @Override
    public void visit(Horseman horseman) {
        System.out.println(getIndent() + "🪖 Horseman (trực tiếp, không qua Proxy)");
    }
}
