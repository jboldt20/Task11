import java.util.ArrayList;
import java.util.List;

public class OrderModel {
    private List<OrderItem> items;

    public OrderModel() {
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public void removeItem(OrderItem item) {
        this.items.remove(item);
    }

    public void getItems(OrderItem items){
        for (OrderItem item : this.items) {

        }

    }

    public double getTotalPrice() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}