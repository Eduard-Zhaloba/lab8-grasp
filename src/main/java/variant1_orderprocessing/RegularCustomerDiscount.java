package variant1_orderprocessing;

public class RegularCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double totalAmount) {
        return totalAmount * 0.05;
    }
}