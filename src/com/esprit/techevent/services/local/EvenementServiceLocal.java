/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.Evenement;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface EvenementServiceLocal {

    //Default Service
    public boolean ajouterEvenement(Evenement evenement);

    public boolean supprimerEvenement(Evenement evenement);

    public boolean modifierEvenement(Evenement evenement);

    public Evenement chercherEvenement(int idEvenement);

    public int compterEvenement();

    //Added Service
}
