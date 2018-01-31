package com.ninja.mexico.database.cruds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ninja.mexico.database.core.DataBaseLyonCRM;
import com.ninja.mexico.database.core.OperationDb;
import com.ninja.mexico.model.Visit;

import java.util.ArrayList;

/**
 * Created by Edgar Gonzalez on 12/01/2018.
 * Actia de Mexico S.A. de C.V..
 */

public class VisitCRUD extends OperationDb{
    public interface Columns_Visita{
        String ID_VISITA = "id_visita";
        String SCHEDULED_DATE = "scheduled_date";
        String ADRESS = "adress";
        String COMPANY_NAME= "company_name";
    }


    private String TAG = "VisitCRUD";
    public static VisitCRUD visitCRUD = new VisitCRUD();

    public VisitCRUD() {
    }

    public static VisitCRUD getInstance(Context context){
        startInstanceDb(context);
        return visitCRUD;
    }


    private Cursor getCursorOneVisit(int idVisit) {
        SQLiteDatabase db = dataBaseLyonCRM.getReadableDatabase();
        String sql = String.format("Select *from %s where %s=?",
                DataBaseLyonCRM.NAME_TABLES.VISITA,
                Columns_Visita.ID_VISITA);
        String[] selectionArgs = {String.valueOf(idVisit)};

        return db.rawQuery(sql, selectionArgs);
    }

    private Cursor getCursorVisitByStatus(int status) {
        SQLiteDatabase db = dataBaseLyonCRM.getReadableDatabase();
        String sql = String.format("Select *from %s where %s=?",
                DataBaseLyonCRM.NAME_TABLES.VISITA,
                Columns_Visita.ID_VISITA);
        String[] selectionArgs = {String.valueOf(status)};

        return db.rawQuery(sql, selectionArgs);
    }



    private Cursor getCursorAllVisit() {
        SQLiteDatabase db = dataBaseLyonCRM.getReadableDatabase();
        String sql = String.format("Select * from %s",
                DataBaseLyonCRM.NAME_TABLES.VISITA);
        return db.rawQuery(sql, null);
    }

    /***public**/



    private ContentValues getValuesVisit(Visit visit) {
        ContentValues values = new ContentValues();
//        values.put(Columns_Visita.ID_VISITA, visit.getIdVisita());
        values.put(Columns_Visita.SCHEDULED_DATE, visit.getScheduledDate());
        values.put(Columns_Visita.ADRESS, visit.getAdress());
        values.put(Columns_Visita.COMPANY_NAME, visit.getCompanyName());


        return values;


    }

    private Visit cursorToVisit(Cursor cursor){
        Visit visit = new Visit(
                cursor.getInt(0),                   //        int idVisita;
                cursor.getString(1),                //        String scheduledDate;
                cursor.getString(2),                //        String adress;
                cursor.getString(3)                 //        String companyName;




        );
        return visit;

    }

    private ArrayList<Visit> cursorToarrayListVisit (Cursor cursor){
        ArrayList<Visit> aListVisit=  new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                aListVisit.add(cursorToVisit(cursor));
            }while (cursor.moveToNext());
        }
        return aListVisit;
    }



    public Visit readOneVisit (int idVisit) {
        Cursor cursor = getCursorOneVisit(idVisit);
        if (cursor.moveToFirst()){
            return cursorToVisit(cursor);
        }
        return null;
    }

    public ArrayList<Visit> readAllVisit(){
        Cursor cursor = getCursorAllVisit();
        return  cursorToarrayListVisit(cursor);
    }
    public boolean deleteVisit(String idVisit) {
        boolean isDeleteOk = false;
        SQLiteDatabase db = dataBaseLyonCRM.getWritableDatabase();

        String whereClause = String.format("%s=?",
                Columns_Visita.ID_VISITA);

        String[] whereArgs = {idVisit};
        int result = db.delete(DataBaseLyonCRM.NAME_TABLES.VISITA, whereClause, whereArgs);
        if (result > 0) {
            isDeleteOk = true;
        }
        return isDeleteOk;

    }

    public boolean createVisit(Visit visit) {
        boolean isCreateOk = false;
        SQLiteDatabase db = dataBaseLyonCRM.getWritableDatabase();
        ContentValues values = getValuesVisit(visit);

        try {
            db.insertOrThrow(DataBaseLyonCRM.NAME_TABLES.VISITA, null, values);
            isCreateOk = true;
            Log.i(TAG, "insert in Visit: " + visit.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            Log.i(TAG, "ERROR in Query: " + values.toString());
            Log.i(TAG, "Cause: " + e.toString());
        }
        return isCreateOk;

    }

    public boolean updateVisit(Visit visit) {
        boolean isUpdateOk = false;
        SQLiteDatabase db = dataBaseLyonCRM.getWritableDatabase();

        ContentValues values = getValuesVisit(visit);

        String selection = String.format("%s=?",
                DataBaseLyonCRM.NAME_TABLES.VISITA);

        String[] whereArgs = {String.valueOf(visit.getIdVisita())};

        int result = db.update(DataBaseLyonCRM.NAME_TABLES.VISITA, values, selection, whereArgs);

        if (result > 0) {
            isUpdateOk = true;
        }
        return isUpdateOk;

    }

    public ArrayList<Visit> getAllVisitByID(int idVisit){
            Cursor cursor = getCursorVisitByStatus(idVisit);
            return  cursorToarrayListVisit(cursor);
    }






}
