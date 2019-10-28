package ProductMining.Department.audit;

import ProductMining.Products.Product;

import java.util.HashMap;
import java.util.Map;

public class Records {
    private Map<String, Product> mRecord;
    private long mTimeStamp;

    public Records(){
        mRecord = new HashMap<>();
    }

    public void makeTransaction(final String username, Product product, long timestamp){
        mTimeStamp = timestamp;
        mRecord.put(username, product);
        System.out.println("Item purchased by " + username + ": " + product.mName + ": " + timestamp);
    }
}
