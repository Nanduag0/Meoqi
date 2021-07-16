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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.meoqi.Adaptors.SupportingArtistsAdaptor;
import com.example.meoqi.MainActivity;
import com.example.meoqi.Models.ArtistData;
import com.example.meoqi.Models.EventArtist;
import com.example.meoqi.Models.EventData;
import com.example.meoqi.Models.Image;
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;
import com.example.meoqi.Utils.MeoqiBackendApi;
import com.google.android.gms.common.api.Api;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EventPage extends AppCompatActivity {

    TextView moreInfo,promoTV,mainNameTv,mainUsernameTv,monthView,dateView,monthView1,dateView1;
    ImageView eventMainBg;
    ImageView mainArtistPic;
    BottomNavigationView bottomNavigationView;
    MeoqiBackendApi meoqiBackendApi;
    CardView progressCard;
    String[] months = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    String id;
    private static final String TAG = "EventPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);
        moreInfo = findViewById(R.id.view_more_tv);
        promoTV = findViewById(R.id.tv2);
        mainNameTv = findViewById(R.id.tv1);
        mainUsernameTv = findViewById(R.id.username1);
        mainArtistPic = findViewById(R.id.pic);
        eventMainBg = findViewById(R.id.event_photo2);
        progressCard = findViewById(R.id.progress_card);
        monthView = findViewById(R.id.text_month);
        dateView = findViewById(R.id.text_date);
        monthView1 = findViewById(R.id.text_month1);
        dateView1 = findViewById(R.id.text_date1);

        id = getIntent().getStringExtra("ID");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");



        RecyclerView recyclerView = findViewById(R.id.rv1);
        ArrayList<ArtistData> list =new ArrayList<>();
        SupportingArtistsAdaptor adaptor = new SupportingArtistsAdaptor(this,list);
        progressCard.setVisibility(View.VISIBLE);

        meoqiBackendApi = ApiProvider.getInstance().provide();
        meoqiBackendApi.getEventbyId(id).enqueue(new Callback<EventData>() {
            @Override
            public void onResponse(Call<EventData> call, Response<EventData> response) {
                Log.d(TAG, "onResponse: RES : "+response.body());
                if(response.body()!=null){
                    promoTV.setText(response.body().getPromotion());

                    String time = null;
                    try {
                        time = simpleDateFormat.format(response.body().getStart_date());
                    } catch (Exception e) {
                        Log.e(TAG, "onBindViewHolder: "+e.getMessage());
                    }
                    String[] tt = time.split("/");
                    monthView.setText(months[Integer.parseInt(tt[1])-1]);
                    dateView.setText(tt[0]);
                    monthView1.setText(months[Integer.parseInt(tt[1])-1]);
                    dateView1.setText(tt[0]);

                    Glide.with(getApplicationContext()).load(ApiProvider.BASE_URL+response.body().getImages()[0]).into(eventMainBg);
                    ArtistData main = null;
                    list.clear();
                    for(EventArtist eventArtist : response.body().getArtists_performing()){
                        ArtistData artistData = new ArtistData(eventArtist.getName(),eventArtist.getId(),eventArtist.getRole(),eventArtist.getFrom(),eventArtist.getTo(),eventArtist.getImages());
                        if(eventArtist.getRole().equals("Support"))
                            list.add(artistData);
                        else main = artistData;
                    }
                    adaptor.notifyDataSetChanged();
                    if(main!=null) {
                        mainNameTv.setText(main.getName());
                        mainUsernameTv.setText("@" + main.getName().toLowerCase().replace(" ",""));
                        Glide.with(getApplicationContext()).load(main.getImages().get(0).getUrl()).into(mainArtistPic);
                    }
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

//        list.add(new ArtistData());
//        list.add(new ArtistData());
//        list.add(new ArtistData());
//        list.add(new ArtistData());


        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(adaptor);

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventPage.this, MoreInfoActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
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
                        Intent intent = new Intent(EventPage.this, HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;
                    case R.id.event :{
                        Intent intent = new Intent(EventPage.this, EventList.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.chat : {
                        Intent intent = new Intent(EventPage.this, ChatsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.date : {
                        Intent intent = new Intent(EventPage.this, DateActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                }
                return false;
            }
        });
    }
}