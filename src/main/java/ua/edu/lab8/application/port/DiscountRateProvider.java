package ua.edu.lab8.application.port;

import java.math.BigDecimal;

public interface DiscountRateProvider {
    BigDecimal getRate(String customerType);
}