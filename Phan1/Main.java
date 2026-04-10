public class Main {
    public static void main(String[] args) {
        // Khởi tạo các Factory đại diện cho từng thời đại
        ArmyFactory medievalFactory = new MedievalFactory();
        ArmyFactory sciFiFactory = new SciFiFactory();

        System.out.println("=== THUÊ QUÂN VÀ THIẾT LẬP ĐẠI ĐỘI ===");

        // Tạo tiểu đội Bộ binh Trung Cổ
        SoldierGroup alphaSquad = new SoldierGroup("Tiểu đội Bộ binh Alpha");
        alphaSquad.addMember(medievalFactory.createInfantryman());
        alphaSquad.addMember(medievalFactory.createInfantryman());

        // Tạo tiểu đội Kỵ binh Viễn Tưởng
        SoldierGroup bravoSquad = new SoldierGroup("Tiểu đội Kỵ binh Sci-Fi Bravo");
        bravoSquad.addMember(sciFiFactory.createHorseman());

        // Tạo một quân đoàn tổng hợp
        SoldierGroup army = new SoldierGroup("Đại đội Tiền phương");
        army.addMember(alphaSquad);
        army.addMember(bravoSquad);
        
        System.out.println("\n[SỰ KIỆN] PHÁT VŨ KHÍ: Giao Kiếm Trung cổ cho toàn bộ Alpha Squad (Hợp lệ)");
        alphaSquad.addEquipment(medievalFactory.getPrimaryWeapon());

        System.out.println("\n[SỰ KIỆN] PHÁT VŨ KHÍ LỖI: Giao Súng Viễn tưởng cho Alpha Squad (Sẽ bị từ chối do khác thời đại!)");
        alphaSquad.addEquipment(sciFiFactory.getPrimaryWeapon());

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

