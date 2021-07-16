package com.example.meoqi.Adaptors;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meoqi.Activities.EventList;
import com.example.meoqi.R;
import com.example.meoqi.Models.EventData;
import com.example.meoqi.Utils.ApiProvider;

import java.text.SimpleDateFormat;
import java.util.List;

public class EventListAdaptor2 extends RecyclerView.Adapter<EventListAdaptor2.ViewHolder>{

    Context context;
    List<EventData> list;
    Activity activity;
    private static final String TAG = "EventListAdaptor2";

    public EventListAdaptor2(Context context, List<EventData> list,Activity activity) {
        this.context = context;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public EventListAdaptor2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_list_2,parent,false);
        EventListAdaptor2.ViewHolder holder = new EventListAdaptor2.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventListAdaptor2.ViewHolder holder, int position) {
        EventData eventData = list.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EventList)(activity)).openEventsListPage(eventData.get_id());
            }
        });

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        String timespan = null;
        try {
            timespan = simpleDateFormat.format(eventData.getStart_date())+ " - "+simpleDateFormat.format(eventData.getEnd_date());
        } catch (Exception e) {
            Log.e(TAG, "onBindViewHolder: "+e.getMessage());
        }
        holder.dateView.setText(timespan);
        holder.titleView.setText(eventData.getName());
        holder.locationView.setText(eventData.getAddress().getCity()+" , "+eventData.getAddress().getCountry());
        Glide.with(context).load(ApiProvider.BASE_URL+eventData.getImages()[0]).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        private View itemView;
        private TextView dateView,titleView,locationView;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            dateView = itemView.findViewById(R.id.date);
            titleView = itemView.findViewById(R.id.t2);
            locationView = itemView.findViewById(R.id.tv2);

            imageView = itemView.findViewById(R.id.img1);
        }

    }
}
