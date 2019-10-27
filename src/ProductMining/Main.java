package ProductMining;

import ProductMining.Department.FridaySale;
import ProductMining.Department.Sale;
import ProductMining.Department.Sales;

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

        for (int i = 0; i < 20; i++){
            Product product= new Product("Tooth Brush", 20, 50, 0);
            productList.add(product);
        }

        Sales.init(productList);

        Sale fridaySale = new FridaySale(20,100000);
        fridaySale.printAllProducts();
    }
}
