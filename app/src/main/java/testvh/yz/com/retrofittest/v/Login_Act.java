package testvh.yz.com.retrofittest.v;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import testvh.yz.com.retrofittest.CallbaclLister.LoginCallback;
import testvh.yz.com.retrofittest.R;
import testvh.yz.com.retrofittest.p.LoginPersenter;
import testvh.yz.com.retrofittest.p.UserPresenter;

/**
 * mvp测试+refite——rxandroid
 */
public class Login_Act extends AppCompatActivity implements LoginView{
    private LoginPersenter loginPersenter;
    @InjectView(value = R.id.logintesttext)
    public TextView textViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        init();
        loginPersenter.Login(null, null);//进行登陆请求
    }
    private void init() {
        ButterKnife.inject(this);
        loginPersenter=new LoginPersenter(this);
    }

    @Override
    public void showtoast(String s) {
        textViews.setText(s);

    }
}
