package entities;

import java.util.Date;

public class Order {
    private int orderId;
    private Date orderDate;
    private Client client;

    public Order(int orderId, Date orderDate, Client client) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.client = client;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", client=" + client +
                '}';
    }
}
