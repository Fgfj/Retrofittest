package testvh.yz.com.RongyunIM;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;
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

    public void 设置用户信息(View view) {
        RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {
            @Override
            public UserInfo getUserInfo(String s) {
                return new UserInfo("1", "设置以后的名字", Uri.parse("https://gss0.bdstatic.com/70cFsj3f_gcX8t7mm9GUKT-xh_/avatar/100/r6s1g1.gif"));
            }
        },true);
    }


    public void 刷新用户信息(View view) {
        /**
         * 刷新用户缓存数据。
         *
         * @param userInfo 需要更新的用户缓存数据。
         */
        RongIM.getInstance().refreshUserInfoCache(
                new UserInfo("1", "刷新以后的名字", Uri.parse("http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png")));

    }


}
