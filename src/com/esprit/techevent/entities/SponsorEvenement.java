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
public class SponsorEvenement {

    private int idSponsor;
    private int idEvenement;

    public SponsorEvenement() {
    }

    public SponsorEvenement(int idSponsor, int idEvenement) {
        this.idSponsor = idSponsor;
        this.idEvenement = idEvenement;
    }

    public int getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(int idSponsor) {
        this.idSponsor = idSponsor;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

}
