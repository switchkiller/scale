package ProductMining.Department.Sales;

import ProductMining.Products.Product;

import java.util.ArrayList;
import java.util.List;

import static ProductMining.Department.Sales.FridaySale.FRIDAY_SALE;

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

    public static List<Product> getProductListForSale(final int saleType){
        if (saleType == FRIDAY_SALE){
            return mSales.mProduct;
        }
        return null;
    }

    public static Sales getInstance(){
        if (mSales == null){
            mSales = new Sales();
        }
        return mSales;
    }
}
