package ua.edu.lab8.application;

import ua.edu.lab8.application.port.DiscountRateProvider;
import ua.edu.lab8.application.port.OrderFactory;
import ua.edu.lab8.application.port.OrderRepository;
import ua.edu.lab8.domain.model.Order;

import java.math.BigDecimal;

public class OrderController {
    private final OrderRepository repository;
    private final OrderFactory factory;
    private final DiscountRateProvider discountRateProvider;

    public OrderController(
            OrderRepository repository,
            OrderFactory factory,
            DiscountRateProvider discountRateProvider
    ) {
        this.repository = repository;
        this.factory = factory;
        this.discountRateProvider = discountRateProvider;
    }

    public OrderResult processOrder(CreateOrderRequest request) {
        Order order = factory.create(request);

        BigDecimal discountRate =
                discountRateProvider.getRate(order.getCustomer().getType());

        order.process(discountRate);
        repository.save(order);

        return new OrderResult(
                order.getId(),
                order.getCustomer().getName(),
                order.getTotalAmount(),
                order.getDiscountAmount(),
                order.getTaxAmount(),
                order.getFinalAmount(),
                order.getStatus()
        );
    }
}