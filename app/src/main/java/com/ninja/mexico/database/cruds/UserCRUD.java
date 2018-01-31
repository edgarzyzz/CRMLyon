package com.ninja.mexico.database.cruds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ninja.mexico.database.core.DataBaseLyonCRM;
import com.ninja.mexico.database.core.OperationDb;
import com.ninja.mexico.model.UserApp;

import java.util.ArrayList;

/**
 * Created by Edgar Gonzalez on 12/01/2018.
 * Actia de Mexico S.A. de C.V..
 */

public class UserCRUD extends OperationDb{

    private String TAG = "UserCRUD";
    public static UserCRUD userCRUD = new UserCRUD();

    public UserCRUD() {
    }

    public static UserCRUD getInstance (Context context){
        startInstanceDb(context);
        return userCRUD;
    }

    public interface ColumnsUsuarios {
        String ID_USUARIO = "idUsuario";
        String NICKNAME = "nickname";
        String PASSWORD = "password";
        String ID_PROFILE = "id_profile";
        String NAME = "name";
        String LAST_NAME_P = "last_name_p";
        String LAST_NAME_M = "last_name_m";
        String PHONNE = "phone";
    }


    private Cursor getCursorOneUsuario(int idUsuario) {
        SQLiteDatabase db = dataBaseLyonCRM.getReadableDatabase();
        String sql = String.format("Select *from %s where %s=?",
                DataBaseLyonCRM.NAME_TABLES.USUARIO,
                ColumnsUsuarios.ID_USUARIO);
        String[] selectionArgs = {String.valueOf(idUsuario)};

        return db.rawQuery(sql, selectionArgs);
    }

    private Cursor getCursorUserMailPass(String user, String password) {
        SQLiteDatabase db = dataBaseLyonCRM.getReadableDatabase();
        String sql = String.format("Select * from %s where %s=? and %s=?",
                DataBaseLyonCRM.NAME_TABLES.USUARIO,
                ColumnsUsuarios.NICKNAME,
                ColumnsUsuarios.PASSWORD);
        String[] selectionArgs = {user,password};

        return db.rawQuery(sql, selectionArgs);
    }


    private Cursor getCursorAllUsuario() {
        SQLiteDatabase db = dataBaseLyonCRM.getReadableDatabase();
        String sql = String.format("Select * from %s",
                DataBaseLyonCRM.NAME_TABLES.USUARIO);
        return db.rawQuery(sql, null);
    }

    /***public**/


    private ContentValues getValuesUsuario(UserApp userApp) {
        ContentValues values = new ContentValues();
//        values.put(ColumnsUsuarios.ID_USUARIO, userApp.getIdUsuario());
        values.put(ColumnsUsuarios.NICKNAME, userApp.getNickname());
        values.put(ColumnsUsuarios.PASSWORD, userApp.getPassword());
        values.put(ColumnsUsuarios.ID_PROFILE, userApp.getId_profile());
        values.put(ColumnsUsuarios.NAME, userApp.getName());
        values.put(ColumnsUsuarios.LAST_NAME_P, userApp.getLast_name_p());
        values.put(ColumnsUsuarios.LAST_NAME_M, userApp.getLast_name_m());
        values.put(ColumnsUsuarios.PHONNE, userApp.getPhone());


        return values;


    }

    private UserApp cursorToUsuario(Cursor cursor) {
        UserApp userApp = new UserApp(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7)
                );
        return userApp;

    }

    private ArrayList<UserApp> cursorToarrayListUsuario(Cursor cursor) {
        ArrayList<UserApp> listUserApp = new ArrayList<>();
        ;
        if (cursor.moveToFirst()) {
            do {
                listUserApp.add(cursorToUsuario(cursor));
            } while (cursor.moveToNext());
        }
        return listUserApp;
    }


    public UserApp readOneUsuario(int user) {
        Cursor cursor = getCursorOneUsuario(user);
        if (cursor.moveToFirst()) {
            return cursorToUsuario(cursor);
        }
        return null;
    }

    public ArrayList<UserApp> readAllUsuario() {
        Cursor cursor = getCursorAllUsuario();
        return cursorToarrayListUsuario(cursor);
    }

    public boolean deleteUsuario(String idUsuario) {
        boolean isDeleteOk = false;
        SQLiteDatabase db = dataBaseLyonCRM.getWritableDatabase();

        String whereClause = String.format("%s=?",
                ColumnsUsuarios.ID_USUARIO);

        String[] whereArgs = {idUsuario};
        int result = db.delete(DataBaseLyonCRM.NAME_TABLES.USUARIO, whereClause, whereArgs);
        if (result > 0) {
            isDeleteOk = true;
        }
        return isDeleteOk;

    }

    public boolean createUsuario(UserApp userApp) {
        boolean isCreateOk = false;
        SQLiteDatabase db = dataBaseLyonCRM.getWritableDatabase();
        ContentValues values = getValuesUsuario(userApp);

        try {
            db.insertOrThrow(DataBaseLyonCRM.NAME_TABLES.USUARIO, null, values);
            isCreateOk = true;
//            Log.i(TAG, "insert in Xxxxx: " + UserApp.toString());
        } catch (SQLException e) {
            e.printStackTrace();
//            Log.i(TAG, "ERROR in Query: " + values.toString());
//            Log.i(TAG, "Cause: " + e.toString());
        }
        return isCreateOk;

    }

    public boolean updateUsuario(UserApp userApp) {
        boolean isUpdateOk = false;
        SQLiteDatabase db = dataBaseLyonCRM.getWritableDatabase();

        ContentValues values = getValuesUsuario(userApp);

        String selection = String.format("%s=?",
                ColumnsUsuarios.ID_USUARIO);

        String[] whereArgs = {String.valueOf(userApp.getIdUsuario())};

        int result = db.update(DataBaseLyonCRM.NAME_TABLES.USUARIO, values, selection, whereArgs);

        if (result > 0) {
            isUpdateOk = true;
        }
        return isUpdateOk;

    }


    public boolean existUserManager(){
        Cursor cursor =  getCursorOneUsuario(1);
        if (cursor!=null && cursor.moveToFirst()){
            return true;
        }
        return false;
    }

    public UserApp login(String mail, String password){
        Cursor cursor = getCursorUserMailPass(mail,password);
        if (cursor!=null && cursor.moveToFirst()){
            return new UserApp(
                    cursor.getInt(0),                       //int idUsuario;
                    cursor.getString(1),                    //String nickname;
                    cursor.getString(2),                    //String password;
                    cursor.getInt(3),                       //int id_profile;
                    cursor.getString(4),                    //String name;
                    cursor.getString(5),                    //String last_name_p;
                    cursor.getString(6),                    //String last_name_m;
                    cursor.getString(7)                     //String phone;
            );
        }
        return null;
    }



}
