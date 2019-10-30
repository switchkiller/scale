package AmazonLocker.LogisticsManager;

import AmazonLocker.PackageManger.Package;
import AmazonLocker.PackageManger.PackageFacility;
import AmazonLocker.PackageManger.PackageManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LogisticsManager implements ILogisticsManager {
    private static LogisticsManager mLogisticManager = null;
    private List[] mGraph;
    private HashMap<Package, Object> mPackageTracker;
    private List<PackageFacility> mPackageFacility;


    private LogisticsManager(){
        int TOTAL_NUMBER_OF_NODES = 1000;
        mGraph = new List[TOTAL_NUMBER_OF_NODES];
        for (int i = 0; i < TOTAL_NUMBER_OF_NODES; i++){
            mGraph[i] = new ArrayList<>();
        }
        mPackageFacility = new ArrayList<>();
    }

    @Override
    public void addPackageFacility(int u, int v, int d){
        if (mGraph[u].isEmpty()){
            PackageFacility packageFacility = new PackageFacility();
            packageFacility.addPackageFacility(u);
            mPackageFacility.add(packageFacility);
        }
        if (mGraph[v].isEmpty()){
            PackageFacility packageFacility = new PackageFacility();
            packageFacility.addPackageFacility(v);
            mPackageFacility.add(packageFacility);
        }

        mGraph[u].add(v);
        mGraph[v].add(u);
    }

    public void printAllConnections(){
        for (PackageFacility packageFacility: mPackageFacility){
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
        List<Integer> packagePath = planOptimalRouteforPackage(start,destination);
        // we will traverse the path and make use of observables to keep track of package everytime
        LogisticAgent logisticAgent = new LogisticAgent(pack, packagePath);




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
