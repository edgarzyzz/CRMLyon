package com.ninja.mexico.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ninja.mexico.infraestructure.ConstantesLyonCRM;
import com.ninja.mexico.ui.activity.R;
import com.ninja.mexico.ui.fragments.ListVisitFragment;

/**
 * Created by Edgar Gonzalez on 25/01/2018.
 * Actia de Mexico S.A. de C.V..
 */

public class PromotorViewPagerAdapter extends FragmentStatePagerAdapter{
    private static  int TAB_COUNT =3;
    Context context;

    public PromotorViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return ListVisitFragment.newInstance(ConstantesLyonCRM.ALL_VISIT);

            case 1:
                return ListVisitFragment.newInstance(ConstantesLyonCRM.NO_VISIT);
            case 2:
                return ListVisitFragment.newInstance(25);
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return context.getString(R.string.lst_visit_title_all);
            case 1:
                return context.getString(R.string.lst_visit_title_Ok);
            case 2:
                return context.getString(R.string.lst_visit_title_no);
        }
        return super.getPageTitle(position);
    }
}
