package testvh.yz.com.RongyunIM;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;
import testvh.yz.com.retrofittest.R;

/**
 * 融云即时聊天
 */
public class Rongyun_Act extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rongyun_);
        textView = (TextView) findViewById(R.id.rongyunserverconntect);
        textView2 = (TextView) findViewById(R.id.rongyuchartteamid);
        String token1="IVWXLYxksSQoOJknQ0q9TYmXK11Lcjn0DpCqMMGvdhcIglhjRbeHebH/J4CRIhI5xVsSnH4vVdcAQtrbKVn1aw==";
        String token26594="xziJJeoWyNCJ5QcuUDqwGomXK11Lcjn0DpCqMMGvdhcIglhjRbeHeQAYIQfk3UenohmhCXcGGauxjen9wJh/8g==";
        RongyunServer.connect(this, token1,
                new RongyunServer.Dopost() {
                    @Override
                    public void poststirng(String s) {
                        textView.setText("链接成功==="+s);
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
                return new UserInfo("1", "yz", Uri.parse("https://gss0.bdstatic.com/70cFsj3f_gcX8t7mm9GUKT-xh_/avatar/100/r6s1g1.gif"));
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
                new UserInfo("1", "1", Uri.parse("http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png")));
        RongIM.getInstance().refreshUserInfoCache(
                new UserInfo("26594", "26594", Uri.parse("http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png")));

    }


    public void 创建讨论组会话并进入会话界面(View view) {
        List<String> listchat=new ArrayList<>();
        listchat.add("1");
        listchat.add("26594");
        listchat.add("2");
        listchat.add("3");
        String s = textView2.getText().toString();
        if(TextUtils.isEmpty(s)) {
            //未创建讨论组
            RongIM.getInstance().createDiscussionChat(this, listchat, "神之讨论组", new RongIMClient.CreateDiscussionCallback() {
                @Override
                public void onSuccess(String s) {
                    Log.d("LoginActivity", "--onSuccess" + s);
                    textView2.setText(s);
                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    Log.d("LoginActivity", "--errorCode" + errorCode);
                }
            });
        }else {
            //进入讨论组
            RongIM.getInstance().startDiscussionChat(this,s,"神之讨论组");

        }
    }
}
