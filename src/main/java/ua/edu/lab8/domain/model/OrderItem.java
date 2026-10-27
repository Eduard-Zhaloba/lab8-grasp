package ua.edu.lab8.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class OrderItem {
    private final Product product;
    private final int quantity;

    OrderItem(Product product, int quantity) {
        this.product = Objects.requireNonNull(product, "Product cannot be null");

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal calculateSubtotal() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}