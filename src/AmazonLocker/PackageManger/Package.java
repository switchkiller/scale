package AmazonLocker.PackageManger;

import AmazonLocker.CommonUtils.Dimen;

public class Package {
    private int mProductId;
    private Dimen mDimension;

    public Package(int id){
        mProductId = id;
        mDimension = new Dimen();
    }
}
