package testvh.yz.com.MyservletApitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import testvh.yz.com.retrofittest.R;

public class MyindexJsp_Act extends AppCompatActivity {

    @InjectView(value = R.id.index_jsp)
    public WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myindex_jsp_);
        ButterKnife.inject(this);
        webView.loadUrl("http://192.168.6.153:8090/test/index.jsp");
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_INSET);//滚动条风格
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//js
//      webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setDefaultTextEncodingName("UTF-8");//code
        webView.addJavascriptInterface(this, "JavaScriptInterface");//传入js android里面的方法
        //setWebViewClient和setWebChromeClient的作用：前者主要用于处理webView的控制问题，如加载、关闭、错误处理等；
        // 后者主要处理js对话框、图标、页面标题等。
    }
    @JavascriptInterface
    public void testjs(){
        Toast.makeText(this,"调用android里面的testjs方法",Toast.LENGTH_SHORT).show();
    }
}
