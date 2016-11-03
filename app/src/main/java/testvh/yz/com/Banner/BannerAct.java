package testvh.yz.com.Banner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import testvh.yz.com.retrofittest.R;

public class BannerAct extends AppCompatActivity {
    private XBanner xBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        xBanner = (XBanner) findViewById(R.id.banner_1);
        final List<String> imgesUrl = new ArrayList<>();
        imgesUrl.add("https://upd13.sogoucdn.com/nstatic/img/logo.png?v=2");
        imgesUrl.add("https://upd13.sogoucdn.com/nstatic/img/logo.png?v=2");
        imgesUrl.add("https://upd13.sogoucdn.com/nstatic/img/logo.png?v=2");
        imgesUrl.add("https://upd13.sogoucdn.com/nstatic/img/logo.png?v=2");
        xBanner.setData(imgesUrl);
        xBanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Picasso.with(BannerAct.this).load(imgesUrl.get(position)).into((ImageView) view);
            }
        });
    }
}
