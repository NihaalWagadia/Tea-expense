package com.example.nihaa_000.chaiwalla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class InputTeaAdapter extends ArrayAdapter<CupPrice> {
    public InputTeaAdapter(Context context, ArrayList<CupPrice> tPrice) {
        super(context, 0, tPrice);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CupPrice cPrice = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.inputtealist, parent, false);
        }
        // Lookup view for data population
        TextView tea = (TextView) convertView.findViewById(R.id.textViewItemforinput);
        EditText halfcup = (EditText) convertView.findViewById(R.id.fullQuantity);
        TextView fullcup = (TextView) convertView.findViewById(R.id.halfQuantity);
        // Populate the data into the template view using the data object
        tea.setText(cPrice.getName());
        halfcup.setText(Integer.toString(cPrice.getSolfhalf()));
        fullcup.setText(Integer.toString(cPrice.getSoldfull()));

//        full.setText(tPrice.getFprice());
        // Return the completed view to render on screen
        return convertView;
    }
}