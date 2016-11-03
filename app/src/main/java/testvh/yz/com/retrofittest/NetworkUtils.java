package testvh.yz.com.retrofittest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2016/2/23.
 */
public class NetworkUtils {


    private static int typeMobile;

    //判断是否为wifi
    public  static boolean iswifi(Context context){
        //监控网络连接可以获取到网络的连接信息 网络连接的具体信息，网络连接状态 速度等
        //当网络连接发生改变的时候，发送广播
        //自动切换网络
        //提供网络了api可以用来查询当前可用网络的连接
        //可以自己选择网络
        int typeMobile = ConnectivityManager.TYPE_WIFI;
        return get(context,typeMobile);
    }
    // 判断是否是手机网络
    public  static boolean isPhone(Context context){
        int typeMobile = ConnectivityManager.TYPE_MOBILE;
       return get(context,typeMobile);
    }
    //判断是否连接上
    public  static boolean isConnected(Context context){
        //获取系统的服务，获取到连接的管理器
        ConnectivityManager manager=
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        manager.getActiveNetwork();
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        //为空表示没有可用的网络连接
        if(activeNetworkInfo==null){
            return false;
        }

        return  activeNetworkInfo.isConnected()&activeNetworkInfo.isAvailable();
    }
    private static boolean get(Context context,int typeMobile){

        //判断是否连接上
        if(!isConnected(context)){
            return false;
        }
        ConnectivityManager manager=
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getNetworkInfo(typeMobile);
        if(networkInfo==null){
            //可能是平板，没网
            return false;
        }

        return networkInfo.isAvailable()&networkInfo.isConnected();
    }

}
