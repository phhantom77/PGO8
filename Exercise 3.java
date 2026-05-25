import java.util.ArrayList;
import java.util.List;

record OrderSummary(String orderNumber, String customerName, double totalAmount) {}

class Order {
    private String orderNumber;
    private String customerName;
    private List<OrderItem> items;

    public Order(String orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public String getOrderNumber() { return orderNumber; }
    public String getCustomerName() { return customerName; }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double total() {
        return items.stream().mapToDouble(OrderItem::total).sum();
    }

    public static class OrderItem {
        private String productName;
        private double unitPrice;
        private int quantity;

        public OrderItem(String productName, double unitPrice, int quantity) {
            this.productName = productName;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        public double total() {
            return unitPrice * quantity;
        }
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        Order order = new Order("ORD-100", "Anna Kowalska");

        order.addItem(new Order.OrderItem("Keyboard", 249.99, 1));
        order.addItem(new Order.OrderItem("Mouse", 99.99, 2));

        OrderSummary summary = new OrderSummary(
                order.getOrderNumber(),
                order.getCustomerName(),
                order.total()
        );

        System.out.println(summary);
    }
}
