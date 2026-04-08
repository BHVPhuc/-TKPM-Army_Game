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

        // ===== OBSERVER PATTERN DEMO =====
        System.out.println("\n=== THIẾT LẬP MẠNG LƯỚI THEO DÕI TỬ TRẬN ===");
        DeathCountObserver counter = DeathCountObserver.getInstance();
        DeathNotifierObserver notifier = DeathNotifierObserver.getInstance();
        army.addObserver(counter);
        army.addObserver(notifier);
        System.out.println("Đã gắn DeathCountObserver và DeathNotifierObserver cho toàn Đại đội!");

        // ===== BATTLE =====
        System.out.println("\n=================================");
        System.out.println("\n[SỰ KIỆN] PHỤC KÍCH: ĐẠI ĐỘI TRÚNG BOM HỦY DIỆT!");
        
        // Sát thương 5000, chia đều cho các thành viên đều sẽ gây sát thương tử vong
        int bomDamage = 5000;
        army.wardOff(bomDamage);

    }
}

