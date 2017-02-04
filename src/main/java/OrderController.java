import Persistents.Order;
import Persistents.Product;

/**
 * Created by receme on 2/4/17.
 */
public class OrderController {

    private DataService serviceProvider;

    public OrderController(DataService serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public void addOrder(Order order) throws Exception {
        int result = serviceProvider.addObject(order);
        serviceProvider.closeSession();

        if (result == 0) {
            throw new Exception("Error occured. Order is not placed");
        }
    }

    public void addProduct(Product product) throws Exception {
        int result = serviceProvider.addObject(product);
        serviceProvider.closeSession();

        if (result == 0) {
            throw new Exception("Error occured. Product is not added");
        }
    }

    public void deleteOrder(Order order) throws Exception {
        int result = serviceProvider.deleteObject(order);
        serviceProvider.closeSession();

        if (result == 0) {
            throw new Exception("Error occured. Order is not deleted");
        }
    }

    public void deleteProduct(Product product) throws Exception {
        int result = serviceProvider.deleteObject(product);
        serviceProvider.closeSession();

        if (result == 0) {
            throw new Exception("Error occured. Product is not deleted");
        }
    }

    public Order getOrder(int orderId) throws Exception {
        Order order = serviceProvider.getOrder(orderId);
        serviceProvider.closeSession();
        if (order == null) {
            throw new Exception("Error occured. Failed to fetch order");
        }

        return order;
    }
}
