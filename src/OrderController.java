public class OrderController {
    private OrderModel model;
    private OrderView view;

    public OrderController(OrderModel model, OrderView view) {
        this.model = model;
        this.view = view;

    }
    public void add(OrderItem i){
        model.addItem(i);
        double t = model.getTotalPrice();
        String o = model.toString();
        view.setItems(i);
    }
}