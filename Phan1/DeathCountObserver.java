public class DeathCountObserver implements DeathObserver {
    private int deadCount = 0;

    @Override
    public void onDeath(Soldier soldier) {
        deadCount++;
        System.out.println("[DeathCountObserver] Số lượng binh lính đã tử trận trong trận chiến: " + deadCount);
    }
}
