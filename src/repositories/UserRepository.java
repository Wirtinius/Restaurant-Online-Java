package repositories;

import data.interfaces.IDB;
import entities.Admin;
import entities.Client;
import entities.Dish;
import entities.Order;
import repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createClient(Client client) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO clients(name,surname,gender, balance) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, client.getName());
            st.setString(2, client.getSurname());
            st.setString(3, client.getGender());
            st.setInt(4, client.getBalance());

            st.execute();
            return true;
        } catch (SQLException throwables) {
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
        return false;
    }
    public boolean createAdmin(Client admin) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO clients(name,surname,gender, balance) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, admin.getName());
            st.setString(2, admin.getSurname());
            st.setString(3, admin.getGender());
            st.setInt(4, admin.getBalance());

            st.execute();
            return true;
        } catch (SQLException throwables) {
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
        return false;
    }

    @Override
    public Client getClient(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender, balance FROM clients WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Client client = new Client(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender"),
                        rs.getInt("balance"));

                return client;
            }
        } catch (SQLException throwables) {
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
    @Override
    public List<Client> getAllClients() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM clients";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Client> clients = new LinkedList<>();
            while (rs.next()) {
                Client client = new Client(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender"),
                        rs.getInt("balance"));

                clients.add(client);
            }

            return clients;
        } catch (SQLException throwables) {
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



    public Client loginIn(String name, String surname){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender, balance FROM clients";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Client> clients = new LinkedList<>();
            while (rs.next()) {
                Client client = new Client(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender"),
                        rs.getInt("balance"));

                clients.add(client);
            }

            for(entities.Client c : clients){
                if(c.getName().equals(name) && c.getSurname().equals(surname)){
                    return c;
                }
            }


        } catch (SQLException throwables) {
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

    public Admin adminLogin(String name, String surname, String password)  {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql1 = "SELECT * FROM admins";
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery(sql1);
            List<Admin> admins = new LinkedList<>();

            while (rs1.next()) {
                Admin admin = new Admin(rs1.getInt("id"),
                        rs1.getString("name"),
                        rs1.getString("surname"),
                        rs1.getString("password"));

                admins.add(admin);
            }

            for(entities.Admin a : admins){
                if(a.getName().equals(name) && a.getSurname().equals(surname) && a.getPassword().equals(password)){
                        return a;
                }
            }


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

    @Override
    public List<Dish> getMenuDishes() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM dishes";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Dish> dishes = new LinkedList<>();
            while (rs.next()) {
                Dish dish = new Dish(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"));

                dishes.add(dish);
            }

            return dishes;
        } catch (SQLException throwables) {
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


    public boolean addDishToMenu(Dish dish) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO dishes(name,price) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, dish.getName());
            st.setInt(2, dish.getPrice());

            st.execute();
            return true;
        } catch (SQLException throwables) {
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
        return false;
    }


}