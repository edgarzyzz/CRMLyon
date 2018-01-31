package com.ninja.mexico.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ninja.mexico.adapters.PromotorViewPagerAdapter;
import com.ninja.mexico.adapters.VisitAdapter;
import com.ninja.mexico.database.cruds.VisitCRUD;
import com.ninja.mexico.model.Visit;
import com.ninja.mexico.ui.activity.R;

import java.util.ArrayList;


public class ListVisitFragment extends Fragment {

    private static final String ARG_TYPE_LIST = "typeListVisit";

    private int typeVisit;

//    private OnFragmentInteractionListener mListener;

    public ListVisitFragment() {
        // Required empty public constructor
    }

    public static ListVisitFragment newInstance(int typeList) {
        ListVisitFragment fragment = new ListVisitFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TYPE_LIST, typeList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
             typeVisit= getArguments().getInt(ARG_TYPE_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragment = inflater.inflate(R.layout.fragment_list_visit, container, false);
        ListView lstvVisitFrg = viewFragment.findViewById(R.id.lstvVisitFrg);

        VisitCRUD visitCRUD = VisitCRUD.getInstance(getContext());
        ArrayList<Visit> visitArrayList = null;
        visitArrayList = visitCRUD.getAllVisitByID(typeVisit);

        VisitAdapter visitAdapter = new VisitAdapter(visitArrayList,getContext());
        lstvVisitFrg.setAdapter(visitAdapter);

//        PromotorViewPagerAdapter adapterPager = new PromotorViewPagerAdapter(getFragmentManager(),getContext());
//        pagerMainPromotor.setAdapter(adapterPager);
//        tabMainPromotor.setupWithViewPager(pagerMainPromotor);


        return viewFragment;
    }


//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
