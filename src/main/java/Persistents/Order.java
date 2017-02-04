package Persistents;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by receme on 1/31/17.
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private int id;
    private String date;
    @OneToMany
    @JoinTable(name = "product_order")
    private List<Product> product = new ArrayList<Product>();

    public Order() {
    }

    public Order(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return product;
    }

    public void setProducts(List<Product> products) {
        this.product = products;
    }
}
