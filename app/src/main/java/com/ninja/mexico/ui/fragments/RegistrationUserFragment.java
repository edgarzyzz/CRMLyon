package com.ninja.mexico.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ninja.mexico.database.cruds.UserCRUD;
import com.ninja.mexico.helpers.HelperProfile;
import com.ninja.mexico.infraestructure.ConstantesLyonCRM;
import com.ninja.mexico.model.UserApp;
import com.ninja.mexico.model.UserProfile;
import com.ninja.mexico.ui.activity.ManagerActivity;
import com.ninja.mexico.ui.activity.R;
import com.ninja.mexico.utils.utils_ui.UtilitiesFormEditText;

import java.util.ArrayList;


public class RegistrationUserFragment extends Fragment {
    private EditText etNameRegUser, etLastNameOneRegUser, etLastNameTwoRegUser, etAdressRegUser, etPositionRegUser, etPhoneRegUser;
    private Spinner spTypePerfilRegUser;
    private Button btnRegisterRegUser;

    public static RegistrationUserFragment newInstance(String param1, String param2) {
        RegistrationUserFragment fragment = new RegistrationUserFragment();
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
        View viewFragment = inflater.inflate(R.layout.fragment_registration_user, container, false);
        etNameRegUser = viewFragment.findViewById(R.id.etNameRegUser);
        etLastNameOneRegUser = viewFragment.findViewById(R.id.etLastNameOneRegUser);
        etLastNameTwoRegUser = viewFragment.findViewById(R.id.etLastNameTwoRegUser);
        etAdressRegUser = viewFragment.findViewById(R.id.etAdressRegUser);
        etPositionRegUser = viewFragment.findViewById(R.id.etPositionRegUser);
        etPhoneRegUser = viewFragment.findViewById(R.id.etPhoneRegUser);
        spTypePerfilRegUser = viewFragment.findViewById(R.id.spTypePerfilRegUser);
        btnRegisterRegUser = viewFragment.findViewById(R.id.btnRegisterRegUser);

        ArrayList<UserProfile> listProfiles= HelperProfile.getListProfiles();
        ArrayAdapter<UserProfile> adapterProfiles = new ArrayAdapter<UserProfile>(getContext(), android.R.layout.simple_spinner_item, listProfiles);
        adapterProfiles.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spTypePerfilRegUser.setAdapter(adapterProfiles);

        btnRegisterRegUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isCreatedUser = false;
                String position = etPositionRegUser.getText().toString().trim();
                String adress = etAdressRegUser.getText().toString().trim();

                if (isCorrectDataEditText()) {
                    UserProfile profileSelected = (UserProfile) spTypePerfilRegUser.getSelectedItem();
                    UserCRUD userCRUD = UserCRUD.getInstance(getContext());

                    isCreatedUser = userCRUD.createUsuario(
                            new UserApp(
                                    0,
                                    etNameRegUser.getText().toString().trim(),
                                    "a",
                                    profileSelected.getTypeUser(),
                                    etNameRegUser.getText().toString().trim(),
                                    etLastNameOneRegUser.getText().toString().trim(),
                                    etLastNameTwoRegUser.getText().toString().trim(),
                                    etPhoneRegUser.getText().toString().trim()
                            )
                    );


                }

                if (isCreatedUser) {
                    Toast.makeText(getContext(), getContext().getString(R.string.reg_user_save_correct), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), ManagerActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), getContext().getString(R.string.reg_user_save_incorrect), Toast.LENGTH_SHORT).show();
                }
            }
        });


        return viewFragment;
    }

    public boolean isCorrectDataEditText() {
        UtilitiesFormEditText validationForm = new UtilitiesFormEditText(getContext());
        if (validationForm.isCorrectDataEditText(etNameRegUser, ConstantesLyonCRM.TEXT_TYPE_CHARACTER) &&
                validationForm.isCorrectDataEditText(etLastNameOneRegUser, ConstantesLyonCRM.TEXT_TYPE_CHARACTER) &&
                validationForm.isCorrectDataEditText(etLastNameTwoRegUser, ConstantesLyonCRM.TEXT_TYPE_CHARACTER) &&
                validationForm.isCorrectDataEditText(etAdressRegUser, ConstantesLyonCRM.TEXT_TYPE_CHARACTER) &&
                validationForm.isCorrectDataEditText(etPositionRegUser, ConstantesLyonCRM.TEXT_TYPE_CHARACTER) &&
                validationForm.isCorrectDataEditText(etPhoneRegUser, ConstantesLyonCRM.TEXT_TYPE_CHARACTER)) {
            return true;
        } else {
            return false;
        }

    }
}
