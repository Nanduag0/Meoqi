package com.example.meoqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.meoqi.Adaptors.ArtistAdaptor;
import com.example.meoqi.Models.ArtistData;

import java.util.ArrayList;
import java.util.List;

public class ArtistPageActivity extends AppCompatActivity implements View.OnClickListener, ArtistAdaptor.onArtistClickListener {

    RecyclerView recyclerView;
    List<ArtistData> artists;
    ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_page);

        artists = new ArrayList<>();

        initializeArrayLists();
        recyclerView=findViewById(R.id.recyclerview_artists_page);
        initRecyclerView();

        close=findViewById(R.id.close_button);
        close.setOnClickListener(this);

    }
    void initializeArrayLists()
    {
//        String artist_about;
//
//        String photo_url="https://slcknecdnems05.cdnsrv.jio.com/c.saavncdn.com/artists/Jubin_Nautiyal_002_20180507091834_500x500.jpg";
//        artist_about= "Jubin Nautiyal (born 14 June 1989) is an Indian singer, songwriter, performer, music composer and music director.";
//        ArtistData artistData = new ArtistData("Jubin Nautiyal",photo_url,artist_about);
//        artists.add(artistData);
//
//        photo_url="https://upload.wikimedia.org/wikipedia/commons/1/13/A.R.Rahman_at_57th_FF_Awards.jpg";
//        artist_about="Allahrakha Rahman (pronunciation (help · info); born A. S. Dileep Kumar on 6 January 1967), known professionally as A. R. Rahman, is an Indian composer, singer and music producer who works predominantly in Tamil and Hindi movies.";
//        artistData = new ArtistData("AR Rahman",photo_url,artist_about);
//        artists.add(artistData);
//
//        photo_url="https://s.abcnews.com/images/US/taylor-swift-gty-jef-190528_hpMain_16x9_992.jpg";
//        artist_about="Taylor Alison Swift (born December 13, 1989) is an American singer-songwriter. Her narrative songwriting, which often centers around her personal life, has received widespread media coverage. Born in West Reading, Pennsylvania, Swift relocated to Nashville, Tennessee in 2004 to pursue a career in country music";
//        artistData = new ArtistData("Taylor Shift",photo_url,artist_about);
//        artists.add(artistData);
//
//        artist_about="Marshmello performed at Electric Daisy Carnival 2016 in Las Vegas on June 19. In a gimmick attempted by Marshmello and Dutch DJ Tiësto, the latter who wore the same clothes as the former on stage, took off his helmet presenting himself as Marshmello";
//        photo_url="https://iscale.iheart.com/v3/url/aHR0cDovL2ltYWdlLmloZWFydC5jb20vaW1hZ2VzL292ZXJyaWRlLzMwMDgwODA5LmpwZw==?surrogate=1cOXl179JY-syhxYSCX6Q1a_Mcu6UO8d-F4oJzpZf1hcUbJr4aImxNEBEU_rwAxaTaKR-LFOtNk5cXmxdyoHMKMVBs9KO-UrQtNlG5m47ggH7RUJpxB-rTeCPQ_mz4n47LD_4xnBVOVV3MwoXE0LId2xcfI_95E98aOB7qJcEtK614HxwRAAmIHUBBF4JOTpxdTzfSXnRLM3";
//        artistData = new ArtistData("Marshmello",photo_url,artist_about);
//        artists.add(artistData);

    }
    void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArtistAdaptor Adaptor = new ArtistAdaptor(this,artists,this);
        recyclerView.setAdapter(Adaptor);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.close_button:
                finish();
        }
    }

    @Override
    public void onArtistClick(int position) {

        Intent intent = new Intent(ArtistPageActivity.this,ArtistProfile.class);
//        intent.putExtra("artistName",artists.get(position).getArtist_name());
//        intent.putExtra("artistPhotoURL",artists.get(position).getArtist_photo());
//        intent.putExtra("artistAbout",artists.get(position).getArtist_about());

        startActivity(intent);
    }
}