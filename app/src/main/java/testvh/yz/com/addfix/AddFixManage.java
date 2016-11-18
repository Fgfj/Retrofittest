package testvh.yz.com.addfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;

/**
 * Created by yz on 2016/11/18.
 */
public class AddFixManage {
    public static PatchManager mInstance;
    public static PatchManager getInstance(Context context){
        if(mInstance==null){
                if(mInstance==null)
                    mInstance = new PatchManager(context);
        }
        return mInstance ;
    }
}
