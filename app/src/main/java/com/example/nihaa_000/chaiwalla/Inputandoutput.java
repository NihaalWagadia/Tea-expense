package com.example.nihaa_000.chaiwalla;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.nihaa_000.chaiwalla.Master.itemsFromMinus;
import static com.example.nihaa_000.chaiwalla.Master.itemsFromPlus;
import static com.example.nihaa_000.chaiwalla.Master.selectedItems;

public class Inputandoutput extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputandoutput);

        TextView textView = findViewById(R.id.textView);
        textView.setText(MainActivity.date);

        ListView listView = (ListView) findViewById(R.id.checkable_list_trans);
        TextView textView1 = (TextView) findViewById(R.id.OverallValue);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener((View.OnClickListener) this);

        Button btnd = findViewById(R.id.buttontomain);
        btnd.setOnClickListener((View.OnClickListener) this);

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);

        DatabaseHelper mydb = new DatabaseHelper(this);
        SQLiteDatabase db = mydb.getReadableDatabase();

        Cursor incomeCursor = db.rawQuery("SELECT TEA_SOLD_TABLE.TEANAME, TEA_SOLD_TABLE.CSF, " +
                "TEA_SOLD_TABLE.CSH, TEA_PRICE_TABLE.POF, TEA_PRICE_TABLE.POH FROM TEA_SOLD_TABLE " +
                "INNER JOIN TEA_PRICE_TABLE ON TEA_SOLD_TABLE.TEANAME=TEA_PRICE_TABLE.TEANAME WHERE TEA_SOLD_TABLE.SOLDDATE='" + MainActivity.sqldate + "';", null);
        incomeCursor.moveToFirst();
        ArrayList<TeaTransaction> teaTransactions = new ArrayList<>();
        int grandTotal = 0;
        int incomeTotal = 0, expenseTotal = 0;

        while (!incomeCursor.isAfterLast()) {
            int priceOfHalf = incomeCursor.getInt(1) * incomeCursor.getInt(3);
            int priceOfFull = incomeCursor.getInt(2) * incomeCursor.getInt(4);
            int totalPrice = priceOfFull + priceOfHalf;
            String teaName = incomeCursor.getString(0);
            teaTransactions.add(new TeaTransaction(teaName, totalPrice));
            incomeCursor.moveToNext();
            incomeTotal += totalPrice;
        }

        Cursor expenseCursor = db.rawQuery("SELECT EXPNAME, EXPPRICE FROM TEA_EXPENSE_TABLE WHERE EXPDATE='" + MainActivity.sqldate + "';", null);
        expenseCursor.moveToFirst();
        while(!expenseCursor.isAfterLast()){
            int expPrice  = expenseCursor.getInt(1);
            String expName = expenseCursor.getString(0);
            teaTransactions.add(new TeaTransaction(expName,expPrice));
            expenseCursor.moveToNext();
            expenseTotal += expPrice;
        }

        incomeCursor.close();
        expenseCursor.close();
        db.close();
        TranscationPageAdapter adapter = new TranscationPageAdapter(this, teaTransactions);
        listView.setAdapter(adapter);

        grandTotal = incomeTotal - expenseTotal;
        textView1.setText("" + grandTotal);
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.button) {
            //   startActivity(new Intent(Inputandoutput.this, InputTea.class));
            Intent i = new Intent(this, InputTea.class);
            i.putStringArrayListExtra("checkBoxValue", itemsFromPlus);
            Master.itemsFromPlus = selectedItems;
            startActivity(i);
        } else if (view.getId() == R.id.button2) {

            startActivity(new Intent(Inputandoutput.this, ExpenseList.class));
//            Intent i = new Intent(this, ExpenseList.class);
//            i.putStringArrayListExtra("checkBoxValue", itemsFromMinus);
//            Master.itemsFromMinus = selectedItems;
//            startActivity(i);

        } else if (view.getId() == R.id.buttontomain) {
            startActivity(new Intent(Inputandoutput.this, MainActivity.class));

        }


    }
}
