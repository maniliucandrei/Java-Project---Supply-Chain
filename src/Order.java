public class Order {
    private String orderId;
    private Product product;
    private int quantity;
    private boolean isFulfilled;

    public Order(String orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.isFulfilled = false;
    }

    public String getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isFulfilled() {
        return isFulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        isFulfilled = fulfilled;
    }

    @Override
    public String toString() {
        return String.format("Order ID: %s, Product: %s, Quantity: %d, Fulfilled: %s",
                orderId, product.getName(), quantity, isFulfilled ? "Yes" : "No");
    }
}