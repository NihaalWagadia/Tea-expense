package com.example.nihaa_000.chaiwalla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ChaiAdapter extends ArrayAdapter<TPrice> {
    public ChaiAdapter(Context context, ArrayList<TPrice> tPrice) {
        super(context, 0, tPrice);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TPrice tPrice = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.forselected, parent, false);
        }
        // Lookup view for data population
        TextView tea = (TextView) convertView.findViewById(R.id.textViewItem);
        EditText half = (EditText) convertView.findViewById(R.id.fullPrice);
        EditText full = (EditText) convertView.findViewById(R.id.halfPrice);
        // Populate the data into the template view using the data object
        tea.setText(tPrice.getName());
        half.setText(Integer.toString(tPrice.getHprice()));
        full.setText(Integer.toString(tPrice.getFprice()));

//        full.setText(tPrice.getFprice());
        // Return the completed view to render on screen
        return convertView;
    }
}