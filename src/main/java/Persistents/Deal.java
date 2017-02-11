package Persistents;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by receme on 1/31/17.
 */
@Entity
@Table(name = "deal")
public class Deal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int deal_id;
    private String date;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_deal", joinColumns = @JoinColumn(name = "deal_id"),  inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<Product>();

    public Deal() {
    }

    public Deal(String date) {
        this.date = date;
    }

    public int getId() {
        return deal_id;
    }

    public void setId(int id) {
        this.deal_id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
