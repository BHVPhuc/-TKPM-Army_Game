public class Main {
    public static void main(String[] args) {
        // Tạo tiểu đội Bộ binh
        SoldierGroup alphaSquad = new SoldierGroup("Tiểu đội Bộ binh Alpha");
        alphaSquad.addMember(new ProxySoldier(new Infantryman()));
        alphaSquad.addMember(new ProxySoldier(new Infantryman()));

        // Tạo tiểu đội Kỵ binh
        SoldierGroup bravoSquad = new SoldierGroup("Tiểu đội Kỵ binh Bravo");
        bravoSquad.addMember(new ProxySoldier(new Horseman()));

        // Tạo một quân đoàn (Composite chứa Composite và Leaf)
        SoldierGroup army = new SoldierGroup("Đại đội Tiên phong");
        army.addMember(alphaSquad);
        army.addMember(bravoSquad);
        
        // Thêm một lính đánh lẻ (Leaf) vào đại đội
        ProxySoldier general = new ProxySoldier(new Horseman());
        army.addMember(general);

        System.out.println("\n[SỰ KIỆN] PHÁT VŨ KHÍ CHO TOÀN BỘ ĐẠI ĐỘI (Giao Shield cho mọi lính)");
        army.addEquipment(Shield::new);

        System.out.println("\n[SỰ KIỆN] PHÁT KIẾM CHỈ CHO TIỂU ĐỘI ALPHA");
        alphaSquad.addEquipment(Sword::new);

        // ===== VISITOR PATTERN DEMO =====
        System.out.println("\n=== VISITOR: Hiển thị cấu trúc đội quân ===");
        DisplayVisitor displayVisitor = new DisplayVisitor();
        army.accept(displayVisitor);

        System.out.println("\n=== VISITOR: Thống kê quân số ===");
        CountVisitor countVisitor = new CountVisitor();
        army.accept(countVisitor);
        countVisitor.printReport();

        // ===== BATTLE =====
        System.out.println("\n=================================");
        System.out.println("\n[SỰ KIỆN] ĐẠI ĐỘI TỔNG TẤN CÔNG");
        int totalDamage = army.hit();
        System.out.println("TỔNG SÁT THƯƠNG ĐẠI ĐỘI GÂY RA: " + totalDamage + "\n");

        System.out.println("\n[SỰ KIỆN] ĐẠI ĐỘI BỊ TẤN CÔNG (Sát thương = " + totalDamage + ")");
        CountVisitor temp = new CountVisitor();
        army.accept(temp);
        temp.printReport();
        army.wardOff(totalDamage);

    }
}

