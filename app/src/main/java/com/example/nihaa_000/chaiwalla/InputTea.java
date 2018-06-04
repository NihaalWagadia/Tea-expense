package com.example.nihaa_000.chaiwalla;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.nihaa_000.chaiwalla.DatabaseHelper.TABLE_NAME_SOLD;

public class InputTea extends AppCompatActivity implements View.OnClickListener {
    ListView listView;
    DatabaseHelper mydb;
    Button button;
    TextView textView;
    ArrayList<CupPrice> cPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_tea);
        mydb = new DatabaseHelper(this);

        button = findViewById(R.id.ok);
        button.setOnClickListener(this);

        listView = findViewById(R.id.teaselected);

        cPrice = mydb.getCupString(CheckedBoxPassed.checkedItems);
        InputTeaAdapter adapter = new InputTeaAdapter(this, cPrice);

        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        int it = 0;
        for (String s : CheckedBoxPassed.checkedItems) {
//            cv.put(COL1,mydb.getTeaID(s));
//            cv.put(COL2, s);
//            cv.put(CO2, ((EditText) listView.getChildAt(it).findViewById(R.id.fullQuantity)).getText().toString());
//            cv.put(CO3, ((EditText) listView.getChildAt(it).findViewById(R.id.halfQuantity)).getText().toString());
//            db.insert(TABLE_NAME_SOLD, null, cv);
            db.execSQL("insert into " + TABLE_NAME_SOLD + "( TEAIDSOLD, TEANAME, SOLDDATE, CSF, CSH) VALUES ( " + mydb.getTeaID(s) + ", '" + s + "', '" +MainActivity.sqldate+"', "+ ((EditText) listView.getChildAt(it).findViewById(R.id.fullQuantity)).getText().toString() + ", " + ((EditText) listView.getChildAt(it).findViewById(R.id.halfQuantity)).getText().toString() + ")");
            it++;
        }
        db.close();
        startActivity(new Intent(InputTea.this, Inputandoutput.class));
    }
}
