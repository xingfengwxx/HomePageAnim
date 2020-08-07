package com.wangxingxing.homepageanim.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ColorUtils;
import com.bumptech.glide.Glide;
import com.wangxingxing.homepageanim.R;

import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * author : 王星星
 * date : 2020/7/27 15:28
 * email : 1099420259@qq.com
 * description :
 */
public class CircleRecyclerViewAdapter extends RecyclerView.Adapter<CircleRecyclerViewAdapter.ViewHolder>{

    private int[] mBorderColors = {
            R.color.colorHeadBorder1,
            R.color.colorHeadBorder2,
            R.color.colorHeadBorder3,
            R.color.colorHeadBorder4
    };

    private Integer[] mImgs = {
            R.drawable.icon_female_a, R.drawable.icon_female_b, R.drawable.icon_female_c, R.drawable.icon_female_d, R.drawable.icon_female_e, R.drawable.icon_female_f,
            R.drawable.icon_man_a, R.drawable.icon_man_b, R.drawable.icon_man_c, R.drawable.icon_man_d, R.drawable.icon_man_e, R.drawable.icon_man_f,
    };

    private IListener mIListener;

    private List<UserInfoBean> mData;
//    private List<Integer> mData;
    private boolean mNeedLoop;
    private Random mRandom = new Random();

    public CircleRecyclerViewAdapter(List<UserInfoBean> data, boolean needLoop) {
        mData = data;
        mNeedLoop = needLoop;
    }

//    public CircleRecyclerViewAdapter(List<Integer> data, boolean needLoop) {
//        mData = data;
//        mNeedLoop = needLoop;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_circle_recycler, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.civ.setBorderWidth(8);
        holder.civ.setBorderColor(ColorUtils.getColor(mBorderColors[mRandom.nextInt(mBorderColors.length)]));
        Glide.with(holder.civ).load(mImgs[mRandom.nextInt(mImgs.length)]).into(holder.civ);
        holder.tvNickName.setText(mData.get(position % mData.size()).getNickName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIListener != null) {
                    mIListener.onItemClickListener(v, position);
                }
            }
        });

//        GlideManger.get().loadHeadImage(mData.get(position).header, holder.civ);
//        holder.tvNickName.setText(mData.get(position).nickName);

//        GlideManger.get().loadHeadImage(mData.get(position % mData.size()), holder.civ);
//        holder.tvNickName.setText("user" + position % mData.size());
    }

    @Override
    public int getItemCount() {
        return mNeedLoop ? Integer.MAX_VALUE : mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView civ;
        TextView tvNickName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            civ = (CircleImageView) itemView.findViewById(R.id.civ_head);
            tvNickName = itemView.findViewById(R.id.tv_nick_name);
        }
    }

    public void setIListener(IListener IListener) {
        mIListener = IListener;
    }

    public interface IListener {
        void onItemClickListener(View view, int position);
    }
}
