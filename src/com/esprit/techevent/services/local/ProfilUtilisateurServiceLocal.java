/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.ProfilUtilisateur;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface ProfilUtilisateurServiceLocal {

    //Default Service
    public boolean ajouterProfilUtilisateur(ProfilUtilisateur categorieUtilisateur);

    public boolean supprimerProfilUtilisateur(ProfilUtilisateur categorieUtilisateur);

    public ProfilUtilisateur chercherProfilUtilisateur(int idProfil, int idUtilisateur);

    public int compterProfilUtilisateur();
    
    //Added Service
    public ProfilUtilisateur chercherProfilUtilisateurParIdUtilisateur(int idUtilisateur);
}
