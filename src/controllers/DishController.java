package controllers;

import entities.Client;
import entities.Dish;
import repositories.interfaces.IDishRepository;

import java.util.ArrayList;
import java.util.List;

public class DishController {
    private final IDishRepository Dishrepo;
    private static Client loggedUser = null;

    public DishController(IDishRepository Dishrepo) {
        this.Dishrepo = Dishrepo;
    }
    public ArrayList<Dish> getMenuDishes() {
        ArrayList<Dish> dishes = (ArrayList<Dish>) Dishrepo.getMenuDishes();

        return dishes;
    }


}
