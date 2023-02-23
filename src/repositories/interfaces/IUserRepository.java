package repositories.interfaces;

import entities.Client;
import entities.Dish;
import entities.Order;

import java.util.List;

public interface IUserRepository {
    boolean createClient(Client client);
    boolean createAdmin(Client admin);
    Client getClient(int id);
    Client loginIn(String name, String surname);
    List<Client> getAllClients();
    boolean adminLogin(String name, String surname);

}