package com.ninja.mexico.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ninja.mexico.database.cruds.UserCRUD;
import com.ninja.mexico.infraestructure.ConstantesLyonCRM;
import com.ninja.mexico.model.UserApp;

public class LoginActivity extends AppCompatActivity {
    EditText etMailLog, etPasswordLog;
    CheckBox chkRememberLog;
    Button btnLoginLog;
    View tvForgotLog;

    private FirebaseAuth authFirebase;
    private DatabaseReference dataFirebase;
    private FirebaseUser currentUserFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startComponents();
        addListeners();

        authFirebase = FirebaseAuth.getInstance();
        dataFirebase = FirebaseDatabase.getInstance().getReference();


    }

    private void addListeners() {
        btnLoginLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userTxt = etMailLog.getText().toString().trim();
                String passwordTxt = etPasswordLog.getText().toString().trim();
                authFirebase.signInWithEmailAndPassword(userTxt, passwordTxt)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(LoginActivity.this, ManagerActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this, getString(R.string.data_incorrect), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

//                UserCRUD userCRUD = UserCRUD.getInstance(LoginActivity.this);
//                UserApp userLog = userCRUD.login(userTxt, passwordTxt);
//
//                if (userLog != null) {
//                    int idProfile = userLog.getId_profile();
//                    Intent intent = null;
//
//                    if (idProfile == ConstantesLyonCRM.ID_PROFILE_MANAGER) {
//                        intent = new Intent(LoginActivity.this, ManagerActivity.class);
//                    } else if (idProfile == ConstantesLyonCRM.ID_PROFILE_PROMOTOR) {
//                        intent = new Intent(LoginActivity.this, MainPromotorActivity.class);
//                    } else if (idProfile == ConstantesLyonCRM.ID_PROFILE_SUPERVISOR) {
//                        intent = new Intent(LoginActivity.this, MainSupervisorActivity.class);
//                    }
//                    startActivity(intent);
//
//                } else {
//                    Toast.makeText(LoginActivity.this, "Usuario y/o Contraseña incorrecta", Toast.LENGTH_SHORT).show();
//                }
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
