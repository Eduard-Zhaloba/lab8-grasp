package variant1_orderprocessing;

public interface OrderRepository {
    void save(Order order);
}

class FileOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("[БД] Замовлення #" + order.id + " успішно збережено у файл orders.txt.");
    }
}