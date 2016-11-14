package testvh.yz.com.VitamioTest;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Metadata;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import testvh.yz.com.retrofittest.R;

public class Vita_ActTest extends AppCompatActivity {

    @InjectView(value = R.id.videoview_vitamio)
    public VideoView videoView;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vita__act_test);
        ButterKnife.inject(this);

//        videoView.setVideoPath(Environment.getExternalStorageDirectory().getPath() + "//mlxm.mp4");
        videoView.setVideoPath("http://www.modrails.com/videos/passenger_nginx.mov");
        videoView.setVideoQuality(View.DRAWING_CACHE_QUALITY_LOW);
        mediaController = new MediaController(this);
        mediaController.show(10000);
        videoView.setMediaController(mediaController);
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                switch (what) {
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                        //开始缓存，暂停播放
                        Log.v("download rate:" ,"开始缓存,暂停播放"+extra);
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                        //缓存完成，继续播放
                        Log.v("download rate:" ,"缓存完成"+extra);
                        Metadata metadata = mp.getMetadata();
                        break;
                    case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                        //显示 下载速度
                        Log.v("download rate:" ,"=="+extra);
                        break;
                }
                return true;
            }
        });
    }
}
