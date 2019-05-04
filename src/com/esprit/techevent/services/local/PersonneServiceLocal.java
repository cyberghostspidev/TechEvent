/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.DTO.PersonneInteretDTO;
import com.esprit.techevent.entities.Personne;
import java.util.List;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface PersonneServiceLocal {

    //Default Service
    public boolean ajouterPersonne(Personne personne);

    public boolean supprimerPersonne(Personne personne);

    public boolean modifierPersonne(Personne personne);

    public Personne chercherPersonne(int idPersonne);

    public int compterPersonne();

    //Added Service
    public Personne chercherPersonneParIdUtilisateur(int idUtilisateur);

    public List<PersonneInteretDTO> compterPersonnesParInterets();

    public PersonneInteretDTO chercherCategoriePlusInteressee();

    public PersonneInteretDTO chercherCategorieMoinsInteressee();
}
