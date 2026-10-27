package ua.edu.lab8.domain.model;

import java.math.BigDecimal;

public final class Customer {
    private final int id;
    private final String name;
    private final String email;
    private final String type;
    private final BigDecimal totalSpent;

    public Customer(int id, String name, String email,
                    String type, BigDecimal totalSpent) {
        if (id <= 0) {
            throw new IllegalArgumentException("Customer ID must be positive");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Customer email cannot be empty");
        }
        if (type == null ||
                (!type.equalsIgnoreCase("New") &&
                        !type.equalsIgnoreCase("Regular") &&
                        !type.equalsIgnoreCase("VIP"))) {
            throw new IllegalArgumentException("Unknown customer type");
        }
        if (totalSpent == null || totalSpent.signum() < 0) {
            throw new IllegalArgumentException("Total spent cannot be negative");
        }

        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.totalSpent = totalSpent;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getTotalSpent() {
        return totalSpent;
    }
}