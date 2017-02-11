import Persistents.Deal;
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

    public void addOrder(Deal deal) throws Exception {
        int result = serviceProvider.addObject(deal);
        serviceProvider.closeSession();

        if (result == 0) {
            throw new Exception("Error occured. Deal is not placed");
        }
    }

    public void addProduct(Product product) throws Exception {
        int result = serviceProvider.addObject(product);
        serviceProvider.closeSession();

        if (result == 0) {
            throw new Exception("Error occured. Product is not added");
        }
    }

    public void deleteOrder(int dealId) throws Exception {
        int result = serviceProvider.deleteObject(dealId);
        serviceProvider.closeSession();

        if (result == 0) {
            throw new Exception("Error occured. Deal is not deleted");
        }
    }

    public void deleteProduct(int objId) throws Exception {
        int result = serviceProvider.deleteObject(objId);
        serviceProvider.closeSession();

        if (result == 0) {
            throw new Exception("Error occured. Product is not deleted");
        }
    }

    public void updateProduct(Product product) throws Exception {
        int result = serviceProvider.updateObject(product);
        serviceProvider.closeSession();

        if (result == 0) {
            throw new Exception("Error occured. Could not update product");
        }
    }

    public Deal getOrder(int orderId) throws Exception {
        Deal deal = serviceProvider.getOrder(orderId);
        serviceProvider.closeSession();
        if (deal == null) {
            throw new Exception("Error occured. Failed to fetch deal");
        }

        return deal;
    }

    public List<Deal> getAllOrder() throws Exception {

        List<Deal> deals = serviceProvider.getAllOrder();
        serviceProvider.closeSession();

        if (deals == null) {
            throw new Exception("Error occured. Failed to fetch deals");
        }

        return deals;
    }

    public Product getProduct(int productId) throws Exception {
        Product product = serviceProvider.getProduct(productId);
        serviceProvider.closeSession();

        if (product == null) {
            throw new Exception("Error occured. Failed to fetch product");
        }

        return product;
    }

    public List<Product> getAllProducts() throws Exception {

        List<Product> products = serviceProvider.getAllProduct();
        serviceProvider.closeSession();

        if (products == null) {
            throw new Exception("Error occured. Failed to fetch products");
        }

        return products;
    }
}
