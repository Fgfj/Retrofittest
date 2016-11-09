package testvh.yz.com.retrofittest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import testvh.yz.com.Animation.Traslation_Act;
import testvh.yz.com.Banner.BannerAct;
import testvh.yz.com.Cirleroundview.Charttest;
import testvh.yz.com.Perssion.PER_Act;
import testvh.yz.com.RongyunIM.Rongyun_Act;
import testvh.yz.com.RoundingImangeview.Roundimage;
import testvh.yz.com.SQL.Act_SQL;
import testvh.yz.com.SQL.DaoSession;
import testvh.yz.com.SQL.DataCleanManager;
import testvh.yz.com.SQL.GreenDaoManager;
import testvh.yz.com.SQL.MESSAGE;
import testvh.yz.com.SQL.MESSAGEDao;
import testvh.yz.com.SQL.Student;
import testvh.yz.com.SQL.StudentDao;
import testvh.yz.com.SQL.Teacher;
import testvh.yz.com.SQL.TeacherDao;
import testvh.yz.com.UIstatus.UiStatus;
import testvh.yz.com.karics.karics.library.zxing.android.CaptureActivity;


public class Erweimacode extends AppCompatActivity {
    private final int REQUEST_CODE = 110;
    private ImageView imageView;
    private TextView tokentextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erweimacode);
        imageView = (ImageView) findViewById(R.id.imageerweima);
    }
    //扫描二维码
    public void go(View view) {
        Intent intentthiss = new Intent(this,CaptureActivity.class);
        startActivityForResult(intentthiss,REQUEST_CODE);
    }

    public void 去自定义图表(View view) {
        startActivity(new Intent(this, Charttest.class));
    }

    public void 清楚数据库(View view) {
        startActivity(new Intent(this, Act_SQL.class));
    }

    public void 去UI切换页面(View view) {
        startActivity(new Intent(this, UiStatus.class));
    }

    public void 去MVP切换页面(View view) {startActivity(new Intent(this, MainActivity.class));
    }

    public void 去banner切换页面(View view) {startActivity(new Intent(this, BannerAct.class));
    }
    public void 去圆形图片切换页面(View view) {startActivity(new Intent(this, Roundimage.class));
    }
    public void 去融云片切换页面(View view) {startActivity(new Intent(this, Rongyun_Act.class));
    }
    public void 去权限切换页面(View view) {startActivity(new Intent(this, PER_Act.class));
    }
    public void 图片旋转(View view) {startActivity(new Intent(this, Traslation_Act.class));
    }
    @Override
    protected void onResume() {
        super.onResume();
        //    app图标
        sendBadgeNumber();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //我们需要的结果返回
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            //拿到二维码扫描后的数据
            //result就是二维码扫描的结果。
            String content = data.getStringExtra("codedContent");
            Bitmap bitmap=data.getParcelableExtra("codedBitmap");
            if(bitmap!=null)
                imageView.setImageBitmap(bitmap);
            Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
//            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT)
//                    .show();
        }
    }
    public void 生成二维码(View view) {
        try {
            Bitmap bitmap = Create2DCode("http://baidu.com");
            imageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
//        Hashtable<EncodeHintType, Object> qrParam = new Hashtable<EncodeHintType, Object>();
//        // 设置QR二维码的纠错级别——这里选择最高H级别 
//        qrParam.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);// 设置编码方式   
//        qrParam.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//        // 设定二维码里面的内容，这里我采用我微博的地址   
//        String content = "http://baidu.com";
//        //生成QR二维码数据——这里只是得到一个由true和false组成的数组   
//        // 参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数   
//        BitMatrix bitMatrix = null;
//        try {
//            bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300, qrParam);
//            // 开始利用二维码数据创建Bitmap图片，分别设为黑白两色
//            int w = bitMatrix.getWidth();
//            int h = bitMatrix.getHeight();
//            int[] data = new int[w * h];
//            for (int y = 0; y < h; y++) {
//                for (int x = 0; x < w; x++) {
//                    if (bitMatrix.get(x, y))
//                        data[y * w + x] = 0xff000000;// 黑色                    else   
//                    data[y * w + x] = -1;// -1 相当于0xffffffff 白色  
//                }
//            }
//            // 创建一张bitmap图片，采用最高的效果显示   
//            Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);// 将上面的二维码颜色数组传入，生成图片颜色          bitmap.setPixels(data, 0, w, 0, 0, w, h);            return bitmap;   
//           if (bitmap!=null){
//               Toast.makeText(this,"bitmap=null",Toast.LENGTH_SHORT).show();
//           }else {
//               imageView.setImageBitmap(bitmap);
//           }
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }

    }
    /**
     * 用字符串生成二维码
     * @param str
     * @author zhouzhe@lenovo-cw.com
     * @return
     * @throws WriterException
     */
    public Bitmap Create2DCode(String str) throws WriterException {
        //生成二维矩阵,编码时指定大小,不要生成了图片以后再进行缩放,这样会模糊导致识别失败
        BitMatrix matrix = new MultiFormatWriter().encode(str,BarcodeFormat.QR_CODE, 300, 300);
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        //二维矩阵转为一维像素数组,也就是一直横着排了
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(matrix.get(x, y)){
                    pixels[y * width + x] = 0xff000000;
                }

            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //通过像素数组生成bitmap,具体参考api
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }
    private void sendBadgeNumber() {
        Log.e("Build",Build.BRAND+"==="+ Build.PRODUCT+"==="+Build.MANUFACTURER+"==="+Erweimacode.class.getName()+"==Android系统定制商,手机制造商, 硬件制造商 ");
        String number = "35";
        if (TextUtils.isEmpty(number)) {
            number = "0";
        } else {
            int numInt = Integer.valueOf(number);
            number = String.valueOf(Math.max(0, Math.min(numInt, 99)));
        }
        if (Build.BRAND.equals("Xiaomi")) {
            sendToXiaoMi(number);
        } else if (Build.BRAND.equals("sony")) {
            sendToSony(number);
        } else if (Build.BRAND.toLowerCase().contains("samsung")) {
            sendToSamsumg(number);
        } else {
            Toast.makeText(this, "Not Support", Toast.LENGTH_LONG).show();
        }
    }
    private void sendToXiaoMi(String number) {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = null;
        boolean isMiUIV6 = true;
        try {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setContentTitle("您有"+number+"未读消息");
            builder.setTicker("您有"+number+"未读消息");
            builder.setAutoCancel(true);
            builder.setSmallIcon(R.drawable.changeloginbtn_shap);
            builder.setDefaults(Notification.DEFAULT_LIGHTS);
            notification = builder.build();
            Class miuiNotificationClass = Class.forName("android.app.MiuiNotification");
            Object miuiNotification = miuiNotificationClass.newInstance();
            Field field = miuiNotification.getClass().getDeclaredField("messageCount");
            field.setAccessible(true);
            field.set(miuiNotification, number);// 设置信息数
            field = notification.getClass().getField("extraNotification");
            field.setAccessible(true);
            field.set(notification, miuiNotification);
            Toast.makeText(this, "Xiaomi=>isSendOk=>1", Toast.LENGTH_LONG).show();
        }catch (Exception e) {
            e.printStackTrace();
            //miui 6之前的版本
            Toast.makeText(this, "Xiaomi<6", Toast.LENGTH_LONG).show();
            isMiUIV6 = false;
            Intent localIntent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            localIntent.putExtra("android.intent.extra.update_application_component_name",getPackageName() + "/"+ Erweimacode.class.getName() );
            localIntent.putExtra("android.intent.extra.update_application_message_text",number);
            sendBroadcast(localIntent);
        }
        finally
        {
            if(notification!=null && isMiUIV6 )
            {
                //miui6以上版本需要使用通知发送
                nm.notify(101010, notification);
            }
        }

    }

    private void sendToSony(String number) {
        boolean isShow = true;
        if ("0".equals(number)) {
            isShow = false;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE",isShow);//是否显示
        localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", Erweimacode.class.getName());//启动页
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", number);//数字
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME",getPackageName());//包名
        sendBroadcast(localIntent);

        Toast.makeText(this, "Sony," + "isSendOk", Toast.LENGTH_LONG).show();
    }

    private void sendToSamsumg(String number)
    {
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", number);//数字
        localIntent.putExtra("badge_count_package_name", getPackageName());//包名
        localIntent.putExtra("badge_count_class_name",Erweimacode.class.getName()); //启动页
        sendBroadcast(localIntent);
        Toast.makeText(this, "Samsumg," + "isSendOk", Toast.LENGTH_LONG).show();
    }



}
