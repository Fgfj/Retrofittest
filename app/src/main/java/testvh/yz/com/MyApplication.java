package testvh.yz.com;

import android.app.Application;

import testvh.yz.com.SQL.GreenDaoManager;

/**
 * Created by yuzhou on 2016/10/20.
 */
public class MyApplication extends Application {
    protected static MyApplication instance;
    public static synchronized MyApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        GreenDaoManager.getInstance();
    }
}
