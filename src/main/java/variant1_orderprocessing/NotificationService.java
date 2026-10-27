package variant1_orderprocessing;

public interface NotificationService {
    void sendNotification(Customer customer, String message);
}

class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(Customer customer, String message) {
        System.out.println("[Email] Сповіщення відправлено на " + customer.email);
    }
}