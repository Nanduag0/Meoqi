package com.example.meoqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.meoqi.Activities.BottomSheetActivity;
import com.example.meoqi.Activities.EventList;
import com.example.meoqi.Activities.EventPage;
import com.example.meoqi.Activities.FoodMenuActivity;
import com.example.meoqi.Activities.HomePage;
import com.example.meoqi.Activities.MoreInfoActivity;
import com.example.meoqi.Activities.OrderCompletePage;
import com.example.meoqi.Activities.ProfilePage;
import com.example.meoqi.Activities.RedeemPage;
import com.example.meoqi.Activities.bottomSheet2;
import com.example.meoqi.LoginSignup.LoginActivity;
import com.example.meoqi.Utils.EventListActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, com.example.meoqi.Activities.LoginActivity.class));
        finish();

    }



//    void fun()
//    {
//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run(){
//                //Call next screen
//                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
//                // Attach all the elements those you want to animate in design
//                Pair[]pairs=new Pair[2];pairs[0]=new Pair<View, String>(image,"logo_image");pairs[1]=new Pair<View, String>(logo,"logo_text");
//                //wrap the call in API level 21 or higher
//                if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.LOLLIPOP)
//                {
//                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
//                    startActivity(intent,options.toBundle());
//                }
//            }
//        },SPLASH_SCREEN);
//    }

    public void rewardCheckout(View view) {
        Intent intent = new Intent(MainActivity.this,RewardCheckoutActivity.class);
        startActivity(intent);
    }

    public void openArtistsPage(View view) {
        Intent intent = new Intent(MainActivity.this,ArtistPageActivity.class);
        startActivity(intent);
    }

    public void openProfilePage(View view) {
        Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
        startActivity(intent);
    }

    public void openEventPage(View view) {
        Intent intent = new Intent(MainActivity.this,EventActivity.class);
        startActivity(intent);
    }

    public void openBitesPage(View view) {
        Intent intent = new Intent(MainActivity.this,BitesPage.class);
        startActivity(intent);
    }

    public void openDrinksPage(View view) {
        Intent intent = new Intent(MainActivity.this,DrinksPage.class);
        startActivity(intent);
    }

    public void openGoodiesPage(View view) {
        Intent intent = new Intent(MainActivity.this,GoodiesPage.class);
        startActivity(intent);
    }

    public void openloginPage() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void openEventsListPage(View view) {
        Intent intent = new Intent(MainActivity.this, EventPage.class);
        startActivity(intent);
    }

    public void openHomePage(View view) {
        Intent intent = new Intent(MainActivity.this, HomePage.class);
        startActivity(intent);
    }

    public void openRedeemPage(View view) {
        Intent intent = new Intent(MainActivity.this, RedeemPage.class);
        startActivity(intent);
    }
    public void openEventListPage(View view) {
        Intent intent = new Intent(MainActivity.this, EventList.class);
        startActivity(intent);
    }

    public void openSuccessPage(View view) {
        Intent intent = new Intent(MainActivity.this, OrderCompletePage.class);
        startActivity(intent);
    }

    public void openMoreInfoPage(View view) {
        Intent intent = new Intent(MainActivity.this, MoreInfoActivity.class);
        startActivity(intent);
    }
    public void openFoodPage(View view) {
        Intent intent = new Intent(MainActivity.this, FoodMenuActivity.class);
        startActivity(intent);
    }

    public void openInvitePage(View view) {
        Intent intent = new Intent(MainActivity.this, BottomSheetActivity.class);
        startActivity(intent);
    }

    public void openEarlyPage(View view) {
        Intent intent = new Intent(MainActivity.this, bottomSheet2.class);
        startActivity(intent);
    }

    public void openProfileNewPage(View view) {
        Intent intent = new Intent(MainActivity.this, ProfilePage.class);
        startActivity(intent);
    }

}