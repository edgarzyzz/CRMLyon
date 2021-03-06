package com.ninja.mexico.model.user_crm;

/**
 * Created by jorge on 05/02/2018.
 */

public class RegionalConfigurationUserCrm {
    String language;
    String regionalConfigCountry;
    String timeFormat;
    String timeZone;

    public RegionalConfigurationUserCrm() {
    }

    public RegionalConfigurationUserCrm(String language, String regionalConfigCountry, String timeFormat, String timeZone) {
        this.language = language;
        this.regionalConfigCountry = regionalConfigCountry;
        this.timeFormat = timeFormat;
        this.timeZone = timeZone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegionalConfigCountry() {
        return regionalConfigCountry;
    }

    public void setRegionalConfigCountry(String regionalConfigCountry) {
        this.regionalConfigCountry = regionalConfigCountry;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
