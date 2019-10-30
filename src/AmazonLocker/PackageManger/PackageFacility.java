package AmazonLocker.PackageManger;

import AmazonLocker.PackageManger.Package;

import java.util.ArrayList;
import java.util.List;

public class PackageFacility {
    private int mPincode;
    private List<Package> mPackage;

    public PackageFacility(){
        mPackage = new ArrayList<>();
    }

    public void addPackageFacility(int pincode){
        mPincode = pincode;
    }


}
