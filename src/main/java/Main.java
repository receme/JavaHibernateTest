import Persistents.Deal;
import Persistents.Product;

import java.util.*;

public class Main {

    static OrderController orderController;
    static Scanner sc;

    public static void main(String[] args) {

        DataServiceProvider dataServiceProvider = new DataServiceProvider(HibernateServiceProvider.getInstance());
        orderController = new OrderController(dataServiceProvider);

        sc = new Scanner(System.in);
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
                case Option.VIEW_ORDER:
                    startOption_viewSpecificOrder();
                    break;
                case Option.VIEW_ALL_ORDERS:
                    startOption_viewAllOrders();
                    break;
                case Option.VIEW_ALL_PRODUCTS:
                    startOption_viewAllProducts();

                    break;
                case Option.ADD_ORDER:
                    startOption_addOrder();
                    break;
                case Option.DELETE_ORDER:
                    startOption_deleteOrder();
                    break;
                case Option.ADD_PRODUCT:
                    PrinterManager.printMessage("Not implemented");
                    break;
                case Option.DELETE_PRODUCT:
                    PrinterManager.printMessage("Not implemented");
                    break;
                case Option.UPDATE_PRODUCT:
                    PrinterManager.printMessage("Not implemented");
                    break;
                case Option.EXIT:
                    exit = 1;
                    break;
            }

            if(exit == 1){
                break;
            }

        }

        System.out.println("Exiting.....");

    }


    private static void startOption_viewSpecificOrder() {
        System.out.println("Enter deal id:");
        int orderId = sc.nextInt();
        try {
            Deal deal = orderController.getOrder(orderId);
            PrinterManager.printOrder(deal);

        } catch (Exception e) {
            PrinterManager.printMessage(e.getMessage());
        }
    }

    private static void startOption_viewAllOrders() {
        try {
            List<Deal> deals = orderController.getAllOrder();

            for(int i = 0; i< deals.size(); i++){
                Deal deal = deals.get(i);
                PrinterManager.printOrder(deal);
            }
        } catch (Exception e) {
            PrinterManager.printMessage(e.getMessage());
        }
    }

    private static void startOption_viewAllProducts() {
        try {
            List<Product> products = orderController.getAllProducts();
            PrinterManager.printAllProduct(products);
        } catch (Exception e) {
            PrinterManager.printMessage(e.getMessage());
        }
    }

    private static void startOption_addOrder() {
        PrinterManager.printMessage("Deal details:");
        Deal deal = new Deal();
        deal.setDate(new Date().toString());
        Deal tempDeal = deal;
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
        deal.setProducts(products);

        try {
            orderController.addOrder(deal);

        } catch (Exception e) {
            PrinterManager.printMessage(e.getMessage());
        }
    }

    private static void startOption_deleteOrder() {

        System.out.println("Enter deal id:");
        int orderId = sc.nextInt();
        try {
            orderController.deleteOrder(orderId);
        } catch (Exception e) {
            PrinterManager.printMessage(e.getMessage());
        }

    }
}
