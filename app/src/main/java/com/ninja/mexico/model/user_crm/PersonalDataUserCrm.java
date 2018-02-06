package com.ninja.mexico.model.user_crm;

/**
 * Created by jorge on 05/02/2018.
 */

public class PersonalDataUserCrm {
    String name;
    String lastNameOne;
    String lastNameTwo;
    String eMail;
    String position;
    String profile;
    String nickname;
    String officePhone;
    String cellPhone;
    String webSite;
    String fax;
    String birthdate;

    public PersonalDataUserCrm() {
    }

    public PersonalDataUserCrm(String name, String lastNameOne, String lastNameTwo, String eMail, String position, String profile, String nickname, String officePhone, String cellPhone, String webSite, String fax, String birthdate) {
        this.name = name;
        this.lastNameOne = lastNameOne;
        this.lastNameTwo = lastNameTwo;
        this.eMail = eMail;
        this.position = position;
        this.profile = profile;
        this.nickname = nickname;
        this.officePhone = officePhone;
        this.cellPhone = cellPhone;
        this.webSite = webSite;
        this.fax = fax;
        this.birthdate = birthdate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNameOne() {
        return lastNameOne;
    }

    public void setLastNameOne(String lastNameOne) {
        this.lastNameOne = lastNameOne;
    }

    public String getLastNameTwo() {
        return lastNameTwo;
    }

    public void setLastNameTwo(String lastNameTwo) {
        this.lastNameTwo = lastNameTwo;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
