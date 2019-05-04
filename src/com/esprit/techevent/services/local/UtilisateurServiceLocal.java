/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.Utilisateur;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface UtilisateurServiceLocal {

    //Default Service
    public boolean ajouterUtilisateur(Utilisateur utilisateur);

    public boolean supprimerUtilisateur(Utilisateur utilisateur);

    public boolean modifierUtilisateur(Utilisateur utilisateur);

    public Utilisateur chercherUtilisateur(int idUtilisateur);

    public int compterUtilisateur();

    //Added Service
    public Utilisateur chercherUtilisateurParUsernameEtPassword(String username, String password);

    public List<Utilisateur> chercherTousUtilisateurs();

    public List<Utilisateur> chercherTousPersonnes();

    public List<Utilisateur> chercherTousSocietes();

//    public List<Utilisateur> modifierDateExpirationUtilisateur(Date dateExpiration);
}
