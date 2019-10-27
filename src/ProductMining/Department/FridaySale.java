package ProductMining.Department;

public class FridaySale extends Sale {
    public static final int FRIDAY_SALE = 1;
    private double mDiscountPercent;

    FridaySale(double discount, int epoch){
        mSaletype = FRIDAY_SALE;
        mDiscountPercent = discount;
        mSaleEpoch = epoch;
        updateProductList();
        applyDiscountOnAllProducts(mDiscountPercent);
    }


}
