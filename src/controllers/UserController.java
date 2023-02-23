package controllers;

import entities.Client;
import entities.Dish;
import entities.Order;
import repositories.interfaces.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final IUserRepository Userrepo;
    private static Client loggedUser = null;

    public UserController(IUserRepository Userrepo) {
        this.Userrepo = Userrepo;
    }

    public boolean loginIn(String name, String surname){
        loggedUser = Userrepo.loginIn(name, surname);

        if(!(loggedUser == null)){
            return true;
        }
        return false;
    }

    public Client getLoggedUser() {
        return loggedUser;
    }

    public String createClient(String name, String surname, String gender) {
        Client client = new Client(name, surname, gender);

        boolean created = Userrepo.createClient(client);
        return (created ? "Client was created!" : "Client creation was failed!");
    }

    public String getClient(int id) {
        Client client = Userrepo.getClient(id);

        return (client == null ? "User was not found!" : client.toString());
    }

    public String getAllClients() {
        List<Client> clients = Userrepo.getAllClients();

        return clients.toString();
    }

    public ArrayList<Dish> getMenuDishes() {
        ArrayList<Dish> dishes = (ArrayList<Dish>) Userrepo.getMenuDishes();

        return dishes;
    }

    public String getMenuDrinks() {
        List<Client> clients = Userrepo.getAllClients();

        return clients.toString();
    }

    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> orders = (ArrayList<Order>) Userrepo.getAllOrders();

        return orders;
    }
}
