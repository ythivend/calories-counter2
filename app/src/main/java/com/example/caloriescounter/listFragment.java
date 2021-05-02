package com.example.caloriescounter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class listFragment extends Fragment {

    public listFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("Item")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>(){
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            List<String> item = new ArrayList<String>();

                            for (QueryDocumentSnapshot document : task.getResult()){
                                Log.d("TAG", document.getId() + " => " + document.getData());

                                //item.add(document.getData().get("Item").toString());

                            }
                            ListView listView = view.findViewById(R.id.itemListView);
                            ArrayAdapter<String> arrayAdapter
                                    = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1 , item);

                            listView.setAdapter(arrayAdapter);
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
       // ListView listView = view.findViewById(R.id.itemListView);



     /*   listView.setOnItemClickListener((adapterView, view, position, rowId) -> {
            String fruit = arrayAdapter.getItem(position);
            //Snackbar.make(view, "Vous avez choisi " + fruit, Snackbar.LENGTH_LONG).show();
        });*/




        //listView.setAdapter(arrayAdapter);
        // Inflate the layout for this fragment
        return view; //inflater.inflate(R.layout.fragment_list, container, false);
    }
}