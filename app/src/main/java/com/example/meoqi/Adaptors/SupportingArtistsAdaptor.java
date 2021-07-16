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
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;

import java.util.List;

public class SupportingArtistsAdaptor extends RecyclerView.Adapter<SupportingArtistsAdaptor.ViewHolder>
{
    Context context;
    List<ArtistData> list;

    public SupportingArtistsAdaptor(Context context, List<ArtistData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friends_rv,parent,false);
        SupportingArtistsAdaptor.ViewHolder holder = new SupportingArtistsAdaptor.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArtistData artistData = list.get(position);
        holder.name.setText(artistData.getName());
        Glide.with(context).load(artistData.getImages().get(0).getUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
        }

    }
}
