package testvh.yz.com;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import testvh.yz.com.retrofittest.R;

public class Jniactivity extends Activity {
//    生成jni文件 在android项目java目录下cmd执行命令 javah -jni -encoding UTF-8 testvh.yz.com.Jniactivity

    public static native String helloJni();
    public static native int addCalc(int a, int b);
    static {
        System.loadLibrary("hello_jni"); // 注意没有前缀lib和后缀.so
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jniactivity);
        Toast.makeText(this,helloJni()+addCalc(1,3)+"",Toast.LENGTH_LONG).show();
    }
}
