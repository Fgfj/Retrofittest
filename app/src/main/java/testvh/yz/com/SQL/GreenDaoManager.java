package testvh.yz.com.SQL;

import testvh.yz.com.MyApplication;

/**
 * Created by yuzhou on 2016/10/20.
 */
public class GreenDaoManager {
    private static GreenDaoManager mInstance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    //数据库名，表名是自动被创建的
    public static final String DB_NAME = "STUDENT";
    public GreenDaoManager() {
//创建数据库
//注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getInstance().getApplicationContext(), DB_NAME, null);
//得到数据库管理者
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
//得到daoSession，可以执行增删改查操作
        mDaoSession = mDaoMaster.newSession();
    }
    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            mInstance = new GreenDaoManager();
        }
        return mInstance;
    }
    public DaoMaster getMaster() {
        return mDaoMaster;
    }
    public DaoSession getSession() {
        return mDaoSession;
    }
    public DaoSession getNewSession() {
                return mDaoSession;
    }
}
