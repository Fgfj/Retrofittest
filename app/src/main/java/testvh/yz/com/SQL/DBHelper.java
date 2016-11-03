package testvh.yz.com.SQL;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by yuzhou on 2016/10/20.
 */
public class DBHelper extends DaoMaster.OpenHelper{
    public static final String DBNAME = "STUDENT";
    public DBHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
