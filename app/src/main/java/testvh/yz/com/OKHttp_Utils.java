package testvh.yz.com;

import android.app.Activity;
import android.content.Context;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/8/4.
 */
public class OKHttp_Utils {
    private static OkHttpClient okHttpClient=null;
    //get
    public static  void Response_Get(final Context context,String url,final Dopost dopost){
        OkHttpClient  okHttpClient=new OkHttpClient();
        Request request = new Request.Builder().url(url).addHeader("DwSdk-Head", "braygame").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Activity activity = (Activity) context;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final String string_json;
                        try {
                            string_json = response.body().string();
                            dopost.poststirng(string_json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
    //post FormEncodingBuilder()
    public static void Response_Post(final Context context,String url, RequestBody requestBody,final Dopost dopost){
        if(okHttpClient==null){
            okHttpClient=new OkHttpClient();
        }
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody).addHeader("DwSdk-Head","braygame")
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                dopost.errorpoststirng(request.toString());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Activity activity = (Activity) context;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final String string_json;
                        try {
                            string_json = response.body().string();
                            dopost.poststirng(string_json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
    public  interface Dopost{
        void poststirng(String s);
        void errorpoststirng(String s);
    }

}
