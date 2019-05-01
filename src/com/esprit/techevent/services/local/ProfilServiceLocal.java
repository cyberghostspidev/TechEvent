/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.Profil;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface ProfilServiceLocal {

    //Default Service
    public boolean ajouterProfil(Profil profil);

    public boolean supprimerProfil(Profil profil);

    public boolean modifierProfil(Profil profil);

    public Profil chercherProfil(int idProfil);

    public int compterProfil();

    //Added Service
}
