package repositories.interfaces;

import entities.Dish;

import java.util.List;

public interface IDishRepository {


    List<Dish> getMenuDishes();

    //    List<Drink> getMenuDrinks();
}
