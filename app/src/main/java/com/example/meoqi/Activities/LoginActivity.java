package com.example.meoqi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meoqi.Models.LoginRes;
import com.example.meoqi.R;
import com.example.meoqi.Utils.ApiProvider;
import com.example.meoqi.Utils.MeoqiBackendApi;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    TextView login,signup;
    EditText usernameTv,passTv;
    MeoqiBackendApi meoqiBackendApi;
    CardView progressCard;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        login = findViewById(R.id.login_btn);
        signup = findViewById(R.id.sign_up_btn);
        usernameTv = findViewById(R.id.username);
        passTv = findViewById(R.id.pass);

        sharedPreferences = getSharedPreferences(getString(R.string.Preference_key_file_name_1110), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        progressCard = findViewById(R.id.progress_card);
        progressCard.setVisibility(View.GONE);

        meoqiBackendApi = ApiProvider.getInstance().provide();

        if(sharedPreferences.getString("user_id",null)!=null)
        {
            Intent intent = new Intent(this,EventList.class);
            startActivity(intent);
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid()){
                    progressCard.setVisibility(View.VISIBLE);
                    meoqiBackendApi.login(usernameTv.getText().toString().trim(),passTv.getText().toString().trim()).enqueue(new Callback<LoginRes>() {
                        @Override
                        public void onResponse(Call<LoginRes> call, Response<LoginRes> response) {
                            Log.d(TAG, "onResponse: RES : "+response.body());
                            if(response.body()!=null){
                                Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
                                progressCard.setVisibility(View.GONE);
                                editor.putString("user_id",response.body().getUser().get_id());
                                editor.apply();
                                Intent intent = new Intent(LoginActivity.this , EventList.class);
                                startActivity(intent);
                            }else {
                                Log.d(TAG, "onResponse: RES NULL");
                                progressCard.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginRes> call, Throwable t) {
                            Log.d(TAG, "onResponse: RES ERROR "+t.getMessage());
                            progressCard.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
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
}