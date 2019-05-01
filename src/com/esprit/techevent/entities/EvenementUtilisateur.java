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
public class EvenementUtilisateur {

    private int idEvenement;
    private int idUtilisateur;

    public EvenementUtilisateur() {
    }

    public EvenementUtilisateur(int idEvenement, int idUtilisateur) {
        this.idEvenement = idEvenement;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

}
