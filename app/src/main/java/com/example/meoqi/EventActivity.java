package com.example.meoqi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.example.meoqi.Fragments.FragmentIcon;
import com.example.meoqi.Fragments.FragmentIcon2;
import com.google.android.material.navigation.NavigationView;

public class EventActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        FragmentIcon.Fragment1Listener,View.OnClickListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ReadMoreTextView description_tv;
    TextView band;
    TextView ev_name;
    Fragment fragment1;
    Fragment fragment2;

    String des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar mToolbar =findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);


        //fragments
        fragment1 =new FragmentIcon();




        fragment2 = new FragmentIcon2();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.v2,fragment1)
                .commit();








        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.open_string, R.string.close_string);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        mToolbar.setNavigationIcon(R.drawable.ic_baseline_dehaze_24);

        Intent intent = getIntent();
        des = intent.getStringExtra("description");
        String name= intent.getStringExtra("event_name");
        String start= intent.getStringExtra("event_start");

        ev_name= findViewById(R.id.eventName);
        //description_tv=findViewById(R.id.description);
        band = findViewById(R.id.start_end);

        ev_name.setText(name+" Presents");
        //description_tv.setText(des);
        band.setText("4 Sep 20:00 - 4 Sep 23:00");

//        drinksIcon = findViewById(R.id.drinks_icon);
//        goodiesIcon = findViewById(R.id.reward_icon2);
//        bitesIcon = findViewById(R.id.bite_icon);

//        drinksIcon.setOnClickListener(this);
//        goodiesIcon.setOnClickListener(this);
//        bitesIcon.setOnClickListener(this);


        //moving
//        ticketIcon=findViewById(R.id.ticket_icon);
//        ticketIcon.setOnClickListener(this);


    }

    /*void move(){

        goodiesIcon.setVisibility(View.INVISIBLE);

        ConstraintLayout constraintLayout;
        constraintLayout = findViewById(R.id.l2);
        //ticketIcon.setVisibility(View.INVISIBLE);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(R.id.ticket_icon,ConstraintSet.RIGHT,R.id.bite_icon,ConstraintSet.LEFT,0);
        constraintSet.connect(R.id.ticket_icon,ConstraintSet.LEFT,R.id.l2,ConstraintSet.LEFT,0);

        constraintSet.connect(R.id.ticket_icon,ConstraintSet.TOP,R.id.l2,ConstraintSet.TOP,0);

        constraintSet.connect(R.id.ticket_icon,ConstraintSet.BOTTOM,R.id.l2,ConstraintSet.BOTTOM,0);
        constraintSet.applyTo(constraintLayout);



    }
*/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Intent intent;

        switch (item.getItemId()){
            case R.id.my_profile:
                intent = new Intent(EventActivity.this,ProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.artist_list:
                intent = new Intent(EventActivity.this,ArtistPageActivity.class);
                startActivity(intent);
                return true;
            case R.id.goodies:
                intent = new Intent(EventActivity.this,GoodiesPage.class);
                startActivity(intent);
                return true;
            case R.id.drinks:
                intent = new Intent(EventActivity.this,DrinksPage.class);
                startActivity(intent);
                return true;
            case R.id.bites:
                intent = new Intent(EventActivity.this,BitesPage.class);
                startActivity(intent);
                return true;


        }
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.drinks_icon:
                //move();
//                intent = new Intent(EventActivity.this,DrinksPage.class);
//                startActivity(intent);
                break;
            case R.id.bite_icon:
                intent = new Intent(EventActivity.this,BitesPage.class);
                startActivity(intent);
                break;
            case R.id.reward_icon2:
                intent = new Intent(EventActivity.this,GoodiesPage.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onTicketIconClick(boolean result) {

        //Toast.makeText(this,"Output"+Boolean.toString(result),Toast.LENGTH_SHORT).show();
        if(result){
            Bundle bundle = new Bundle();
            bundle.putString("description",des);
            fragment2.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.v2,fragment2)
                    .commit();
        }
    }
}