package com.example.meoqi.Adaptors;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meoqi.Models.Date;
import com.example.meoqi.Models.Image;
import com.example.meoqi.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class DatePagerAdapter extends ListAdapter<Date, DatePagerAdapter.ViewHolder> {

    List<Date> dates = new ArrayList<>();
    Context mContext;

    public DatePagerAdapter() {
        super(diffCallback);
    }

    private static final DiffUtil.ItemCallback<Date> diffCallback = new DiffUtil.ItemCallback<Date>() {
        @Override
        public boolean areItemsTheSame(@NonNull Date oldItem, @NonNull Date newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Date oldItem, @NonNull Date newItem) {
            return false;
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_date,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter();
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image());images.add(new Image());images.add(new Image());images.add(new Image());images.add(new Image());images.add(new Image());images.add(new Image());

        imagePagerAdapter.submitList(images);
        imagePagerAdapter.setList(images);
        imagePagerAdapter.setViewPager2(holder.viewPager2);
        holder.viewPager2.setAdapter(imagePagerAdapter);

    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        View itemView;
        ViewPager2 viewPager2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            viewPager2 = itemView.findViewById(R.id.img_pager);
        }
    }

    public void setList(List<Date> dates) {
        this.dates = dates;
        Log.d("VPA","foodListsize : "+dates.size());
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }
}
