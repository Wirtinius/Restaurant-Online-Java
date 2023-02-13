package repositories.interfaces;

import entities.Client;
import entities.Dish;

import java.util.List;

public interface IUserRepository {
    boolean createClient(Client client);
    Client getClient(int id);
    Client loginIn(String name, String surname);
    List<Client> getAllClients();
    List<Dish> getMenuDishes();
//    List<Drink> getMenuDrinks();

}