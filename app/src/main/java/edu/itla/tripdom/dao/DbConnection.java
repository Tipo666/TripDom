package edu.itla.tripdom.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tipo666 on 11/26/2017.
 */

public class DbConnection extends SQLiteOpenHelper{


    public static String DATABASE_NAME = "TripDomDB.db";
    public static String LOG_T = "DbConnection";

    public DbConnection(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public DbConnection
}
