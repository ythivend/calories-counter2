package com.example.caloriescounter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class breakfastListFragment extends Fragment {



    public breakfastListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_breakfast_list, container, false);
        /*Button button = view.findViewById(R.id.breakfast_fab);

        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_breakfastListFragment_to_listFragment);
        */return view;
    }
}