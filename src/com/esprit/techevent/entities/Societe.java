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
public class Societe {

    private int idSociete;
    private String raisonSociale;
    private String adresse;
    private String numTel;
    
    public Societe() {
    }

    public Societe(String raisonSociale, String adresse, String numTel) {
        this.raisonSociale = raisonSociale;
        this.adresse = adresse;
    }

    public Societe(int idSociete, String raisonSociale, String adresse, String numTel) {
        this.idSociete = idSociete;
        this.raisonSociale = raisonSociale;
        this.adresse = adresse;
        this.numTel = this.numTel;
    }

    public int getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(int idSociete) {
        this.idSociete = idSociete;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

}
