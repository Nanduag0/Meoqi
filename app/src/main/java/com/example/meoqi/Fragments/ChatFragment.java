package com.example.meoqi.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.meoqi.Activities.ConvoActivity;
import com.example.meoqi.Adaptors.ChatAdapter;
import com.example.meoqi.Models.Chat;
import com.example.meoqi.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;


public class ChatFragment extends Fragment {

    public static final String ARG_OBJECT = "param1";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "ChatFragment";

    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private ArrayList<Chat> list;

    public ChatFragment() {
        // Required empty public constructor
    }

    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
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
            mParam1 = getArguments().getInt(ARG_PARAM1)+"";
            mParam2 = getArguments().getInt(ARG_PARAM2)+"";
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ChatFragment CREATED......................");
        list = new ArrayList<>();
        list.add(new Chat());list.add(new Chat());list.add(new Chat());list.add(new Chat());list.add(new Chat());list.add(new Chat());list.add(new Chat());list.add(new Chat());

        recyclerView = view.findViewById(R.id.rv);
        chatAdapter = new ChatAdapter(getContext(),list,this);
        recyclerView.setAdapter(chatAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        chatAdapter.notifyDataSetChanged();
    }
    public void openActivity(){
        Intent intent = new Intent(getContext(), ConvoActivity.class);
        startActivity(intent);
    }
}