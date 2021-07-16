package com.example.meoqi.LoginSignup;
import com.example.meoqi.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView back;
    Button signUpBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        back= findViewById(R.id.signup_back_button);
        back.setOnClickListener(this);

        signUpBtn = findViewById(R.id.signup_next_button);
        signUpBtn.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.signup_back_button:
                finish();
            case R.id.signup_next_button:
                Toast.makeText(this,"Signed Up",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
//                startActivity(intent);
                finish();
        }
    }
}