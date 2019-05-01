/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.entities;

import java.sql.Date;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class Evenement {

    private int idEvenement;
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String affiche;
    private String sponsor;
    private String afficheSponsor;
    private String observation;
    private boolean validite;
    private boolean cloture;
    private int idLocalisation;
    private int idCategorie;

    public Evenement() {
    }

    public Evenement(int idEvenement, String nom, String description, Date dateDebut, Date dateFin, String affiche, String sponsor, String afficheSponsor, String observation, boolean validite, boolean cloture, int idLocalisation, int idCategorie) {
        this.idEvenement = idEvenement;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.affiche = affiche;
        this.sponsor = sponsor;
        this.afficheSponsor = afficheSponsor;
        this.observation = observation;
        this.validite = validite;
        this.cloture = cloture;
        this.idLocalisation = idLocalisation;
        this.idCategorie = idCategorie;
    }

    public Evenement(String nom, String description, Date dateDebut, Date dateFin, String affiche, String sponsor, String afficheSponsor, String observation, boolean validite, boolean cloture, int idLocalisation, int idCategorie) {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.affiche = affiche;
        this.sponsor = sponsor;
        this.afficheSponsor = afficheSponsor;
        this.observation = observation;
        this.validite = validite;
        this.cloture = cloture;
        this.idLocalisation = idLocalisation;
        this.idCategorie = idCategorie;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getAfficheSponsor() {
        return afficheSponsor;
    }

    public void setAfficheSponsor(String afficheSponsor) {
        this.afficheSponsor = afficheSponsor;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public boolean getValidite() {
        return validite;
    }

    public void setValidite(boolean validite) {
        this.validite = validite;
    }

    public boolean getCloture() {
        return cloture;
    }

    public void setCloture(boolean cloture) {
        this.cloture = cloture;
    }

    public int getIdLocalisation() {
        return idLocalisation;
    }

    public void setIdLocalisation(int idLocalisation) {
        this.idLocalisation = idLocalisation;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

}
