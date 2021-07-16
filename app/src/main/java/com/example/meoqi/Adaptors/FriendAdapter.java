package com.example.meoqi.Adaptors;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.meoqi.Activities.FriendsActivity;
import com.example.meoqi.Models.Chat;
import com.example.meoqi.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    Context context;
    List<Chat> list;
    List<String> selected;
    Activity activity;

    public FriendAdapter(Context context, List<Chat> list, Activity activity) {
        this.context = context;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend,parent,false);
        FriendAdapter.ViewHolder holder = new FriendAdapter.ViewHolder(view);
        selected = new ArrayList<>();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected.size()>0)
                {
                    if(selected.contains(holder.getAdapterPosition()+""))
                    {
                        holder.itemView.setBackgroundColor(ResourcesCompat.getColor(context.getResources(),R.color.cardColor,null));
                        holder.imageView.setVisibility(View.INVISIBLE);
                        selected.remove(holder.getAdapterPosition()+"");
                        if(selected.size()==0)
                            ((FriendsActivity)activity).showInviteBtn(false);
                    }
                    else {
                        holder.itemView.setBackgroundColor(ResourcesCompat.getColor(context.getResources(),R.color.selectedColor,null));
                        holder.imageView.setVisibility(View.VISIBLE);
                        selected.add(holder.getAdapterPosition()+"");
                    }
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                holder.itemView.setBackgroundColor(ResourcesCompat.getColor(context.getResources(),R.color.selectedColor,null));
                holder.imageView.setVisibility(View.VISIBLE);
                ((FriendsActivity)activity).showInviteBtn(true);
                selected.add(holder.getAdapterPosition()+"");
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private View itemView;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            imageView = itemView.findViewById(R.id.selected);
        }

    }
}
