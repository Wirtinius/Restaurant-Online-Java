package entities;

public class Dish {
    private String name;
    private int price;
    private int id;
    private static int id_gen = 1;

    public Dish(){
        id = id_gen++;
    }

    public Dish(String name, int price){
        setPrice(price);
        setName(name);
    }

    public Dish(int id, String name, int price){
        this();
        setId(id);
        setPrice(price);
        setName(name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}