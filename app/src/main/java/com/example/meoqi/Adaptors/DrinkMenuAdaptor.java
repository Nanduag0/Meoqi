package com.example.meoqi.Adaptors;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.meoqi.Models.Drink;
import com.example.meoqi.Models.Food;
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class DrinkMenuAdaptor extends RecyclerView.Adapter<DrinkMenuAdaptor.ViewHolder> {

    Context context;
    List<Drink> list;

    public DrinkMenuAdaptor(Context context, List<Drink> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DrinkMenuAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_menu_rv, parent, false);
        DrinkMenuAdaptor.ViewHolder holder = new DrinkMenuAdaptor.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkMenuAdaptor.ViewHolder holder, int position) {
        Drink drink = list.get(position);
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

                title.setText(drink.getName());
                desc.setText(drink.getDescription());
                Glide.with(context).load(ApiProvider.BASE_URL+"/"+drink.getImage()).into(imageView);
                ratingBar.setRating(Integer.parseInt(drink.getRating())%5);
                alertDialog.setView(view);
                Dialog dialog = alertDialog.create();
                dialog.show();
                if(dialog.getWindow()!=null)
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        });

        holder.title.setText(drink.getName());
        holder.desc.setText(drink.getDescription());
        Glide.with(context).load(ApiProvider.BASE_URL+"/"+drink.getImage()).into(holder.imageView);
        holder.ratingBar.setRating(Integer.parseInt(drink.getRating())%5);
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