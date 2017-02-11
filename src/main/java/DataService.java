import Persistents.Deal;
import Persistents.Product;

import java.util.List;

/**
 * Created by receme on 2/4/17.
 */
public interface DataService {
    Product getProduct(int productId);
    Deal getOrder(int orderId);
    List<Product> getAllProduct();
    List<Deal> getAllOrder();
    int addObject(Object obj);
    int deleteObject(Object obj);
    int updateObject(Object obj);
    void closeSession();
}
