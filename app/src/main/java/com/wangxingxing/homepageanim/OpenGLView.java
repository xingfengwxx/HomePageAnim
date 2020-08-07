package com.wangxingxing.homepageanim;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * author : 王星星
 * date : 2020/8/3 16:39
 * email : 1099420259@qq.com
 * description :
 */
public class OpenGLView extends GLSurfaceView {

    private OpenGLRenderer4 mRenderer;

    private float mDownX = 0.0f;
    private float mDownY = 0.0f;

    public OpenGLView(Context context) {
        super(context);

        mRenderer = new OpenGLRenderer4();
        this.setRenderer(mRenderer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mDownX = event.getX();
                mDownY = event.getY();
                return true;
            case MotionEvent.ACTION_UP:
                return true;
            case MotionEvent.ACTION_MOVE:
                float mX = event.getX();
                float mY = event.getY();
                mRenderer.mLightX += (mX - mDownX) / 10;
                mRenderer.mLightY -= (mY - mDownY) / 10;
                mDownX = mX;
                mDownY = mY;
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }
    
}
