package controllers;

import entities.Client;
import entities.Dish;
import entities.Order;
import repositories.interfaces.IOrderRepository;

import java.util.ArrayList;
import java.util.List;


public class OrderController {
    private final IOrderRepository Orderrepo;
    private static Client loggedUser = null;

    public OrderController(IOrderRepository Orderrepo) {
        this.Orderrepo = Orderrepo;
    }

    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> orders = (ArrayList<Order>) Orderrepo.getAllOrders();

        return orders;
    }
}
