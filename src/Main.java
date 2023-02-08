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

    public static void clientLog(entities.Client loggedClient, ArrayList<entities.Dish> dishes) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> orders = new ArrayList<Integer>();
        boolean flag = true;
        int summa = 0, choice1;
        while (flag) {
            System.out.println("1. Make an order");
            System.out.println("2. Make a gift");
            System.out.println("3. Bring the bill");
            System.out.println("4. Exit");
            System.out.print("Please choose one of the options: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\n===========================  -Menu-  ===========================");
                    System.out.printf("|%-10s | %-30s | %-15s |%n", "No", "entities.Dish Name", "Price");
                    for (entities.Dish dish : dishes) {
                        System.out.printf("|%-10d | %-30s | %15f |%n", dish.getId(), dish.getName(), dish.getPrice());
                    }
                    while (true) {
                        System.out.print("Make a choice (-1 for exist) :  ");
                        choice1 = input.nextInt();

                        if (choice1 == -1) {
                            System.out.println();
                            break;
                        }

                        orders.add(choice1 - 1);

                        summa += dishes.get(choice1 - 1).getPrice();

                    }
                    break;
                case 3:
                    System.out.println("\n===========================  -Checkout-  ===========================");
                    System.out.printf("|%-10s | %-30s | %-15s |%n", "No", "entities.Dish Name", "Price");
                    for (Integer o : orders) {
                        System.out.printf("|%-10d | %-30s | %15f |%n", dishes.get(o).getId(), dishes.get(o).getName(), dishes.get(o).getPrice());
                    }
                    System.out.printf("%nTotal price: %d%n%n", summa);
                    break;

                case 4:
                    System.out.println("Goodbye");
                    flag = false;
            }
        }
            }


}