package ProductMining.Department.Sales;

import ProductMining.Customer.User;
import ProductMining.Products.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class Sale {
    public int mSaletype;
    public long mSaleEpoch;
    private List<Product> mProducts;
    private long mSaleStartTime;
    private long mSaleEndTime;

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

    public void startSale(){
        mSaleStartTime = System.currentTimeMillis();
        mSaleEndTime = mSaleStartTime + mSaleEpoch;
    }



    public boolean isSaleLive(){
        long currentTime = System.currentTimeMillis() + 500;
        return currentTime >= mSaleStartTime && currentTime <= mSaleEndTime;
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

    public void purchase(User user, final String item){
        for (Product product : mProducts){
            if (product.mName.equals(item)){
                System.out.println("Item purchased by " + user.mUsername + ": " + item);
                break;
            }
        }
    }

}
