package com.example.meoqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.meoqi.Adaptors.RewardAdaptor;
import com.example.meoqi.Models.RewardData;

import java.util.ArrayList;
import java.util.List;

public class BitesPage extends AppCompatActivity implements RewardAdaptor.onRewardItemClickListener{

    private static final int NUM_COL = 2;
    List<RewardData> rewardList;
    String left = "Left";
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bites_page);

        rewardList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview_bites_page);
        initRewardList();

        initRecyclerView();


    }
    void initRewardList()
    {

        RewardData rewardData;


        String url = "https://natashaskitchen.com/wp-content/uploads/2019/04/Best-Burger-5.jpg";
        rewardData = new RewardData(url,"Burger","20",left);
        rewardList.add(rewardData);

        url="https://i.pinimg.com/236x/ce/50/da/ce50da50a5d13c1ad64b41397e4392e8.jpg";
        rewardData = new RewardData(url,"Fish","2",left);
        rewardList.add(rewardData);


        url="https://www.corriecooks.com/wp-content/uploads/2018/08/Instant-Pot-French-Fries.jpg";
        rewardData = new RewardData(url,"French Fries","12",left);
        rewardList.add(rewardData);

        /*url="https://i.pinimg.com/236x/ce/50/da/ce50da50a5d13c1ad64b41397e4392e8.jpg";
        rewardData = new RewardData(url,"French Fries","2",left);
        rewardList.add(rewardData);*/

        url="https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pizza_with_mushrooms_and_cheese.jpg/300px-Pizza_with_mushrooms_and_cheese.jpg";
        rewardData = new RewardData(url,"Pizza","10",left);
        rewardList.add(rewardData);

        url = "https://natashaskitchen.com/wp-content/uploads/2019/04/Best-Burger-5.jpg";
        rewardData = new RewardData(url,"Burger","20",left);
        rewardList.add(rewardData);

         url="https://i.pinimg.com/236x/ce/50/da/ce50da50a5d13c1ad64b41397e4392e8.jpg";
        rewardData = new RewardData(url,"Fish","2",left);
        rewardList.add(rewardData);


    }

    void initRecyclerView()
    {
        RewardAdaptor rewardAdaptor = new RewardAdaptor(this,rewardList,this);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(NUM_COL, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(rewardAdaptor);
    }

    @Override
    public void onRewardClick(int position) {
        Intent intent = new Intent(BitesPage.this,RewardCheckoutActivity.class);
        intent.putExtra("item_name",rewardList.get(position).getReward_name());
        intent.putExtra("item_count",rewardList.get(position).getReward_count());
        intent.putExtra("item_description","Description Demo Data");
        intent.putExtra("item_image_url",rewardList.get(position).getReward_image_url());

        startActivity(intent);

    }
}