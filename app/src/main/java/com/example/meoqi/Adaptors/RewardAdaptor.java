package com.example.meoqi.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.meoqi.R;
import com.example.meoqi.Models.RewardData;

import java.util.List;

public class RewardAdaptor extends RecyclerView.Adapter<RewardAdaptor.ViewHolder> {

    Context context;
    List<RewardData> list;
    onRewardItemClickListener rewardItemClickListener;

    public RewardAdaptor(Context context,List<RewardData> list, onRewardItemClickListener rewardItemClickListener) {
        this.list = list;
        this.context=context;
        this.rewardItemClickListener=rewardItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reward_item_layout,parent,false);

        return new ViewHolder(view,rewardItemClickListener);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.color.colorBlack);

        Glide.with(context)
                .asBitmap()
                .load(list.get(position).getReward_image_url())
                .apply(requestOptions)
                .into(holder.itemPhoto);

        holder.itemName.setText(list.get(position).getReward_name());
        holder.itemCount.setText(list.get(position).getReward_count());

        int count = Integer.parseInt(list.get(position).getReward_count());
        if(count <= 10)
        {
            holder.itemCount.setTextColor(ContextCompat.getColor(context,R.color.colorRed));
            holder.itemName.setTextColor(ContextCompat.getColor(context,R.color.colorRed));

            holder.left.setTextColor(ContextCompat.getColor(context,R.color.colorRed));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView itemPhoto;
        TextView itemName;
        TextView itemCount;
        TextView left;
        onRewardItemClickListener RewardItemClickListener;


        public ViewHolder(@NonNull View itemView, onRewardItemClickListener rewardItemClickListener) {
            super(itemView);
            itemPhoto = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemCount = itemView.findViewById(R.id.item_count);
            left = itemView.findViewById(R.id.left);
            this.RewardItemClickListener=rewardItemClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            rewardItemClickListener.onRewardClick(getAdapterPosition());

        }
    }
    public interface onRewardItemClickListener{
        void onRewardClick(int position);
    }
}
