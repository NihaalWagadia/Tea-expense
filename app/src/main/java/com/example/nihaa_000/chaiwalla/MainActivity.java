package com.example.nihaa_000.chaiwalla;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

import static com.example.nihaa_000.chaiwalla.Master.selectedItems;

public class MainActivity extends AppCompatActivity {
    public static String date;
    public static String sqldate;

    CalendarView mCalendarview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mCalendarview = (CalendarView) findViewById(R.id.calendarView);
        mCalendarview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                date = (month + 1) + "/" + dayOfMonth + "/" + year;
                sqldate = year + "-" + month + "-" + dayOfMonth + " 00:00:00:000";
                //   Intent intent = new Intent(MainActivity.this, Inputandoutput.class);
                Intent intent = new Intent(MainActivity.this, Inputandoutput.class);
                intent.putExtra("date", date);
                intent.putStringArrayListExtra("checkBoxValue", selectedItems);
                Master.itemsFromCalendar = selectedItems;
                startActivity(intent);


                //    Intent i = new Intent(this, Inputandoutput.class);
//                i.putStringArrayListExtra("checkBoxValue", selectedItems);
//                Master.itemsFromCalendar = selectedItems;
                //    startActivity(i);

            }
        });
    }
}
