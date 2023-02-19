package entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name, surname, gender;
    private int balance;
    private static int id = 0;
    private List<Order> orders;

    public Client(String name, String surname, String gender) {
        this(name, surname, gender, 0);
    }

    public Client(String name, String surname, String gender, int balance) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setBalance(balance);
        orders = new ArrayList<>();
    }

    public Client(int id, String name, String surname, String gender, int balance) {
        this(name, surname, gender, balance);
        setId(id);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static void setId(int id) {
        Client.id = id;
    }

    public static int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "entities.Client{" + id + ". " +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
