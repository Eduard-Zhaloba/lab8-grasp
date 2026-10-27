package variant1_orderprocessing;

public class NewCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double totalAmount) {
        return 0.0;
    }
}