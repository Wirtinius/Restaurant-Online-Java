package repositories;

import data.interfaces.IDB;
import entities.Client;
import entities.Dish;
import entities.Order;
import repositories.interfaces.IDishRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class DishRepository implements IDishRepository {

    private final IDB db;

    public DishRepository(IDB db) {
        this.db = db;
    }
public ArrayList<Dish> getMenuDishes(){
    Connection con = null;
    try {
        con = db.getConnection();
        String sql = "SELECT id,name,price FROM dishes";
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);
        ArrayList<Dish> dishes = new ArrayList<>();
        while (rs.next()) {
            Dish dish = new Dish(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
            dishes.add(dish);
        }

        return dishes;

    }catch (SQLException throwables) {
        throwables.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } finally {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    return null;
}
}
