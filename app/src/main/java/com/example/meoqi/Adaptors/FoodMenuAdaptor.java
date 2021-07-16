package com.example.meoqi.Adaptors;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meoqi.Models.Food;
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;

import java.util.List;

public class FoodMenuAdaptor extends RecyclerView.Adapter<FoodMenuAdaptor.ViewHolder> {

    Context context;
    List<Food> list;

    public FoodMenuAdaptor(Context context, List<Food> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FoodMenuAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_menu_rv, parent, false);
        FoodMenuAdaptor.ViewHolder holder = new FoodMenuAdaptor.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodMenuAdaptor.ViewHolder holder, int position) {
        Food food = list.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                LayoutInflater factory = LayoutInflater.from(context);
                final View view = factory.inflate(R.layout.expanded_food_drinks_layout, null);

                TextView title = view.findViewById(R.id.t1);
                TextView desc = view.findViewById(R.id.tt2);
                RatingBar ratingBar = view.findViewById(R.id.rat);
                ImageView imageView = view.findViewById(R.id.img);

                title.setText(food.getName());
                desc.setText(food.getDescription());
                Glide.with(context).load(ApiProvider.BASE_URL+"/"+food.getImage()).into(imageView);
                ratingBar.setRating(Integer.parseInt(food.getRating())%5);

                alertDialog.setView(view);
                Dialog dialog = alertDialog.create();
                dialog.show();
                if(dialog.getWindow()!=null)
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        });
        holder.title.setText(food.getName());
        holder.desc.setText(food.getDescription());
        Glide.with(context).load(ApiProvider.BASE_URL+"/"+food.getImage()).into(holder.imageView);
        holder.ratingBar.setRating(Integer.parseInt(food.getRating())%5);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private TextView title,desc;
        private RatingBar ratingBar;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            title = itemView.findViewById(R.id.t1);
            desc = itemView.findViewById(R.id.tt2);
            ratingBar = itemView.findViewById(R.id.rat);
            imageView = itemView.findViewById(R.id.i1);
        }

    }
}