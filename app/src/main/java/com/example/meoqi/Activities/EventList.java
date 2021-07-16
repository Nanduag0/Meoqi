package com.example.meoqi.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.meoqi.Adaptors.EventListAdaptor1;
import com.example.meoqi.Adaptors.EventListAdaptor2;
import com.example.meoqi.Models.ArtistData;
import com.example.meoqi.Models.EventArtist;
import com.example.meoqi.R;
import com.example.meoqi.Models.EventData;
import com.example.meoqi.Utils.ApiProvider;
import com.example.meoqi.Utils.MeoqiBackendApi;
import com.google.android.gms.common.api.Api;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class EventList extends AppCompatActivity {

    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    ArrayList<EventData>arrayList1;
    ArrayList<EventData>arrayList2;
    BottomNavigationView bottomNavigationView;
    MeoqiBackendApi meoqiBackendApi;
    CardView progressCard;

    private static final String TAG = "EventList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list2);
        progressCard = findViewById(R.id.progress_card);

        recyclerView1 = findViewById(R.id.rv1);
        recyclerView2 = findViewById(R.id.rv2);

        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();

        meoqiBackendApi = ApiProvider.getInstance().provide();

        EventListAdaptor1 adaptor1 = new EventListAdaptor1(this,arrayList1,this);
        EventListAdaptor2 adaptor2 = new EventListAdaptor2(this,arrayList2,this);
//        arrayList1.add(new EventData());
//        arrayList1.add(new EventData());
//        arrayList1.add(new EventData());
//        arrayList1.add(new EventData());
//
//        arrayList2.add(new EventData());
//        arrayList2.add(new EventData());
//        arrayList2.add(new EventData());
//        arrayList2.add(new EventData());
        progressCard.setVisibility(View.VISIBLE);
        Call<List<EventData>> getAllEvents = meoqiBackendApi.getEvent();
        getAllEvents.enqueue(new Callback<List<EventData>>() {
            @Override
            public void onResponse(Call<List<EventData>> call, Response<List<EventData>> response) {
                Log.d(TAG, "onResponse: RES : "+response.body());
                if(response.body()!=null) {
                    arrayList1.clear();
                    //arrayList1.addAll(response.body());

                    int j = 0;
                    for(EventData eventData : response.body()){
                        arrayList1.add(eventData);
                        arrayList2.add(eventData);
                        j++;
                    }

                    adaptor1.notifyDataSetChanged();
                }
                else {
                    Log.d(TAG, "onResponse: ERROR FETCHING EVENTS");
                }
                progressCard.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<EventData>> call, Throwable t) {
                Log.d(TAG, "onFailure: ERROR : "+t.getMessage());
                progressCard.setVisibility(View.GONE);
            }
        });




        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(gridLayoutManager);
        recyclerView2.hasFixedSize();
        recyclerView2.setAdapter(adaptor2);

        LinearLayoutManager gridLayoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setLayoutManager(gridLayoutManager2);
        recyclerView1.hasFixedSize();
        recyclerView1.setAdapter(adaptor1);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.event);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu :{
                        Intent intent = new Intent(EventList.this, HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;
                    case R.id.event :{
                        Intent intent = new Intent(EventList.this, EventList.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.chat : {
                        Intent intent = new Intent(EventList.this, ChatsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.date : {
                        Intent intent = new Intent(EventList.this, DateActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                }
                return false;
            }
        });
    }

    public void openEventsListPage(String id) {
        Intent intent = new Intent(this, EventPage.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }
}