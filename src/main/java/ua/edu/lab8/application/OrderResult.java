package ua.edu.lab8.application;

import java.math.BigDecimal;

public record OrderResult(
        int orderId,
        String customerName,
        BigDecimal totalAmount,
        BigDecimal discountAmount,
        BigDecimal taxAmount,
        BigDecimal finalAmount,
        String status
) {
}