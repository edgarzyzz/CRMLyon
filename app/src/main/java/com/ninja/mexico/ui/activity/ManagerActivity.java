package com.ninja.mexico.ui.activity;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.ninja.mexico.ui.fragments.RegisterVisitFragment;
import com.ninja.mexico.ui.fragments.RegistrationUserFragment;

public class ManagerActivity extends AppCompatActivity   {
    DrawerLayout drawerLytManager;
    NavigationView navigationViewManager;

    NavigationView.OnNavigationItemSelectedListener navigationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        Toolbar toolbar = findViewById(R.id.toolbarLyon);
        setSupportActionBar(toolbar);

        drawerLytManager = findViewById(R.id.drawerLytManager);
        navigationViewManager = findViewById(R.id.navigationViewManager);
        navigationListener =  new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                Class fragmentClass = null;
                switch (item.getItemId()){
                    case R.id.mn_profile_man:
//                        fragmentClass = .class;
                        break;
                    case R.id.mn_visit_man:
                        fragmentClass = RegisterVisitFragment.class;
                        break;
                    case R.id.mn_user_man:
                        fragmentClass = RegistrationUserFragment.class;
                        break;
                    case R.id.mn_sesion_man:
//                        fragmentClass = .class;
                        break;
                    default:
                        break;
                }

                try {
                    if (fragmentClass!=null){
                        fragment = (Fragment) fragmentClass.newInstance();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.fLytContainerManager, fragment).commit();
                    }

                    item.setCheckable(true);
                    setTitle(item.getTitle());
                    drawerLytManager.closeDrawers();

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                return true;
            }
        };

        navigationViewManager.inflateMenu(R.menu.menu_manager);
        navigationViewManager.setNavigationItemSelectedListener(navigationListener);

        ActionBar actionBar =  getSupportActionBar();
        if (actionBar!=null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLytManager.openDrawer(Gravity.START);
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }



}
