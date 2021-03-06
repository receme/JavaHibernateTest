package Persistents;

import javax.persistence.*;

/**
 * Created by receme on 1/31/17.
 */

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int product_id;
    private String name;
    private String price;
    private String description;
    private String date;

    public Product() {

    }

    public Product(String name, String price, String description, String date) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return product_id;
    }

    public void setId(int id) {
        this.product_id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


