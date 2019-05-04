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
    private String email;
    private String username;
    private String password;
    private Date dateInscription;
    private Date dateExpiration;
    private String type;

    public Utilisateur() {
    }

    public Utilisateur(String email, String username, String password, Date dateInscription, Date dateExpiration, String type) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateInscription = dateInscription;
        this.dateExpiration = dateExpiration;
        this.type = type;
    }

    public Utilisateur(int idUtilisateur, String email, String username, String password, Date dateInscription, Date dateExpiration, String type) {
        this.idUtilisateur = idUtilisateur;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateInscription = dateInscription;
        this.dateExpiration = dateExpiration;
        this.type = type;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}
