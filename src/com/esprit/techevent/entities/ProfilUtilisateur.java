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
public class ProfilUtilisateur {

    private int idProfil;
    private int idUtilisateur;

    public ProfilUtilisateur() {
    }

    public ProfilUtilisateur(int idProfil, int idUtilisateur) {
        this.idProfil = idProfil;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(int idProfil) {
        this.idProfil = idProfil;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
