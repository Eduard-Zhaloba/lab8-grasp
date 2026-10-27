package ua.edu.lab8.application.port;

import ua.edu.lab8.application.CreateOrderRequest;
import ua.edu.lab8.domain.model.Order;

public interface OrderFactory {
    Order create(CreateOrderRequest request);
}