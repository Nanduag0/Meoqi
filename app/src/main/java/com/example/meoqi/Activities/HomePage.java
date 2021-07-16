package com.example.meoqi.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.meoqi.MainActivity;
import com.example.meoqi.Models.Ticket;
import com.example.meoqi.Models.User;
import com.example.meoqi.Models.UserRes;
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;
import com.example.meoqi.Utils.MeoqiBackendApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {

    RelativeLayout acc,friends,redeem,tickets;
    BottomNavigationView bottomNavigationView;
    MeoqiBackendApi meoqiBackendApi;
    SharedPreferences sharedPreferences;
    String userID;
    CardView progressCard;
    TextView nameView,usernamView;
    private static final String TAG = "HomePage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        acc = findViewById(R.id.account);
        tickets = findViewById(R.id.tickets);
        redeem = findViewById(R.id.redeem);
        friends = findViewById(R.id.friend_list);
        nameView = findViewById(R.id.name);
        usernamView = findViewById(R.id.tv2);

        progressCard = findViewById(R.id.progress_card);

        sharedPreferences = getSharedPreferences(getString(R.string.Preference_key_file_name_1110), Context.MODE_PRIVATE);
        userID = sharedPreferences.getString("user_id",null);
        Log.d(TAG, "onCreate: USER_ID : "+userID);

        progressCard.setVisibility(View.VISIBLE);
        meoqiBackendApi = ApiProvider.getInstance().provide();
        meoqiBackendApi.getProfile(userID).enqueue(new Callback<UserRes>() {
            @Override
            public void onResponse(Call<UserRes> call, Response<UserRes> response) {
                Log.d(TAG, "onResponse: RES : "+response.body());
                if(response.body()!=null)
                {
                    nameView.setText(response.body().getUser().getFirst_name());
                    usernamView.setText("@"+response.body().getUser().getUsername());
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
                        Intent intent = new Intent(HomePage.this, HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;
                    case R.id.event :{
                        Intent intent = new Intent(HomePage.this, EventList.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.chat : {
                        Intent intent = new Intent(HomePage.this, ChatsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.date : {
                        Intent intent = new Intent(HomePage.this, DateActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                }
                return false;
            }
        });

        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, ProfilePage.class);
                startActivity(intent);
            }
        });
        tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, TicketsActivity.class);
                startActivity(intent);
            }
        });
        redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, RedeemPage.class);
                startActivity(intent);
            }
        });
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, FriendsActivity.class);
                startActivity(intent);
            }
        });
    }
}