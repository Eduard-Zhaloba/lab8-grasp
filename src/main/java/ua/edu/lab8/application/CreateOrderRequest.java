package ua.edu.lab8.application;

public record CreateOrderRequest(
        String customerName,
        String customerType,
        int laptopQuantity,
        int mouseQuantity
) {
}