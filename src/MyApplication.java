
import controllers.UserController;
import entities.Dish;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    private final UserController controller;
    public static ArrayList<Integer> orders = new ArrayList<>();
    private final Scanner scanner;
    private ArrayList<Dish> dishess = new ArrayList<>();

    public MyApplication(UserController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() throws InputMismatchException {
        while (true) {
            System.out.println("\n========================");
            System.out.println("=   -AITU Restaurant-  =");
            System.out.println("========================");
            System.out.println("1. Login to account");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");

            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    loginToAccount();
                } else if (option == 2) {
                    createUserMenu();
                } else if (option == 3) {
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

    public void loginToAccount(){
        System.out.print("Please enter name: ");
        String name = scanner.next();
        System.out.print("Please enter surname: ");
        String surname = scanner.next();

        String response = controller.loginIn(name, surname);
        System.out.println(response);
        if(response.equals("<==- You sign in successfully! -==>")){
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
        }else{
            System.out.println("Please try again or sign-up");
        }
    }

    public void getMenu(){
        ArrayList<Dish> dishes = controller.getMenuDishes();
        dishess = dishes;
        if (dishes != null) {
            System.out.println("\n===========================  -Menu-  ===========================");
            System.out.printf("|%-10s | %-30s | %-15s |%n", "No", "Dish Name", "Price");
            for (entities.Dish dish : dishes) {
                System.out.printf("|%-10d | %-30s | %15f |%n", dish.getId(), dish.getName(), dish.getPrice());
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
            System.out.printf("|%-10d | %-30s | %15f |%n", index++, dishess.get(o).getName(), dishess.get(o).getPrice());
            summa += dishess.get(o).getPrice();
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
}
