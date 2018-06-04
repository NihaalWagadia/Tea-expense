package com.example.nihaa_000.chaiwalla;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.nihaa_000.chaiwalla.DatabaseHelper.C1;
import static com.example.nihaa_000.chaiwalla.DatabaseHelper.C2;
import static com.example.nihaa_000.chaiwalla.DatabaseHelper.COL2;
import static com.example.nihaa_000.chaiwalla.DatabaseHelper.TABLE_NAME_PRICE;
import static com.example.nihaa_000.chaiwalla.Master.selectedItems;

public class CheckedBoxPassed extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    ListView listView;
    DatabaseHelper mydb;
    public static ArrayList<String> checkedItems;

    // final ArrayList<String> checkedItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checked_box_passed);

        mydb = new DatabaseHelper(this);

        btn = findViewById(R.id.btnforvalue);
        btn.setOnClickListener(this);

        listView = findViewById(R.id.checkable_list1);

        Bundle bundle = this.getIntent().getExtras();
        checkedItems = bundle.getStringArrayList("checkBoxValue");
        ArrayList<TPrice> tPrice = mydb.getPriceString(checkedItems);
        ChaiAdapter adapter = new ChaiAdapter(this, tPrice);
        listView.setAdapter(adapter);
        Log.d("list", listView.toString());


    }


    @Override
    public void onClick(View view) {

        Intent i = new Intent(this, MainActivity.class);

        DatabaseHelper dbhelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        int it = 0;

        for (String s : checkedItems) {
            ContentValues values = new ContentValues();

            values.put(COL2, s);
            values.put(C1, ((EditText) listView.getChildAt(it).findViewById(R.id.fullPrice)).getText().toString());
            values.put(C2, ((EditText) listView.getChildAt(it).findViewById(R.id.halfPrice)).getText().toString());
            db.insert(TABLE_NAME_PRICE, null, values);
            it++;
        }
        startActivity(i);
    }
}
