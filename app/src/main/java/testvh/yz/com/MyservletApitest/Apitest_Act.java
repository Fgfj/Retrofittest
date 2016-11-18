package testvh.yz.com.MyservletApitest;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;

import java.io.File;
import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import testvh.yz.com.OKHttp_Utils;
import testvh.yz.com.addfix.AddFixManage;
import testvh.yz.com.retrofittest.Erweimacode;
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
                textView.setText(s + "==");
                textView.append("===========");//fixapk 添加的代码
                 try {
                            File file = new File(Environment.getExternalStorageDirectory().getPath() + "//" + s+".apatch");
                            if (file.exists()) {
                                Log.e("myApi",Environment.getExternalStorageDirectory().getPath() + "//" + s+".apatch");
                                AddFixManage.getInstance(Apitest_Act.this).addPatch(Environment.getExternalStorageDirectory().getPath() + "//" + s+".apatch");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
            }

            @Override
            public void errorpoststirng(String s) {

            }
        });
    }
}
