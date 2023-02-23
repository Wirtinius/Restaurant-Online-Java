package repositories.interfaces;

import entities.Order;

import java.util.List;

public interface IOrderRepository {
    List<Order> getAllOrders();
    }
