package com.example.caloriescounter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ItemFragment extends Fragment {

    private Spinner sp1;
    private String nomItem;
    private TextView mNameTextView;

    public ItemFragment() {
        // Required empty public constructor
    }

    public static ItemFragment newInstance(String name) {
        Bundle bundle = new Bundle();
        bundle.putString("nomItem", name);
        //bundle.putInt("age", age);

        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            nomItem = bundle.getString("nomItem");
            //age = bundle.getInt("age");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);

        //fetching the spinner id
        sp1 = view.findViewById(R.id.spinner);

        //put desired string items in the spinner
        String[] val_spinner = {"g", "mg"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, val_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adapter);

        readBundle(getArguments());
        mNameTextView = (TextView) view.findViewById(R.id.weightText);
        mNameTextView.setText(String.format("%s", nomItem));

        return view;
    }
}