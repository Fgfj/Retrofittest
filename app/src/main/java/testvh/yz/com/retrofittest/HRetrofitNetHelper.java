package testvh.yz.com.retrofittest;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yuzhou on 2016/9/28.
 */
public class HRetrofitNetHelper {
    public static HRetrofitNetHelper mInstance;
    public Retrofit mRetrofit;
    public static final String BASE_URL = "http://japi.juhe.cn/";

    private HRetrofitNetHelper(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("zgx", "OkHttp====message " + message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new HttpBaseParamsLoggingInterceptor())//拦截
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build();
    }
    public static HRetrofitNetHelper getInstance(){
        if(mInstance==null){
            synchronized (HRetrofitNetHelper.class){
                if(mInstance==null)
                    mInstance = new HRetrofitNetHelper ();
            }
        }
        return mInstance ;
    }
    //okhttp拦截器
    class HttpBaseParamsLoggingInterceptor implements Interceptor {
        private Context context;
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            okhttp3.Response response = chain.proceed(request);
            String requestUrl = response.request().url().uri().getPath();
            if(!TextUtils.isEmpty(requestUrl)){
                if(requestUrl.contains("list.from")) {
                    if (Looper.myLooper() == null) {
                        Looper.prepare();
                    }//对网址拦截 利用Rxandroid 进行ui操作主线程
                    Observable<String> observable=Observable.just("现在请求的是list.from接口");
                    observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                            .subscribe(new Observer<String>() {
                                @Override
                                public void onCompleted() {
                                }
                                @Override
                                public void onError(Throwable e) {
                                }
                                @Override
                                public void onNext(String s) {
                                }
                            });
                }
            }
            return response;
        }
    }
//==========================================retrofit配置
//Gson mGson = new GsonBuilder()
//.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//.addConverterFactory(GsonConverterFactory.create(mGson))
//addConverterFactory(ProtoConverterFactory.create())   proto 格式
//ProtoConverterFactory和GsonConverterFactory添加 converter 的顺序很重要。
// Retrofit会依次询问每一个 converter 能否处理一个类型。当Retrofit试图反序列化一个 proto 格式，
// 它其实会被当做 JSON 来对待。所以Retrofit会先要检查 proto buffer 格式，
// 然后才是 JSON。所以要先添加ProtoConverterFactory，然后是GsonConverterFactory。
}
