package com.example.meoqi.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.example.meoqi.BitesPage;
import com.example.meoqi.DrinksPage;
import com.example.meoqi.GoodiesPage;
import com.example.meoqi.R;

public class FragmentIcon2 extends Fragment implements View.OnClickListener {

    ImageView ticket;
    ReadMoreTextView description_tv;

    ImageView drinks_iv;
    ImageView bites_iv;
    ImageView goodies_iv;
    //Fragment2Listener listener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String description = getArguments().getString("description");
        View view = inflater.inflate(R.layout.fragment_icon2,container,false);
        ticket = view.findViewById(R.id.ticket_icon);

        description_tv = view.findViewById(R.id.description);
        description_tv.setText(description);

        goodies_iv=view.findViewById(R.id.reward_icon2);
        bites_iv=view.findViewById(R.id.bite_icon);
        drinks_iv=view.findViewById(R.id.drinks_icon);

        goodies_iv.setOnClickListener(this);
        bites_iv.setOnClickListener(this);
        drinks_iv.setOnClickListener(this);

//        ticket.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onTicketIconClick(true);
//            }
//        });
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.reward_icon2:
                intent = new Intent(getActivity(), GoodiesPage.class);
                startActivity(intent);
                break;
            case R.id.bite_icon:
                intent = new Intent(getActivity(), BitesPage.class);
                startActivity(intent);
                break;
            case R.id.drinks_icon:
                intent = new Intent(getActivity(), DrinksPage.class);
                startActivity(intent);
                break;
        }
    }

//    public interface Fragment2Listener{
//        void onTicketIconClick(boolean result);
//    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        if(context instanceof Fragment2Listener){
//            listener = (Fragment2Listener) context;
//        }
//        else{
//            throw new RuntimeException(context.toString()
//                    + "must implement Fragment1Listener");
//        }
//
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        listener=null;
//    }
}
