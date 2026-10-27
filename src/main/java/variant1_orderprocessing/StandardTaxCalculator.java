package variant1_orderprocessing;

public class StandardTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double amountAfterDiscount) {
        return amountAfterDiscount * 0.20;
    }
}