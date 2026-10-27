package variant1_orderprocessing;

public class OrderProcessor {
    private final TaxCalculator taxCalculator;
    private final OrderRepository orderRepository;
    private final NotificationService notificationService;
    private final ReceiptGenerator receiptGenerator;

    public OrderProcessor(TaxCalculator taxCalculator, OrderRepository orderRepository, NotificationService notificationService, ReceiptGenerator receiptGenerator) {
        this.taxCalculator = taxCalculator;
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
        this.receiptGenerator = receiptGenerator;
    }

    public void processOrder(Order order) {
        order.processCalculations(taxCalculator);

        String receipt = receiptGenerator.generate(order);
        System.out.println(receipt);

        orderRepository.save(order);
        notificationService.sendNotification(order.customer, receipt);
    }
}