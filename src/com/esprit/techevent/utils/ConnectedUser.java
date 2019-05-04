/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.utils;

import com.esprit.techevent.entities.Profil;
import com.esprit.techevent.entities.Utilisateur;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class ConnectedUser {

    private Utilisateur utilisateur;
    private Profil profil;
    private static ConnectedUser connectedUser;

    private ConnectedUser() {

    }

    public static ConnectedUser getInstance() {
        if (connectedUser == null) {
            connectedUser = new ConnectedUser();
        }
        return connectedUser;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
}
