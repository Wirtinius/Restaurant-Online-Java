package entities;

public class Admin {
    private String name, surname, password;
    private static int id = 0;

    public Admin(int id, String name, String surname, String password){
        setId(id);
        setPassword(password);
        setName(name);
        setSurname(surname);
    }

    public String getName() {
        return name;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Admin.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
