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
public class Utilisateur {

    private int idUtilisateur;
    private String username;
    private String password;
    private String email;
    private Date dateInscription;
    private Date dateExpiration;
    private String type;
    private int idPersonne;
    private int idSociete;

    public Utilisateur() {
    }

    public Utilisateur(String username, String password, String email, Date dateInscription, Date dateExpiration, String type, int idPersonne, int idSociete) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateInscription = dateInscription;
        this.dateExpiration = dateExpiration;
        this.type = type;
        this.idPersonne = idPersonne;
        this.idSociete = idSociete;
    }

    public Utilisateur(int idUtilisateur, String username, String password, String email, Date dateInscription, Date dateExpiration, String type, int idPersonne, int idSociete) {
        this.idUtilisateur = idUtilisateur;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateInscription = dateInscription;
        this.dateExpiration = dateExpiration;
        this.type = type;
        this.idPersonne = idPersonne;
        this.idSociete = idSociete;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public int getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(int idSociete) {
        this.idSociete = idSociete;
    }
}
