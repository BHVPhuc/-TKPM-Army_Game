public class DeathCountObserver implements DeathObserver {
    private static DeathCountObserver instance;
    private int deadCount = 0;

    private DeathCountObserver() {}

    public static DeathCountObserver getInstance() {
        if (instance == null) {
            instance = new DeathCountObserver();
        }
        return instance;
    }

    @Override
    public void onDeath(Soldier soldier) {
        deadCount++;
        System.out.println("[DeathCountObserver] Số lượng binh lính đã tử trận trong trận chiến: " + deadCount);
    }
}
