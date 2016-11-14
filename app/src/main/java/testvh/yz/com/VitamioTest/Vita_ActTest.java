package testvh.yz.com.VitamioTest;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;
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

        videoView.setVideoPath(Environment.getExternalStorageDirectory().getPath()+"//mlxm.mp4");
        mediaController = new MediaController(this);
        mediaController.show(5000);
        videoView.setMediaController(mediaController);

    }
}
