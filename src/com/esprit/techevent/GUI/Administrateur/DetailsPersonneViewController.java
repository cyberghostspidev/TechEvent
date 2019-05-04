/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.GUI.Administrateur;

import com.esprit.techevent.entities.Categorie;
import com.esprit.techevent.entities.Personne;
import com.esprit.techevent.entities.Utilisateur;
import com.esprit.techevent.services.CategorieService;
import com.esprit.techevent.services.CategorieUtilisateurService;
import com.esprit.techevent.services.PersonneService;
import com.esprit.techevent.services.local.CategorieServiceLocal;
import com.esprit.techevent.services.local.CategorieUtilisateurServiceLocal;
import com.esprit.techevent.services.local.PersonneServiceLocal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author HP EliteBook
 */
public class DetailsPersonneViewController implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label professionLabel;
    @FXML
    private ListView<String> interetListView;
    
    private Utilisateur utilisateur;
    PersonneServiceLocal personneServiceLocal = new PersonneService();
    CategorieServiceLocal categorieServiceLocal = new CategorieService();
    CategorieUtilisateurServiceLocal categorieUtilisateurServiceLocal = new CategorieUtilisateurService();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void show() {
        Personne personne = personneServiceLocal.chercherPersonneParIdUtilisateur(utilisateur.getIdUtilisateur());
        titleLabel.setText("Infromations Personnel de " + personne.getNom() + " " + personne.getPrenom()); 
        nomLabel.setText(personne.getNom());
        prenomLabel.setText(personne.getPrenom());
        ageLabel.setText(personne.getAge() + " ans");
        professionLabel.setText(personne.getProfession());
        categorieUtilisateurServiceLocal.chercherTousCategorieDeUtilisateur(utilisateur.getIdUtilisateur())
                .forEach(categorieUtilisateur -> {
                    Categorie categorie = categorieServiceLocal.chercherCategorie(categorieUtilisateur.getIdCategorie());
                    interetListView.getItems().add(categorie.getNom());
                });
    }
}
