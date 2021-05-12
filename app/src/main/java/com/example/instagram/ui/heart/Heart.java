package com.example.instagram.ui.heart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.instagram.R;
import com.example.instagram.ui.home.HomeViewModel;


public class Heart extends Fragment {
    private HeartViewModel heartViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        heartViewModel =
                    new ViewModelProvider(this).get(HeartViewModel.class);
        View root =  inflater.inflate(R.layout.fragment_heart, container, false);
        final TextView textView = root.findViewById(R.id.text_heart);
        heartViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return  root;
    }
}