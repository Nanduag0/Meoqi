package com.example.meoqi.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meoqi.MainActivity;
import com.example.meoqi.Pages.EventsActivityNew;
import com.example.meoqi.Pages.SplashScreenActivity;
import com.example.meoqi.R;
import com.example.meoqi.Utils.EventListActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    TextInputEditText phoneTv;
    //TextInputEditText otpTv;

    Button otpBtn, loginBtn;
    Button callSignUp;

    TextView logoText, sloganText;

    ImageView image;
    ImageView facebook_login_btn;
    //ImageView google_login_btn;

    FirebaseAuth mAuth;
    String codeSent;


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.login_btn); //login button
        //otpBtn = findViewById(R.id.otp_btn); //otp button


        phoneTv = findViewById(R.id.phone_no); //phone no textView
        //otpTv = findViewById(R.id.otp); //otp textView

        logoText = findViewById(R.id.logo_name);  //logo textView
        sloganText = findViewById(R.id.sign_in_text);


        callSignUp = findViewById(R.id.sign_up);
        image = findViewById(R.id.logo_image);


        //currently not in use
        facebook_login_btn = findViewById(R.id.facebook_login); //facebook sign-in button
        //google_login_btn = findViewById(R.id.google_login);
        facebook_login_btn.setOnClickListener(this);
        //google_login_btn.setOnClickListener(this);


        //onClickListeners
        loginBtn.setOnClickListener(this);
        //otpBtn.setOnClickListener(this);

        //Firebase Auth
        mAuth = FirebaseAuth.getInstance();



        /*callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*Intent intent = new Intent(Login.this, SignUp.class);
                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(logoText, "logo_text");
                pairs[2] = new Pair<View, String>(sloganText, "logo_desc");
                pairs[3] = new Pair<View, String>(username, "username_tran");
                pairs[4] = new Pair<View, String>(password, "password_tran");
                pairs[5] = new Pair<View, String>(login_btn, "button_tran");
                pairs[6] = new Pair<View, String>(callSignUp, "login_signup_tran");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                    startActivity(intent, options.toBundle());*//*
                }
            }
        });*/
    }

    private void sendVerificationCode(String phoneNumber) {

        if (phoneNumber.isEmpty()) {
            phoneTv.setError("Phone Number is required");
            phoneTv.requestFocus();
            return;
        }
        if (phoneNumber.length() < 10) {
            phoneTv.setError("Invalid Phone Number");
            phoneTv.requestFocus();
            return;
        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            Log.d(TAG, "verificationCompleted:success");
            signInWithPhoneAuthCredential(phoneAuthCredential);

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Log.d(TAG, "verificationFailed:success" + e);

        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeSent = s;
            //Toast.makeText(LoginActivity.this,codeSent,Toast.LENGTH_SHORT).show();


        }
    };

    private void verifyOTP(String otp_entered) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, otp_entered);

        signInWithPhoneAuthCredential(credential);
    }

    String TAG = "signInWithPhone";

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            Toast.makeText(LoginActivity.this, "Log-In success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, CreateProfileActivity.class);
                            startActivity(intent);
                            finish();


                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(LoginActivity.this, "Wrong OTP", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
                });
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login_btn:
                String entered_phone = "+91 " + phoneTv.getText().toString();
                //Toast.makeText(this,entered_phone,Toast.LENGTH_SHORT).show();
                //String entered_password = password.getText().toString();

                sendVerificationCode(entered_phone);

                /*String otp_entered = otpTv.getText().toString();
                if (otp_entered.isEmpty()) {
                    otpTv.setError("OTP required");
                    otpTv.requestFocus();
                    break;
                }
                if (otp_entered.length() < 6) {
                    otpTv.setError("Invalid OTP");
                    otpTv.requestFocus();
                    break;
                }*/
                //verifyOTP(otp_entered);
                break;

//                if(entered_password.equals("") || entered_username.equals("")){
//                    Toast.makeText(this,"Username and Password can't be empty",Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                if(entered_password.length()<8){
//                    Toast.makeText(this,"Password must contain 8 characters ",Toast.LENGTH_SHORT).show();
//                    return;}
//
//
//

//
//                Intent intent = new Intent(LoginActivity.this, EventListActivity.class);
//                startActivity(intent);
//                finish();
//            case R.id.login_btn:
//                String otp_entered = otpTv.getText().toString();
//                if(otp_entered.isEmpty()){
//                    otpTv.setError("OTP required");
//                    otpTv.requestFocus();
//                    break;
//                }
//                if(otp_entered.length()<6){
//                    otpTv.setError("Invalid OTP");
//                    otpTv.requestFocus();
//                    break;
//                }
//                verifyOTP(otp_entered);
//                break;

            case R.id.facebook_login:
                Toast.makeText(this, "Action Under-Development", Toast.LENGTH_SHORT).show();
                break;

        }

    }

    public void openSignupPage(View view) {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
    }
}