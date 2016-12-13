package testvh.yz.com.Skintest;

import android.app.Application;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * Created by yz on 2016/12/13.
 */
public class SkinApplication extends Application {
    private static SkinApplication mInstance=null;

    public ArrayList<ISkinUpdate> mActivitys=new ArrayList<ISkinUpdate>();

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mInstance=this;
        String skinPath=SkinConfig.getInstance(this).getSkinResourcePath();
        if(!TextUtils.isEmpty(skinPath))
        {
            //如果已经换皮肤，那么第二次进来时，需要加载该皮肤
            SkinPackageManager.getInstance(this).loadSkinAsync(skinPath, null);
        }
//        SkinBroadCastReceiver.registerBroadCastReceiver(this);
    }

    public static SkinApplication getInstance()
    {
        return mInstance;
    }

    @Override
    public void onTerminate() {
        // TODO Auto-generated method stub
//        SkinBroadCastReceiver.unregisterBroadCastReceiver(this);
        super.onTerminate();
    }

    public void changeSkin()
    {
        for(ISkinUpdate skin:mActivitys)
        {
            skin.updateTheme();
        }
    }
}
