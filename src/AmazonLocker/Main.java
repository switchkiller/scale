package AmazonLocker;

import AmazonLocker.CommonUtils.Dimen;
import AmazonLocker.LogisticsManager.LogisticsManager;

public class Main {
    public static void main(String[] args) {
        Dimen dimen = null;
        LogisticsManager.getInstance().addPackageFacility(101,102,10);
        LogisticsManager.getInstance().addPackageFacility(102,103,10);
        LogisticsManager.getInstance().addPackageFacility(103,101,10);
        LogisticsManager.getInstance().addPackageFacility(104,101,10);

        LogisticsManager.getInstance().printAllConnections();

    }
}
