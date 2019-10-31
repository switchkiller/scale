package AmazonLocker.PackageManger;

import java.util.Queue;

public class PackageTrackingQueue implements Observer{
    private Package mPackage;
    private PackageManager.Tracker mTracker;
    private Queue<PackageFacility> mPackageFacilities;
    private Subject subject;


    public PackageTrackingQueue(Package pack, Queue<PackageFacility> packageFacilities, Object tracker){
        mPackage = pack;
        mTracker = (PackageManager.Tracker) tracker;
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
            System.out.println("History:");

            for(Integer pincode: mTracker.mHistory){
                System.out.print(pincode + " ");
            }
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
