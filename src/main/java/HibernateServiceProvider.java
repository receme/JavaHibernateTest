import Persistents.Deal;
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

    private String hibernateConfigFileName = null;
    private SessionFactory sessionFactory;
    private static HibernateServiceProvider provider;
    private Session session;

    private HibernateServiceProvider() {

        Configuration configuration = new Configuration();

        if (hibernateConfigFileName == null || hibernateConfigFileName.length()==0) {
            configuration = configuration.configure();
        }
        else{
            configuration = configuration.configure(hibernateConfigFileName);
        }

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
        session = sessionFactory.openSession();
        Product product = session.get(Product.class,productId);
        return product;
    }

    public Deal getOrder(int orderId) {
        session = sessionFactory.openSession();
        Deal deal = session.get(Deal.class,orderId);
        session.close();

        return deal;
    }

    public List<Product> getAllProduct() {
        session = sessionFactory.openSession();
        List<Product> products =  session.createQuery("from Product",Product.class).list();
        session.close();

        return  products;
    }

    public List<Deal> getAllOrder() {
        session = sessionFactory.openSession();
        List<Deal> deals = session.createQuery("from Deal", Deal.class).list();
        session.close();

        return deals;
    }

    public int addObject(Object obj) {
        session = null;
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

        session = null;
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

        session = null;
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

    public void closeSession() {
        if(session!=null){
            session.close();
        }
    }


}
