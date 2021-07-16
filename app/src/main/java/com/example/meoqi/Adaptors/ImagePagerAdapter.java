package com.example.meoqi.Adaptors;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meoqi.Models.Date;
import com.example.meoqi.Models.Image;
import com.example.meoqi.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class ImagePagerAdapter extends ListAdapter<Image, ImagePagerAdapter.ViewHolder> {

    List<Image> images = new ArrayList<>();
    Context mContext;
    ViewPager2 viewPager2;

    public ImagePagerAdapter() {
        super(diffCallback);
    }

    private static final DiffUtil.ItemCallback<Image> diffCallback = new DiffUtil.ItemCallback<Image>() {
        @Override
        public boolean areItemsTheSame(@NonNull Image oldItem, @NonNull Image newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Image oldItem, @NonNull Image newItem) {
            return false;
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_image,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(viewPager2.getCurrentItem()==images.size())
            holder.right.setVisibility(View.INVISIBLE);
        else holder.right.setVisibility(View.VISIBLE);
        if(viewPager2.getCurrentItem()==0)
            holder.left.setVisibility(View.INVISIBLE);
        else holder.left.setVisibility(View.VISIBLE);

        holder.right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager2.getCurrentItem()<images.size()-1)
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
                else holder.right.setVisibility(View.INVISIBLE);
            }
        });
        holder.left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager2.getCurrentItem()>0)
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem()-1);
                else holder.left.setVisibility(View.INVISIBLE);
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        View itemView;
        CardView right,left;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            right = itemView.findViewById(R.id.right);
            left = itemView.findViewById(R.id.left);
        }
    }

    public void setViewPager2(ViewPager2 viewPager2)
    {
        this.viewPager2 = viewPager2;
    }

    public void setList(List<Image> images) {
        this.images = images;
        Log.d("VPA","foodListsize : "+images.size());
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}
