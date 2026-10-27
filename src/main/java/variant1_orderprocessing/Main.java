package variant1_orderprocessing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Оформлення замовлення ===");
        System.out.print("Введіть ім'я клієнта: ");
        String name = scanner.nextLine();
        System.out.print("Введіть тип клієнта (New/Regular/VIP): ");
        String customerType = scanner.nextLine();
        scanner.close();

        Customer customer = new Customer();
        customer.id = 1;
        customer.name = name;
        customer.email = "client@example.com";
        customer.type = customerType;
        customer.totalSpent = 15000.0;

        Order order = new Order();
        order.id = 101;
        order.customer = customer;
        order.status = "New";

        Product p1 = new Product();
        p1.id = 1; p1.name = "Ноутбук"; p1.price = 30000.0; p1.category = "Electronics";
        Product p2 = new Product();
        p2.id = 2; p2.name = "Мишка"; p2.price = 800.0; p2.category = "Accessories";

        OrderItem item1 = new OrderItem(); item1.product = p1; item1.quantity = 1;
        OrderItem item2 = new OrderItem(); item2.product = p2; item2.quantity = 2;
        order.items.add(item1);
        order.items.add(item2);

        TaxCalculator taxCalculator = new StandardTaxCalculator();
        OrderRepository orderRepository = new FileOrderRepository();
        NotificationService notificationService = new EmailNotificationService();
        ReceiptGenerator receiptGenerator = new StandardReceiptGenerator();

        OrderProcessor processor = new OrderProcessor(taxCalculator, orderRepository, notificationService, receiptGenerator);

        processor.processOrder(order);
    }
}