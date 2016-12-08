package testvh.yz.com.Cirleroundview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import testvh.yz.com.retrofittest.R;

/**
 * 自定义表盘
 * Created by yz on 2016/12/8.
 */
public class ClockView extends View{
    private Paint panit;
    private RectF mBounds;

    private float wdith;
    private float height;
    private float radius;

    float largeLength;
    float smallLength;

    //外来表盘颜色 和 宽度
    private int mBordercolor;
    private float mBorderwidth;

    public ClockView(Context context) {
        super(context);
        init(context,null,0);
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }
    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr);
    }
    private void init(Context context, AttributeSet attrs, int i) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.lockview, 0, 0);
        try {
            mBordercolor=typedArray.getColor(R.styleable.lockview_border_color,0xff000000);
            mBorderwidth=typedArray.getDimension(R.styleable.lockview_border_width,12);
        } catch (Exception e) {
            typedArray.recycle();
        }
        panit=new Paint(Paint.ANTI_ALIAS_FLAG);
        panit.setStyle(Paint.Style.STROKE);
        panit.setStrokeWidth(mBorderwidth);
        panit.setColor(mBordercolor);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mBounds=new RectF(w,h,oldw,oldh);
        wdith=mBounds.right-mBounds.left;
        height=mBounds.bottom-mBounds.top;
        if(wdith<height){
            radius=wdith/4;
        }else {
            radius=height/4;
        }

        smallLength=10;
        largeLength=20;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0xff000000);
        panit.setColor(0x66555555);
        canvas.drawRoundRect(new RectF(mBounds.centerX()-(float)0.9*wdith/2, mBounds.centerY() - (float)0.9*height/2, mBounds.centerX() + (float)0.9*wdith/2, mBounds.centerY() + (float)0.9*height/2), 30, 30, panit);
        panit.setColor(mBordercolor);
        canvas.drawCircle(mBounds.centerX(),mBounds.centerY(),radius,panit);
        float start_x,start_y;
        float end_x,end_y;
        for(int i=0;i<60;++i){
            start_x= radius *(float)Math.cos(Math.PI/180 * i * 6);
            start_y= radius *(float)Math.sin(Math.PI/180 * i * 6);
            if(i%5==0){
                end_x = start_x+largeLength*(float)Math.cos(Math.PI / 180 * i * 6);
                end_y = start_y+largeLength*(float)Math.sin(Math.PI/180 * i * 6);
            }else{
                end_x = start_x+smallLength*(float)Math.cos(Math.PI/180 * i * 6);
                end_y = start_y+smallLength*(float)Math.sin(Math.PI/180 * i * 6);
            }
            start_x+=mBounds.centerX();
            end_x+=mBounds.centerX();
            start_y+=mBounds.centerY();
            end_y+=mBounds.centerY();
            canvas.drawLine(start_x, start_y, end_x, end_y, panit);
        }
        canvas.drawCircle(mBounds.centerX(),mBounds.centerY(),20,panit);
        canvas.rotate(60,mBounds.centerX(),mBounds.centerY());
        canvas.drawLine(mBounds.centerX(),mBounds.centerY(),mBounds.centerX(),mBounds.centerY()-radius,panit);
    }
}
