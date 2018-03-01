package nrt;

/**
 *
 * @author sonu
 */
public class SharedData {
    
    public  static String UserName;
    public  static String WorkerName;
    public  static String WorkerId;
    
    public static void setLoginName(String LoginName) {
        SharedData.UserName = LoginName;
    }
    public static String getLoginName() {
        return UserName;
    }
    public static void setWorkerName(String WorkerName) {
        SharedData.WorkerName = WorkerName;
    }
    public static String getWorkerName() {
        return WorkerName;
    }
    public static void setWorkerId(String WorkerId) {
        SharedData.WorkerId = WorkerId;
    }
    public static String getWorkerId() {
        return WorkerId;
    }
}
