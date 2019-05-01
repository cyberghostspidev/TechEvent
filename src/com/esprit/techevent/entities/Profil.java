/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.entities;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class Profil {

    private int idProfil;
    private String code;
    private String description;
    private int nature;

    public Profil() {
    }

    public Profil(String codeProfil, String descriptionProfil, int nature) {
        this.code = codeProfil;
        this.description = descriptionProfil;
        this.nature = nature;
    }

    public Profil(int idProfil, String code, String description, int nature) {
        this.idProfil = idProfil;
        this.code = code;
        this.description = description;
        this.nature = nature;
    }

    public int getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(int idProfil) {
        this.idProfil = idProfil;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

}
