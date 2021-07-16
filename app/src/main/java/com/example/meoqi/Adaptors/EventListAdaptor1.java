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
import com.example.meoqi.Models.ArtistData;
import com.example.meoqi.Models.EventArtist;
import com.example.meoqi.R;
import com.example.meoqi.Models.EventData;
import com.example.meoqi.Utils.ApiProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EventListAdaptor1 extends RecyclerView.Adapter<EventListAdaptor1.ViewHolder>{

    Context context;
    List<EventData> list;
    Activity activity;
    private static final String TAG = "EventListAdaptor1";

    public EventListAdaptor1(Context context, List<EventData> list,Activity activity) {
        this.context = context;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public EventListAdaptor1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event1_rv,parent,false);
        EventListAdaptor1.ViewHolder holder = new EventListAdaptor1.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventListAdaptor1.ViewHolder holder, int position) {
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
        for(EventArtist eventArtist : eventData.getArtists_performing()){
            if(eventArtist.getRole().equals("Lead")) {
                holder.featureArtistNameView.setText(eventArtist.getName());
                holder.featureArtistUserNameView.setText("@"+eventArtist.getName().toLowerCase().replace(" ",""));
                Glide.with(context).load(eventArtist.getImages().get(0).getUrl()).into(holder.artistImage);
                break;
            }
        }
        Glide.with(context).load(ApiProvider.BASE_URL+eventData.getImages()[0]).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        private View itemView;
        private TextView dateView,titleView,locationView,featureArtistNameView,featureArtistUserNameView;
        private ImageView imageView,artistImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            dateView = itemView.findViewById(R.id.date);
            titleView = itemView.findViewById(R.id.t2);
            locationView = itemView.findViewById(R.id.tv2);
            featureArtistNameView = itemView.findViewById(R.id.tv5);
            featureArtistUserNameView = itemView.findViewById(R.id.artist_id);

            imageView = itemView.findViewById(R.id.i1);
            artistImage = itemView.findViewById(R.id.iv1);
        }

    }
}
