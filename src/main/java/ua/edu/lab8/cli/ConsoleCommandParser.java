package ua.edu.lab8.cli;

import ua.edu.lab8.application.CreateOrderRequest;

public class ConsoleCommandParser {

    public CreateOrderRequest parse(
            String name,
            String type,
            String laptopQuantity,
            String mouseQuantity
    ) {
        try {
            int laptops = Integer.parseInt(laptopQuantity.trim());
            int mice = Integer.parseInt(mouseQuantity.trim());

            if (laptops < 0 || mice < 0) {
                throw new IllegalArgumentException(
                        "Quantities cannot be negative"
                );
            }

            return new CreateOrderRequest(
                    name, type, laptops, mice
            );
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "Quantities must be integers", exception
            );
        }
    }
}