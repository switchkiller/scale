package AmazonLocker.PackageManger;

import java.util.ArrayList;
import java.util.List;

public class PackageFacility implements Subject{
    private int mPincode;
    private List<Observer> mObservers;
    private List<Package> mPackage;

    public PackageFacility(){
        mPackage = new ArrayList<>();
        mObservers = new ArrayList<>();
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
