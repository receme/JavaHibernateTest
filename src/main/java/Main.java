import Persistents.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by receme on 1/31/17.
 */
public class Main {

    public static void main(String[] args) {

        //creating configuration object
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

        //creating seession factory object
        SessionFactory factory=cfg.buildSessionFactory();

        //creating session object
        Session session=factory.openSession();

        //creating transaction object
        Transaction t=session.beginTransaction();

        Product e1=new Product();
        e1.setName("ppp");
        e1.setPrice("saxcxc");
        e1.setDate("22/09/2020");

        session.persist(e1);//persisting the object
        //session.update(e1);


        t.commit();//transaction is committed
        session.close();

        System.out.println("successfully saved");

    }
}
