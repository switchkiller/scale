package AmazonLocker.LogisticsManager;

import java.util.ArrayList;
import java.util.List;

public class LogisticsManager extends LogisticManagerImpl{
    public static LogisticsManager mLogisticManager = null;
    private List<List<Integer>> mGraph;

    private LogisticsManager(){
        mLogisticManager.mGraph = new ArrayList<>();
    }

    public static void addPackageFacility(int u, int v, int d){
        if (mLogisticManager.mGraph.get(u) == null){
            mLogisticManager.mGraph.set(u, new ArrayList<>());
        }
        if (mLogisticManager.mGraph.get(v) == null){
            mLogisticManager.mGraph.set(v, new ArrayList<>());
        }

        mLogisticManager.mGraph.get(u).add(v);
        mLogisticManager.mGraph.get(v).add(u);
    }


    public static LogisticsManager getInstance(){
        if (mLogisticManager == null){
            mLogisticManager = new LogisticsManager();
        }
        return mLogisticManager;
    }
}
