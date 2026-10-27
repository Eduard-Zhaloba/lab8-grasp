package ua.edu.lab8.cli;

import ua.edu.lab8.application.CreateOrderRequest;
import ua.edu.lab8.application.OrderController;
import ua.edu.lab8.application.OrderResult;

import java.util.Scanner;

public class ConsoleMenu {
    private final OrderController controller;
    private final ConsoleCommandParser parser;

    public ConsoleMenu(
            OrderController controller,
            ConsoleCommandParser parser
    ) {
        this.controller = controller;
        this.parser = parser;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Оформлення замовлення ===");
            System.out.println("1. Створити замовлення");
            System.out.println("0. Вийти");
            System.out.print("Ваш вибір: ");

            String command = scanner.nextLine();

            if ("0".equals(command)) {
                return;
            }

            if (!"1".equals(command)) {
                System.out.println("Невідома команда");
                continue;
            }

            System.out.print("Ім'я клієнта: ");
            String name = scanner.nextLine();

            System.out.print("Тип клієнта (New/Regular/VIP): ");
            String type = scanner.nextLine();

            System.out.print("Кількість ноутбуків: ");
            String laptops = scanner.nextLine();

            System.out.print("Кількість мишок: ");
            String mice = scanner.nextLine();

            try {
                CreateOrderRequest request =
                        parser.parse(name, type, laptops, mice);

                OrderResult result = controller.processOrder(request);

                System.out.println("\nЗамовлення #" + result.orderId());
                System.out.println("Клієнт: " + result.customerName());
                System.out.println("Сума: " + result.totalAmount() + " грн");
                System.out.println("Знижка: " + result.discountAmount() + " грн");
                System.out.println("ПДВ: " + result.taxAmount() + " грн");
                System.out.println("До сплати: " + result.finalAmount() + " грн");
                System.out.println("Статус: " + result.status());

            } catch (IllegalArgumentException | IllegalStateException exception) {
                System.out.println("Помилка: " + exception.getMessage());
            }
        }
    }
}