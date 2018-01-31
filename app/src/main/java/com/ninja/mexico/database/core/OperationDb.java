package com.ninja.mexico.database.core;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Edgar Gonzalez on 12/01/2018.
 * Actia de Mexico S.A. de C.V..
 */

public class OperationDb {
    public static  DataBaseLyonCRM dataBaseLyonCRM;
    protected static OperationDb instanceOperationsDb = new OperationDb();

    public OperationDb() {
    }

    protected static void startInstanceDb(Context context){
        if (dataBaseLyonCRM==null){
            dataBaseLyonCRM = new DataBaseLyonCRM(context);
        }
    }

    public static OperationDb getInstance(Context context){
        startInstanceDb(context);
        return instanceOperationsDb;
    }

    public SQLiteDatabase getDb(){
        return  dataBaseLyonCRM.getWritableDatabase();
    }

    public Cursor readQueryDb(String query){
        SQLiteDatabase db = dataBaseLyonCRM.getReadableDatabase();
        return  db.rawQuery(query,null);
    }
}
