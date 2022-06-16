package com.wangxingxing.homepageanim;

import android.os.CountDownTimer;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author : 王星星
 * date : 2022/6/9 18:38
 * email : 1099420259@qq.com
 * description :
 */
public class CountDownTimerAdapter extends RecyclerView.Adapter<CountDownTimerAdapter.ViewHolder> {

    public static final long COUNT_TIME = 10 * 60 * 60 * 1000;

    private SparseArray<CountDownTimer> countDownMap;

    //记录每次刷新时的时间
    private long tempTime;

    public CountDownTimerAdapter() {
        countDownMap = new SparseArray<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_count_down_timer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //记录时间点
        long timeStamp = System.currentTimeMillis() - tempTime;

        long time = COUNT_TIME - timeStamp;

        if (holder.mCountDownTimer != null) {
            holder.mCountDownTimer.cancel();
        }

        holder.mCountDownTimer = new CountDownTimer(COUNT_TIME, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                holder.tv.setText(getMinuteSecond(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                holder.tv.setText("00:00");
            }
        };
        holder.mCountDownTimer.start();
        countDownMap.put(position, holder.mCountDownTimer);
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public void setGetTime(long tempTime) {
        this.tempTime = tempTime;
    }

    /**
     * 清空资源
     */
    public void cancelAllTimers() {
        if (countDownMap == null) {
            return;
        }
        for (int i = 0,length = countDownMap.size(); i < length; i++) {
            CountDownTimer cdt = countDownMap.get(countDownMap.keyAt(i));
            if (cdt != null) {
                cdt.cancel();
            }
        }
    }

    /**
     * 将毫秒数换算成 00:00 形式
     */
    public static String getMinuteSecond(long time) {
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = time / dd;
        long hour = (time - day * dd) / hh;
        long minute = (time - day * dd - hour * hh) / mi;
        long second = (time - day * dd - hour * hh - minute * mi) / ss;

        String strMinute = minute < 10 ? "0" + minute : "" + minute;
        String strSecond = second < 10 ? "0" + second : "" + second;
        return strMinute + ":" + strSecond;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;
        private CountDownTimer mCountDownTimer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_content);
        }
    }
}
