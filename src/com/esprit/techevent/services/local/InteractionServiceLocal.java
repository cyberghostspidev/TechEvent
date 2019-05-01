/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.Interaction;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface InteractionServiceLocal {

    //Default Service
    public boolean ajouterInteraction(Interaction interaction);

    public boolean supprimerInteraction(Interaction interaction);

    public boolean modifierInteraction(Interaction interaction);

    public Interaction chercherInteraction(int idInteraction);

    public int compterInteraction();

    //Added Service
}
