package com.ninja.mexico.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ninja.mexico.ui.activity.R;


public class AddressRegFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText etStreetAddressUser;
    private EditText etCologneAddressUser;
    private EditText etPostalCodeAddressUser;
    private EditText etOutdoorNumberAddressUser;
    private EditText etInteriorNumberAddressUser;
    private EditText etCityAddressUser;
    private EditText etStateAddressUser;
    private EditText etCountryAddressUser;

    private OnFragmentAdressListener listenerFgmntAdress;


    private String mParam1;
    private String mParam2;


    public AddressRegFragment() {
    }

    public interface OnFragmentAdressListener {
        void onFgmntAdressInteraction(Uri uri);
    }

    public static AddressRegFragment newInstance(String param1, String param2) {
        AddressRegFragment fragment = new AddressRegFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView =  inflater.inflate(R.layout.fragment_address_reg, container, false);
        etStreetAddressUser= fragmentView.findViewById(R.id.etStreetAddressUser);
        etCologneAddressUser= fragmentView.findViewById(R.id.etCologneAddressUser);
        etPostalCodeAddressUser= fragmentView.findViewById(R.id.etPostalCodeAddressUser);
        etOutdoorNumberAddressUser= fragmentView.findViewById(R.id.etOutdoorNumberAddressUser);
        etInteriorNumberAddressUser= fragmentView.findViewById(R.id.etInteriorNumberAddressUser);
        etCityAddressUser= fragmentView.findViewById(R.id.etCityAddressUser);
        etStateAddressUser= fragmentView.findViewById(R.id.etStateAddressUser);
        etCountryAddressUser= fragmentView.findViewById(R.id.etCountryAddressUser);



        return fragmentView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentAdressListener) {
            listenerFgmntAdress = (OnFragmentAdressListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listenerFgmntAdress = null;
    }
}
