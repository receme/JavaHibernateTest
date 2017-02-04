import Persistents.Order;
import Persistents.Product;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        DataServiceProvider dataServiceProvider = new DataServiceProvider(HibernateServiceProvider.getInstance());
        OrderController orderController = new OrderController(dataServiceProvider);

        Scanner sc = new Scanner(System.in);
        System.out.println("___Choose Option___");
        System.out.println("1. View specific order");
        System.out.println("2. View all orders");
        System.out.println("3. View all products");
        System.out.println("4. Add order");
        System.out.println("5. Delete order");
        System.out.println("6. Add product");
        System.out.println("7. Delete product");
        System.out.println("8. Update product");
        System.out.println("0. Exit");

        int exit = 0;

        while(true){
            int option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("Enter order id:");
                    int orderId = sc.nextInt();
                    try {
                        Order order = orderController.getOrder(orderId);
                        PrinterManager.printOrder(order);

                    } catch (Exception e) {
                        PrinterManager.printMessage(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        List<Order> orders = orderController.getAllOrder();
                        for(int i=0;i<orders.size();i++){
                            Order order = orders.get(i);
                            PrinterManager.printOrder(order);
                        }
                    } catch (Exception e) {
                        PrinterManager.printMessage(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        List<Product> products = orderController.getAllProducts();
                        PrinterManager.printAllProduct(products);
                    } catch (Exception e) {
                        PrinterManager.printMessage(e.getMessage());
                    }
                    break;
                case 4:
                    PrinterManager.printMessage("Order details:");
                    Order order = new Order();
                    order.setDate(new Date().toString());
                    PrinterManager.printMessage("How many product will be added?");
                    int productCount = sc.nextInt();

                    List<Product> products = new ArrayList<Product>();
                    for(int i=0;i<productCount;i++){
                        PrinterManager.printMessage("Enter product id to add:");
                        int pId = sc.nextInt();
                        try {
                            Product product = orderController.getProduct(pId);
                            products.add(product);
                        } catch (Exception e) {
                            PrinterManager.printMessage(e.getMessage());
                            i--;
                        }
                    }
                    order.setProducts(products);

                    try {
                        orderController.addOrder(order);
                    } catch (Exception e) {
                        PrinterManager.printMessage(e.getMessage());
                    }
                    break;
                case 5:
                    PrinterManager.printMessage("Not implemented");
                    break;
                case 6:
                    PrinterManager.printMessage("Not implemented");
                    break;
                case 7:
                    PrinterManager.printMessage("Not implemented");
                    break;
                case 8:
                    PrinterManager.printMessage("Not implemented");
                    break;
                case 0:
                    exit = 1;
                    break;
            }

            if(exit == 1){
                break;
            }

        }

        System.out.println("Exiting.....");

    }
}
