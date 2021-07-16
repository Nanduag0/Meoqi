package com.example.meoqi.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.meoqi.R;

public class FragmentIcon extends Fragment implements View.OnClickListener {

    ImageView tick;
    ImageView ticket;
    Fragment1Listener listener;
    TextView address_tv;
    ImageView address_iv;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_icons,container,false);

        tick = view.findViewById(R.id.tick_icon);
        ticket = view.findViewById(R.id.ticket_icon);
        address_iv = view.findViewById(R.id.pin_logo);
        address_tv = view.findViewById(R.id.address);

        address_tv.setOnClickListener(this);
        address_iv.setOnClickListener(this);


        ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTicketIconClick(true);
            }
        });

        tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tick.setColorFilter(ContextCompat.getColor(getContext(),R.color.colorGreen));
            }
        });



        return view;
    }

    void openGoogleMap(String address){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+address));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        String address  = address_tv.getText().toString();
        switch (v.getId()){

            case R.id.address:
                openGoogleMap(address);
                break;

            case R.id.pin_logo:
                openGoogleMap(address);
                break;
        }
    }

    public interface Fragment1Listener{
        void onTicketIconClick(boolean result);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Fragment1Listener){
            listener = (Fragment1Listener) context;
        }
        else{
            throw new RuntimeException(context.toString()
                    + "must implement Fragment1Listener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
