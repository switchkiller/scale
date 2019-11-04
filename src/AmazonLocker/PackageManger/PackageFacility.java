package AmazonLocker.PackageManger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PackageFacility implements Subject{
    private int mPincode;
    private List<Observer> mObservers;
    private List<Package> mPackage;
    private List<Package> mPackageToDeliverList;

    public PackageFacility(){
        mPackage = new ArrayList<>();
        mObservers = new ArrayList<>();
        mPackageToDeliverList = new LinkedList<>();
    }

    public void updateWaitingList(Package pack){
        mPackageToDeliverList.add(pack);
    }

    public Package getPriorityPackage(){
        if (mPackageToDeliverList.isEmpty()) return null;
        else{
            return null;
        }
    }

    public void addPackageFacility(int pincode){
        mPincode = pincode;
    }

    public void processPackage(){
        System.out.println("Processing Package at " + mPincode);
        notifyObservers();
    }

    public void addPackageToFacility(Package pack){
        mPackage.add(pack);
    }

    public int getPinCode(){
        return mPincode;
    }

    @Override
    public void register(Observer observer) {
        mObservers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        mObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : mObservers){
            observer.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        // nothing to pass to Observer. Lets keep it as it is.
        return null;
    }
}
