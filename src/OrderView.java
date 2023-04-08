import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class OrderView extends JFrame implements ActionListener {

    private OrderModel orderModel;
    private JLabel titleLabel;
    private JTextArea orderTextArea;
    private JTextField totalTextField;
    private JButton hamburgerButton;
    private JButton chickenSandwichButton;
    private JButton popButton;
    private JButton friesButton;
    private JButton combo1Button;
    private JButton combo2Button;

    public OrderView(OrderModel model) {
        this.orderModel = model;
        setTitle("Order System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    protected void initializeComponents() {

        titleLabel = new JLabel("Order Items:");

        orderTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(orderTextArea);

        totalTextField = new JTextField();
        totalTextField.setText("$0.00");

        hamburgerButton = new JButton("Hamburger ($5.00)");
        hamburgerButton.addActionListener(this);

        chickenSandwichButton = new JButton("Chicken Sandwich ($6.00)");
        chickenSandwichButton.addActionListener(this);

        popButton = new JButton("Pop ($1.50)");
        popButton.addActionListener(this);

        friesButton = new JButton("Fries ($2.00)");
        friesButton.addActionListener(this);

        combo1Button = new JButton("Combo #1 ($8.55)");
        combo1Button.addActionListener(this);

        combo2Button = new JButton("Combo #2 ($9.45)");
        combo2Button.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout());
        buttonPanel.add(hamburgerButton);
        buttonPanel.add(chickenSandwichButton);
        buttonPanel.add(popButton);
        buttonPanel.add(friesButton);
        buttonPanel.add(combo1Button);
        buttonPanel.add(combo2Button);

        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new BorderLayout());
        orderPanel.add(titleLabel, BorderLayout.NORTH);
        orderPanel.add(scrollPane, BorderLayout.CENTER);


        JPanel totalPanel = new JPanel();
        totalPanel.add(new JLabel("Total:"));
        totalPanel.add(totalTextField);

        setLayout(new BorderLayout());
        add(orderPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(totalPanel, BorderLayout.SOUTH);
    }


    protected void updateTotalTextField() {
        totalTextField.setText("$" + orderModel.getTotalPrice());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hamburgerButton) {
            OrderItem hamburger = new Product("Hamburger", 3.50);
            orderModel.addItem(hamburger);
        } else if (e.getSource() == chickenSandwichButton) {
            OrderItem chicken = new Product("Chicken Sandwich", 3.50);
            orderModel.addItem(chicken);
        } else if (e.getSource() == popButton) {
            OrderItem pop = new Product("Pop", 1.00);
            orderModel.addItem(pop);
        } else if (e.getSource() == friesButton) {
            OrderItem fries = new Product("Fries", 2.00);
            orderModel.addItem(fries);
        } else if (e.getSource() == combo1Button) {
            OrderItem combo1 = new Product("Combo 1", 5.00);
            orderModel.addItem(combo1);
        } else if (e.getSource() == combo2Button) {
            OrderItem combo2 = new Product("Combo 2", 5.00);
            orderModel.addItem(combo2);
        }
    }
}