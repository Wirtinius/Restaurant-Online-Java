package entities;

public class Client {
    private String name, surname, gender;
    private int balance;
    private static int id = 0;



    public Client(String name, String surname, String gender){
        setName(name);
        setSurname(surname);
        setGender(gender);
    }

    public Client(int id ,String name, String surname, String gender, int balance){
        this(name, surname, gender);
        setId(id);
        setBalance(balance);
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

    public Client(int id, String name, String surname, String gender){
        this(name, surname, gender);
        setId(id);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
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

    public static int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "entities.Client{" + id + ". " +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
