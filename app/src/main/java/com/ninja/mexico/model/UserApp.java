package com.ninja.mexico.model;

/**
 * Created by Edgar Gonzalez on 12/01/2018.
 * Actia de Mexico S.A. de C.V..
 */

public class UserApp {
    private int idUsuario;
    private String nickname;
    private String password;
    private int id_profile;
    private String name;
    private String last_name_p;
    private String last_name_m;
    private String phone;

    public UserApp() {
    }

    public UserApp(int idUsuario, String nickname, String password, int id_profile, String name, String last_name_p, String last_name_m, String phone) {
        this.idUsuario = idUsuario;
        this.nickname = nickname;
        this.password = password;
        this.id_profile = id_profile;
        this.name = name;
        this.last_name_p = last_name_p;
        this.last_name_m = last_name_m;
        this.phone = phone;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_profile() {
        return id_profile;
    }

    public void setId_profile(int id_profile) {
        this.id_profile = id_profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name_p() {
        return last_name_p;
    }

    public void setLast_name_p(String last_name_p) {
        this.last_name_p = last_name_p;
    }

    public String getLast_name_m() {
        return last_name_m;
    }

    public void setLast_name_m(String last_name_m) {
        this.last_name_m = last_name_m;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
