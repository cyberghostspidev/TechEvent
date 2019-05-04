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
    private String logo;
    private String numTel;
    private int idUtilisateur;

    public Societe() {
    }

    public Societe(String raisonSociale, String adresse, String logo, String numTel, int idUtilisateur) {
        this.raisonSociale = raisonSociale;
        this.adresse = adresse;
        this.logo = logo;
        this.numTel = numTel;
        this.idUtilisateur = idUtilisateur;
    }

    public Societe(int idSociete, String raisonSociale, String adresse, String logo, String numTel, int idUtilisateur) {
        this.idSociete = idSociete;
        this.raisonSociale = raisonSociale;
        this.adresse = adresse;
        this.logo = logo;
        this.numTel = numTel;
        this.idUtilisateur = idUtilisateur;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
