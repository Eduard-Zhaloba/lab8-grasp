package variant1_orderprocessing;

public class DiscountStrategyFactory {
    public static DiscountStrategy getStrategy(String customerType) {
        if ("VIP".equalsIgnoreCase(customerType)) {
            return new VIPCustomerDiscount();
        } else if ("Regular".equalsIgnoreCase(customerType)) {
            return new RegularCustomerDiscount();
        } else {
            return new NewCustomerDiscount();
        }
    }
}