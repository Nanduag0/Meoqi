package com.example.meoqi.Adaptors;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.meoqi.Activities.MoreInfoActivity;
import com.example.meoqi.Models.Drink;
import com.example.meoqi.Models.Image;
import com.example.meoqi.Models.Ticket;
import com.example.meoqi.Models.TicketType;
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class TicketTypeAdapter extends RecyclerView.Adapter<TicketTypeAdapter.ViewHolder> {

    Context context;
    List<TicketType> list;
    Activity activity;
    static double countPrice;
    private static final String TAG = "TicketTypeAdapter";

    public TicketTypeAdapter(Context context, List<TicketType> list,Activity activity) {
        this.context = context;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TicketTypeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        countPrice = 0;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket_type, parent, false);
        TicketTypeAdapter.ViewHolder holder = new TicketTypeAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TicketTypeAdapter.ViewHolder holder, int position) {
        TicketType ticketType = list.get(position);
        Log.d(TAG, "onBindViewHolder: "+ticketType);
        holder.price.setText(ticketType.getCurrency()+" "+ticketType.getPrice());
        holder.title.setText(ticketType.getTicket().getName());
        holder.food.setText(ticketType.getTicket().getFood());
        holder.drink.setText(ticketType.getTicket().getDrinks());
        holder.gift.setText(ticketType.getTicket().getGoodies());

        holder.incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ctr = Integer.parseInt(holder.count.getText()+"")+1;
                holder.count.setText(String.valueOf(ctr));
                countPrice += list.get(position).getPrice();
                ((MoreInfoActivity)activity).updatePrice(countPrice);
                ((MoreInfoActivity)activity).updateEachType(list.get(position).getTicket().get_id(),ctr);
            }
        });
        holder.decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ctr = Math.max(0,Integer.parseInt(holder.count.getText()+"")-1);
                holder.count.setText(String.valueOf(ctr));
                countPrice -= list.get(position).getPrice();
                ((MoreInfoActivity)activity).updatePrice(Math.max(0,countPrice));
                ((MoreInfoActivity)activity).updateEachType(list.get(position).getTicket().get_id(),ctr);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title,price,food,drink,gift,count;
        private ImageView incr,decr;
        private View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            title = itemView.findViewById(R.id.t11);
            price = itemView.findViewById(R.id.tt4);
            food = itemView.findViewById(R.id.tt1);
            drink = itemView.findViewById(R.id.tt3);
            gift = itemView.findViewById(R.id.tt0);
            count = itemView.findViewById(R.id.u1);
            incr = itemView.findViewById(R.id.t12);
            decr = itemView.findViewById(R.id.dec);
        }

    }
}
