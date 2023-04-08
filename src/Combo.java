import java.util.ArrayList;
import java.util.List;

public class Combo implements OrderItem {
    private List<Product> items;

    public Combo() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product p) {
        this.items.add(p);
    }

    public void removeItem(Product p) {
        this.items.remove(p);
    }

    @Override
    public String getName() {
        StringBuilder name = new StringBuilder("Combo: ");
        for (Product p : items) {
            name.append(p.getName()).append(", ");
        }
        name.delete(name.length() - 2, name.length());
        return name.toString();
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }
}