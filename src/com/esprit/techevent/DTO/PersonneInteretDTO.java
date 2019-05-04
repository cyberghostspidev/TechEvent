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
public class PersonneInteretDTO {

    private int ordre;
    private String nomInteret;
    private int nbPersonne;

    public PersonneInteretDTO() {
    }

    public PersonneInteretDTO(int ordre, String nomInteret, int nbPersonne) {
        this.ordre = ordre;
        this.nomInteret = nomInteret;
        this.nbPersonne = nbPersonne;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public String getNomInteret() {
        return nomInteret;
    }

    public void setNomInteret(String nomInteret) {
        this.nomInteret = nomInteret;
    }

    public int getNbPersonne() {
        return nbPersonne;
    }

    public void setNbPersonne(int nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

}
