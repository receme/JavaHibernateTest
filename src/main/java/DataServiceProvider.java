import Persistents.Order;
import Persistents.Product;

import java.util.List;

/**
 * Created by receme on 2/4/17.
 */
public class DataServiceProvider implements DataService{

    private ServiceProvider serviceProvider;
    public DataServiceProvider(ServiceProvider serviceProvider){
        this.serviceProvider = serviceProvider;
    }

    public Product getProduct(int productId) {
        return serviceProvider.getProduct(productId);
    }

    public Order getOrder(int orderId) {
        return serviceProvider.getOrder(orderId);
    }

    public List<Product> getAllProduct() {
        return serviceProvider.getAllProduct();
    }

    public List<Order> getAllOrder() {
        return serviceProvider.getAllOrder();
    }
}
