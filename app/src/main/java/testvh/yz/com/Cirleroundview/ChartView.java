package testvh.yz.com.Cirleroundview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import java.util.List;

/**
 * Created by yz on 2016/10/18.
 */
public class ChartView extends View {

    //中间汉字
    private String testtext;
    private Paint CentertextPain;
    public void setTesttext(String testtext){
        this.testtext=testtext;
    }

    //饼图白色轮廓画笔 饼状图外圆半径   外园颜色  宽度
    private Paint mOuterLinePaint;
    private float mOutRadius;
    private Color mOutcolor;
    private static int OUTER_LINE_WIDTH = 3;


    //饼状图画笔
    private Paint mPiePaint;


    //内圆画笔  饼状图内圆半径 颜色
    private Paint mInnerPaint;
    private float mInnerRadius;
    private Color mInnercolor;

    private RectF mRectF = new RectF();


    //动画时间 绘制弧形的sweep数组 构成饼状图的数据集合
    private static final int ANIMATION_DURATION = 800;
    private float[] mPieSweep;
    private List<PieData> mPieDataList;
    private static final int PIE_ANIMATION_VALUE = 100;
    private PieChartAnimation mAnimation;

    //总量
    private int max=0;

    //饼状图外圆半径
    private float mRadius = Measure_Utils.dip2px(getContext(), 60) + OUTER_LINE_WIDTH;
    //初始画弧所在的角度
    private static final int START_DEGREE = -90;
    public ChartView(Context context) {
        super(context);
        init(context,null,0);
    }

    public ChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs,0);
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mOuterLinePaint = new Paint();
        mOuterLinePaint.setAntiAlias(true);
        mOuterLinePaint.setStyle(Paint.Style.STROKE);
        mOuterLinePaint.setStrokeWidth(OUTER_LINE_WIDTH);
        mOuterLinePaint.setColor(Color.WHITE);

        //中间汉字
        CentertextPain=new Paint();
        CentertextPain.setAntiAlias(true);
        CentertextPain.setStyle(Paint.Style.STROKE);
        CentertextPain.setColor(Color.BLACK);
        CentertextPain.setTextSize(40);
        mPiePaint = new Paint();
        mPiePaint.setAntiAlias(true);
        mPiePaint.setStyle(Paint.Style.FILL);
        //设置动画
        mAnimation = new PieChartAnimation();
        mAnimation.setDuration(ANIMATION_DURATION);

        mInnerPaint = new Paint();
        mInnerPaint.setColor(Color.WHITE);
        mInnerPaint.setStyle(Paint.Style.FILL);
        mInnerPaint.setAntiAlias(true);
        initRectF();

    }
    //内圆 和文字
    protected void drawInnerCircle(Canvas canvas) {
        canvas.drawCircle(mRadius, mRadius, (float) (mRadius * 0.72), mInnerPaint);
        canvas.drawText(testtext, mRadius, mRadius, CentertextPain);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int length = (int) (2 * mRadius);
        setMeasuredDimension(length, length);
    }

    private boolean isleft=false;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPieDataList != null && !mPieDataList.isEmpty()) {
            //起始是从-90°位置开始画
            float pieStart = START_DEGREE;
            if (mPieSweep == null) {
                mPieSweep = new float[mPieDataList.size()];
            }
            for(int i=0;i<mPieDataList.size();i++){
                //设置弧形颜色
                mPiePaint.setColor(mPieDataList.get(i).getColorId());
                //绘制弧形区域，以构成饼状图
                float pieSweep = mPieDataList.get(i).getValue() * 360;
                canvas.drawArc(mRectF, pieStart, mPieSweep[i], true, mPiePaint);
                canvas.drawArc(mRectF, pieStart, mPieSweep[i], true, mOuterLinePaint);
                pieStart += pieSweep;
            }
        }else {
            //无数据时，显示灰色圆环
            mPiePaint.setColor(Color.parseColor("#dadada"));//灰色
            canvas.drawCircle(mRadius, mRadius, mRadius, mPiePaint);
        }
        drawInnerCircle(canvas);
    }

    /**
     * 设置需要绘制的数据集合
     */
    public void setPieDataList(List<PieData> pieDataList) {
        this.mPieDataList = pieDataList;
        if (mPieSweep == null) {
            mPieSweep = new float[mPieDataList.size()];
        }
        startAnimation(mAnimation);
    }

    /**
     * 设置外圆半径
     *
     * @param radius 外圆半径 dp为单位
     **/
    public void setOuterRadius(float radius) {
        this.mRadius = Measure_Utils.dip2px(getContext(), radius) + OUTER_LINE_WIDTH ;
        initRectF();
    }
    /**
     * 初始化绘制弧形所在矩形的四点坐标
     **/
    private void initRectF() {
        mRectF.left = 0;
        mRectF.top = 0;
        mRectF.right = 2 * mRadius;
        mRectF.bottom = 2 * mRadius;
    }

    /**
     * 动画 mPieSweep绘制弧形的sweep数组   mPieDataList 构成饼状图的数据集合  PIE_ANIMATION_VALUE
     */
    private class PieChartAnimation extends Animation {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            mPieSweep = new float[mPieDataList.size()];
            if (interpolatedTime < 1.0f) {
                for (int i = 0; i < mPieDataList.size(); i++) {
                    mPieSweep[i] = (mPieDataList.get(i).getValue() * PIE_ANIMATION_VALUE) * interpolatedTime / PIE_ANIMATION_VALUE * 360;
                }
            } else {
                for (int i = 0; i < mPieDataList.size(); i++) {
                    mPieSweep[i] = mPieDataList.get(i).getValue() * 360;
                }
            }
            invalidate();
        }
    }
}
