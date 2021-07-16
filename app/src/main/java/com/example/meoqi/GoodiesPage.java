package com.example.meoqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.meoqi.Adaptors.RewardAdaptor;
import com.example.meoqi.Models.RewardData;

import java.util.ArrayList;
import java.util.List;

public class GoodiesPage extends AppCompatActivity implements RewardAdaptor.onRewardItemClickListener {

    private static final int NUM_COL = 2;
    List<RewardData> rewardList;
    String left = "Left";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodies_page);

        rewardList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview_goodies_page);
        initRewardList();
        initRecyclerView();

    }

    void initRewardList()
    {

        RewardData rewardData;
        String url;

        url="https://img1.etsystatic.com/000/0/5497622/il_fullxfull.290468409.jpg";
        rewardData = new RewardData(url,"Watch","2",left);
        rewardList.add(rewardData);


        url="https://i.ebayimg.com/images/i/162144029118-0-1/s-l1000.jpg";
        rewardData = new RewardData(url,"T-Bag","12",left);
        rewardList.add(rewardData);

        url="https://www.chatelaine.com/wp-content/uploads/2019/04/white-t-shirt-aritzia.jpg";
        rewardData = new RewardData(url,"T-shirt","2",left);
        rewardList.add(rewardData);

        url="https://i.pinimg.com/736x/86/48/2b/86482b8e95595b2799bbd5fd427fdb7f--school-style-mens-leather.jpg";
        rewardData = new RewardData(url,"Trash Bag","10",left);
        rewardList.add(rewardData);

        url="https://i.pinimg.com/originals/6e/6a/69/6e6a69f20f28c129b01a7f3902a403f8.jpg";
        rewardData = new RewardData(url,"Bag","2",left);
        rewardList.add(rewardData);




    }

    void initRecyclerView()
    {
        RewardAdaptor rewardAdaptor = new RewardAdaptor(this,rewardList,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, NUM_COL,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(rewardAdaptor);
    }

    @Override
    public void onRewardClick(int position) {
        Intent intent = new Intent(GoodiesPage.this,RewardCheckoutActivity.class);
        intent.putExtra("item_name",rewardList.get(position).getReward_name());
        intent.putExtra("item_count",rewardList.get(position).getReward_count());
        intent.putExtra("item_description","Description Demo Data");
        intent.putExtra("item_image_url",rewardList.get(position).getReward_image_url());

        startActivity(intent);

    }
}