/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.DTO;

/**
 *
 * @author HP EliteBook
 */
public class EvenementCategorieDTO {

    private int ordre;
    private String nomCategorie;
    private int nbEvenement;

    public EvenementCategorieDTO() {
    }

    public EvenementCategorieDTO(int ordre, String nomCategorie, int nbEvenement) {
        this.ordre = ordre;
        this.nomCategorie = nomCategorie;
        this.nbEvenement = nbEvenement;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public int getNbEvenement() {
        return nbEvenement;
    }

    public void setNbEvenement(int nbEvenement) {
        this.nbEvenement = nbEvenement;
    }

    
}
