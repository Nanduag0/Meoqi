package com.example.meoqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jgabrielfreitas.core.BlurImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class RewardCheckoutActivity extends AppCompatActivity implements View.OnClickListener {

    TextView item_name;
    TextView item_des;
    TextView item_count;
    ImageView item_photo;
    ImageView closeButton;
    ImageView shareMainButton;
    ImageView checkButton;
    ImageView blurBackground;


    ImageView share2;
    ImageView facebook;
    ImageView whatsapp;
    ImageView instagram;


    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_checkout);

        closeButton = findViewById(R.id.close_button);
        closeButton.setOnClickListener(this);

        shareMainButton = findViewById(R.id.share_main_reward);
        shareMainButton.setOnClickListener(this);

        checkButton = findViewById(R.id.check_reward);
        checkButton.setOnClickListener(this);


        Intent intent = getIntent();
        String name = intent.getStringExtra("item_name");
        String url = intent.getStringExtra("item_image_url");
        String count = intent.getStringExtra("item_count");
        String des = intent.getStringExtra("item_description");

        item_name = findViewById(R.id.reward_name);
        item_des = findViewById(R.id.reward_description);
        item_count = findViewById(R.id.left_info);
        item_photo = findViewById(R.id.image_content);
        blurBackground = findViewById(R.id.blur_background);


        item_name.setText(name);
        item_des.setText(des);
        item_count.setText(count + " Left");

        Glide.with(this)
                .asBitmap()
                .load(url)
                .into(item_photo);

        Glide.with(this)
                .asBitmap()
                .load(url)
                .override(100)
                .into(blurBackground);

        constraintLayout = findViewById(R.id.parent_layout);
        share2 = findViewById(R.id.share2);
        share2.setOnClickListener(this);

        facebook = findViewById(R.id.facebook);
        facebook.setOnClickListener(this);

        whatsapp = findViewById(R.id.whatsapp);
        whatsapp.setOnClickListener(this);

        instagram = findViewById(R.id.instagram);
        instagram.setOnClickListener(this);


    }


    void image(String packageName) {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        BitmapDrawable drawable = (BitmapDrawable) item_photo.getDrawable();

        Bitmap bitmap = drawable.getBitmap();
        File file = new File(getExternalCacheDir() + "/" + item_name.getText().toString() + ".png");
        Intent intent = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.putExtra(Intent.EXTRA_TEXT, "Got a reward of " + item_name.getText().toString() + " from " + this.getString(R.string.app_name));
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            if (!packageName.equals(""))
                intent.setPackage(packageName);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (intent != null)
            startActivity(Intent.createChooser(intent, "share"));
    }

    private boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            return packageManager.getApplicationInfo(packageName, 0).enabled;

        } catch (PackageManager.NameNotFoundException e) {

            return false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_button:
                finish();
                break;

            case R.id.check_reward:
                Toast.makeText(this, "Reward Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.share_main_reward:
                ImageView share = findViewById(v.getId());
                share.setVisibility(View.INVISIBLE);
                LinearLayout layout = findViewById(R.id.onClicking_Share_LinearLayout);
                layout.setVisibility(View.VISIBLE);
                break;

            case R.id.share2:
                image("");
                break;

            case R.id.facebook:
                if (isPackageInstalled("com.facebook.katana", getApplicationContext().getPackageManager()))
                    image("com.facebook.katana");
                else
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.facebook.katana")));
                break;

            case R.id.whatsapp:
                if (isPackageInstalled("com.whatsapp", getApplicationContext().getPackageManager()))
                    image("com.whatsapp");
                    //Toast.makeText(this,"Yes",Toast.LENGTH_SHORT).show();}
                else
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.whatsapp")));
                break;

            case R.id.instagram:
                if (isPackageInstalled("com.instagram.android", getApplicationContext().getPackageManager()))
                    image("com.instagram.android");
                    //Toast.makeText(this,"Yes",Toast.LENGTH_SHORT).show();}
                else
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.instagram.android")));
                break;


        }
    }
}