package ProductMining.Department;

import ProductMining.Product;

import java.util.ArrayList;
import java.util.List;

public class Sales {
    private static Sales mSales = null;
    private List<Product> mProduct;

    private Sales(){
        mProduct = new ArrayList<>();
    }

    public static void init(List<Product> product){
        if (mSales == null){
            mSales = new Sales();
        }
        mSales.mProduct = product;
    }

    public static List<Product> getProductListForSale(){
        return mSales.mProduct;
    }

    public static Sales getInstance(){
        if (mSales == null){
            mSales = new Sales();
        }
        return mSales;
    }
}
