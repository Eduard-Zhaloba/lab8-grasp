package ua.edu.lab8.infrastructure;

import ua.edu.lab8.application.CreateOrderRequest;
import ua.edu.lab8.application.port.OrderFactory;
import ua.edu.lab8.domain.model.Customer;
import ua.edu.lab8.domain.model.Order;
import ua.edu.lab8.domain.model.Product;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoOrderFactory implements OrderFactory {
    private final AtomicInteger nextId = new AtomicInteger(101);

    private final Product laptop = new Product(
            1, "Ноутбук", new BigDecimal("30000.00"), "Electronics"
    );

    private final Product mouse = new Product(
            2, "Мишка", new BigDecimal("800.00"), "Accessories"
    );

    @Override
    public Order create(CreateOrderRequest request) {
        Customer customer = new Customer(
                1,
                request.customerName(),
                "client@example.com",
                request.customerType(),
                new BigDecimal("15000.00")
        );

        Order order = Order.create(nextId.getAndIncrement(), customer);

        if (request.laptopQuantity() > 0) {
            order.addItem(laptop, request.laptopQuantity());
        }

        if (request.mouseQuantity() > 0) {
            order.addItem(mouse, request.mouseQuantity());
        }

        return order;
    }
}