/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.Categorie;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface CategorieServiceLocal {

    //Default Service
    public boolean ajouterCategorie(Categorie categorie);

    public boolean supprimerCategorie(Categorie categorie);

    public boolean modifierCategorie(Categorie categorie);

    public Categorie chercherCategorie(int idCategorie);

    public int compterCategorie();

    //Added Service
}
