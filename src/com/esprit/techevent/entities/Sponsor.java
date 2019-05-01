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
public class Sponsor {
    private int idSponsor;
    private String nom;
    private String affiche;

    public Sponsor() {
    }

    public Sponsor(String nom, String affiche) {
        this.idSponsor = idSponsor;
        this.nom = nom;
        this.affiche = affiche;
    }
    public Sponsor(int idSponsor, String nom, String affiche) {
        this.idSponsor = idSponsor;
        this.nom = nom;
        this.affiche = affiche;
    }

    public int getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(int idSponsor) {
        this.idSponsor = idSponsor;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }
 
    
    
}
