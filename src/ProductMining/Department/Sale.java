package ProductMining.Department;

import ProductMining.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class Sale {
    public int mSaletype;
    public long mSaleEpoch;
    private List<Product> mProducts;

    /*
    * Product should be private property of sale as products to be discounted is decided by some other
    * team and should not be exposed to inherited classes. We just fetch product list from Sales department
    * */

    Sale(){
        mProducts = new ArrayList<>();
    }

    private void updateProductList(List<Product> products){
        mProducts = products;
    }

    public void updateProductList(){
        List<Product> products = Sales.getProductListForSale(mSaletype);
        updateProductList(products);
    }

    public void applyDiscountOnAllProducts(final double discount){
        // Process product list and apply discount. Remember the list is hidden from all other people. Discount and product list both are abstract
        // do something
        for (Product product : mProducts){
            product.mDiscount = discount;
        }
    }


    public int getSaleType(){
        return mSaletype;
    }

    public long getSaleDuration(){
        return mSaleEpoch;
    }

    public void printAllProducts(){
        for (Product product : mProducts){
            System.out.println(product.mName + " " + product.mCostPrice + " " + product.mSalePrice + " " + product.mDiscount);
        }
    }

}
