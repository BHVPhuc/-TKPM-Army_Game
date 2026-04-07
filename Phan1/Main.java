public class Main {
    public static void main(String[] args) {
        Soldier infantryman = new Infantryman();
        Soldier horseman = new Horseman();

        System.out.println("Infantryman attacks: " + infantryman.hit());
        System.out.println("Horseman attacks: " + horseman.hit());

        Soldier swordInfantryman = new SwordDecorator(infantryman);
        Soldier shieldHorseman = new ShieldDecorator(horseman);

        System.out.println("Sword Infantryman attacks: " + swordInfantryman.hit());
        System.out.println("Shield Horseman wardOff(10): " + shieldHorseman.wardOff(10));
    }
}
