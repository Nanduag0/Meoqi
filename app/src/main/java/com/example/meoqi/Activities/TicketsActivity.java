package com.example.meoqi.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.meoqi.Adaptors.TicketsAdapter;
import com.example.meoqi.Models.ArtistData;
import com.example.meoqi.Models.EventArtist;
import com.example.meoqi.Models.EventData;
import com.example.meoqi.Models.Ticket;
import com.example.meoqi.Models.User;
import com.example.meoqi.Models.UserRes;
import com.example.meoqi.Models.UserTicket;
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;
import com.example.meoqi.Utils.MeoqiBackendApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TicketsActivity extends AppCompatActivity {

    RecyclerView rv;
    TicketsAdapter ticketsAdapter;
    ArrayList<UserTicket> arrayList1;
    ArrayList<EventData> eventData;

    BottomNavigationView bottomNavigationView;
    MeoqiBackendApi meoqiBackendApi;
    SharedPreferences sharedPreferences;
    String userID;

    CardView progressCard;

   // MutableLiveData<String> mutableLiveData;

    private static final String TAG = "TicketsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
        meoqiBackendApi = ApiProvider.getInstance().provide();

        //mutableLiveData = new MutableLiveData<>();

        sharedPreferences = getSharedPreferences(getString(R.string.Preference_key_file_name_1110), Context.MODE_PRIVATE);
        userID = sharedPreferences.getString("user_id",null);
        arrayList1 = new ArrayList<>();

        rv = findViewById(R.id.rv);
        ticketsAdapter = new TicketsAdapter(this,arrayList1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);
        rv.hasFixedSize();
        rv.setAdapter(ticketsAdapter);

        progressCard = findViewById(R.id.progress_card);
        progressCard.setVisibility(View.VISIBLE);


        meoqiBackendApi.getProfile(userID).enqueue(new Callback<UserRes>() {
            @Override
            public void onResponse(Call<UserRes> call, Response<UserRes> response) {
                Log.d(TAG, "onResponse: RES : "+response.body());
                if(response.body()!=null)
                {
                    arrayList1.addAll(response.body().getUser().getTickets());
                    ticketsAdapter.notifyDataSetChanged();
                    progressCard.setVisibility(View.GONE);
                }
                else{
                    Log.d(TAG, "onResponse: RES : NULL ");
                    progressCard.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<UserRes> call, Throwable t) {
                Log.d(TAG, "onFailure: ERROR "+t.getMessage());
                progressCard.setVisibility(View.GONE);
            }
        });



        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu :{
                        Intent intent = new Intent(TicketsActivity.this, HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;
                    case R.id.event :{
                        Intent intent = new Intent(TicketsActivity.this, EventList.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.chat : {
                        Intent intent = new Intent(TicketsActivity.this, ChatsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.date : {
                        Intent intent = new Intent(TicketsActivity.this, DateActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                }
                return false;
            }
        });
    }
}