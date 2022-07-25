package com.wangxingxing.homepageanim.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * author : 王星星
 * date : 2020/9/16 15:06
 * email : 1099420259@qq.com
 * description :
 */
public class LinearGradientView extends View {
    //默认渐变色开始颜色(红色)
    private static final int DEFAULT_START_COLOR = Color.parseColor("#FF0000");
    //默认渐变色结束颜色(黄色)
    private static final int DEFAULT_END_COLOR = Color.parseColor("#FFFF00");

    //开始、结束颜色
    private int mStartColor, mEndColor;
    //绘制的矩形区域
    private RectF mRectF;
    //画笔
    private Paint mPaint;

    int[] colorArray = new int[]{Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN};
    float[] positionArray = new float[]{0f,0.3f,0.6f,0.9f};

    public LinearGradientView(Context context) {
        this(context, null);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LinearGradientView);
//        mStartColor = typedArray.getColor(R.styleable.LinearGradientView_startColor, DEFAULT_START_COLOR);
//        mEndColor = typedArray.getColor(R.styleable.LinearGradientView_endColor, DEFAULT_END_COLOR);
//        typedArray.recycle();

        mStartColor = DEFAULT_START_COLOR;
        mEndColor = DEFAULT_END_COLOR;

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        mRectF = new RectF(0, 0, width, height);
        Shader.TileMode tile;
//        LinearGradient linearGradient = new LinearGradient(0, 0, mRectF.right, 0,
//                mStartColor, mEndColor, Shader.TileMode.MIRROR);
        LinearGradient linearGradient1 = new LinearGradient(0, 0, mRectF.right, 0,
                colorArray, positionArray, Shader.TileMode.REPEAT);
        mPaint.setShader(linearGradient1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(mRectF, mPaint);
    }
}
