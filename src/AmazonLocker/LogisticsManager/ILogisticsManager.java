package AmazonLocker.LogisticsManager;

import AmazonLocker.PackageManger.ITracker;
import AmazonLocker.PackageManger.Package;

import java.util.List;

public interface ILogisticsManager {

    void addPackageFacility(int source, int destination, int distance);

    List<Integer> planOptimalRouteforPackage(int source, int destination);

    void packageReadyForShipment(int start, int destination, Package pack, ITracker tracker);

    void updateHistory(Package pack, int position);

}
