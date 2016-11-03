package testvh.yz.com.InterFtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import testvh.yz.com.retrofittest.R;

/**
 * 接口测试
 */
public class InterFtest_Act extends AppCompatActivity implements TestA{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_ftest_);
        Ctollrtinterface ctollrtinterface = new Ctollrtinterface(this, this);
        ctollrtinterface.registper();
    }


    @Override
    public void changename(String s) {
    }

    @Override
    public void changesex(String s) {

    }
}
