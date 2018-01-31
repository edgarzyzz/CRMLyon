package com.ninja.mexico.utils.utils_ui;

import android.content.Context;
import android.widget.EditText;

import com.ninja.mexico.infraestructure.ConstantesLyonCRM;
import com.ninja.mexico.ui.activity.R;

/**
 * Created by Edgar Gonzalez on 22/01/2018.
 * Actia de Mexico S.A. de C.V..
 */

public class UtilitiesFormEditText {
    private Context context;

    public UtilitiesFormEditText(Context context) {
        this.context = context;
    }
    //    private boolean existDataEditText(String name, String adress, String comapny, String sheduledDate) {
//        boolean isDataCorrect =true;
//
//        if (name==null || name.length()==0){
//            isDataCorrect = false;
//            markErrorEmptyField(etNameContactRegVis);
//        }else{
//
//        }
//        if (adress==null || adress.length()==0){
//            isDataCorrect = false;
//            markErrorEmptyField(etAdressRegVis);
//        }
//        if (comapny==null || comapny.length()==0){
//            isDataCorrect = false;
//            markErrorEmptyField(etCompanyRegVis);
//        }
//        if (sheduledDate==null || sheduledDate.length()==0){
//            isDataCorrect = false;
//            markErrorEmptyField(etscheduledDateRegVis);
//        }
//
//        return isDataCorrect;
//
//
//    }

    public boolean isCorrectDataEditText(EditText editText, int typeField){
        boolean isCorrectFormat = true;
        String data = editText.getText().toString().trim();
        if (editText==null || editText.length()==0){
            markErrorEmptyField(editText);
            isCorrectFormat=false;
        }else{
            if (!checkFormat(data, typeField)){
                isCorrectFormat=false;
                markErrorIncorrectFormat(editText,typeField);
            }
        }
        return isCorrectFormat;
    }

    private boolean checkFormat(String data, int typeField) {
        String regex = null;
        if (typeField==ConstantesLyonCRM.TEXT_TYPE_CHARACTER){
            regex = "[A-Za-z]";
        }else if (typeField==ConstantesLyonCRM.TEXT_TYPE_NUMBER){
            regex="[0-9]+";
        }


        boolean isCorrectFormat = data.matches(regex);

        return true;
    }

    private void markErrorEmptyField(EditText editTextWhitError) {
        editTextWhitError.requestFocus();
        editTextWhitError.setError(context.getString(R.string.msg_field_obligatory));
        editTextWhitError.setText("");
    }

    private void markErrorIncorrectFormat(EditText editTextWhitError,int typeField) {
        editTextWhitError.requestFocus();
        String textErrrorFormat = getTextErrorFormat(typeField);
        editTextWhitError.setError(textErrrorFormat);
    }

    private String getTextErrorFormat(int typeField) {
        if (typeField== ConstantesLyonCRM.TEXT_TYPE_CHARACTER){
            return context.getString(R.string.msg_field_must_text);
        }else if (typeField== ConstantesLyonCRM.TEXT_TYPE_NUMBER){
            return context.getString(R.string.msg_field_must_numeric);
        }else if (typeField== ConstantesLyonCRM.TEXT_TYPE_EMAIL){
            return context.getString(R.string.msg_field_must_email);
        }else if (typeField== ConstantesLyonCRM.TEXT_TYPE_ALPHANUMERIC){
            return context.getString(R.string.msg_field_must_alphanumeric);
        }


        return "";
    }


}
