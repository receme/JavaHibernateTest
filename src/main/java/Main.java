import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DataServiceProvider dataServiceProvider = new DataServiceProvider(HibernateServiceProvider.getInstance());
        OrderController orderController = new OrderController(dataServiceProvider);

        Scanner sc = new Scanner(System.in);
        System.out.println("___choose option___");
        System.out.println("1. View specific order");
        System.out.println("2. View all orders");
        System.out.println("3. View all products");
        System.out.println("4. Add order");
        System.out.println("4. Delete order");
        System.out.println("5. Add product");
        System.out.println("6. Delete product");
        System.out.println("7. Update product");


        while(true){







        }


    }
}
