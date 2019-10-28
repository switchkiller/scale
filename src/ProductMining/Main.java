package ProductMining;

import ProductMining.Customer.User;
import ProductMining.Department.Sales.FridaySale;
import ProductMining.Department.Sales.Sale;
import ProductMining.Department.Sales.Sales;
import ProductMining.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        * We are providing list of product to Sales Department so that they supply the same list to Sale Class.
        *
        * */
        List<Product> productList;
        productList = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            Product product= new Product("Brush", 20, 50, 0);
            productList.add(product);
        }

        for (int i = 0; i < 5; i++){
            Product product= new Product("Toolbox", 10, 40, 0);
            productList.add(product);
        }

        for (int i = 0; i < 5; i++){
            Product product= new Product("Soap", 30, 40, 0);
            productList.add(product);
        }

        Sales.init(productList);

        Sale fridaySale = new FridaySale(20,10000);

        /*
        * Write a transaction history for every item purchase with UID and Transaction ID
        * */

        // fridaySale.printAllProducts();

        /*
        * UID makes a purchase of a product from sales, and we give discount according to sale user selects.
        * User will make purchase on basis of name of product.
        *
        * */

        fridaySale.startSale();


        // Observe the code of User class
        User newUser1 = new User("Barun" ,"Brush", fridaySale);
        User newUser2 = new User("Shubham" , "Toolbox", fridaySale);
        User newUser3 = new User("Babnish", "Soap", fridaySale);

    }
}
