package com.example.meoqi.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.meoqi.Adaptors.FriendAdapter;
import com.example.meoqi.Adaptors.TicketsAdapter;
import com.example.meoqi.Models.Chat;
import com.example.meoqi.Models.Ticket;
import com.example.meoqi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity {

    RecyclerView rv;
    FriendAdapter friendAdapter;
    ArrayList<Chat> arrayList1;
    BottomNavigationView bottomNavigationView;
    Button btnInvite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends2);

        btnInvite = findViewById(R.id.invite_btn);

        arrayList1 = new ArrayList<>();
        arrayList1.add(new Chat());
        arrayList1.add(new Chat());
        arrayList1.add(new Chat());
        arrayList1.add(new Chat());
        arrayList1.add(new Chat());arrayList1.add(new Chat());arrayList1.add(new Chat());arrayList1.add(new Chat());

        rv = findViewById(R.id.rv);
        friendAdapter = new FriendAdapter(this,arrayList1,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);
        rv.hasFixedSize();
        rv.setAdapter(friendAdapter);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu :{
                        Intent intent = new Intent(FriendsActivity.this, HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;
                    case R.id.event :{
                        Intent intent = new Intent(FriendsActivity.this, EventList.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.chat : {
                        Intent intent = new Intent(FriendsActivity.this, ChatsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                    case R.id.date : {
                        Intent intent = new Intent(FriendsActivity.this, DateActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }break;

                }
                return false;
            }
        });
    }
    public void showInviteBtn(boolean show)
    {
        if(show)
            btnInvite.setVisibility(View.VISIBLE);
        else btnInvite.setVisibility(View.INVISIBLE);
    }
}