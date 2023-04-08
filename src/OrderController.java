public class OrderController {
    private OrderModel model;
    private OrderView view;

    public OrderController(OrderModel model, OrderView view) {
        this.model = model;
        this.view = view;

        }
}