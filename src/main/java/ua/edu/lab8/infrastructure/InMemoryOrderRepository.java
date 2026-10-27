package ua.edu.lab8.infrastructure;

import ua.edu.lab8.application.port.OrderRepository;
import ua.edu.lab8.domain.model.Order;

import java.util.HashMap;
import java.util.Map;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<Integer, Order> orders = new HashMap<>();

    @Override
    public void save(Order order) {
        orders.put(order.getId(), order);
    }
}