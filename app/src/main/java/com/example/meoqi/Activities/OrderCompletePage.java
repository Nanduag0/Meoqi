package com.example.meoqi.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.meoqi.DrinksPage;
import com.example.meoqi.MainActivity;
import com.example.meoqi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OrderCompletePage extends AppCompatActivity {

    RelativeLayout drinks,tickets,gifts;
    RelativeLayout food;
    BottomNavigationView bottomNavigationView;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete_page);

        drinks = findViewById(R.id.drinks_lay);
        food = findViewById(R.id.food_lay);
        tickets = findViewById(R.id.tickets);
        gifts = findViewById(R.id.gift_layout);

        id = getIntent().getStringExtra("ID");

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderCompletePage.this, FoodMenuActivity.class);
                intent.putExtra("title","Drinks");
                startActivity(intent);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderCompletePage.this, FoodMenuActivity.class);
                intent.putExtra("title","Food");
                startActivity(intent);
            }
        });
        tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderCompletePage.this, TicketsActivity.class);
                startActivity(intent);
            }
        });

        gifts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderCompletePage.this, FoodMenuActivity.class);
                intent.putExtra("title","Goodie");
                intent.putExtra("ID",id);
                startActivity(intent);
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
                        Intent intent = new Intent(OrderCompletePage.this, HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;
                    case R.id.event :{
                        Intent intent = new Intent(OrderCompletePage.this, EventList.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.chat : {
                        Intent intent = new Intent(OrderCompletePage.this, ChatsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.date : {
                        Intent intent = new Intent(OrderCompletePage.this, DateActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                }
                return false;
            }
        });
    }
}