package testvh.yz.com.RongyunIM;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import io.rong.message.ImageMessage;
import io.rong.message.RichContentMessage;
import io.rong.message.TextMessage;
import io.rong.message.VoiceMessage;
import io.rong.push.notification.PushNotificationMessage;
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
                        /**
                         *  设置发送消息的监听器。
                         */
                        if (RongIM.getInstance() != null) {
                            //设置自己发出的消息监听器。
                            RongIM.getInstance().setSendMessageListener(new MySendMessageListener());
                        }
                        /**
                         *  设置接收消息的监听器。
                         */
                        RongIM.setOnReceiveMessageListener(new MyReceiveMessageListener());
                        if (RongIM.getInstance() != null && RongIM.getInstance().getRongIMClient() != null) {
                            /**
                             * 设置连接状态变化的监听器.
                             */
                            RongIM.getInstance().getRongIMClient().setConnectionStatusListener(new MyConnectionStatusListener());
                        }
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
    private NotificationManager notificationManager;
    private class MyReceiveMessageListener implements RongIMClient.OnReceiveMessageListener {

        /**
         * 收到消息的处理。
         *
         * @param message 收到的消息实体。
         * @param left    剩余未拉取消息数目。
         * @return 收到消息是否处理完成，true 表示走自已的处理方式，false 走融云默认处理方式。
         */
        @Override
        public boolean onReceived(Message message, int left) {
            //开发者根据自己需求自行处理
            MessageContent content = message.getContent();
            TextMessage textMessage = (TextMessage) content;
            Log.e("LoginActivity",
                    "接受消息监听ReceiveMessageListener===="+textMessage.getContent());
            return false;
        }
    }
    private static final String TAG="LoginActivity";
    private class MySendMessageListener implements RongIM.OnSendMessageListener {

        /**
         * 消息发送前监听器处理接口（是否发送成功可以从 SentStatus 属性获取）。
         *
         * @param message 发送的消息实例。
         * @return 处理后的消息实例。
         */
        @Override
        public Message onSend(Message message) {
            //开发者根据自己需求自行处理逻辑
            return message;
        }

        /**
         * 消息在 UI 展示后执行/自己的消息发出后执行,无论成功或失败。
         *
         * @param message              消息实例。
         * @param sentMessageErrorCode 发送消息失败的状态码，消息发送成功 SentMessageErrorCode 为 null。
         * @return true 表示走自已的处理方式，false 走融云默认处理方式。
         */
        @Override
        public boolean onSent(Message message,RongIM.SentMessageErrorCode sentMessageErrorCode) {

            if(message.getSentStatus()== Message.SentStatus.FAILED){
                if(sentMessageErrorCode== RongIM.SentMessageErrorCode.NOT_IN_CHATROOM){
                    //不在聊天室
                }else if(sentMessageErrorCode== RongIM.SentMessageErrorCode.NOT_IN_DISCUSSION){
                    //不在讨论组
                }else if(sentMessageErrorCode== RongIM.SentMessageErrorCode.NOT_IN_GROUP){
                    //不在群组
                }else if(sentMessageErrorCode== RongIM.SentMessageErrorCode.REJECTED_BY_BLACKLIST){
                    //你在他的黑名单中
                }
            }

            MessageContent messageContent = message.getContent();

            if (messageContent instanceof TextMessage) {//文本消息
                TextMessage textMessage = (TextMessage) messageContent;
                Log.d(TAG, "onSent-TextMessage:" + textMessage.getContent());
            } else if (messageContent instanceof ImageMessage) {//图片消息
                ImageMessage imageMessage = (ImageMessage) messageContent;
                Log.d(TAG, "onSent-ImageMessage:" + imageMessage.getRemoteUri());
            } else if (messageContent instanceof VoiceMessage) {//语音消息
                VoiceMessage voiceMessage = (VoiceMessage) messageContent;
                Log.d(TAG, "onSent-voiceMessage:" + voiceMessage.getUri().toString());
            } else if (messageContent instanceof RichContentMessage) {//图文消息
                RichContentMessage richContentMessage = (RichContentMessage) messageContent;
                Log.d(TAG, "onSent-RichContentMessage:" + richContentMessage.getContent());
            } else {
                Log.d(TAG, "onSent-其他消息，自己来判断处理");
            }

            return false;
        }
    }
    private class MyConnectionStatusListener implements RongIMClient.ConnectionStatusListener {

        @Override
        public void onChanged(ConnectionStatus connectionStatus) {

            switch (connectionStatus){

                case CONNECTED://连接成功。
                    Log.d(TAG, "连接成功");
                    break;
                case DISCONNECTED://断开连接。
                    Log.d(TAG, "断开连接");
                    break;
                case CONNECTING://连接中。
                    Log.d(TAG, "连接中");
                    break;
                case NETWORK_UNAVAILABLE://网络不可用。
                    Log.d(TAG, "网络不可用");
                    break;
                case KICKED_OFFLINE_BY_OTHER_CLIENT://用户账户在其他设备登录，本机会被踢掉线
                    Log.d(TAG, "用户账户在其他设备登录");
                    break;
            }
        }
    }
}
