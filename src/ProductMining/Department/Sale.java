package ProductMining.Department;

import ProductMining.Department.Sales;
import ProductMining.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class Sale {
    private int mSaletype;
    private int mSaleEpoch;
    private List<Product> mProducts;

    /*
    * Product should be private property of sale as products to be discounted is decided by some other
    * team and should not be exposed to inherited classes. We just fetch product list from Sales department
    * */

    Sale(){
        mProducts = new ArrayList<>();
    }

    private void updateProduct(List<Product> products){
        mProducts = products;
    }

    public void updateProduct(){
        List<Product> products = Sales.getProductListForSale();
        updateProduct(products);
    }

    public int getSaleType(){
        return mSaletype;
    }

    public int getSaleDuration(){
        return mSaleEpoch;
    }

    public void setSaleType(int type){
        mSaletype = type;
    }

    public void setSaleDuration(int epoch){
        mSaleEpoch = epoch;
    }

}
