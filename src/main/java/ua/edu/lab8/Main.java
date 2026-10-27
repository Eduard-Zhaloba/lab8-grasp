package ua.edu.lab8;

import ua.edu.lab8.application.OrderController;
import ua.edu.lab8.cli.ConsoleCommandParser;
import ua.edu.lab8.cli.ConsoleMenu;
import ua.edu.lab8.infrastructure.DemoOrderFactory;
import ua.edu.lab8.infrastructure.InMemoryOrderRepository;
import ua.edu.lab8.infrastructure.StandardDiscountRateProvider;

public class Main {
    public static void main(String[] args) {
        OrderController controller = new OrderController(
                new InMemoryOrderRepository(),
                new DemoOrderFactory(),
                new StandardDiscountRateProvider()
        );

        ConsoleMenu menu = new ConsoleMenu(
                controller,
                new ConsoleCommandParser()
        );

        menu.run();
    }
}