package com.example.meoqi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meoqi.Models.SignUpData;
import com.example.meoqi.Models.UsernameCheck;
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;
import com.example.meoqi.Utils.MeoqiBackendApi;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

public class SetUsernameAndPass extends AppCompatActivity {

    private EditText usernameTv,passTv;
    private MeoqiBackendApi meoqiBackendApi;
    private TextView btnContinue;
    private static final String TAG = "SetUsernameAndPass";
    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;
    private CardView progressCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_username_and_pass);
        usernameTv = findViewById(R.id.username);
        passTv = findViewById(R.id.pass);
        btnContinue = findViewById(R.id.continue_btn);
        progressCard = findViewById(R.id.progress_card);
        progressCard.setVisibility(View.GONE);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        meoqiBackendApi = ApiProvider.getInstance().provide();
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid())
                    checkAndProceed(usernameTv.getText().toString(),passTv.getText().toString());
            }
        });

    }
    private boolean isValid(){
        if(usernameTv.getText().length()==0) {
            usernameTv.setError("Field should not be empty");
            return false;
        }
        if(passTv.getText().length()==0) {
            passTv.setError("Field should not be empty");
            return false;
        }
        return true;
    }
    private void checkAndProceed(String username,String pass){
        progressCard.setVisibility(View.VISIBLE);
        meoqiBackendApi.checkUsername(username).enqueue(new Callback<UsernameCheck>() {
            @Override
            public void onResponse(Call<UsernameCheck> call, Response<UsernameCheck> response) {
                Log.d(TAG, "onResponse: RES : "+response.body());
                if(response.body()!=null){
                    UsernameCheck check = response.body();
                    boolean unique = false;
                    unique = check.isUnique();

                    if(unique){
                        signUp(username,pass);
                    }
                    else {
                        usernameTv.setError("Username must be unique");
                        progressCard.setVisibility(View.GONE);
                    }
                }
                else {
                    Log.d(TAG, "onResponse: RES NULL");
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                    progressCard.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<UsernameCheck> call, Throwable t) {
                Log.d(TAG, "onFailure: ERROR : "+t.getMessage());
                progressCard.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void signUp(String username,String pass){
        //SignUpData signUpData = new SignUpData(user.getDisplayName(),"",username,pass,pass);
        meoqiBackendApi.createProfile(username,user.getDisplayName(),"",pass,pass).enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                Log.d(TAG, "onResponse: RES : "+response.body());
                if(response.body()!=null){
                    Intent intent = new Intent(SetUsernameAndPass.this,LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else{
                    Log.d(TAG, "onResponse: RES NULL");
                    progressCard.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.d(TAG, "onFailure: ERROR : "+t.getMessage());
                progressCard.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}