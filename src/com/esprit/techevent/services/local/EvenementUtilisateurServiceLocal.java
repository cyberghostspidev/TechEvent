/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.EvenementUtilisateur;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface EvenementUtilisateurServiceLocal {
    
    //Default Service
    public boolean ajouterEvenementUtilisateur(EvenementUtilisateur evenementUtilisateur);

    public boolean supprimerEvenementUtilisateur(EvenementUtilisateur evenementUtilisateur);

    public EvenementUtilisateur chercherEvenementUtilisateur(int idEvenement, int idUtilisateur);

    public int compterEvenementUtilisateur();

    //Added Service 
}
