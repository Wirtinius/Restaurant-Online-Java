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

        // ========================= -Logging Page- =================================
        Scanner input = new Scanner(System.in);
        boolean isClient = false;
        entities.Client loggedClient = null;


        System.out.println("\n========================");
        System.out.println("=   -AITU Restaurant-  =");
        System.out.println("========================");

        System.out.print("Please enter your name: ");
        String name = input.nextLine();
        System.out.print("Please enter your surname: ");
        String surname = input.nextLine();
        for (entities.Client c : clients) {
            if (c.getName().equals(name) && c.getSurname().equals(surname)) {
                isClient = true;
                loggedClient = c;
            }
        }
        if (isClient) {
            System.out.printf("\nWelcome to the our restaurant %s!\n\n", loggedClient.getName());
            clientLog(loggedClient, dishes);
        }

        //===========================================================================
    }
}