package com.ninja.mexico.model;

/**
 * Created by jorge on 20/01/2018.
 */

public class Visit {
    private int idVisita;
    private String scheduledDate;
    private String adress;
    private String companyName;

    public Visit(int idVisita, String scheduledDate, String adress, String companyName) {
        this.idVisita = idVisita;
        this.scheduledDate = scheduledDate;
        this.adress = adress;
        this.companyName = companyName;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {

        String datosVisita =getIdVisita()+"   "+ getScheduledDate()+"   "+ getAdress()+"   "+ getCompanyName();
        return datosVisita;
    }
}
