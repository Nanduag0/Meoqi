package com.example.meoqi.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meoqi.Models.ArtistData;
import com.example.meoqi.Models.Image;
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;

import java.util.List;

public class ArtistPerformingAdaptor extends RecyclerView.Adapter<ArtistPerformingAdaptor.ViewHolder> {

    Context context;
    List<ArtistData> list;

    public ArtistPerformingAdaptor(Context context, List<ArtistData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ArtistPerformingAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artists_rv, parent, false);
        ArtistPerformingAdaptor.ViewHolder holder = new ArtistPerformingAdaptor.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistPerformingAdaptor.ViewHolder holder, int position) {
        ArtistData artist = list.get(position);
        holder.artistNameTv.setText(artist.getName());
        holder.timeRangeTv.setText(artist.getFrom()+"-"+artist.getTo());
        Glide.with(context).load(artist.getImages().get(0).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView artistNameTv,timeRangeTv;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artistNameTv = itemView.findViewById(R.id.t1);
            timeRangeTv = itemView.findViewById(R.id.t2);
            imageView = itemView.findViewById(R.id.i1);
        }

    }
}