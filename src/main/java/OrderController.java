import Persistents.Order;
import Persistents.Product;

import java.util.List;

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

    public void updateProduct(Product product) throws Exception {
        int result = serviceProvider.updateObject(product);
        serviceProvider.closeSession();

        if(result == 0){
            throw new Exception("Error occured. Could not update product");
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

    public List<Order> getAllOrder() throws Exception {

        List<Order> orders = serviceProvider.getAllOrder();
        serviceProvider.closeSession();

        if(orders==null){
            throw new Exception("Error occured. Failed to fetch orders");
        }

        return orders;
    }

    public Product getProduct(int productId) throws Exception {
        Product product = serviceProvider.getProduct(productId);
        serviceProvider.closeSession();

        if(product == null){
            throw new Exception("Error occured. Failed to fetch product");
        }

        return product;
    }

    public List<Product> getAllProducts() throws Exception {

        List<Product> products = serviceProvider.getAllProduct();
        serviceProvider.closeSession();

        if(products==null){
            throw new Exception("Error occured. Failed to fetch products");
        }

        return products;
    }
}
