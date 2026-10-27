package ua.edu.lab8.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Order {
    private static final BigDecimal TAX_RATE = new BigDecimal("0.20");

    private final int id;
    private final Customer customer;
    private final List<OrderItem> items = new ArrayList<>();

    private BigDecimal totalAmount = BigDecimal.ZERO;
    private BigDecimal discountAmount = BigDecimal.ZERO;
    private BigDecimal taxAmount = BigDecimal.ZERO;
    private BigDecimal finalAmount = BigDecimal.ZERO;
    private String status = "New";

    private Order(int id, Customer customer) {
        if (id <= 0) {
            throw new IllegalArgumentException("Order ID must be positive");
        }

        this.id = id;
        this.customer = Objects.requireNonNull(customer, "Customer cannot be null");
    }

    public static Order create(int id, Customer customer) {
        return new Order(id, customer);
    }

    public void addItem(Product product, int quantity) {
        if (!"New".equals(status)) {
            throw new IllegalStateException("Cannot modify a processed order");
        }

        items.add(new OrderItem(product, quantity));
    }

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }

    public BigDecimal calculateSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;

        for (OrderItem item : items) {
            subtotal = subtotal.add(item.calculateSubtotal());
        }

        return subtotal;
    }

    public void process(BigDecimal discountRate) {
        if (!"New".equals(status)) {
            throw new IllegalStateException("Order has already been processed");
        }
        if (items.isEmpty()) {
            throw new IllegalStateException("Order must contain at least one item");
        }
        if (discountRate == null ||
                discountRate.compareTo(BigDecimal.ZERO) < 0 ||
                discountRate.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("Invalid discount rate");
        }

        totalAmount = calculateSubtotal();
        discountAmount = totalAmount.multiply(discountRate);
        taxAmount = totalAmount.subtract(discountAmount)
                .multiply(TAX_RATE);
        finalAmount = totalAmount.subtract(discountAmount)
                .add(taxAmount);

        totalAmount = totalAmount.setScale(2, RoundingMode.HALF_UP);
        discountAmount = discountAmount.setScale(2, RoundingMode.HALF_UP);
        taxAmount = taxAmount.setScale(2, RoundingMode.HALF_UP);
        finalAmount = finalAmount.setScale(2, RoundingMode.HALF_UP);

        status = "Processed";
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public String getStatus() {
        return status;
    }
}