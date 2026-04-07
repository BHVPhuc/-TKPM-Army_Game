public class Main {
    public static void main(String[] args) {
        Soldier infantryman = new Infantryman();
        Soldier horseman = new Horseman();

        System.out.println("--- Bộ binh (Proxy) ---");
        ProxySoldier proxyInfantryman = new ProxySoldier(infantryman);
        proxyInfantryman.addEquipment(Sword::new);
        proxyInfantryman.addEquipment(Shield::new);
        
        System.out.println("\n--- Thử trang bị trùng lặp ---");
        proxyInfantryman.addEquipment(Sword::new);

        System.out.println("\n--- Kỵ binh (Proxy) ---");
        ProxySoldier proxyHorseman = new ProxySoldier(horseman);
        proxyHorseman.addEquipment(Shield::new);
        
        System.out.println("\n--- Trận chiến bắt đầu ---");
        
        System.out.println("1. Bộ binh tấn công Kỵ binh:");
        int damage1 = proxyInfantryman.hit();
        System.out.println("\n=> Kỵ binh chịu đòn:");
        proxyHorseman.wardOff(damage1);
        System.out.println();

        System.out.println("\n2. Kỵ binh phản công Bộ binh:");
        int damage2 = proxyHorseman.hit();
        System.out.println("\n=> Bộ binh chịu đòn:");
        proxyInfantryman.wardOff(damage2);
        System.out.println();
    }
}
