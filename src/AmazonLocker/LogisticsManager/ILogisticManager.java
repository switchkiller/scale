package AmazonLocker.LogisticsManager;

import java.util.List;

public interface ILogisticManager {

    void addPackageFacility(int source, int destination, int distance);

    List<Integer> planOptimalRouteforPackage(int source, int destination);

    void packageReadyForShipment(int start, int destination, Package pack);

}
