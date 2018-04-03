package com.example.alfonso.lab01;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private static List<Form> forms;
    private static final String DATABASE_NAME = "forms_db";

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        final AppDatabase formDatabase = Room.databaseBuilder(view.getContext(), AppDatabase.class,
                DATABASE_NAME).fallbackToDestructiveMigration().build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                forms = formDatabase.formDao().getAll();
            }
        }).start();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lista = (ListView) view.findViewById(R.id.listView_fragment);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Info, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);


    }
}
