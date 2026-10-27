package ua.edu.lab8.infrastructure;

import ua.edu.lab8.application.port.DiscountRateProvider;

import java.math.BigDecimal;

public class StandardDiscountRateProvider implements DiscountRateProvider {

    @Override
    public BigDecimal getRate(String customerType) {
        if ("VIP".equalsIgnoreCase(customerType)) {
            return new BigDecimal("0.15");
        }

        if ("Regular".equalsIgnoreCase(customerType)) {
            return new BigDecimal("0.05");
        }

        if ("New".equalsIgnoreCase(customerType)) {
            return BigDecimal.ZERO;
        }

        throw new IllegalArgumentException("Unknown customer type");
    }
}