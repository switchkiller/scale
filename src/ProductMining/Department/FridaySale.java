package ProductMining.Department;

public class FridaySale extends Sale {
    public static final int FRIDAY_SALE = 1;
    private double mDiscountPercent;

    public FridaySale(double discount, long epoch){
        mSaletype = FRIDAY_SALE;
        mDiscountPercent = discount;
        mSaleEpoch = epoch;
        updateProductList();
        applyDiscountOnAllProducts(mDiscountPercent);
    }
}
