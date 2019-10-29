package AmazonLocker.LogisticsManager;

public class LogisticsManager {
    public static LogisticsManager mLogisticManager = null;


    private LogisticsManager(){

    }



    public static LogisticsManager getInstance(){
        if (mLogisticManager == null){
            mLogisticManager = new LogisticsManager();
        }
        return mLogisticManager;
    }
}
