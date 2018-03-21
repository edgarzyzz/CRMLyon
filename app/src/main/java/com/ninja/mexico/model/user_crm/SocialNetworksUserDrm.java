package com.ninja.mexico.model.user_crm;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by jorge on 05/02/2018.
 */

public class SocialNetworksUserDrm implements Serializable {
    String facebook;
    String twitter;
    String instagram;
    String google;

    public SocialNetworksUserDrm() {
    }

    public SocialNetworksUserDrm(String facebook, String twitter, String instagram, String google) {
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
        this.google = google;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }
}
