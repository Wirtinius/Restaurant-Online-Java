import data.PostgresDB;
import data.interfaces.IDB;
import repositories.UserRepository;
import repositories.interfaces.IUserRepository;
import controllers.UserController;


import data.PostgresDB;
import data.interfaces.IDB;

import java.util.ArrayList;
import java.util.Scanner;


import java.sql.*;

public class Main {


    public static void main(String[] args) {

        IDB db = new PostgresDB();
        IUserRepository repo = new UserRepository(db);
        UserController controller = new UserController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}