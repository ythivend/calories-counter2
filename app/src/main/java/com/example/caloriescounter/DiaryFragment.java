package com.example.caloriescounter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class DiaryFragment extends Fragment {

    private EditText inputName, inputAge, inputW, inputGW;
    private Button saveBtn;

    public static final String SHARED_PREFS = "sharedPrefs";
    private String text1, text2, text3, text4;

    public DiaryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);

        inputName = (EditText) view.findViewById(R.id.name_textInput);
        inputAge = (EditText) view.findViewById(R.id.age_textInput);
        inputW = (EditText) view.findViewById(R.id.weight_textInput);
        inputGW = (EditText) view.findViewById(R.id.gWeight_textInput);
        saveBtn = view.findViewById(R.id.save_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });

        //loadData();
        //updateViews();

        return view;
    }

    public void SaveData()
    {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("textName", inputName.getText().toString());
        editor.putString("textAge", inputAge.getText().toString());
        editor.putString("textW", inputW.getText().toString());
        editor.putString("textGW", inputGW.getText().toString());

        editor.apply();
    }

    public void loadData()
    {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text1 = sharedPreferences.getString("textName", "");
        text2 = sharedPreferences.getString("textAge", "");
        text3 = sharedPreferences.getString("textW", "");
        text4 = sharedPreferences.getString("textGW", "");
    }

    public void updateViews()
    {
        inputName.setText(text1);
        inputAge.setText(text2);
        inputW.setText(text3);
        inputGW.setText(text4);
    }

}