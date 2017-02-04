import Persistents.Order;
import Persistents.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.List;

/**
 * Created by receme on 2/4/17.
 */
public class HibernateServiceProvider implements DataService {

    private String hibernateConfigFileName;
    private SessionFactory sessionFactory;

    public HibernateServiceProvider() {

        Configuration configuration = new Configuration();

        if (hibernateConfigFileName == null || hibernateConfigFileName.length()==0) {
            configuration = configuration.configure();
        }
        configuration = configuration.configure(hibernateConfigFileName);
        sessionFactory = configuration.buildSessionFactory();
    }

    public void setHibernateConfig(String hibernateConfigFileName) {
        this.hibernateConfigFileName = hibernateConfigFileName;
    }

    public Product getProduct(int productId) {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class,productId);
        session.close();

        return product;
    }

    public Order getOrder(int orderId) {
        return null;
    }

    public List<Product> getAllProduct() {
        Session session = sessionFactory.openSession();
        List<Product> products =  session.createQuery("from Product").list();
        session.close();

        return  products;
    }

    public List<Order> getAllOrder() {
        return null;
    }
}
