package com.example.caloriescounter;

import android.content.ClipData;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class listFragment extends Fragment {

    public listFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static listFragment newInstance() {
        listFragment fragment = new listFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        CollectionReference item = FirebaseFirestore.getInstance().collection("Item");

        ListView listView = view.findViewById(R.id.itemListView);
            /*UserAccount tom = new UserAccount("Tom","admin");
            UserAccount jerry = new UserAccount("Jerry","user");
            UserAccount donald = new UserAccount("Donald","guest", false);

            UserAccount[] users = new UserAccount[]{tom,jerry, donald};
*/

        // android.R.layout.simple_list_item_1 is a constant predefined layout of Android.
        // used to create a ListView with simple ListItem (Only one TextView).

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1 , (List<String>) item);


        listView.setAdapter(arrayAdapter);
        // Inflate the layout for this fragment
        return view; //inflater.inflate(R.layout.fragment_list, container, false);
    }
}