package com.ninja.mexico.database.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ninja.mexico.database.cruds.UserCRUD;
import com.ninja.mexico.database.cruds.VisitCRUD;

/**
 * Created by Edgar Gonzalez on 12/01/2018.
 * Actia de Mexico S.A. de C.V..
 */

public class DataBaseLyonCRM extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "LyonDb.db";
    private static final int DB_VERSION = 1;
    private String TAG = "DataBaseLyonCRM";


    public DataBaseLyonCRM(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    public interface NAME_TABLES {
        String USUARIO = "USUARIO";
        String VISITA = "VISITA";
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s (" +
                        "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s varchar (20), " +
                        "%s varchar(20)," +
                        "%s INTEGER, " +
                        "%s varchar (20)," +
                        "%s varchar (20)," +
                        "%s varchar (20)," +
                        "%s varchar (20))",
                NAME_TABLES.USUARIO,
                UserCRUD.ColumnsUsuarios.ID_USUARIO,
                UserCRUD.ColumnsUsuarios.NICKNAME,
                UserCRUD.ColumnsUsuarios.PASSWORD,
                UserCRUD.ColumnsUsuarios.ID_PROFILE,
                UserCRUD.ColumnsUsuarios.NAME,
                UserCRUD.ColumnsUsuarios.LAST_NAME_P,
                UserCRUD.ColumnsUsuarios.LAST_NAME_M,
                UserCRUD.ColumnsUsuarios.PHONNE));


        db.execSQL(String.format("CREATE TABLE %s (" +
                        "%s INTEGER PRIMARY KEY , " +
                        "%s varchar (20)," +
                        "%s varchar (50)," +
                        "%s varchar (20))",
                NAME_TABLES.VISITA,
                VisitCRUD.Columns_Visita.ID_VISITA,
                VisitCRUD.Columns_Visita.SCHEDULED_DATE,
                VisitCRUD.Columns_Visita.ADRESS,
                VisitCRUD.Columns_Visita.COMPANY_NAME
        ));


    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
