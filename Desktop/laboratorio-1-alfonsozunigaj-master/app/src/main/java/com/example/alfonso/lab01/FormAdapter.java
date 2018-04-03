package com.example.alfonso.lab01;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alfonso on 03-04-2018.
 */

public class FormAdapter extends ArrayAdapter<Form> {

    private Context context;

    public FormAdapter (Context context, List<Form> items) {
        super(context, 0, items);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Form forms = getItem(position);
        View view = convertView;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_list, parent, false);
            //FALTAN COSAS AUN
        }

        Form item = getItem(position);
        if (item!= null) {
            TextView itemView = (TextView) view.findViewById(R.id.title);
            if (itemView != null) {
                itemView.setText("Item: " + item + " in position " + position);
            }
        }

        return view;
    }
}
