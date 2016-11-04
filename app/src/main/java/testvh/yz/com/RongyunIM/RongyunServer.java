package testvh.yz.com.RongyunIM;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * Created by yz on 2016/11/4.
 */
public class RongyunServer {
    /**
     * 建立与融云服务器的连接
     *
     * @param token
     */
    public static void connect(final Context context,String token, final Dopost dopost) {
        final Activity activity = (Activity) context;


            /**
             * IMKit SDK调用第二步,建立与服务器的连接
             */
            RongIM.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * Token 错误，在线上环境下主要是因为 Token 已经过期，您需要向 App Server 重新请求一个新的 Token
                 */
                @Override
                public void onTokenIncorrect() {
                    Log.d("LoginActivity", "--onTokenIncorrect");
                }
                /**
                 * 连接融云成功
                 * @param userid 当前 token
                 */
                @Override
                public void onSuccess(String userid) {

                    Log.d("LoginActivity", "--onSuccess" + userid);
                    dopost.poststirng("userid==="+userid);
                }
                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {

                    Log.d("LoginActivity", "--onError" + errorCode);
                    dopost.errorpoststirng("errorCode==="+errorCode);
                }
            });

    }
    public  interface Dopost{
        void poststirng(String s);
        void errorpoststirng(String s);
    }
}
