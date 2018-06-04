package com.example.nihaa_000.chaiwalla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class EAdapter extends ArrayAdapter<ExpensePrice> {
    public EAdapter(Context context, ArrayList<ExpensePrice> ePrice) {
        super(context, 0, ePrice);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ExpensePrice ePrice = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.expenselist, parent, false);
        }
        // Lookup view for data population
        TextView exp = (TextView) convertView.findViewById(R.id.textViewItemforexpense);
        EditText epricer = (EditText) convertView.findViewById(R.id.Amount);

        // Populate the data into the template view using the data object
        exp.setText(ePrice.getName());
        epricer.setText(Integer.toString(ePrice.getPrice()));

//        full.setText(tPrice.getFprice());
        // Return the completed view to render on screen
        return convertView;
    }
}