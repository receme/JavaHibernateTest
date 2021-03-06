import Persistents.Deal;
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

    public Deal getOrder(int orderId) {
        return serviceProvider.getOrder(orderId);
    }

    public List<Product> getAllProduct() {
        return serviceProvider.getAllProduct();
    }

    public List<Deal> getAllOrder() {
        return serviceProvider.getAllOrder();
    }

    public int addObject(Object obj) {
        return serviceProvider.addObject(obj);
    }

    public int deleteObject(int objId) {
        return serviceProvider.deleteObject(objId);
    }

    public int updateObject(Object obj) {
        return serviceProvider.updateObject(obj);
    }

    public void closeSession() {
        serviceProvider.closeSession();
    }
}
