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
        // Lệnh cấp thiết bị này sẽ đệ quy truyền từ Army -> Squads -> ProxySoldier
        army.addEquipment(Shield::new);

        System.out.println("\n[SỰ KIỆN] PHÁT KIẾM CHỈ CHO TIỂU ĐỘI ALPHA");
        // Chỉ cấp cho một nhánh con
        alphaSquad.addEquipment(Sword::new);

        System.out.println("\n=================================");
        System.out.println("\n[SỰ KIỆN] ĐẠI ĐỘI TỔNG TẤN CÔNG");
        int totalDamage = army.hit();
        System.out.println("TỔNG SÁT THƯƠNG ĐẠI ĐỘI GÂY RA: " + totalDamage + "\n");

        System.out.println("\n[SỰ KIỆN] ĐẠI ĐỘI BỊ TẤN CÔNG (Sát thương = 60)");
        army.wardOff(60);
    }
}
