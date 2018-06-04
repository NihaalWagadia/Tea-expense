package com.example.nihaa_000.chaiwalla;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.example.nihaa_000.chaiwalla.DatabaseHelper.TABLE_NAME_EXPENSE;
import static com.example.nihaa_000.chaiwalla.DatabaseHelper.TABLE_NAME_SOLD;

public class ExpenseList extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper mydb;
    public static ArrayList<String> checkedexpense;
    public ArrayList<ExpensePrice> ex=new ArrayList<>();
//    public Iterator<ExpensePrice> iterator = ex.iterator();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_list);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Button btn = findViewById(R.id.okexpense);
        btn.setOnClickListener((View.OnClickListener) this);

        mydb = new DatabaseHelper(this);

        ex.add(new ExpensePrice("Gas",0));
        ex.add(new ExpensePrice("Electricity",0));
        ex.add(new ExpensePrice("Water",0));
        ex.add(new ExpensePrice("Cups",0));
        ex.add(new ExpensePrice("Labor",0));
        ex.add(new ExpensePrice("Milk",0));


        EAdapter adapter = new EAdapter(this,ex);

        listView = findViewById(R.id.expenseselected);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
         Iterator<ExpensePrice> iterator = ex.iterator();
            DatabaseHelper helper = new DatabaseHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues vals = new ContentValues();
        //    List<String> value = ex.get()
            int it = 0;

        for(int i = 0; i < ex.size();i++) {
            int expPrice = Integer.parseInt(((EditText) listView.getChildAt(i).findViewById(R.id.Amount)).getText().toString());
//            cv.put(COL1,mydb.getTeaID(s));
//            cv.put(COL2, s);
//            cv.put(CO2, ((EditText) listView.getChildAt(it).findViewById(R.id.fullQuantity)).getText().toString());
//            cv.put(CO3, ((EditText) listView.getChildAt(it).findViewById(R.id.halfQuantity)).getText().toString());
//            db.execSQL("insert into " + TABLE_NAME_SOLD + "( TEAIDSOLD, TEANAME, SOLDDATE, CSF, CSH) VALUES ( " + mydb.getTeaID(s) + ", '" + s + "', '" +MainActivity.sqldate+"', "+ ((EditText) listView.getChildAt(it).findViewById(R.id.fullQuantity)).getText().toString() + ", " + ((EditText) listView.getChildAt(it).findViewById(R.id.halfQuantity)).getText().toString() + ")");
              if(expPrice>0)
                  db.execSQL("insert into " + TABLE_NAME_EXPENSE + "( EXPNAME, EXPDATE, EXPPRICE) VALUES ( '" + ex.get(i).name + "', '" + MainActivity.sqldate + "', "+ expPrice + ")");
//            it++;
        }
            db.close();
            startActivity(new Intent(ExpenseList.this, Inputandoutput.class));
        }
    }

