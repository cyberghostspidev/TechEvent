/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.GUI.Administrateur;

import com.esprit.techevent.entities.Categorie;
import com.esprit.techevent.entities.Societe;
import com.esprit.techevent.entities.Utilisateur;
import com.esprit.techevent.services.CategorieService;
import com.esprit.techevent.services.CategorieUtilisateurService;
import com.esprit.techevent.services.SocieteService;
import com.esprit.techevent.services.local.CategorieServiceLocal;
import com.esprit.techevent.services.local.CategorieUtilisateurServiceLocal;
import com.esprit.techevent.services.local.SocieteServiceLocal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author HP EliteBook
 */
public class DetailsSocieteViewController implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private Label raisonSocialeLabel;
    @FXML
    private Label adresseLabel;
    @FXML
    private Label numTelLabel;
    @FXML
    private Label domaineLabel;

    private Utilisateur utilisateur;
    SocieteServiceLocal societeServiceLocal = new SocieteService();
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
        Societe societe = societeServiceLocal.chercherSocieteParIdUtilisateur(utilisateur.getIdUtilisateur());
        titleLabel.setText("Infromations de Societe " + societe.getRaisonSociale());
        raisonSocialeLabel.setText(societe.getRaisonSociale());
        adresseLabel.setText(societe.getAdresse());
        numTelLabel.setText(societe.getNumTel());
        int idCategorie = categorieUtilisateurServiceLocal
                .chercherTousCategorieDeUtilisateur(utilisateur.getIdUtilisateur())
                .get(0).getIdCategorie();
        Categorie categorie = categorieServiceLocal
                .chercherCategorie(idCategorie);
        domaineLabel.setText(categorie.getNom());
    }

}
