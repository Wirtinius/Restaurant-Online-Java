package repositories.interfaces;

import entities.Admin;
import entities.Client;
import entities.Dish;

import java.util.List;

public interface IUserRepository {
    boolean createClient(Client client);
    boolean createAdmin(Client admin);
    Client getClient(int id);
    Client loginIn(String name, String surname);
    List<Client> getAllClients();
    Admin adminLogin(String name, String surname, String password);
    List<Dish> getMenuDishes();

    boolean addDishToMenu(Dish dish);
//    List<Drink> getMenuDrinks();

}