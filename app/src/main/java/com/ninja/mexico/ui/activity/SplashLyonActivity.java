package com.ninja.mexico.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ninja.mexico.database.cruds.UserCRUD;
import com.ninja.mexico.database.cruds.VisitCRUD;
import com.ninja.mexico.infraestructure.ConstantesLyonCRM;
import com.ninja.mexico.model.UserApp;
import com.ninja.mexico.model.Visit;

public class SplashLyonActivity extends AppCompatActivity {

    private FirebaseAuth authFirebase;
    private DatabaseReference dataFirebase;
    private FirebaseUser currentUserFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_lyon);

        authFirebase = FirebaseAuth.getInstance();
        dataFirebase = FirebaseDatabase.getInstance().getReference();


//        authFirebase.signInWithEmailAndPassword("ninjasystemsmexico@gmail.com", "ninja123")
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()){
//                            FirebaseUser uno = authFirebase.getCurrentUser();
//                            String unosss = uno.getUid();
//                            authFirebase.createUserWithEmailAndPassword("xx@xx.xx", "ninja123")
//                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                        @Override
//                                        public void onComplete(@NonNull Task<AuthResult> task) {
//                                            if (task.isSuccessful()){
//                                                String id = task.getResult().getUser().getUid();
//                                                id.length();
//
//                                                FirebaseUser curus = authFirebase.getCurrentUser();
//                                                String gg = curus.getUid();
//                                                gg.length();
//                                            }
//
//                                        }
//                                    });
//
//                        }
//                    }
//                });
//
//
//
//
//
//        startDummyDB();
//
//
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
                Intent intent = null;
//                if (authFirebase.getCurrentUser()!=null){
//                    authFirebase.getCurrentUser().getUid();
//                    intent = new Intent(SplashLyonActivity.this, LoginActivity.class);
//                }else{
        intent = new Intent(SplashLyonActivity.this, LoginActivity.class);
//
//                }
        startActivity(intent);


//            }
//        }, 1000);


    }


    private void startDummyDB() {
        UserCRUD userCRUD = UserCRUD.getInstance(this);
        if (!userCRUD.existUserManager()) {

            userCRUD.createUsuario(new UserApp(
                    1,
                    "admin",
                    "abc",
                    ConstantesLyonCRM.ID_PROFILE_MANAGER,
                    "edgar",
                    "gonzalez",
                    "galindo",
                    "12345678"
            ));
            userCRUD.createUsuario(new UserApp(
                    2,
                    "prom",
                    "abc",
                    ConstantesLyonCRM.ID_PROFILE_PROMOTOR,
                    "edgar",
                    "gonzalez",
                    "galindo",
                    "12345678"
            ));
            userCRUD.createUsuario(new UserApp(
                    3,
                    "super",
                    "abc",
                    ConstantesLyonCRM.ID_PROFILE_SUPERVISOR,
                    "edgar",
                    "gonzalez",
                    "galindo",
                    "12345678"
            ));


            VisitCRUD visitCRUD = VisitCRUD.getInstance(this);
            visitCRUD.createVisit(new Visit(
                    1,
                    "19/01/2018",
                    "Ocote 39",
                    "Soriana"
            ));

            visitCRUD.createVisit(new Visit(
                    2,
                    "20/01/2018",
                    "Av te 584",
                    "UPIICSA"
            ));

            visitCRUD.createVisit(new Visit(
                    3,
                    "26/01/2018",
                    "Pascle",
                    "Banamex"
            ));
        }


    }


    private void getIntentFromProfile(String uidFirebase) {
//        dataFirebase.child("").getDatabase().get
    }
}
