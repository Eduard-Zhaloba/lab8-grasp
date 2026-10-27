package ua.edu.lab8.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class Product {
    private final int id;
    private final String name;
    private final BigDecimal price;
    private final String category;

    public Product(int id, String name, BigDecimal price, String category) {
        if (id <= 0) {
            throw new IllegalArgumentException("Product ID must be positive");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (price == null || price.signum() < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Product category cannot be empty");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}