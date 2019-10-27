package ProductMining.Customer;

import ProductMining.Department.Sales.Sale;

public class User {

    public String mUsername;
    public User(final String username, final String item, Sale sale){
        mUsername = username;
        if (sale.isSaleLive()){
            // do something
            sale.purchase(this,item);
        }
    }
}
