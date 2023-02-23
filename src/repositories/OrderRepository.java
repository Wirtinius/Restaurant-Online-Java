package repositories;

import data.interfaces.IDB;
import entities.Client;
import entities.Dish;
import entities.Order;
import repositories.interfaces.IOrderRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderRepository implements IOrderRepository {

//    private final IDB db;
//
//    public OrderRepository(IDB db) {
//        this.db = db;
//    }

    @Override
    public List<Order> getAllOrders() {
        return null;
//        rewrite
    }
}