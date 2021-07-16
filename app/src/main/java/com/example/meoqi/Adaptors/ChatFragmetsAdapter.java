package com.example.meoqi.Adaptors;

import android.os.Bundle;

import com.example.meoqi.Fragments.ChatFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ChatFragmetsAdapter extends FragmentStateAdapter {
    public ChatFragmetsAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int)
        Fragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(ChatFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
