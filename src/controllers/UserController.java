package controllers;

import entities.Client;
import entities.Dish;
import repositories.interfaces.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public String loginIn(String name, String surname){
        boolean logged = repo.loginIn(name, surname);

        if(logged){
            return "<==- You sign in successfully! -==>";
        }
        return "\nFailed to sign in!";
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

    public String getMenuDrinks() {
        List<Client> clients = repo.getAllClients();

        return clients.toString();
    }
}