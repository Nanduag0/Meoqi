package com.example.meoqi.LoginSignup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.meoqi.Pages.EventsActivityNew;
import com.example.meoqi.Pages.SplashScreenActivity;
import com.example.meoqi.R;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CreateProfileActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);



        SharedPreferences user_name_sh = getSharedPreferences("user_name_sh", MODE_PRIVATE);

        String userName  = user_name_sh.getString("user_name","");

        if(userName.equals("")){
            showPromptForInviteCode();
        }


        SharedPreferences.Editor user_name_sh_edit = user_name_sh.edit();
        user_name_sh_edit.putString("user_name", "LoginUser");
        user_name_sh_edit.apply();

        btn=findViewById(R.id.but1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateProfileActivity.this, EventsActivityNew.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void showPromptForInviteCode()
    {
        LayoutInflater inflater = LayoutInflater.from(this);
        View prompt = inflater.inflate(R.layout.dialog_invite_code, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(prompt);
        final AlertDialog dialog1 = builder.create();
        Button btn_ok = prompt.findViewById(R.id.ok_btn);
        TextView inviteCode = prompt.findViewById(R.id.invite_code);
        RadioButton rb_yes = prompt.findViewById(R.id.yes_btn);
        RadioButton rb_no = prompt.findViewById(R.id.no_btn);


        rb_yes.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                inviteCode.setVisibility(View.VISIBLE);
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bool = rb_yes.isChecked();
                if(bool){

                    if(inviteCode.getText().toString().isEmpty()){
                        inviteCode.setError("Enter Invite Code");

                    }
                    else{
                        Toast.makeText(CreateProfileActivity.this,"Entered Code: "+inviteCode.getText().toString(),Toast.LENGTH_SHORT).show();
                        dialog1.dismiss();
                    }
                }
                else
                {
                    dialog1.dismiss();
                }
            }
        });
        dialog1.setCancelable(false);
        dialog1.show();
    }
}