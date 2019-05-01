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
public class CategorieUtilisateur {

    private int idCategorie;
    private int idUtilisateur;

    public CategorieUtilisateur() {
    }

    public CategorieUtilisateur(int idCategorie, int idUtilisateur) {
        this.idCategorie = idCategorie;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
