package variant1_orderprocessing;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public int id;
    public Customer customer;
    public List<OrderItem> items = new ArrayList<>();
    public double totalAmount;
    public double discountAmount;
    public double taxAmount;
    public double finalAmount;
    public String status;


    public void processCalculations(TaxCalculator taxCalculator) {
        double subtotal = 0.0;
        for (OrderItem item : items) {
            subtotal += item.calculateSubtotal();
        }
        this.totalAmount = subtotal;

        DiscountStrategy discountStrategy = DiscountStrategyFactory.getStrategy(customer.type);
        this.discountAmount = discountStrategy.calculateDiscount(this.totalAmount);

        double taxableAmount = this.totalAmount - this.discountAmount;
        this.taxAmount = taxCalculator.calculateTax(taxableAmount);
        this.finalAmount = taxableAmount + this.taxAmount;
        this.status = "Processed";
    }
}