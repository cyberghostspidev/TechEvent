/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.Societe;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface SocieteServiceLocal {

    //Default Service
    public boolean ajouterSociete(Societe societe);

    public boolean supprimerSociete(Societe societe);

    public boolean modifierSociete(Societe societe);

    public Societe chercherSociete(int idSociete);

    public int compterSociete();

    //Added Service
}
