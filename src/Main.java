import data.PostgresDB;
import data.interfaces.IDB;
import repositories.OrderRepository;
import repositories.UserRepository;
import repositories.DishRepository;
import repositories.interfaces.IUserRepository;
import controllers.UserController;
import repositories.interfaces.IOrderRepository;
import controllers.OrderController;
import controllers.DishController;
import repositories.interfaces.IDishRepository;

import data.PostgresDB;
import data.interfaces.IDB;

import java.util.ArrayList;
import java.util.Scanner;


import java.sql.*;

public class Main {


    public static void main(String[] args) {

        IDB db = new PostgresDB();
        IUserRepository userrepo = new UserRepository(db);
        UserController usercontroller = new UserController(userrepo);
        IOrderRepository orderrepo = new OrderRepository(db);
        OrderController ordercontroller = new OrderController(orderrepo);
        IDishRepository dishrepo = new DishRepository(db);
        DishController dishcontroller = new DishController(dishrepo);
        MyApplication app = new MyApplication(usercontroller, ordercontroller, dishcontroller);
        app.start();
    }
}