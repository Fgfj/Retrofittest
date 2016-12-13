package testvh.yz.com.SQL;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Method;

import testvh.yz.com.retrofittest.R;

public class Skintest_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skintest_);
        String dexPath_tmp="";
        PackageManager mPm=this.getPackageManager();
        PackageInfo mInfo=mPm.getPackageArchiveInfo(dexPath_tmp, PackageManager.GET_ACTIVITIES);
        String mPackageName=mInfo.packageName;
        AssetManager assetManager = null;
        try {
            assetManager = AssetManager.class.newInstance();
            Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, dexPath_tmp);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Resources superRes = this.getResources();
        Resources skinResource=new Resources(assetManager, superRes.getDisplayMetrics(), superRes.getConfiguration());
    }
}
