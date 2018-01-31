package com.ninja.mexico.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.ninja.mexico.adapters.PromotorViewPagerAdapter;
import com.ninja.mexico.adapters.VisitAdapter;
import com.ninja.mexico.database.cruds.VisitCRUD;
import com.ninja.mexico.model.Visit;

import java.util.ArrayList;


public class MainPromotorActivity extends AppCompatActivity {
    DrawerLayout drawerLytPromotor;
    NavigationView navigationViewPromotor;
    TabLayout tabMainPromotor;
    ViewPager pagerMainPromotor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_promotor);

        Toolbar toolbar = findViewById(R.id.toolbarLyon);
        navigationViewPromotor= findViewById(R.id.navigationViewMainPromotor);
        drawerLytPromotor= findViewById(R.id.drawerLytPromotor);
        tabMainPromotor = findViewById(R.id.tabMainPromotor);
        pagerMainPromotor = findViewById(R.id.pagerMainPromotor);
        setSupportActionBar(toolbar);


//        for (int x=0;x<visitArrayList.size();x++){
//            System.out.println(visitArrayList.get(x).getCompanyName());
//        }

//        ListView visiView = findViewById(R.id.visitList);


//        ArrayAdapter<Visit> adapterVisit = new ArrayAdapter<Visit>(this, android.R.layout.simple_list_item_1, visitArrayList);
//        visiView.setAdapter(adapterVisit);
//        VisitAdapter visitAdapter = new VisitAdapter(visitArrayList,this);
//        visiView.setAdapter(visitAdapter);


        PromotorViewPagerAdapter adapterPager = new PromotorViewPagerAdapter(getSupportFragmentManager(),getBaseContext());
        pagerMainPromotor.setAdapter(adapterPager);
        tabMainPromotor.setupWithViewPager(pagerMainPromotor);
        boolean abc =false;


    }
}
