package testvh.yz.com.Gesturestest;

import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import butterknife.ButterKnife;
import butterknife.InjectView;
import testvh.yz.com.retrofittest.R;

public class Gestures_Act extends AppCompatActivity {
    private GestureDetector mDetector;
    private GesOnlistner mgListener;
    private final static String TAG = "MyGesture";

    @InjectView(value = R.id.gesture)
    public GestureOverlayView gestureOverlayView;//手势会话view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures_);
        ButterKnife.inject(this);
        mgListener=new GesOnlistner();
        mDetector=new GestureDetector(this,mgListener);

        gestureOverlayView.setGestureColor(Color.GREEN);
        gestureOverlayView.setGestureStrokeWidth(5);

        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                Bitmap bitmap = gesture.toBitmap(128,128,10,0xffff0000);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }
    private class GesOnlistner implements GestureDetector.OnGestureListener{

        @Override
        public boolean onDown(MotionEvent e) {//按下
            Log.d(TAG, "onDown:按下");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {//手指按下一段时间,不过还没到长按
            Log.d(TAG, "onShowPress:手指按下一段时间,不过还没到长按");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {//手指离开屏幕的一瞬间
            Log.d(TAG, "onSingleTapUp:手指离开屏幕的一瞬间");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(TAG, "onScroll:在触摸屏上滑动");
            return false;//在触摸屏上滑动
        }

        @Override
        public void onLongPress(MotionEvent e) {//长按并且没有松开
            Log.d(TAG, "onLongPress:长按并且没有松开");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d(TAG, "onFling:迅速滑动，并松开");
            return false;//迅速滑动，并松开
        }
    }
}
