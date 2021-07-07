package com.wangxingxing.homepageanim;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.blankj.utilcode.util.ConvertUtils;

/**
 * author : 王星星
 * date : 2021/6/16 14:50
 * email : 1099420259@qq.com
 * description : 评论区点赞
 */
public class LikePopupWindow {

    private ConstraintLayout mClHug;
    private ConstraintLayout mClOk;
    private ConstraintLayout mClLike;

    private TextView mTvHug;
    private TextView mTvOk;
    private TextView mTvLike;

    private PopupWindow mPopupWindow;
    private IListener mListener;

    public void setListener(IListener listener) {
        mListener = listener;
    }

    public static LikePopupWindow create(@NonNull Context context) {
        return new LikePopupWindow(context);
    }

    private LikePopupWindow(@NonNull Context context) {
        createPopupWindow(context);
    }

    private void createPopupWindow(@NonNull Context context) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.popup_like_view, null);
        initView(rootView);
        initEvent();
        initData();

        mPopupWindow = new PopupWindow(rootView, ConvertUtils.dp2px(233), ConvertUtils.dp2px(33));
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
    }

    private void initView(View root) {
        mClHug = root.findViewById(R.id.cl_hug);
        mClOk = root.findViewById(R.id.cl_ok);
        mClLike = root.findViewById(R.id.cl_like);

        mTvHug = root.findViewById(R.id.tv_like_hug);
        mTvOk = root.findViewById(R.id.tv_like_ok);
        mTvLike = root.findViewById(R.id.tv_like_normal);

    }

    private void initEvent() {

    }

    private void initData() {


    }

    public void showAsDropDown(@NonNull View view, int offX, int offY) {
        mPopupWindow.showAsDropDown(view, offX, offY, Gravity.RIGHT);
    }

    public void dismiss() {
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
        }

    }

    public interface IListener {
        void onClickLike(int likeType);
    }
}
