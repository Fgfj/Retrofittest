package testvh.yz.com.MyservletApitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import testvh.yz.com.OKHttp_Utils;
import testvh.yz.com.retrofittest.R;

public class Apitest_Act extends AppCompatActivity {
    @InjectView(value = R.id.apirepsonse_text)
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apitest_);
        ButterKnife.inject(this);
        OKHttp_Utils.Response_Get(this, "http://192.168.6.153:8090/test/servlet/Getusername_Servlet", new OKHttp_Utils.Dopost() {
            @Override
            public void poststirng(String s) {
                Log.e("myApi",s+"==");
                textView.setText(s+"==");
            }

            @Override
            public void errorpoststirng(String s) {

            }
        });
    }
}
