package com.example.meoqi.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.meoqi.Adaptors.EventsViewPagerAdaptor;
import com.example.meoqi.Models.EventsModel;
import com.example.meoqi.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class EventsActivityNew extends AppCompatActivity {

    private ArrayList<EventsModel> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_new);

        arrayList = new ArrayList<>();
        initList();







        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new EventsViewPagerAdaptor(this,arrayList));

    }

    void initList(){

        String url = "https://s.abcnews.com/images/US/taylor-swift-gty-jef-190528_hpMain_16x9_992.jpg";
        arrayList.add(new EventsModel("Event 1 @Taylor","23","JAN",url,R.drawable.artist_photo));

        url="https://slcknecdnems05.cdnsrv.jio.com/c.saavncdn.com/artists/Jubin_Nautiyal_002_20180507091834_500x500.jpg";
        arrayList.add(new EventsModel("Event 2 @Jubin","04","FEB",url,R.drawable.artist_photo));

        url = "https://upload.wikimedia.org/wikipedia/commons/1/13/A.R.Rahman_at_57th_FF_Awards.jpg";
        arrayList.add(new EventsModel("Event 3 @Ar Rahman","19","MAR",url,R.drawable.artist_photo));

    }
}