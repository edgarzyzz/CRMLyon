package com.ninja.mexico.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ninja.mexico.database.cruds.VisitCRUD;
import com.ninja.mexico.infraestructure.ConstantesLyonCRM;
import com.ninja.mexico.model.Visit;
import com.ninja.mexico.ui.activity.ManagerActivity;
import com.ninja.mexico.ui.activity.R;
import com.ninja.mexico.utils.utils_ui.UtilitiesFormEditText;

public class RegisterVisitFragment extends Fragment {
    EditText etNameContactRegVis, etAdressRegVis, etCompanyRegVis, etscheduledDateRegVis;
    Button btnAceptRegVis;

    public RegisterVisitFragment() {
    }


    public static RegisterVisitFragment newInstance(String param1, String param2) {
        RegisterVisitFragment fragment = new RegisterVisitFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragment = inflater.inflate(R.layout.fragment_register_visit, container, false);
        etNameContactRegVis = viewFragment.findViewById(R.id.etNameContactRegVis);
        etAdressRegVis = viewFragment.findViewById(R.id.etAdressRegVis);
        etCompanyRegVis = viewFragment.findViewById(R.id.etCompanyRegVis);
        etscheduledDateRegVis = viewFragment.findViewById(R.id.etscheduledDateRegVis);
        btnAceptRegVis = viewFragment.findViewById(R.id.btnAceptRegVis);

        btnAceptRegVis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (isCorrectDataEditText()){
                    String adress = etAdressRegVis.getText().toString().trim();//FIXME falta agregar este campo en la clase

                    VisitCRUD visitCRUD = VisitCRUD.getInstance(getContext());
                    boolean isCreatedVisit = visitCRUD.createVisit(new Visit(
                            0,
                            etscheduledDateRegVis.getText().toString().trim(),
                            etNameContactRegVis.getText().toString().trim(),
                            etCompanyRegVis.getText().toString().trim()
                    ));
                    if (isCreatedVisit){
                        Toast.makeText(getContext(), getContext().getString(R.string.reg_vis_save_correct), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(), ManagerActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getContext(), getContext().getString(R.string.reg_vis_save_incorrect), Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        return viewFragment;
    }


    private boolean isCorrectDataEditText(){
        UtilitiesFormEditText validationForm = new UtilitiesFormEditText(getContext());
        if (validationForm.isCorrectDataEditText(etNameContactRegVis, ConstantesLyonCRM.TEXT_TYPE_CHARACTER)==true
                && validationForm.isCorrectDataEditText(etAdressRegVis, ConstantesLyonCRM.TEXT_TYPE_CHARACTER)==true
                && validationForm.isCorrectDataEditText(etCompanyRegVis, ConstantesLyonCRM.TEXT_TYPE_CHARACTER)==true
                && validationForm.isCorrectDataEditText(etscheduledDateRegVis, ConstantesLyonCRM.TEXT_TYPE_CHARACTER)==true){
            return true;
        }
        return false;
    }


}
