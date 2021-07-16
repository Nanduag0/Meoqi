package com.example.meoqi.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.meoqi.R;
import com.example.meoqi.Models.EventData;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventsAdaptor extends RecyclerView.Adapter<EventsAdaptor.ViewHolder>{


    private onEventItemClickListener eventItemClickListener;
    private Context context;
    private List<EventData> eventList;

    public EventsAdaptor(Context context, List<EventData> eventList,onEventItemClickListener eventItemClickListener) {
        this.context = context;
        this.eventList = eventList;
        this.eventItemClickListener = eventItemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_cardview,parent,false);

        EventsAdaptor.ViewHolder holder = new ViewHolder(view,eventItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.eventName.setText(eventList.get(position).getName());
        //String date_time = eventList.get(position).getStart_time() +" - " +eventList.get(position).getEnd_time();
        String date_time = "4 Sep 20:00 - 4 Sep 23:00";
        holder.eventDateTime.setText(date_time);


    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView eventImage;
        TextView eventName;
        TextView eventDateTime;
        TextView bandNames;
        onEventItemClickListener onEventClick;


        public ViewHolder(@NonNull View itemView, onEventItemClickListener onEventItemClickListener) {
            super(itemView);
            eventImage = itemView.findViewById(R.id.event_photo1);
            eventName = itemView.findViewById(R.id.event_name);
            eventDateTime = itemView.findViewById(R.id.date_time_event);
            bandNames = itemView.findViewById(R.id.band_name);
            this.onEventClick = onEventItemClickListener;
            itemView.setOnClickListener(this);



        }

        @Override
        public void onClick(View v) {
            eventItemClickListener.onEventClick(getAdapterPosition());
        }
    }
    public interface onEventItemClickListener{
        void onEventClick(int position);
    }
}
