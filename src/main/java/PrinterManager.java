import Persistents.Order;
import Persistents.Product;

import java.util.List;

/**
 * Created by receme on 2/4/17.
 */
public class PrinterManager {

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printOrder(Order order){
        System.out.println("Order date: "+order.getDate());
        System.out.println("Product included in order:");
        List<Product> products = order.getProducts();
        printAllProduct(products);
    }

    public static void printProduct(Product p){
        System.out.println(p.getName()+" "+p.getDescription()+" "+p.getPrice()+" "+p.getDate());
    }

    public static void printAllProduct(List<Product> products){
        for(int i=0;i<products.size();i++){
            Product p = products.get(i);
            printProduct(p);
        }
    }
}
