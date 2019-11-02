package AmazonLocker.PackageManger;

import AmazonLocker.LogisticsManager.LogisticsManager;

import java.util.ArrayList;
import java.util.List;

public class PackageManager {
    private List<Tracker> mTracker;

    public void addPackage(Package pack, int start, int end){
        Tracker tracker = new Tracker(pack,start,end);
        mTracker.add(tracker);
        LogisticsManager.getInstance().packageReadyForShipment(start,end,pack,tracker);

        for(Tracker track: mTracker){
            System.out.print(track.mHistory + " ");
        }

    }

    public PackageManager(){
        mTracker = new ArrayList<>();
    }



    public class Tracker implements ITracker{
        private Package mPack;
        private int start;
        private int end;
        private List<Integer> mHistory;

        Tracker(Package pack, int start, int end){
            mPack = pack;
            this.start = start;
            this.end = end;
            mHistory = new ArrayList<>();
        }

        @Override
        public void updateHistory(int position){
            mHistory.add(position);
        }
    }
}
