public class DeathNotifierObserver implements DeathObserver {
    @Override
    public void onDeath(Soldier soldier) {
        System.out.println("[DeathNotifierObserver] Binh lính [" + soldier.getClass().getSimpleName() + "] đã hy sinh! Đang gửi email thông báo chia buồn...");
    }
}
