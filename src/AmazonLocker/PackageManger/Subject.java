package AmazonLocker.PackageManger;

public interface Subject {
    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();

    public Object getUpdate(Observer observer);
}
