package com.example.meoqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.bumptech.glide.Glide;
import com.example.meoqi.Adaptors.TopArtistFanAdaptor;
import com.example.meoqi.Models.TopArtistData;

import java.util.ArrayList;
import java.util.List;

public class ArtistProfile extends AppCompatActivity implements View.OnClickListener {

    ImageView closeButton;
    String artist_name;
    String artist_photo_url;
    String artist_about_details;
    TextView artist_name_textview;
    ReadMoreTextView about;
    ImageView artist_image;

    RecyclerView recyclerView;
    List<TopArtistData> list;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);
        closeButton = findViewById(R.id.close_button);
        closeButton.setOnClickListener(this);

        Intent intent =getIntent();
        artist_name=intent.getStringExtra("artistName");
        artist_photo_url=intent.getStringExtra("artistPhotoURL");
        artist_about_details=intent.getStringExtra("artistAbout");

        artist_name_textview = findViewById(R.id.artist_name_detail);
        artist_name_textview.setText(artist_name);

        about=findViewById(R.id.about);
        about.setText(artist_about_details);

        artist_image=findViewById(R.id.artist_photo_big);

        Glide.with(this)
                .asBitmap()
                .load(artist_photo_url)
                .into(artist_image);

        list = new ArrayList<>();
        initTopFans();
        initRecyclerview();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_button:
                finish();

        }
    }
    void initTopFans() {
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