package testvh.yz.com;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.UserInfo;
import io.rong.message.LocationMessage;
import io.rong.message.RichContentMessage;
import testvh.yz.com.SQL.GreenDaoManager;

/**
 * Created by yuzhou on 2016/10/20.
 */
public class MyApplication extends Application {
    protected static MyApplication instance;
    public static synchronized MyApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        GreenDaoManager.getInstance();
        RongIM.init(this);
        RongIM.setConversationBehaviorListener(new RongIM.ConversationBehaviorListener() {
            @Override
            public boolean onUserPortraitClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo) {
//                当点击用户头像后执行。
                Toast.makeText(getApplicationContext(),"name=="+userInfo.getName(),Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onUserPortraitLongClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo) {
//                当长点击用户头像后执行。
                return false;
            }

            @Override
            public boolean onMessageClick(Context context, View view, Message message) {
//                当点击消息时执行
                return false;
            }

            @Override
            public boolean onMessageLinkClick(Context context, String s) {
//                当点击链接消息时执行。
                return false;
            }

            @Override
            public boolean onMessageLongClick(Context context, View view, Message message) {
//                当长按消息时执行。
                return false;
            }
        });
    }

}
