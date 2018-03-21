package com.ninja.mexico.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ninja.mexico.helpers.HelperProfile;
import com.ninja.mexico.model.UserProfile;
import com.ninja.mexico.model.user_crm.PersonalDataUserCrm;
import com.ninja.mexico.ui.activity.R;

import java.util.ArrayList;


public class PersonalDataRegFragment extends Fragment {
    private EditText etNameRegUser, etLastNameOneRegUser, etLastNameTwoRegUser, etEmailRegUser;
    private EditText etPasswordUser, etPositionRegUser, etNickNameRegUser, etOfficePhoneRegUser;
    private EditText etCellPhoneRegUser, etWebSiteRegUser, etFaxRegUser, etBirthdateRegUser;
    private Spinner spTypePerfilRegUser;
    private Button btnNextPersonal;
    private Button btnBackPersonal;
    private OnFragmentPersonalInteraction listenerFgmntPers;


    public static PersonalDataRegFragment newInstance(String param1, String param2) {
        PersonalDataRegFragment fragment = new PersonalDataRegFragment();
        return fragment;
    }

    public interface OnFragmentPersonalInteraction{
        void onFgmntPErsonalInteraction(boolean isBackPressed, PersonalDataUserCrm dataPersonalUser);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_personal_data_reg, container, false);

        etNameRegUser=viewFragment.findViewById(R.id.etNameRegUser);
        etLastNameOneRegUser=viewFragment.findViewById(R.id.etLastNameOneRegUser);
        etLastNameTwoRegUser=viewFragment.findViewById(R.id.etLastNameTwoRegUser);
        etEmailRegUser=viewFragment.findViewById(R.id.etEmailRegUser);
        etPasswordUser=viewFragment.findViewById(R.id.etPasswordUser);
        etPositionRegUser=viewFragment.findViewById(R.id.etPositionRegUser);
        etNickNameRegUser=viewFragment.findViewById(R.id.etNickNameRegUser);
        etOfficePhoneRegUser=viewFragment.findViewById(R.id.etOfficePhoneRegUser);
        etCellPhoneRegUser=viewFragment.findViewById(R.id.etCellPhoneRegUser);
        etWebSiteRegUser=viewFragment.findViewById(R.id.etWebSiteRegUser);
        etFaxRegUser=viewFragment.findViewById(R.id.etFaxRegUser);
        etBirthdateRegUser=viewFragment.findViewById(R.id.etBirthdateRegUser);
        btnNextPersonal = viewFragment.findViewById(R.id.btnNextPersonal);
        btnBackPersonal = viewFragment.findViewById(R.id.btnBackPersonal);


        spTypePerfilRegUser = viewFragment.findViewById(R.id.spTypePerfilRegUser);

        ArrayList<UserProfile> listProfiles = HelperProfile.getListProfiles();
        ArrayAdapter<UserProfile> adapterProfiles = new ArrayAdapter<UserProfile>(getContext(), android.R.layout.simple_spinner_item, listProfiles);
        adapterProfiles.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spTypePerfilRegUser.setAdapter(adapterProfiles);

        btnBackPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerFgmntPers.onFgmntPErsonalInteraction(true,
                        new PersonalDataUserCrm(
                                etNameRegUser.getText().toString(),
                                etLastNameOneRegUser.getText().toString(),
                                etLastNameTwoRegUser.getText().toString(),
                                etEmailRegUser.getText().toString(),
                                etPasswordUser.getText().toString(),
                                etPositionRegUser.getText().toString(),
                                etNickNameRegUser.getText().toString(),
                                etOfficePhoneRegUser.getText().toString(),
                                etCellPhoneRegUser.getText().toString(),
                                etWebSiteRegUser.getText().toString(),
                                etFaxRegUser.getText().toString(),
                                etBirthdateRegUser.getText().toString()

                        ));
            }
        });
        btnNextPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerFgmntPers.onFgmntPErsonalInteraction(true,
                        new PersonalDataUserCrm(
                                etNameRegUser.getText().toString(),
                                etLastNameOneRegUser.getText().toString(),
                                etLastNameTwoRegUser.getText().toString(),
                                etEmailRegUser.getText().toString(),
                                etPasswordUser.getText().toString(),
                                etPositionRegUser.getText().toString(),
                                etNickNameRegUser.getText().toString(),
                                etOfficePhoneRegUser.getText().toString(),
                                etCellPhoneRegUser.getText().toString(),
                                etWebSiteRegUser.getText().toString(),
                                etFaxRegUser.getText().toString(),
                                etBirthdateRegUser.getText().toString()

                        ));
            }

        });


        return viewFragment;
    }



    public boolean isCorrectDataEditText() {
//        UtilitiesFormEditText validationForm = new UtilitiesFormEditText(getContext());
//        if (validationForm.isCorrectDataEditText(etNameRegUser, ConstantesLyonCRM.TEXT_TYPE_CHARACTER) &&
//                validationForm.isCorrectDataEditText(etLastNameOneRegUser, ConstantesLyonCRM.TEXT_TYPE_CHARACTER) &&
//                validationForm.isCorrectDataEditText(etLastNameTwoRegUser, ConstantesLyonCRM.TEXT_TYPE_CHARACTER) &&
//
//                {
//            return true;
//        } else {
            return false;
//        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentPersonalInteraction){
            listenerFgmntPers = (OnFragmentPersonalInteraction) context;
        }else{
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }


    }

    @Override
    public void onDetach() {
        super.onDetach();
        listenerFgmntPers =null;
    }
}
