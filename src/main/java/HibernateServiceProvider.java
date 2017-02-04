import Persistents.Order;
import Persistents.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.List;

/**
 * Created by receme on 2/4/17.
 */
public class HibernateServiceProvider implements ServiceProvider {

    private String hibernateConfigFileName;
    private SessionFactory sessionFactory;
    private static HibernateServiceProvider provider;

    private HibernateServiceProvider() {

        Configuration configuration = new Configuration();

        if (hibernateConfigFileName == null || hibernateConfigFileName.length()==0) {
            configuration = configuration.configure();
        }
        configuration = configuration.configure(hibernateConfigFileName);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static HibernateServiceProvider getInstance(){

        if(provider == null){
            provider = new HibernateServiceProvider();
        }
        return provider;
    }

    public void setHibernateConfig(String hibernateConfigFileName) {
        this.hibernateConfigFileName = hibernateConfigFileName;
        provider = null;
    }

    public Product getProduct(int productId) {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class,productId);
        session.close();

        return product;
    }

    public Order getOrder(int orderId) {
        Session session = sessionFactory.openSession();
        Order order = session.get(Order.class,orderId);
        session.close();

        return  order;
    }

    public List<Product> getAllProduct() {
        Session session = sessionFactory.openSession();
        List<Product> products =  session.createQuery("from Product",Product.class).list();
        session.close();

        return  products;
    }

    public List<Order> getAllOrder() {
        Session session = sessionFactory.openSession();
        List<Order> orders = session.createQuery("from Order",Order.class).list();
        session.close();

        return  orders;
    }

    public int addObject(Object obj) {
        Session session = null;
        int result = 0;
        try{

            session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            session.persist(obj);
            t.commit();

            result = 1;

        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session!=null){
                session.close();
            }
        }

        return result;
    }

    public int deleteObject(Object obj) {

        Session session = null;
        int result = 0;

        try{
            session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            session.delete(obj);
            t.commit();

            result = 1;

        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session!=null){
                session.close();
            }
        }

        return result;
    }

    public int updateObject(Object obj) {

        Session session = null;
        int result = 0;

        try{
            session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            session.update(obj);
            t.commit();

            result = 1;

        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session!=null){
                session.close();
            }
        }

        return result;
    }
}
