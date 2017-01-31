package Persistents;

/**
 * Created by receme on 1/31/17.
 */
public class Product {

    private int id;
    private String name;
    private String price;
    private String date;

    public Product(){

    }

    public Product(int id, String name, String price, String date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
