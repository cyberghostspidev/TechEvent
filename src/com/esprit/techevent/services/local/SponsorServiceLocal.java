/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.Sponsor;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface SponsorServiceLocal {
    
    //Default Service
    public boolean ajouterSponsor(Sponsor sponsor);

    public boolean supprimerSponsor(Sponsor sponsor);

    public boolean modifierSponsor(Sponsor sponsor);

    public Sponsor chercherSponsor(int idSponsor);

    public int compterSponsor();

    //Added Service
}
