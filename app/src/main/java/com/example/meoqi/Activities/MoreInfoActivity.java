package com.example.meoqi.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.meoqi.Adaptors.ArtistPerformingAdaptor;
import com.example.meoqi.Adaptors.RewardAdaptor;
import com.example.meoqi.Adaptors.TicketTypeAdapter;
import com.example.meoqi.Models.ArtistData;
import com.example.meoqi.Models.EventArtist;
import com.example.meoqi.Models.EventData;
import com.example.meoqi.Models.EventDrink;
import com.example.meoqi.Models.EventFood;
import com.example.meoqi.Models.TicketRes;
import com.example.meoqi.Models.TicketType;
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;
import com.example.meoqi.Utils.MeoqiBackendApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoreInfoActivity extends AppCompatActivity {

    TextView terms,drinks,foods,gifts,buy,desc;
    ArrayList<ArtistData> list;
    ArrayList<TicketType> ticketTypes;
    final int NUM_COL = 2;
    RecyclerView recyclerView;
    BottomNavigationView bottomNavigationView;
    ArtistPerformingAdaptor artistPerformingAdaptor;
    TicketTypeAdapter ticketTypeAdapter;
    MeoqiBackendApi meoqiBackendApi;
    private BottomSheetBehavior bookBottomSheetBehavior;
    private TextView buyTickets;
    String id;
    CardView progressCard;
    RecyclerView ticketTypeRV;
    View bottomSheet;

    SharedPreferences sharedPreferences;
    String userID;

    static double totalPrice = 0;
    static Map<String,Integer> typeIDs = new HashMap<>();

    private static final String TAG = "MoreInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        terms = findViewById(R.id.more);
        drinks = findViewById(R.id.t1);
        foods = findViewById(R.id.t2);
        gifts = findViewById(R.id.t3);
        buy = findViewById(R.id.t4);
        desc = findViewById(R.id.tv2);
        progressCard = findViewById(R.id.progress_card);

        bottomSheet = findViewById(R.id.tt_bottomsheet);
        bookBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        ticketTypeRV = bottomSheet.findViewById(R.id.ticket_type_rv);
        buyTickets = bottomSheet.findViewById(R.id.t4);

        sharedPreferences = getSharedPreferences(getString(R.string.Preference_key_file_name_1110), Context.MODE_PRIVATE);
        userID = sharedPreferences.getString("user_id",null);

        recyclerView = findViewById(R.id.recyclerview_artists);
        id = getIntent().getStringExtra("ID");

        String text="Terms and Conditions";
        SpannableString content = new SpannableString(text);
        content.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        terms.setText(content);

        list = new ArrayList<>();
        ticketTypes = new ArrayList<>();

        ticketTypeAdapter = new TicketTypeAdapter(this,ticketTypes,this);
        ticketTypeRV.setLayoutManager(new LinearLayoutManager(this));
        ticketTypeRV.setAdapter(ticketTypeAdapter);
        ticketTypeAdapter.notifyDataSetChanged();
//        list.add("1");
//        list.add("2");
//        list.add("1");
//        list.add("2");
//        list.add("1");


        initRecyclerView();
        progressCard.setVisibility(View.VISIBLE);
        meoqiBackendApi = ApiProvider.getInstance().provide();
        meoqiBackendApi.getEventbyId(id).enqueue(new Callback<EventData>() {
            @Override
            public void onResponse(Call<EventData> call, Response<EventData> response) {
                Log.d(TAG, "onResponse: RES : "+response.body());
                if(response.body()!=null){
                    desc.setText(response.body().getDescription());
                    list.clear();
                    ticketTypes.addAll(response.body().getTicketTypes());
                    for(EventArtist eventArtist : response.body().getArtists_performing()){
                        ArtistData artistData = new ArtistData(eventArtist.getName(),eventArtist.getId(),eventArtist.getRole(),eventArtist.getFrom(),eventArtist.getTo(),eventArtist.getImages());
                        if(eventArtist.getRole().equals("Support"))
                            list.add(artistData);
                    }
                    Log.d(TAG, "onResponse: type size : "+ticketTypes.size());
                    artistPerformingAdaptor.notifyDataSetChanged();
                    ticketTypeAdapter.notifyDataSetChanged();
                    ticketTypeAdapter.notifyDataSetChanged();
                }
                else {
                    Log.d(TAG, "onResponse: NULL ERROR");
                }
                progressCard.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<EventData> call, Throwable t) {
                Log.d(TAG, "onResponse: ERROR : "+t.getMessage());
                progressCard.setVisibility(View.GONE);
            }
        });

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInfoActivity.this, FoodMenuActivity.class);
                intent.putExtra("title","Drinks");
                intent.putExtra("ID",id);
                startActivity(intent);
            }
        });

        foods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInfoActivity.this, FoodMenuActivity.class);
                intent.putExtra("title","Food");
                intent.putExtra("ID",id);
                startActivity(intent);
            }
        });

        gifts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInfoActivity.this, FoodMenuActivity.class);
                intent.putExtra("title","Goodie");
                intent.putExtra("ID",id);
                startActivity(intent);
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        buyTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo buy tickets
                if(totalPrice > 0){
                    buyTicket();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please add some tickets", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bookBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState == BottomSheetBehavior.STATE_COLLAPSED)
                    bookBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.event);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu :{
                        Intent intent = new Intent(MoreInfoActivity.this, HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;
                    case R.id.event :{
                        Intent intent = new Intent(MoreInfoActivity.this, EventList.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.chat : {
                        Intent intent = new Intent(MoreInfoActivity.this, ChatsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.date : {
                        Intent intent = new Intent(MoreInfoActivity.this, DateActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                }
                return false;
            }
        });

    }
    public void updatePrice(double price)
    {
        Log.d(TAG, "updatePrice: PRICE : "+price);
        totalPrice = price;
        buyTickets.setText("Buy Tickets "+ticketTypes.get(0).getCurrency() +" "+price);
    }
    public void updateEachType(String id,int count){
        typeIDs.put(id,count);
    }
    void buyTicket(){
        Log.d(TAG, "buyTicket: "+typeIDs.entrySet());
        meoqiBackendApi.bookTicket(userID,totalPrice+"",ticketTypes.get(0).getCurrency(),typeIDs,id,"12234sazd").enqueue(new Callback<TicketRes>() {
            @Override
            public void onResponse(Call<TicketRes> call, Response<TicketRes> response) {
                Log.d(TAG, "onResponse: RES : "+response.body());
                if(response.body()!=null)
                {
                    Log.d(TAG, "onResponse: SUCCESS!.............................");
                    Intent intent = new Intent(MoreInfoActivity.this, OrderCompletePage.class);
                    intent.putExtra("ID",id);
                    startActivity(intent);
                }
                else Log.d(TAG, "onResponse: RES NULL ");
            }

            @Override
            public void onFailure(Call<TicketRes> call, Throwable t) {
                Log.d(TAG, "onFailure: ERROR : "+t.getMessage());
            }
        });
    }

    void initRecyclerView()
    {
        artistPerformingAdaptor = new ArtistPerformingAdaptor(this,list);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(NUM_COL, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(artistPerformingAdaptor);
    }
}