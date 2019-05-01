/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.CategorieUtilisateur;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface CategorieUtilisateurServiceLocal {

    //Default Service
    public boolean ajouterCategorieUtilisateur(CategorieUtilisateur categorieUtilisateur);

    public boolean supprimerCategorieUtilisateur(CategorieUtilisateur categorieUtilisateur);

    public CategorieUtilisateur chercherCategorieUtilisateur(int idCategorie, int idUtilisateur);

    public int compterCategorieUtilisateur();

    //Added Service
}
