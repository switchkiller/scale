package AmazonLocker.PackageManger;

import AmazonLocker.LogisticsManager.LogisticsManager;

import java.util.Queue;

public class ProxyPackageTracker implements Observer{
    private Package mPackage;
    private ITracker mTracker;
    private Queue<PackageFacility> mPackageFacilities;
    private Subject subject;


    public ProxyPackageTracker(Package pack, Queue<PackageFacility> packageFacilities, ITracker tracker){
        mPackage = pack;
        mTracker = tracker;
        mPackageFacilities = packageFacilities;
        processQueue();
    }

    /*
        We are using observer pattern here. We are doing this because we want independent processing from Package Facility. It gives us better control for processing.
        Processing Package at 101
        Processing Package at 102
        Processing Package at 103
        Done
        History:
                101 102 103
    */


    public void processQueue(){
        Observer observer = this;
        if (!mPackageFacilities.isEmpty()){
           PackageFacility packageFacility = mPackageFacilities.poll();
           subject = packageFacility;
           mTracker.updateHistory(packageFacility.getPinCode());
           packageFacility.register(observer);
           packageFacility.addPackageToFacility(mPackage);
           packageFacility.processPackage();
        }else{
            System.out.println("Done");
            LogisticsManager.getInstance().hasReachedEndFacility(mPackage);
        }
    }


    @Override
    public void update() {
        processQueue();
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
