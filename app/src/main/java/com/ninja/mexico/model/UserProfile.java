package com.ninja.mexico.model;

/**
 * Created by Edgar Gonzalez on 25/01/2018.
 * Actia de Mexico S.A. de C.V..
 */

public class UserProfile {
    private int typeUser;
    private String nameType;

    public UserProfile() {
    }

    public UserProfile(int typeUser, String nameType) {
        this.typeUser = typeUser;
        this.nameType = nameType;
    }

    public int getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Override
    public String toString() {
        return getNameType();
    }
}
