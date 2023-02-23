import java.util.List;
import java.util.concurrent.TimeUnit;

import controllers.DishController;
import controllers.OrderController;
import controllers.UserController;
import entities.Admin;
import entities.Client;
import entities.Dish;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final UserController controller;
    private final OrderController orderController;
    private final DishController dishController;
    private Client loggedUser = null;
    private Admin loggedAdmin = null;
    public static ArrayList<Integer> orders = new ArrayList<>();
    private final Scanner scanner;
    private ArrayList<Dish> dishes2;

    public MyApplication(UserController controller, OrderController orderController, DishController dishController) {
        this.controller = controller;
        this.orderController = orderController;
        this.dishController = dishController;
        scanner = new Scanner(System.in);
    }
    public ArrayList<Integer> getOrders() {
        return orders;
    }
    public void start() throws InputMismatchException {
        while (true) {
            System.out.println("\n========================");
            System.out.println("=   -AITU Restaurant-  =");
            System.out.println("========================");
            System.out.println("1. Login to account");
            System.out.println("2. Sign Up");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");

            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    loginToAccount();
                } else if (option == 2) {
                    createUserMenu();
                } else if (option == 3) {
                    loginToAdmin();
                } else if (option == 4) {
                    System.out.println("\n ==> Goodbye! See you later! <==");
                    break;
                } else if (option == 999) {
                    //
                } else {
                    System.out.println("Please choose the right command.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void loginToAccount() throws InterruptedException {
        System.out.print("Please enter name: ");
        String name = scanner.next();
        System.out.print("Please enter surname: ");
        String surname = scanner.next();

        boolean response = controller.loginIn(name, surname);
        loggedUser = controller.getLoggedUser();
        if(response){
            System.out.print("\nYou sign in successfully! ");
            System.out.println("Welcome back "+ loggedUser.getName()+"!");
            TimeUnit.SECONDS.sleep(3);
            while (true){
                System.out.println("1. Make an order");
                System.out.println("2. Bring the bill");
                System.out.println("3. Log Out");
                System.out.print("Please choose one of the options: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if(choice == 1){
                    getMenu();
                } else if (choice == 2) {
                    checkBill();
                } else if (choice == 3) {
                    break;
                }else{
                    System.out.println("Please choose the right command.");
                }
            }
        } else{
            System.out.println("\nFailed to sign in.");
            System.out.println("Please try again or sign-up!");
            TimeUnit.SECONDS.sleep(3);
        }
    }
    public void loginToAdmin() throws InterruptedException {
        System.out.print("Please enter name: ");
        String name = scanner.next();
        System.out.print("Please enter surname: ");
        String surname = scanner.next();
        System.out.print("Please enter password: ");
        String password = scanner.next();

        boolean response = controller.adminLogin(name, surname, password);
        loggedAdmin = UserController.getLoggedAdmin();
        if (response){
            System.out.println("\n==> Welcome, "+ loggedAdmin.getName() + "! <==");
            while (true) {
                System.out.println("\n1. Add a dish to the menu");
                System.out.println("2. Remove a dish from the menu");
                System.out.println("3. Edit a dish in the menu");
                System.out.println("4. View the menu");
                System.out.println("5. Log Out");
                System.out.println("6. View all orders");
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    addDishToMenu();
                } else if (option == 4) {
                    viewMenu();
                } else if (option == 5) {
                    break;
                } else if (option == 6) {
                    viewAllOrders();
                }
                else {
                    System.out.println("Please choose the right command.");
                }
            }
        } else{
            System.out.println("\nFailed to sign in.");
            System.out.println("Please try again!");
            TimeUnit.SECONDS.sleep(3);
        }
    }

    public void getMenu(){
        List<Dish> dishes = controller.getMenuDishes();
        dishes2 = new ArrayList<Dish>(dishes);
        System.out.println(dishes.toString());
        System.out.println(dishes2.toString());
        if (dishes != null) {
            System.out.println("\n===========================  -Menu-  ===========================");
            System.out.printf("|%-10s | %-30s | %-15s |%n", "No", "Dish Name", "Price");
            for (Dish dish : dishes2) {
                System.out.printf("|%-10d | %-30s | %15d |%n", dish.getId(), dish.getName(), dish.getPrice());
            }
            System.out.println("================================================================");
            while (true) {
                System.out.print("Make a choice (-1 for exist) :  ");
                int choice1 = scanner.nextInt();
                if (choice1 == -1) {
                    System.out.println();
                    break;
                }

                if(choice1 != -1 && choice1 <= dishes.size()){
                    orders.add(choice1 - 1);
                }else{
                    System.out.println("Please enter right id's");
                }
            }
        }else {
            System.out.println("NULL");
        }
        if(dishes != null){
            System.out.println("Your orders are successfully added!");
            System.out.println("*************************\n");
        }
    }

    public void checkBill(){
        int[] orderz = new int[orders.size()];
        for(int i=0; i<orders.size(); i++){
            orderz[i] = orders.get(i);
        }

        int summa = 0, index = 1;
        System.out.println("\n===========================  -Checkout-  ===========================");
        System.out.printf("|%-10s | %-30s | %-15s |%n", "No", "Dish Name", "Price");
        for (int o:orderz) {
            System.out.printf("|%-10d | %-30s | %15f |%n", index++, dishes2.get(o).getName(), dishes2.get(o).getPrice());
            summa += dishes2.get(o).getPrice();
        }
        System.out.println("=====================================================================");

        System.out.printf("%nTotal price: %d%n%n", summa);
    }

    public void getAllUsersMenu() {
        String response = controller.getAllClients();
        System.out.println(response);
    }

    public void getUserByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getClient(id);
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender (male/female)");
        String gender = scanner.next();

        String response = controller.createClient(name, surname, gender);
        System.out.println(response);
    }

    public void addDishToMenu() {
        System.out.print("Enter dish name: ");
        String dishName = scanner.next();
        System.out.print("Enter dish price: ");
        int dishPrice = scanner.nextInt();

        String response = controller.addDishToMenu(dishName, dishPrice);
        System.out.println(response);
    }


    public void viewMenu() {
        System.out.println("\n========================");
        System.out.println("=   -AITU Restaurant-  =");
        System.out.println("========================");
        System.out.println("Dishes on the menu:");
        for (Dish dish : dishes2) {
            System.out.println(dish.getName() + " - $" + dish.getPrice());
        }
    }
    public void viewAllOrders() {
//        ArrayList<Client> clients = controller.getClients();
//        System.out.println("\n=======================================");
//        System.out.println("|      Order History of All Clients    |");
//        System.out.println("=======================================");
//        for (Client client : clients) {
//            ArrayList<Integer> clientOrders = client.getOrders();
//            if (clientOrders.size() > 0) {
//                System.out.println("\nClient: " + client.getName() + " " + client.getSurname());
//                System.out.println("Orders:");
//                for (Integer order : clientOrders) {
//                    System.out.println(" - " + dishess.get(order).getName() + " ($" + dishess.get(order).getPrice() + ")");
//                }
//            }
//        }
        System.out.println("=======================================\n");
    }



}
