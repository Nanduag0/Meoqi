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

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.meoqi.Adaptors.ArtistPerformingAdaptor;
import com.example.meoqi.Adaptors.DrinkMenuAdaptor;
import com.example.meoqi.Adaptors.FoodMenuAdaptor;
import com.example.meoqi.Adaptors.GoodieMenuAdaptor;
import com.example.meoqi.Models.ArtistData;
import com.example.meoqi.Models.Drink;
import com.example.meoqi.Models.EventArtist;
import com.example.meoqi.Models.EventData;
import com.example.meoqi.Models.Food;
import com.example.meoqi.Models.Goodie;
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;
import com.example.meoqi.Utils.MeoqiBackendApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FoodMenuActivity extends AppCompatActivity {

    ArrayList<Food> foods;
    ArrayList<Drink> drinks;
    ArrayList<Goodie> goodies;
    RecyclerView recyclerView;
    TextView textView;
    BottomNavigationView bottomNavigationView;
    FoodMenuAdaptor foodMenuAdaptor;
    DrinkMenuAdaptor drinkMenuAdaptor;
    GoodieMenuAdaptor goodieMenuAdaptor;
    MeoqiBackendApi meoqiBackendApi;
    String id;
    CardView progressCard;

    private static final String TAG = "FoodMenuActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        progressCard = findViewById(R.id.progress_card);

        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        String title = intent.getStringExtra("title");
        textView =findViewById(R.id.t1);
        textView.setText("Complementary\n"+title+" Menu");

        recyclerView = findViewById(R.id.rv2);

        foods = new ArrayList<>();
        drinks = new ArrayList<>();
        goodies = new ArrayList<>();
        foodMenuAdaptor = new FoodMenuAdaptor(this,foods);
        drinkMenuAdaptor = new DrinkMenuAdaptor(this,drinks);
        goodieMenuAdaptor = new GoodieMenuAdaptor(this,goodies);

        initRecyclerView(title);



        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.event);

        meoqiBackendApi = ApiProvider.getInstance().provide();
        meoqiBackendApi.getEventbyId(id).enqueue(new Callback<EventData>() {
            @Override
            public void onResponse(Call<EventData> call, Response<EventData> response) {
                Log.d(TAG, "onResponse: RES : "+response.body());
                if(response.body()!=null){
                    EventData eventData = response.body();
                    for(int i=0;i<eventData.getFoods().length;i++)
                    {
                        foods.add(eventData.getFoods()[i].getFood());
                    }
                    for(int i = 0;i<eventData.getDrinks().length;i++)
                    {
                        drinks.add(eventData.getDrinks()[i].getDrink());
                    }
                    for(int i = 0;i<eventData.getGoodies().length;i++)
                    {
                        goodies.add(eventData.getGoodies()[i].getGoodie());
                    }
                    foodMenuAdaptor.notifyDataSetChanged();
                    drinkMenuAdaptor.notifyDataSetChanged();
                    goodieMenuAdaptor.notifyDataSetChanged();
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

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu :{
                        Intent intent = new Intent(FoodMenuActivity.this, HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;
                    case R.id.event :{
                        Intent intent = new Intent(FoodMenuActivity.this, EventList.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.chat : {
                        Intent intent = new Intent(FoodMenuActivity.this, ChatsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.date : {
                        Intent intent = new Intent(FoodMenuActivity.this, DateActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                }
                return false;
            }
        });
    }

    void initRecyclerView(String title)
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        if(title!=null && title.compareTo("Food")==0)
        {
            recyclerView.setAdapter(foodMenuAdaptor);
            foodMenuAdaptor.notifyDataSetChanged();
        }
        else if(title!=null && title.compareTo("Drinks")==0){
            recyclerView.setAdapter(drinkMenuAdaptor);
            drinkMenuAdaptor.notifyDataSetChanged();
        }
        else {
            recyclerView.setAdapter(goodieMenuAdaptor);
            goodieMenuAdaptor.notifyDataSetChanged();
        }
    }
}