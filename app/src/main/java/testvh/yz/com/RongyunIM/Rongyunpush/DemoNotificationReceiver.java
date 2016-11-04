package testvh.yz.com.RongyunIM.Rongyunpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import io.rong.push.notification.PushMessageReceiver;
import io.rong.push.notification.PushNotificationMessage;
import testvh.yz.com.retrofittest.R;

/**
 * 自定义广播接收器
 * Created by yz on 2016/11/4.
 */
public class DemoNotificationReceiver extends PushMessageReceiver {
    private NotificationManager notificationManager;
    @Override
    public boolean onNotificationMessageArrived(Context context, PushNotificationMessage pushNotificationMessage) {
        //用来接收服务器发来的通知栏消息(消息到达客户端时触发)，
        // 默认return false，通知消息会以融云 SDK 的默认形式展现。
        // 如果需要自定义通知栏的展示，在这里实现自己的通知栏展现代码，同时 return true 即可。

        String pushContent = pushNotificationMessage.getPushContent();
        Log.d("LoginActivity", "--onSuccess" + pushContent);
        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("消息通知");
        builder.setContentText(pushContent);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher));
        //设置通知的音乐、振动、LED等
        builder.setDefaults(Notification.DEFAULT_ALL);
        notificationManager.notify(1, builder.build());

        return true;
    }

    @Override
    public boolean onNotificationMessageClicked(Context context, PushNotificationMessage pushNotificationMessage) {
        //是在用户点击通知栏消息时触发
        // (注意:如果自定义了通知栏的展现，则不会触发)，默认 return false 。
        // 如果需要自定义点击通知时的跳转，return true 即可。融云 SDK 默认跳转规则如下
        return false;
    }
}
