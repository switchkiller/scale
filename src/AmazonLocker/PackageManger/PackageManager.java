package AmazonLocker.PackageManger;

import java.util.List;



public class PackageManager {
    private List<Tracker> mTracker;

    public PackageManager(Package pack, int start, int end){
        mTracker.add(new Tracker(pack,start,end));
    }



    class Tracker{
        Package mPack;
        int start;
        int end;

        Tracker(Package pack, int start, int end){
            mPack = pack;
            this.start = start;
            this.end = end;
        }
    }
}
