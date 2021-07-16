package com.example.meoqi.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meoqi.R;

import java.util.List;

public class MusicAdaptor extends RecyclerView.Adapter<MusicAdaptor.ViewHolder>{

    Context context;
    List<String> list;

    public MusicAdaptor(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MusicAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music_rv,parent,false);
        MusicAdaptor.ViewHolder holder = new MusicAdaptor.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdaptor.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }

    }
}
