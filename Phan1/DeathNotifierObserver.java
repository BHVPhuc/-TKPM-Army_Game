public class DeathNotifierObserver implements DeathObserver {
    private static DeathNotifierObserver instance;

    private DeathNotifierObserver() {}

    public static DeathNotifierObserver getInstance() {
        if (instance == null) {
            instance = new DeathNotifierObserver();
        }
        return instance;
    }
    @Override
    public void onDeath(Soldier soldier) {
        System.out.println("[DeathNotifierObserver] Binh lính [" + soldier.getClass().getSimpleName() + "] đã hy sinh! Đang gửi email thông báo chia buồn...");
    }
}
