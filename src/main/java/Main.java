import Persistents.Order;
import Persistents.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        //creating configuration object
//        Configuration cfg=new Configuration();
//        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
//
//        //creating seession factory object
//        SessionFactory factory=cfg.buildSessionFactory();
//
//        //creating session object
//        Session session=factory.openSession();
//
//        //creating transaction object
//        Transaction t=session.beginTransaction();
//
//        Product e1=new Product();
//        e1.setName("ppp");
//        e1.setPrice("saxcxc");
//        e1.setDate("22/09/2020");
//
//        session.persist(e1);//persisting the object
//        //session.update(e1);
//
//
//        t.commit();//transaction is committed
//        session.close();
//
//        System.out.println("successfully saved");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Product product = session.get(Product.class, 8);

        List<Product> products = session.createQuery("from Product").list();

        Order order = session.get(Order.class,2);
        //List<Order> orders = session.createQuery("from Order").list();

        if(order!=null){
            System.out.println(order.getId());
            System.out.println(order.getDate());

            List<Product> products1 = order.getProducts();
            System.out.println("____Product details____");
            for(int i=0;i<products1.size();i++){
                Product p = products1.get(i);
                System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getDescription());
            }
        }
    }
}
