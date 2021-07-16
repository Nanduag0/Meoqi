package com.example.meoqi.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meoqi.Adaptors.ChatFragmetsAdapter;
import com.example.meoqi.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainChatFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ViewPager2 viewPager;
    ChatFragmetsAdapter chatFragmetsAdapter;
    private String mParam1;
    private String mParam2;

    public MainChatFragment() {
        // Required empty public constructor
    }

    public static MainChatFragment newInstance(String param1, String param2) {
        MainChatFragment fragment = new MainChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        chatFragmetsAdapter = new ChatFragmetsAdapter(this);

        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(chatFragmetsAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(returnText(position+1))
        ).attach();
    }
    private String returnText(int position)
    {
        switch (position){
            case 1: return "Chats";
            case 2: return "Groups";
            case 3: return "Active Groups";
            default: return position+"";
        }
    }
}