package testvh.yz.com.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.plugins.RxJavaObservableExecutionHook;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @InjectView(value = R.id.testtextview)
    public TextView textView;
    private  HRetrofitNetHelper instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        instance = HRetrofitNetHelper.getInstance();

        TaobaoIPService taobaoIPService1 = instance.mRetrofit.create(TaobaoIPService.class);

        taobaoIPService1.get("52d4ebc7f765a59212a943a0f0b7f038","2","10","asc","1418745237")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Avd>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Avd resultBean) {
                        List<Avd.ResultBean.DataBean> data = resultBean.getResult().getData();
                        textView.setText(resultBean.getResult().getData().toString());
                    }
                });
    }
    public interface TaobaoIPService {
        @GET("joke/content/list.from?key=52d4ebc7f765a59212a943a0f0b7f038&page=2&pagesize=10&sort=asc&time=1418745237")
        Observable<Avd> post();
        @GET("joke/content/list.from?/")
        Observable<Avd> get(@Query("key") String key,
                            @Query("page") String page,
                            @Query("pagesize") String pagesize,
                            @Query("sort") String sort,
                            @Query("time") String time);
    }

}
