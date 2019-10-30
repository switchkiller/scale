package AmazonLocker;

import AmazonLocker.CommonUtils.Dimen;
import AmazonLocker.LogisticsManager.LogisticsManager;
import AmazonLocker.PackageManger.Package;
import AmazonLocker.PackageManger.PackageManager;

public class Main {
    public static void main(String[] args) {
        Dimen dimen = null;
        LogisticsManager.getInstance().addPackageFacility(101,102,10);
        LogisticsManager.getInstance().addPackageFacility(102,103,10);
        LogisticsManager.getInstance().addPackageFacility(104,101,10);

        // LogisticsManager.getInstance().printAllConnections();
        PackageManager packageManager = new PackageManager();
        Package pack = new Package(12);
        packageManager.addPackage(pack, 101,102);
    }
}
