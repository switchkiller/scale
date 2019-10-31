package AmazonLocker.LogisticsManager;

import AmazonLocker.PackageManger.Package;
import AmazonLocker.PackageManger.PackageFacility;
import AmazonLocker.PackageManger.PackageManager;
import AmazonLocker.PackageManger.PackageTrackingQueue;

import java.util.*;

public class LogisticsManager implements ILogisticsManager {
    private static LogisticsManager mLogisticManager = null;
    private List[] mGraph;
    private Map<Package, Object> mPackageTracker;
    private Map<Integer,PackageFacility> mPackageFacility;


    private LogisticsManager(){
        int TOTAL_NUMBER_OF_NODES = 1000;
        mGraph = new List[TOTAL_NUMBER_OF_NODES];
        for (int i = 0; i < TOTAL_NUMBER_OF_NODES; i++){
            mGraph[i] = new ArrayList<>();
        }
        mPackageFacility = new HashMap<>();
        mPackageTracker = new HashMap<>();
    }

    @Override
    public void addPackageFacility(int u, int v, int d){
        if (mGraph[u].isEmpty()){
            PackageFacility packageFacility = new PackageFacility();
            packageFacility.addPackageFacility(u);
            mPackageFacility.put(u,packageFacility);
        }
        if (mGraph[v].isEmpty()){
            PackageFacility packageFacility = new PackageFacility();
            packageFacility.addPackageFacility(v);
            mPackageFacility.put(v,packageFacility);
        }

        mGraph[u].add(v);
        mGraph[v].add(u);
    }

    public void printAllConnections(){
        Iterator packageFacilityIterator = mPackageFacility.entrySet().iterator();
        while (packageFacilityIterator.hasNext()){
            Map.Entry packageFacilityEntry = (Map.Entry) packageFacilityIterator.next();
            PackageFacility packageFacility = (PackageFacility) packageFacilityEntry.getValue();
            System.out.print(packageFacility.getPinCode() + "->");
            for(Object adjacentNode : mGraph[packageFacility.getPinCode()]){
                System.out.print((int) adjacentNode + " ");
            }
            System.out.println();
        }
    }

    @Override
    public List<Integer> planOptimalRouteforPackage(int source, int destination) {
//        TODO
        return null;
    }

    @Override
    public void packageReadyForShipment(int start, int destination, final Package pack, Object tracker) {
        mPackageTracker.put(pack,tracker);
//        List<Integer> packagePath = planOptimalRouteforPackage(start,destination);
        // we will traverse the path and make use of observables to keep track of package everytime
        List<Integer> packagePath = new ArrayList<>();
        packagePath.add(101);
        packagePath.add(102);
        packagePath.add(103);
        Queue<Integer> path = new LinkedList<Integer>(packagePath);
        Queue<PackageFacility> packageFacilities = new LinkedList<>();
        // Get the package facilities that we are going to use
        while(!path.isEmpty()){
            int nextDestination = path.poll();
            PackageFacility packageFacility = mPackageFacility.get(nextDestination);
            packageFacilities.add(packageFacility);
        }

        PackageTrackingQueue packageTrackingQueue = new PackageTrackingQueue(pack, packageFacilities, tracker);

    }

    @Override
    public void updateHistory(Package pack, int position) {
        if (mPackageTracker.containsKey(pack)){
            PackageManager.Tracker tracker = (PackageManager.Tracker) mPackageTracker.get(pack);
            tracker.updateHistory(position);
        }
    }

    public static LogisticsManager getInstance(){
        if (mLogisticManager == null){
            mLogisticManager = new LogisticsManager();
        }
        return mLogisticManager;
    }
}
