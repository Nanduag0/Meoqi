package com.example.meoqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.meoqi.Adaptors.TopArtistFanAdaptor;
import com.example.meoqi.Models.TopArtistData;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView closeButton;
    RecyclerView recyclerView;
    List<TopArtistData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        closeButton = findViewById(R.id.close_button);
        closeButton.setOnClickListener(this);

        list = new ArrayList<>();
        initTopArtists();
        initRecyclerview();


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_button:
                finish();

        }
    }

    void initTopArtists() {
        TopArtistData data;

        String photo_url = "https://slcknecdnems05.cdnsrv.jio.com/c.saavncdn.com/artists/Jubin_Nautiyal_002_20180507091834_500x500.jpg";
        data = new TopArtistData("Jubin Nautiyal", photo_url);
        list.add(data);


        photo_url = "https://upload.wikimedia.org/wikipedia/commons/1/13/A.R.Rahman_at_57th_FF_Awards.jpg";
        data = new TopArtistData("AR Rahman", photo_url);
        list.add(data);


        photo_url = "https://s.abcnews.com/images/US/taylor-swift-gty-jef-190528_hpMain_16x9_992.jpg";
        data = new TopArtistData("Taylor Shift", photo_url);
        list.add(data);

        photo_url = "https://iscale.iheart.com/v3/url/aHR0cDovL2ltYWdlLmloZWFydC5jb20vaW1hZ2VzL292ZXJyaWRlLzMwMDgwODA5LmpwZw==?surrogate=1cOXl179JY-syhxYSCX6Q1a_Mcu6UO8d-F4oJzpZf1hcUbJr4aImxNEBEU_rwAxaTaKR-LFOtNk5cXmxdyoHMKMVBs9KO-UrQtNlG5m47ggH7RUJpxB-rTeCPQ_mz4n47LD_4xnBVOVV3MwoXE0LId2xcfI_95E98aOB7qJcEtK614HxwRAAmIHUBBF4JOTpxdTzfSXnRLM3";
        data = new TopArtistData("Marshmello", photo_url);
        list.add(data);

        photo_url = "https://iscale.iheart.com/v3/url/aHR0cDovL2ltYWdlLmloZWFydC5jb20vaW1hZ2VzL292ZXJyaWRlLzMwMDgwODA5LmpwZw==?surrogate=1cOXl179JY-syhxYSCX6Q1a_Mcu6UO8d-F4oJzpZf1hcUbJr4aImxNEBEU_rwAxaTaKR-LFOtNk5cXmxdyoHMKMVBs9KO-UrQtNlG5m47ggH7RUJpxB-rTeCPQ_mz4n47LD_4xnBVOVV3MwoXE0LId2xcfI_95E98aOB7qJcEtK614HxwRAAmIHUBBF4JOTpxdTzfSXnRLM3";
        data = new TopArtistData("Marshmello", photo_url);
        list.add(data);


    }

    void initRecyclerview(){

        recyclerView = findViewById(R.id.top_recyclerview);

        TopArtistFanAdaptor adaptor = new TopArtistFanAdaptor(this,list);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(adaptor);


    }
}