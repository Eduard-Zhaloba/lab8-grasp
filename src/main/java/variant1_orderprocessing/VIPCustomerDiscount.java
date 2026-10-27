package variant1_orderprocessing;

public class VIPCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double totalAmount) {
        return totalAmount * 0.15;
    }
}