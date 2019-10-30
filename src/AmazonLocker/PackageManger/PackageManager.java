package AmazonLocker.PackageManger;

import AmazonLocker.LogisticsManager.LogisticsManager;

import java.util.ArrayList;
import java.util.List;



public class PackageManager {
    private List<Tracker> mTracker;

    public PackageManager(Package pack, int start, int end){
        Tracker tracker = new Tracker(pack,start,end);
        mTracker.add(tracker);
        LogisticsManager.getInstance().packageReadyForShipment(start,end,pack,tracker);
    }

    public PackageManager(){
        mTracker = new ArrayList<>();
    }



    public class Tracker{
        Package mPack;
        int start;
        int end;
        List<Integer> mHistory;

        Tracker(Package pack, int start, int end){
            mPack = pack;
            this.start = start;
            this.end = end;
            mHistory = new ArrayList<>();
        }

        public void updateHistory(int position){
            mHistory.add(position);
        }
    }
}
