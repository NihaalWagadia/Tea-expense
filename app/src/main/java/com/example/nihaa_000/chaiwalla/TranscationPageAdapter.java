package com.example.nihaa_000.chaiwalla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nihaa_000.chaiwalla.R;
import com.example.nihaa_000.chaiwalla.TPrice;

import java.util.ArrayList;


public class TranscationPageAdapter extends ArrayAdapter<TeaTransaction> {
    public TranscationPageAdapter(Context context, ArrayList<TeaTransaction> tTrans) {
        super(context, 0, tTrans);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TeaTransaction tTrans = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.typeandtrans, parent, false);
        }
        // Lookup view for data population
        TextView teanames = (TextView) convertView.findViewById(R.id.textViewlist);
        TextView trans = (TextView) convertView.findViewById(R.id.trans);

        teanames.setText(tTrans.getName());
        trans.setText(Integer.toString(tTrans.getTrans()));


        return convertView;
    }
}