package variant1_orderprocessing;

public interface ReceiptGenerator {
    String generate(Order order);
}

class StandardReceiptGenerator implements ReceiptGenerator {
    @Override
    public String generate(Order order) {
        return "Замовлення #" + order.id + " для " + order.customer.name +
                "\nСума: " + order.totalAmount + " грн" +
                "\nЗнижка: " + order.discountAmount + " грн" +
                "\nПДВ: " + order.taxAmount + " грн" +
                "\nДо сплати: " + order.finalAmount + " грн";
    }
}