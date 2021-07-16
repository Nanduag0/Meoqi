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

public class DrinksPage extends AppCompatActivity  implements RewardAdaptor.onRewardItemClickListener{

    private static final int NUM_COL = 2;
    List<RewardData> rewardList;
    String left = "Left";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_page);

        rewardList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview_drinks_page);

        initRewardList();
        initRecyclerView();

    }

    void initRewardList()
    {

        RewardData rewardData;
        String url;

        url="https://media2.popsugar-assets.com/files/thumbor/crlwZNUGmuM0rgr8FfdJbLc8sB4/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2016/07/26/735/n/1922195/258ba871fa379f6e_179fee32_edit_img_pinterest_post_image_file_42077753_1469474751_Starbucks-Rainbow-PINTEREST.jpg";
        rewardData = new RewardData(url,"Drink 2","2",left);
        rewardList.add(rewardData);


        url="https://i.pinimg.com/originals/57/43/9c/57439c60a11c612153f76eba3535a7bc.jpg";
        rewardData = new RewardData(url,"Drink 3","12",left);
        rewardList.add(rewardData);

        url="https://i.pinimg.com/originals/c0/84/01/c0840124d8b0ee6e40975aa318b29501.jpg";
        rewardData = new RewardData(url,"Drink 4","2",left);
        rewardList.add(rewardData);

        url="https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Classic_bubble_tea.jpg/220px-Classic_bubble_tea.jpg";
        rewardData = new RewardData(url,"Drink 5","10",left);
        rewardList.add(rewardData);

        url="https://media2.popsugar-assets.com/files/thumbor/crlwZNUGmuM0rgr8FfdJbLc8sB4/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2016/07/26/735/n/1922195/258ba871fa379f6e_179fee32_edit_img_pinterest_post_image_file_42077753_1469474751_Starbucks-Rainbow-PINTEREST.jpg";
        rewardData = new RewardData(url,"Drink 2","2",left);
        rewardList.add(rewardData);

        url = "https://i.pinimg.com/originals/57/43/9c/57439c60a11c612153f76eba3535a7bc.jpg";
        rewardData = new RewardData(url,"Drink 6","20",left);
        rewardList.add(rewardData);

        url = "https://www.topinspired.com/wp-content/uploads/2013/11/best-alcoholic-winter-coctail-drinks_04.jpg";
        rewardData = new RewardData(url,"Drink 7","20",left);
        rewardList.add(rewardData);

        url="https://media2.popsugar-assets.com/files/thumbor/crlwZNUGmuM0rgr8FfdJbLc8sB4/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2016/07/26/735/n/1922195/258ba871fa379f6e_179fee32_edit_img_pinterest_post_image_file_42077753_1469474751_Starbucks-Rainbow-PINTEREST.jpg";
        rewardData = new RewardData(url,"Drink 2","2",left);
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
        Intent intent = new Intent(DrinksPage.this,RewardCheckoutActivity.class);
        intent.putExtra("item_name",rewardList.get(position).getReward_name());
        intent.putExtra("item_count",rewardList.get(position).getReward_count());
        intent.putExtra("item_description","Description Demo Data");
        intent.putExtra("item_image_url",rewardList.get(position).getReward_image_url());

        startActivity(intent);

    }
}