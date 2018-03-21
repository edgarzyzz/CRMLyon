package com.ninja.mexico.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ninja.mexico.model.user_crm.SocialNetworksUserDrm;
import com.ninja.mexico.ui.activity.R;



public class SocialNetworkRegFragment extends Fragment {
    private static final String ARG_SOCIAL = "arg_social";

    private SocialNetworksUserDrm socialNetworksUserDrm;


    private TextView etFacebookSocialNetReg;
    private TextView etTwitterSocialNetReg;
    private TextView etInstagramSocialNetReg;
    private TextView etGoogleSocialNetReg;
    private Button btnBackSocial;
    private Button btnNextSocial;

    private OnFragmentSocialListener mListener;



    public SocialNetworkRegFragment() {
    }


    public interface OnFragmentSocialListener {
        void onFgmntSocialInteraction(boolean isBackPressed, SocialNetworksUserDrm dataSocialUser);

    }

    public static SocialNetworkRegFragment newInstance(SocialNetworkRegFragment dataRegisteredSocial) {
        SocialNetworkRegFragment fragment = new SocialNetworkRegFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_SOCIAL, (Parcelable) dataRegisteredSocial);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            socialNetworksUserDrm = (SocialNetworksUserDrm) getArguments().getSerializable(ARG_SOCIAL);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragment = inflater.inflate(R.layout.fragment_social_network_reg, container, false);
        etFacebookSocialNetReg = viewFragment.findViewById(R.id.etFacebookSocialNetReg);
        etTwitterSocialNetReg = viewFragment.findViewById(R.id.etTwitterSocialNetReg);
        etInstagramSocialNetReg = viewFragment.findViewById(R.id.etInstagramSocialNetReg);
        etGoogleSocialNetReg = viewFragment.findViewById(R.id.etGoogleSocialNetReg);
        btnBackSocial = viewFragment.findViewById(R.id.btnBackSocial);
        btnNextSocial = viewFragment.findViewById(R.id.btnNextSocial);

        btnBackSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SocialNetworksUserDrm dataSocialUser =  new SocialNetworksUserDrm(
                        etFacebookSocialNetReg.getText().toString(),
                        etTwitterSocialNetReg.getText().toString(),
                        etInstagramSocialNetReg.getText().toString(),
                        etGoogleSocialNetReg.getText().toString()
                );

                mListener.onFgmntSocialInteraction(true,dataSocialUser);
            }
        });

        btnNextSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SocialNetworksUserDrm dataSocialUser =  new SocialNetworksUserDrm(
                        etFacebookSocialNetReg.getText().toString(),
                        etTwitterSocialNetReg.getText().toString(),
                        etInstagramSocialNetReg.getText().toString(),
                        etGoogleSocialNetReg.getText().toString()
                );

                mListener.onFgmntSocialInteraction(false,dataSocialUser);
            }
        });

        if (mListener != null) {
            SocialNetworksUserDrm dataSocialUser =  new SocialNetworksUserDrm(
                    etFacebookSocialNetReg.getText().toString(),
                    etTwitterSocialNetReg.getText().toString(),
                    etInstagramSocialNetReg.getText().toString(),
                    etGoogleSocialNetReg.getText().toString()
            );

            mListener.onFgmntSocialInteraction(true,dataSocialUser);
        }
        return viewFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentSocialListener) {
            mListener = (OnFragmentSocialListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
