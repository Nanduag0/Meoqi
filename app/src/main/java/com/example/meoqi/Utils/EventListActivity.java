package com.example.meoqi.Utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.meoqi.Adaptors.EventsAdaptor;
import com.example.meoqi.EventActivity;
import com.example.meoqi.Models.EventData;
import com.example.meoqi.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class EventListActivity extends AppCompatActivity implements EventsAdaptor.onEventItemClickListener{


    TextView textView; //will delete it later
    RecyclerView recyclerView;
    List<EventData> events;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_layout);

        //textView=findViewById(R.id.textview);

        //recyclerView=findViewById(R.id.recyclerview_events_page);
        progressBar = findViewById(R.id.progress_circular1);
        progressBar.setVisibility(View.VISIBLE);

        events = new ArrayList<>();
        //load();

        retrofitApiCall();


    }

    void load()
    {
        new CountDownTimer(4000, 1000) {

            @Override
            public void onTick(long l) {
                System.out.println("E");
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {

                progressBar.setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        EventsAdaptor Adaptor = new EventsAdaptor(this,events,this);
        recyclerView.setAdapter(Adaptor);

    }




    void retrofitApiCall(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://meoqi-backend.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MeoqiBackendApi meoqiBackendApi = retrofit.create(MeoqiBackendApi.class);
        Call<List<EventData>> call = meoqiBackendApi.getEvent();

        call.enqueue(new Callback<List<EventData>>() {
            @Override
            public void onResponse(Call<List<EventData>> call, Response<List<EventData>> response) {
                if(! response.isSuccessful())
                {
//                    textView.setText("Code "+response.code());
                    String error = "Code: "+response.message();
                    Log.e("API Error",error);
                    return;
                }
                events = response.body();
                setContentView(R.layout.activity_event_list);
                recyclerView=findViewById(R.id.recyclerview_events_page);
                progressBar = findViewById(R.id.progress_bar_event_list);
                initRecyclerView();


//                String description ="";
//                for(EventData data : events)
//                {
//
//                    description+= data.getDescription()+"\n";
//
//                }
//                textView.setText(description);

            }

            @Override
            public void onFailure(Call<List<EventData>> call, Throwable t) {
                //textView.setText("Error "+t.getMessage());
            }
        });

    }


    @Override
    public void onEventClick(int position) {
        Intent intent = new Intent(EventListActivity.this, EventActivity.class);

        intent.putExtra("event_name",events.get(position).getName());
        intent.putExtra("event_start",events.get(position).getStart_date());
        intent.putExtra("description",events.get(position).getDescription());
        startActivity(intent);
    }
}