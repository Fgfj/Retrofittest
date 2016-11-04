package testvh.yz.com.RongyunIM;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;
import testvh.yz.com.retrofittest.R;

/**
 * 融云即时聊天
 */
public class Rongyun_Act extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rongyun_);
        textView = (TextView) findViewById(R.id.rongyunserverconntect);
        RongyunServer.connect(this, "IVWXLYxksSQoOJknQ0q9TYmXK11Lcjn0DpCqMMGvdhcIglhjRbeHebH/J4CRIhI5xVsSnH4vVdcAQtrbKVn1aw==",
                new RongyunServer.Dopost() {
            @Override
            public void poststirng(String s) {
                textView.setText(s);
            }
            @Override
            public void errorpoststirng(String s) {
                textView.setText(s);
            }
        });
    }
    public void 启动会话界面(View view) {
        //启动会话界面
        if (RongIM.getInstance() != null)
            RongIM.getInstance().startPrivateChat(this, "26594", "title");
    }

    public void 启动会话列表界面(View view) {
        //启动会话列表界面
        if (RongIM.getInstance() != null)
            RongIM.getInstance().startConversationList(this);
    }

    public void 启动聚合会话列表界面(View view) {
        //启动聚合会话列表界面
        if (RongIM.getInstance() != null)
            RongIM.getInstance().startSubConversationList(this, Conversation.ConversationType.GROUP);
    }
}
