package com.example.meoqi.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.meoqi.Models.EventsModel;
import com.example.meoqi.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class EventsViewPagerAdaptor extends PagerAdapter {

    private Context context;
    private ArrayList<EventsModel> list;

    public EventsViewPagerAdaptor(Context context,ArrayList<EventsModel>list) {
        this.context = context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position){

        LayoutInflater inflater = LayoutInflater.from(context);

        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.event_viewpager_layout, collection, false);

        ImageView artist_image = layout.findViewById(R.id.photo_artist);

        Glide.with(context)
                .asBitmap()
                .load(list.get(position).getImage_id())
                .into(artist_image);

        TextView tv = layout.findViewById(R.id.name_event);
        TextView date = layout.findViewById(R.id.date);
        TextView month = layout.findViewById(R.id.month);
        tv.setText(list.get(position).getEventName());
        month.setText(list.get(position).getMonth());
        //String date = (list.get(position).getDate());
        date.setText(list.get(position).getDate());

        ConstraintLayout bottomSheet;
        BottomSheetBehavior bottomSheetBehavior;
        ImageView arrow;

        bottomSheet = layout.findViewById(R.id.con1);
        arrow=layout.findViewById(R.id.arrow);

        //TextView rem = layout.findViewById(R.id.remove);
        ScrollView scrollView = layout.findViewById(R.id.scrollView);


        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        final int[] curState = {bottomSheetBehavior.getState()};


        //int d = BottomSheetBehavior.

        TextView no_followers= layout.findViewById(R.id.no);
        ImageView no_icon= layout.findViewById(R.id.no_icon);

        ConstraintLayout con1 = layout.findViewById(R.id.const1);
        ConstraintLayout con2 = layout.findViewById(R.id.const2);



        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                curState[0] = bottomSheetBehavior.getState();
                //Toast.makeText(context,"Change"+curState[0],Toast.LENGTH_SHORT).show();
                if(curState[0]==3){

                    con1.setVisibility(View.VISIBLE);
                    con2.setVisibility(View.GONE);

                    arrow.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_keyboard_arrow_down_24));
                }
                else if(curState[0]==2){


                    date.setVisibility(View.INVISIBLE);
                    month.setVisibility(View.INVISIBLE);
                    no_followers.setVisibility(View.VISIBLE);
                    no_icon.setVisibility(View.VISIBLE);
                }
                else if(curState[0]==4){
                    con1.setVisibility(View.GONE);
                    con2.setVisibility(View.VISIBLE);

                    arrow.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_keyboard_arrow_up_24));
                    date.setVisibility(View.VISIBLE);
                    month.setVisibility(View.VISIBLE);
                    no_followers.setVisibility(View.INVISIBLE);
                    no_icon.setVisibility(View.INVISIBLE);

                }

            }



            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                if(BottomSheetBehavior.STATE_EXPANDED==curState[0])
                {

//                    rem.setVisibility(View.INVISIBLE);
//                    scrollView.setVisibility(View.VISIBLE);
                    arrow.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_keyboard_arrow_down_24));

                }
                else if(BottomSheetBehavior.STATE_COLLAPSED==curState[0])
                {
                    arrow.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_keyboard_arrow_up_24));

                }

                /*if(bottomSheetBehavior.getState()==bottomSheetBehavior.STATE_COLLAPSED)
                    rem.setVisibility(View.INVISIBLE);*/
            }
        });





        /*arrow.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(bottomSheetBehavior.getState()==BottomSheetBehavior.STATE_EXPANDED){
                    Toast.makeText(context,"Show",Toast.LENGTH_SHORT).show();
                    bottomSheetBehavior.setPeekHeight(150);
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                    //arrow.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_keyboard_arrow_down_24));
                }

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });*/

        collection.addView(layout);
        return layout;
    }
    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }
}
