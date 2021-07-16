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
import com.example.meoqi.R;
import com.example.meoqi.Models.ArtistData;
import com.jgabrielfreitas.core.BlurImageView;

import java.util.List;

public class ArtistAdaptor extends RecyclerView.Adapter<ArtistAdaptor.ViewHolder> {

    private List<ArtistData> artists;
    private Context context;
    private onArtistClickListener onArtistClickListener;

    public ArtistAdaptor( Context context,List<ArtistData> list,onArtistClickListener onArtistClickListener) {
        this.onArtistClickListener=onArtistClickListener;
        this.artists=list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.artists_card_view,parent,false);
        ViewHolder holder = new ViewHolder(view,onArtistClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
//        Glide.with(context)
//                .asBitmap()
//                .load(artists.get(position).getProfile_img())
//                .into(holder.artist_photo);


//        holder.artist_name.setText(artists.get(position).getFirst_name()+" "+artists.get(position).getLast_name());
//
//        Glide.with(context)
//                .load(artists.get(position).getProfile_img())
//                .override(4,4)
//                .into(holder.background);

    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView artist_photo;
        TextView artist_name;
        onArtistClickListener artistClickListener;
        BlurImageView background;

        public ViewHolder(@NonNull View itemView,onArtistClickListener onArtistClickListener) {
            super(itemView);
            artist_name=itemView.findViewById(R.id.artist_name);
            artist_photo=itemView.findViewById(R.id.profile_photo);
            artistClickListener=onArtistClickListener;
            background=itemView.findViewById(R.id.blur_card_background);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            artistClickListener.onArtistClick(getAdapterPosition());
        }
    }

    public interface onArtistClickListener{
        void onArtistClick(int position);
    }
}
