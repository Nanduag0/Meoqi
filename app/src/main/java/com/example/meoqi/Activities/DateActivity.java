package com.example.meoqi.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.meoqi.Adaptors.DatePagerAdapter;
import com.example.meoqi.Models.Date;
import com.example.meoqi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class DateActivity extends AppCompatActivity {

    private DatePagerAdapter datePagerAdapter;
    private ViewPager2 viewPager2;
    private ArrayList<Date> dates;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        dates = new ArrayList<>();

        dates.add(new Date());dates.add(new Date());dates.add(new Date());dates.add(new Date());dates.add(new Date());dates.add(new Date());dates.add(new Date());dates.add(new Date());

        datePagerAdapter = new DatePagerAdapter();
        datePagerAdapter.setList(dates);
        datePagerAdapter.submitList(dates);
        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(datePagerAdapter);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.date);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu :{
                        Intent intent = new Intent(DateActivity.this, HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;
                    case R.id.event :{
                        Intent intent = new Intent(DateActivity.this, EventList.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.chat : {
                        Intent intent = new Intent(DateActivity.this, ChatsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.date : {
                        Intent intent = new Intent(DateActivity.this, DateActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                }
                return false;
            }
        });

    }
}