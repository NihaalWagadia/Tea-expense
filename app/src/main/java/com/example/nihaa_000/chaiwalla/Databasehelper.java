package com.example.nihaa_000.chaiwalla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by nihaa_000 on 4/9/2018.
 */

class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Tea.db";
    public static final String TABLE_NAME = "Tea_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "TEANAME";

    public static final String TABLE_NAME_PRICE = "Tea_price_table";
    public static final String C0 = "TEAIDPRICE";
    public static final String C1 = "POF";
    public static final String C2 = "POH";

    public static final String TABLE_NAME_SOLD = "Tea_sold_table";
    public static final String CO1 = "TEAIDSOLD";
    public static final String CO2 = "CSF";
    public static final String CO3 = "CSH";
    public static final String CO4 = "DATE";

    public static final String TABLE_NAME_EXPENSE = "Tea_expense_table";
    public static final String EC1 = "EXPNAME";
    public static final String EC2 = "EXPDATE";
    public static final String EC3 = "EXPPRICE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, TEANAME TEXT, POF INTEGER, POH INTEGER )");
        db.execSQL("create table " + TABLE_NAME_SOLD + "( TEAIDSOLD INTEGER, SOLDDATE TEXT, TEANAME TEXT, CSF INTEGER, CSH INTEGER, FOREIGN KEY(TEAIDSOLD) REFERENCES Tea_table(ID) )");
        db.execSQL("create table " + TABLE_NAME_PRICE + "( TEAIDPRICE INTEGER, TEANAME TEXT, POF INTEGER, POH INTEGER, FOREIGN KEY(TEAIDPRICE) REFERENCES Tea_table(ID) )");
        db.execSQL("create table " + TABLE_NAME_EXPENSE + "( EXPNAME TEXT, EXPDATE TEXT, EXPPRICE INTEGER)");


//        db.execSQL("insert into " + TABLE_NAME_EXPENSE + "( EXPNAME, POF) VALUES ('BRING', 0)");
//        db.execSQL("insert into " + TABLE_NAME_EXPENSE + "( EXPNAME, POF) VALUES ('RENT', 0)");
//        db.execSQL("insert into " + TABLE_NAME_EXPENSE + "( EXPNAME, POF) VALUES ('HIRE', 0)");
//        db.execSQL("insert into " + TABLE_NAME_EXPENSE + "( EXPNAME, POF) VALUES ('FIRE', 0)");

        db.execSQL("insert into " + TABLE_NAME + "( TEANAME, POF, POH) VALUES ('Masala tea', 0, 0)");
        db.execSQL("insert into " + TABLE_NAME + "( TEANAME, POF, POH) VALUES ('Lemon tea', 0, 0)");
        db.execSQL("insert into " + TABLE_NAME + "( TEANAME, POF, POH) VALUES ('Ginger tea', 0, 0)");
        db.execSQL("insert into " + TABLE_NAME + "( TEANAME, POF, POH) VALUES ('Black tea', 0, 0)");

        //   db.execSQL("insert into " + TABLE_NAME_PRICE + "( TEANAME, POF, POH) VALUES ('B', 0, 0);");


        Cursor cursor = db.rawQuery("select ID, TEANAME from " + TABLE_NAME, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            db.execSQL("insert into " + TABLE_NAME_SOLD + "( TEAIDSOLD, TEANAME, CSF, CSH) VALUES ( " + cursor.getInt(cursor.getColumnIndex("ID")) + ", '" + cursor.getString(cursor.getColumnIndex("TEANAME")) + "', 0, 0)");
            cursor.moveToNext();
        }
        cursor.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SOLD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PRICE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_EXPENSE);

        onCreate(db);
    }

    public String[] getChaiStrin() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select TEANAME from " + TABLE_NAME, new String[]{});
        cursor.moveToFirst();
        ArrayList<String> names = new ArrayList<String>();
        while (!cursor.isAfterLast()) {
            names.add(cursor.getString(cursor.getColumnIndex("TEANAME")));
            cursor.moveToNext();
        }
        cursor.close();
        return names.toArray(new String[names.size()]);

    }

    public int getTeaID(String name) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT ID FROM " + TABLE_NAME + " WHERE TEANAME='" + name + "'", null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }


    public ArrayList<TPrice> getPriceString(ArrayList<String> teas) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<TPrice> pof = new ArrayList<TPrice>();
        for (String tea : teas) {
            Cursor cursor = db.rawQuery("select POH, POF from " + TABLE_NAME + " WHERE TEANAME='" + tea + "'", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                pof.add(new TPrice(tea, cursor.getInt(cursor.getColumnIndex("POF")), cursor.getInt(cursor.getColumnIndex("POH"))));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return pof;


        //make update table then write query like raqquery then make update function
    }


    public ArrayList<CupPrice> getCupString(ArrayList<String> cteas) {
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<CupPrice> poc = new ArrayList<CupPrice>();
        for (String tea : cteas) {
//            Cursor cursor = db.rawQuery("select ID from " + TABLE_NAME + " WHERE TEANAME='" + tea + "'", null);
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()) {
            poc.add(new CupPrice(tea, 0, 0));
//                cursor.moveToNext();
//            }
//            cursor.close();
        }

//        int i = 0;
//        ArrayList<CupPrice> poc = new ArrayList<CupPrice>();
//        for (Integer id : ids) {
//            Cursor cursor = db.rawQuery("select CSF, CSH from " + TABLE_NAME_SOLD + " WHERE TEAIDSOLD=" + id , null);
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()) {
//                poc.add(new CupPrice(cteas.get(i++), cursor.getInt(cursor.getColumnIndex("CSF")),cursor.getInt(cursor.getColumnIndex("CSH"))));
//                cursor.moveToNext();
//            }
//            cursor.close();
//        }
        return poc;


        //make update table then write query like raqquery then make update function
    }


    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});

    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

//    public Integer insertData(){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//
//
//    }
}
