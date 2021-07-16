package com.example.meoqi.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meoqi.R;
import com.example.meoqi.Models.TopArtistData;

import java.util.List;

public class TopArtistFanAdaptor extends RecyclerView.Adapter<TopArtistFanAdaptor.ViewHolder> {

    Context context;
    List<TopArtistData> list;
    //private TopArtistFanAdaptor.onArtistClickListener onArtistClickListener;

    public TopArtistFanAdaptor(Context context, List<TopArtistData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.top_artist_fan_layout,parent,false);
        TopArtistFanAdaptor.ViewHolder holder = new TopArtistFanAdaptor.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context)
                .asBitmap()
                .load(list.get(position).getArtist_image_url())
                .into(holder.photo);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView photo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photo=itemView.findViewById(R.id.profile_photo1);
        }

    }
}
