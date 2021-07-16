package com.example.meoqi.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;


import com.example.meoqi.LoginSignup.CreateProfileActivity;
import com.example.meoqi.LoginSignup.LoginActivity;
import com.example.meoqi.R;
import com.example.meoqi.Utils.EventListActivity;


public class SplashScreenActivity extends AppCompatActivity {

    int SPLASH_SCREEN = 1000;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        image=findViewById(R.id.logo);

        new Handler(Looper.myLooper()).postDelayed(new Runnable(){
            @Override
            public void run(){

                if(! checkForLogIn())
                    openMainActivity();
                else {
                    //Call next screen

                    openLoginPage();
                /*Intent intent=new Intent(SplashScreenActivity.this,.class);

                 //Attach all the elements those you want to animate in design
                //Pair[] pairs =new Pair[1];
                Pair pair = new Pair<View, String>(image,"logo_image");
                //pairs[1]=new Pair<View, String>(logo,"logo_text");
                //wrap the call in API level 21 or higher

                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(SplashScreenActivity.this,pair);
                    startActivity(intent,options.toBundle());*/
                    finish();

                }
            }
        },SPLASH_SCREEN);





    }

    boolean checkForLogIn()
    {
        SharedPreferences user_name_sh = getSharedPreferences("user_name_sh",MODE_PRIVATE) ;
        String userName  = user_name_sh.getString("user_name","");


        if(userName.equals("")){
            return true;
        }
        else
            return false;
    }

    private void openLoginPage() {
        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private void openMainActivity(){

        //Intent intent = new Intent(SplashScreenActivity.this, EventListActivity.class);
        Intent intent = new Intent(SplashScreenActivity.this, EventsActivityNew.class);
        startActivity(intent);
        finish();
    }
}