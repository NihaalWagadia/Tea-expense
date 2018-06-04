package com.example.nihaa_000.chaiwalla;

//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class TypesOfTea extends AppCompatActivity implements View.OnClickListener {
    final ArrayList<String> selectedItems = new ArrayList<>();
    Button button;
    DatabaseHelper mydb;
    ExtraClass extraClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_of_tea);

        mydb = new DatabaseHelper(this);

        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(this);

        //mydb.insertDatatn();

        ListView chl = (ListView) findViewById(R.id.checkable_list);
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


          //String[] tot = {"Masala","M","A","B","C","D","E","F"};
        String[] tot = mydb.getChaiStrin();
        System.out.println(mydb.getChaiStrin());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout,R.id.txt_tea,tot);
      //  extraClass = new ExtraClass (this);
        chl.setAdapter(adapter);
        chl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selecteditem = ((TextView)view).getText().toString();
                if(selectedItems.contains(selecteditem))
                {
                    selectedItems.remove(selecteditem);   //Uncheck item
                }
                else
                    selectedItems.add(selecteditem);
            }
        });



    }

    @Override
    public void onClick(View view) {

        //startActivity(new Intent(TypesOfTea.this,CheckedBoxPassed.class));
        Intent i = new Intent(this, CheckedBoxPassed.class);
        i.putStringArrayListExtra("checkBoxValue", selectedItems);
        Master.selectedItems = selectedItems;
        startActivity(i);
    }
//    public void showSelectedItems(View view){
//        String items ="";
//        for(String item : selectedItems){
//            items+="-"+item+"\n";
//        }
//        Toast.makeText(this,"You have selected \n" +items,Toast.LENGTH_SHORT).show();
//    }



}
