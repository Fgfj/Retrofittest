package testvh.yz.com.Skintest;

import android.content.Context;

/**
 * Created by yz on 2016/12/13.
 */
public class SkinConfig {
    public static SkinConfig mInstance=null;
    public Context mContext;
    public static String path="";

    public SkinConfig(Context mContext) {
        this.mContext = mContext;
    }

    public static SkinConfig getInstance(Context mContext)
    {
        if(mInstance==null)
        {
            mInstance=new SkinConfig(mContext);
        }

        return mInstance;
    }
    public static void setSkinResourcePath(String s){
        path=s;
    }
    public static String getSkinResourcePath(){
        return path;
    }
}
