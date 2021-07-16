package com.example.meoqi.Adaptors;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.meoqi.Activities.EventList;
import com.example.meoqi.Models.EventData;
import com.example.meoqi.Models.Ticket;
import com.example.meoqi.Models.UserTicket;
import com.example.meoqi.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.ViewHolder> {


    Context context;
    List<UserTicket> list;
    ArrayList<EventData> eventList;
    public TicketsAdapter(Context context, List<UserTicket> list) {
        this.context = context;
        this.list = list;
    }

    public void setEventList(ArrayList<EventData> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket,parent,false);
        TicketsAdapter.ViewHolder holder = new TicketsAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        holder.title.setText(list.get(position).getType().getName());
        holder.location.setText(list.get(position).getEvent().getAddress().getCity()+" , "+list.get(position).getEvent().getAddress().getCountry());
        holder.date.setText(simpleDateFormat.format(list.get(position).getEvent().getStart_date()));
        holder.foodCount.setText(list.get(position).getType().getFood());
        holder.drinkCount.setText(list.get(position).getType().getDrinks());
        holder.giftCount.setText(list.get(position).getType().getGoodies());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private View itemView;
        private TextView title,date,location,foodCount,drinkCount,giftCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            title = itemView.findViewById(R.id.ticket_title);
            date = itemView.findViewById(R.id.date);
            location = itemView.findViewById(R.id.location);
            foodCount = itemView.findViewById(R.id.food_count);
            drinkCount = itemView.findViewById(R.id.drinks_count);
            giftCount = itemView.findViewById(R.id.gift_count);
        }

    }
}
