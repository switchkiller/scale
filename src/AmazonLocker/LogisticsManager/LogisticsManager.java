package AmazonLocker.LogisticsManager;

import AmazonLocker.PackageManger.Package;
import AmazonLocker.PackageManger.PackageFacility;
import AmazonLocker.PackageManger.PackageManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LogisticsManager implements ILogisticManager{
    private static LogisticsManager mLogisticManager = null;
    private List<List<Integer>> mGraph;
    private HashMap<Package, Object> mPackageTracker;
    private List<PackageFacility> mPackageFacility;


    private LogisticsManager(){
        mLogisticManager.mGraph = new ArrayList<>();
    }

    @Override
    public void addPackageFacility(int u, int v, int d){
        if (mLogisticManager.mGraph.get(u) == null){
            PackageFacility packageFacility = new PackageFacility();
            packageFacility.addPackageFacility(u);
            mPackageFacility.add(packageFacility);
            mLogisticManager.mGraph.set(u, new ArrayList<>());
        }
        if (mLogisticManager.mGraph.get(v) == null){
            PackageFacility packageFacility = new PackageFacility();
            packageFacility.addPackageFacility(v);
            mPackageFacility.add(packageFacility);
            mLogisticManager.mGraph.set(v, new ArrayList<>());
        }

        mLogisticManager.mGraph.get(u).add(v);
        mLogisticManager.mGraph.get(v).add(u);
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
