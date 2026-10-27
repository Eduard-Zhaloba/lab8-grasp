package ua.edu.lab8.application.port;

import ua.edu.lab8.domain.model.Order;

public interface OrderRepository {
    void save(Order order);
}