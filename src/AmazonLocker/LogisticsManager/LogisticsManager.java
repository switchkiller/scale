package AmazonLocker.LogisticsManager;

import java.util.ArrayList;
import java.util.List;

public class LogisticsManager implements ILogisticManager{
    private static LogisticsManager mLogisticManager = null;
    private List<List<Integer>> mGraph;

    private LogisticsManager(){
        mLogisticManager.mGraph = new ArrayList<>();
    }

    @Override
    public void addPackageFacility(int u, int v, int d){
        if (mLogisticManager.mGraph.get(u) == null){
            mLogisticManager.mGraph.set(u, new ArrayList<>());
        }
        if (mLogisticManager.mGraph.get(v) == null){
            mLogisticManager.mGraph.set(v, new ArrayList<>());
        }

        mLogisticManager.mGraph.get(u).add(v);
        mLogisticManager.mGraph.get(v).add(u);
    }

    @Override
    public List<Integer> planOptimalRouteforPackage(int source, int destination) {
        return null;
    }

    @Override
    public void packageReadyForShipment(int start, int destination, Package pack) {

    }

    public static LogisticsManager getInstance(){
        if (mLogisticManager == null){
            mLogisticManager = new LogisticsManager();
        }
        return mLogisticManager;
    }
}
