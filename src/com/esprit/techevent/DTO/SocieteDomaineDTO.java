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
public class SocieteDomaineDTO {

    private int ordre;
    private String nomDomaine;
    private int nbSociete;

    public SocieteDomaineDTO() {
    }

    public SocieteDomaineDTO(int ordre, String nomDomaine, int nbSociete) {
        this.ordre = ordre;
        this.nomDomaine = nomDomaine;
        this.nbSociete = nbSociete;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public String getNomDomaine() {
        return nomDomaine;
    }

    public void setNomDomaine(String nomDomaine) {
        this.nomDomaine = nomDomaine;
    }

    public int getNbSociete() {
        return nbSociete;
    }

    public void setNbSociete(int nbSociete) {
        this.nbSociete = nbSociete;
    }

}
