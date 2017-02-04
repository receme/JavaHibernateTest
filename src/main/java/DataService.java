import Persistents.Order;
import Persistents.Product;

import java.util.List;

/**
 * Created by receme on 2/4/17.
 */
public interface DataService {
    Product getProduct(int productId);
    Order getOrder(int orderId);
    List<Product> getAllProduct();
    List<Order> getAllOrder();
}
