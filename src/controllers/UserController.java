package controllers;

import entities.Admin;
import entities.Client;
import entities.Dish;
import repositories.interfaces.IUserRepository;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final IUserRepository repo;
    private static Client loggedUser = null;
    private static Admin loggedAdmin = null;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public boolean loginIn(String name, String surname){
        loggedUser = repo.loginIn(name, surname);

        if(!(loggedUser == null)){
            return true;
        }
        return false;
    }

    public boolean adminLogin(String name, String surname, String password){
        loggedAdmin = repo.adminLogin(name, surname, password);

        if(!(loggedAdmin == null)){
            return true;
        }
        return false;
    }

    public Client getLoggedUser() {
        return loggedUser;
    }

    public String createClient(String name, String surname, String gender) {
        Client client = new Client(name, surname, gender);

        boolean created = repo.createClient(client);
        return (created ? "Client was created!" : "Client creation was failed!");
    }

    public String getClient(int id) {
        Client client = repo.getClient(id);

        return (client == null ? "User was not found!" : client.toString());
    }

    public String getAllClients() {
        List<Client> clients = repo.getAllClients();

        return clients.toString();
    }

    public ArrayList<Dish> getMenuDishes() {
        ArrayList<Dish> dishes = (ArrayList<Dish>) repo.getMenuDishes();

        return dishes;
    }

    public static Admin getLoggedAdmin() {
        return loggedAdmin;
    }

    public String getMenuDrinks() {
        List<Client> clients = repo.getAllClients();

        return clients.toString();
    }

    public String addDishToMenu(String name, int price) {
        Dish dish = new Dish(name, price);

        boolean created = repo.addDishToMenu(dish);
        return (created ? "Dish was added!" : "Dish creation was failed!");
    }
}