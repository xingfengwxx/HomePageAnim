package com.wangxingxing.homepageanim.weight;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import com.wangxingxing.homepageanim.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * author : 王星星
 * date : 2021/4/21 15:57
 * email : 1099420259@qq.com
 * description :
 */

public class BezierView extends View {

    /**
     * 第1条二阶贝塞尔曲线
     * pointF---0: PointF(117.0, 1725.6398)
     * pointF---1: PointF(520.0, 1910.5)
     * pointF---2: PointF(938.4201, 1621.4202)
     *
     * 第2条二阶贝塞尔曲线
     * pointF---0: PointF(227.0, 1153.4037)
     * pointF---1: PointF(875.0, 1164.0)
     * pointF---2: PointF(938.4201, 1621.4202)
     *
     * 第3条二阶贝塞尔曲线
     * pointF---0: PointF(227.0, 1153.4037)
     * pointF---1: PointF(435.70526, 952.2947)
     * pointF---2: PointF(921.0, 884.5)
     *
     * 第4条二阶贝塞尔曲线
     * pointF---0: PointF(281.5, 618.0)
     * pointF---1: PointF(663.0, 681.5)
     * pointF---2: PointF(921.0, 884.5)
     *
     * 第5条二阶贝塞尔曲线
     * pointF---0: PointF(281.5, 618.0)
     * pointF---1: PointF(486.5, 448.0)
     * pointF---2: PointF(772.21765, 448.0)
     *
     * 第6条二阶贝塞尔曲线
     * pointF---0: PointF(348.5, 261.5)
     * pointF---1: PointF(594.0, 325.0)
     * pointF---2: PointF(772.21765, 448.0)
     */

    private static final float DELAY = 0.005f;

    //贝塞尔曲线控制点，每3个控制点画一条贝塞尔二阶曲线
    private List<BezierPoint> mPoints;

    private Paint mPaint;
    private Path mBezierPath;

    // 箭头图片
    private Bitmap mArrowBitmap;
    private Matrix mMatrix;
    // 路径测量
    private PathMeasure mPathMeasure;
    private ValueAnimator valueAnimator;
    // 当前移动值
    private float mCurrentValue = 0;
    // PathMeasure 测量过程中的坐标
    private float mPos[];
    // PathMeasure 测量过程中的正切
    private float mTan[];

    public BezierView(Context context) {
        this(context, null);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void initData() {
        mPoints = new ArrayList<>();
        mPoints.add(new BezierPoint(new Point(117, 1725), new Point(520, 1910), new Point(938, 1621)));
        mPoints.add(new BezierPoint(new Point(227, 1153), new Point(875, 1164), new Point(938, 1621)));
        mPoints.add(new BezierPoint(new Point(227, 1153), new Point(435, 952), new Point(921, 884)));
        mPoints.add(new BezierPoint(new Point(281, 618), new Point(663, 681), new Point(921, 884)));
        mPoints.add(new BezierPoint(new Point(281, 618), new Point(486, 448), new Point(772, 448)));
        mPoints.add(new BezierPoint(new Point(348, 261), new Point(594, 325), new Point(772, 448)));
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        // 获取图片
        mArrowBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.arrow, null);

        // 初始化 装载 坐标 和 正余弦 的数组
        mPos = new float[2];
        mTan = new float[2];

        mBezierPath = new Path();

        // 初始化 PathMeasure 并且关联 圆路径
        mPathMeasure = new PathMeasure();


        // 初始化矩阵
        mMatrix = new Matrix();

        // 初始化 估值器 [区间0-1、时长5秒、线性增长、无限次循环]
        valueAnimator = ValueAnimator.ofFloat(0, 1f);
        valueAnimator.setDuration(2000);
        // 匀速增长
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 第一种做法：通过自己控制，是箭头在原来的位置继续运行
                mCurrentValue += DELAY;
                if (mCurrentValue >= 1) {
                    mCurrentValue -= 1;
                }

                // 第二种做法：直接获取可以通过估值器，改变其变动规律
//                mCurrentValue = (float) animation.getAnimatedValue();

                invalidate();
            }
        });

        initData();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mPoints.size(); i++) {
            //贝塞尔
            BezierPoint point = mPoints.get(i);
            mBezierPath.moveTo(point.startPoint.x, point.startPoint.y);
            mBezierPath.quadTo(point.controlPoint.x, point.controlPoint.y, point.endPoint.x, point.endPoint.y);

            //绘制贝塞尔
            mPaint.setColor(Color.RED);
            canvas.drawPath(mBezierPath, mPaint);
        }

        mPathMeasure.setPath(mBezierPath, false);

        // 测量 pos(坐标) 和 tan(正切)
        mPathMeasure.getPosTan(mPathMeasure.getLength() * mCurrentValue, mPos, mTan);

        // 计算角度
        float degree = (float) (Math.atan2(mTan[1], mTan[0]) * 180 / Math.PI);

        // 重置矩阵
        mMatrix.reset();
        // 设置旋转角度
        mMatrix.postRotate(degree, mArrowBitmap.getWidth() / 2, mArrowBitmap.getHeight() / 2);
        // 设置偏移量
        mMatrix.postTranslate(mPos[0] - mArrowBitmap.getWidth() / 2,
                mPos[1] - mArrowBitmap.getHeight() / 2);

        // 画原点
        canvas.drawCircle(0, 0, 3, mPaint);

        // 画箭头，使用矩阵旋转
        canvas.drawBitmap(mArrowBitmap, mMatrix, mPaint);

//        mPathMeasure.nextContour();

    }

    public void startLoading() {
        valueAnimator.start();
    }

    public void stopLoading() {
        valueAnimator.cancel();
    }
}
