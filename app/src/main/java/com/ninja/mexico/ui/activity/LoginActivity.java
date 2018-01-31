package com.ninja.mexico.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.ninja.mexico.database.cruds.UserCRUD;
import com.ninja.mexico.infraestructure.ConstantesLyonCRM;
import com.ninja.mexico.model.UserApp;

public class LoginActivity extends AppCompatActivity {
    EditText etMailLog, etPasswordLog;
    CheckBox chkRememberLog;
    Button btnLoginLog;
    View tvForgotLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startComponents();
        addListeners();


    }

    private void addListeners() {
        btnLoginLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userTxt = etMailLog.getText().toString().trim();
                String passwordTxt = etPasswordLog.getText().toString().trim();

                UserCRUD userCRUD = UserCRUD.getInstance(LoginActivity.this);
                UserApp userLog = userCRUD.login(userTxt, passwordTxt);

                if (userLog != null) {
                    int idProfile = userLog.getId_profile();
                    Intent intent = null;

                    if (idProfile == ConstantesLyonCRM.ID_PROFILE_MANAGER) {
                        intent = new Intent(LoginActivity.this, ManagerActivity.class);
                    } else if (idProfile == ConstantesLyonCRM.ID_PROFILE_PROMOTOR) {
                        intent = new Intent(LoginActivity.this, MainPromotorActivity.class);
                    } else if (idProfile == ConstantesLyonCRM.ID_PROFILE_SUPERVISOR) {
                        intent = new Intent(LoginActivity.this, MainSupervisorActivity.class);
                    }
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "Usuario y/o Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void startComponents() {
        etMailLog = findViewById(R.id.etMailLog);
        etPasswordLog = findViewById(R.id.etPasswordLog);
        chkRememberLog = findViewById(R.id.chkRememberLog);
        btnLoginLog = findViewById(R.id.btnLoginLog);
        tvForgotLog = findViewById(R.id.tvForgotLog);
    }


}
