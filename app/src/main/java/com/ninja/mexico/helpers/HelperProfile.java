package com.ninja.mexico.helpers;

import com.ninja.mexico.model.UserProfile;

import java.util.ArrayList;

/**
 * Created by Edgar Gonzalez on 25/01/2018.
 * Actia de Mexico S.A. de C.V..
 */

public class HelperProfile {
    private static ArrayList<UserProfile> profiles = null;

    public static ArrayList<UserProfile> getListProfiles(){
        if (profiles==null){
            profiles= new ArrayList<>();
            profiles.add(new UserProfile(1, "Manager"));
            profiles.add(new UserProfile(2, "Supervisor"));
            profiles.add(new UserProfile(3, "Promotor"));
        }
        return profiles;
    }
}
