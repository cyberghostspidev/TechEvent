/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.SponsorEvenement;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface SponsorEvenementServiceLocal {

    //Default Service
    public boolean ajouterSponsorEvenement(SponsorEvenement sponsorEvenement);

    public boolean supprimerSponsorEvenement(SponsorEvenement sponsorEvenement);

    public SponsorEvenement chercherSponsorEvenement(int idSponsor, int idEvenement);

    public int compterSponsorEvenement();

    //Added Service
}
