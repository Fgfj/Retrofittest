package testvh.yz.com.retrofittest.m;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import testvh.yz.com.retrofittest.Avd;
import testvh.yz.com.retrofittest.CallbaclLister.LoginCallback;
import testvh.yz.com.retrofittest.CallbaclLister.LoginService;
import testvh.yz.com.retrofittest.HRetrofitNetHelper;

/**
 * Created by yuzhou on 2016/9/29.
 */
public class ILoginModel implements LoginModel {

    private HRetrofitNetHelper instance;
    private LoginService loginService;

    @Override
    public void login(String username, String password, final LoginCallback listener) {
        //实现登陆
        instance = HRetrofitNetHelper.getInstance();
        loginService = instance.mRetrofit.create(LoginService.class);
        loginService.post().observeOn(AndroidSchedulers.mainThread())
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
                        listener.sucess(data.toString());
                    }
                });
    }
}
