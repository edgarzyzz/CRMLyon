package com.ninja.mexico.model.user_crm;

/**
 * Created by jorge on 05/02/2018.
 */

public class AddressUserCrm {
    String street;
    String cologne;
    String postalCode;
    String outdoorNumber;
    String interiorNumber;
    String city;
    String state;
    String country;

    public AddressUserCrm() {
    }

    public AddressUserCrm(String street, String cologne, String postalCode, String outdoorNumber, String interiorNumber, String city, String state, String country) {
        this.street = street;
        this.cologne = cologne;
        this.postalCode = postalCode;
        this.outdoorNumber = outdoorNumber;
        this.interiorNumber = interiorNumber;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCologne() {
        return cologne;
    }

    public void setCologne(String cologne) {
        this.cologne = cologne;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getOutdoorNumber() {
        return outdoorNumber;
    }

    public void setOutdoorNumber(String outdoorNumber) {
        this.outdoorNumber = outdoorNumber;
    }

    public String getInteriorNumber() {
        return interiorNumber;
    }

    public void setInteriorNumber(String interiorNumber) {
        this.interiorNumber = interiorNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
