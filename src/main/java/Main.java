import Persistents.Order;

import java.util.Scanner;

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
        System.out.println("4. Delete order");
        System.out.println("5. Add product");
        System.out.println("6. Delete product");
        System.out.println("7. Update product");
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
                        e.printStackTrace();
                    }
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
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
