package variant1_orderprocessing;

public class OrderItem {
    public Product product;
    public int quantity;

    public double calculateSubtotal() {
        return product.price * quantity;
    }
}