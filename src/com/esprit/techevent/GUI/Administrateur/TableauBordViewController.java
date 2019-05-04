/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.GUI.Administrateur;

import com.esprit.techevent.DTO.EvenementCategorieDTO;
import com.esprit.techevent.DTO.PersonneInteretDTO;
import com.esprit.techevent.DTO.SocieteDomaineDTO;
import com.esprit.techevent.services.CategorieService;
import com.esprit.techevent.services.EvenementService;
import com.esprit.techevent.services.PersonneService;
import com.esprit.techevent.services.SocieteService;
import com.esprit.techevent.services.local.CategorieServiceLocal;
import com.esprit.techevent.services.local.EvenementServiceLocal;
import com.esprit.techevent.services.local.PersonneServiceLocal;
import com.esprit.techevent.services.local.SocieteServiceLocal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author HP EliteBook
 */
public class TableauBordViewController implements Initializable {

    @FXML
    private Label nbTotalEvenementsLabel;
    @FXML
    private Label maxCategorieLabel;
    @FXML
    private Label minCategorieLabel;
    @FXML
    private Label nbTotalParticipantsLabel;
    @FXML
    private Label maxInteretLabel;
    @FXML
    private Label minInteretLabel;
    @FXML
    private Label nbTotalOrganisateursLabel;
    @FXML
    private Label maxDomaineLabel;
    @FXML
    private Label minDomaineLabel;
    @FXML
    private PieChart evenementsGroupesPieChart;
    @FXML
    private PieChart participantsGroupesPieChart;
    @FXML
    private PieChart organisateursGroupesPieChart;

    CategorieServiceLocal categorieServiceLocal = new CategorieService();
    EvenementServiceLocal evenementServiceLocal = new EvenementService();
    PersonneServiceLocal personneServiceLocal = new PersonneService();
    SocieteServiceLocal societeServiceLocal = new SocieteService();
    int nbCategories = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nbCategories = categorieServiceLocal.compterCategorie();

        //Evenements
        setNombreTotalEvenements();
        setNombreEvenementsParCategories();
        setCategorieDominante();
        setCategorieIgnoree();

        //Pariticipants
        setNombreTotalParticipants();
        setCategoriePlusInteressee();
        setCategorieMoinsInteressee();
        setNombrePersonneParCategories();

        //Organisateurs
        setNombreTotalOrganisateurs();
        setCategoriePlusOrganisee();
        setCategorieMoinsOrganisee();
        setNombreSocietesParCategories();
    }

    private void setNombreTotalEvenements() {
        int nbEvenements = evenementServiceLocal.compterEvenement();
        nbTotalEvenementsLabel.setText(nbTotalEvenementsLabel.getText() + " " + nbEvenements + " événement(s)");
    }

    private void setCategorieDominante() {
        EvenementCategorieDTO categorie = evenementServiceLocal.chercherCategorieDominante();
        maxCategorieLabel.setText(maxCategorieLabel.getText() + " " + categorie.getNomCategorie());
    }

    private void setCategorieIgnoree() {
        if (nbCategories > 1) {
            EvenementCategorieDTO categorie = evenementServiceLocal.chercherCategorieIgnoree();
            minCategorieLabel.setText(minCategorieLabel.getText() + " " + categorie.getNomCategorie());
        } else {
            minCategorieLabel.setText("N/A");
        }
    }

    private void setNombreEvenementsParCategories() {
        List<EvenementCategorieDTO> nbEvenements = evenementServiceLocal.compterEvenementsParCategorie();
        if (nbEvenements != null && !nbEvenements.isEmpty()) {
            ObservableList<PieChart.Data> pieChartDatas = nbEvenements.stream().map(evenement -> new PieChart.Data(evenement.getNomCategorie(), Double.parseDouble(evenement.getNbEvenement() + ""))).collect(Collectors.collectingAndThen(Collectors.toList(), l -> FXCollections.observableArrayList(l)));
            evenementsGroupesPieChart.setData(pieChartDatas);
        }
    }

    private void setNombreTotalParticipants() {
        int nbParticipants = personneServiceLocal.compterPersonne();
        nbTotalParticipantsLabel.setText(nbTotalParticipantsLabel.getText() + " " + nbParticipants + " participant(s)");
    }

    private void setCategoriePlusInteressee() {
        PersonneInteretDTO interet = personneServiceLocal.chercherCategoriePlusInteressee();
        maxInteretLabel.setText(maxInteretLabel.getText() + " " + interet.getNomInteret());
    }

    private void setCategorieMoinsInteressee() {
        if (nbCategories > 1) {
            PersonneInteretDTO interet = personneServiceLocal.chercherCategorieMoinsInteressee();
            minInteretLabel.setText(minInteretLabel.getText() + " " + interet.getNomInteret());
        } else {
            minInteretLabel.setText("N/A");
        }
    }

    private void setNombrePersonneParCategories() {
        List<PersonneInteretDTO> nbPersonnes = personneServiceLocal.compterPersonnesParInterets();
        if (nbPersonnes != null && !nbPersonnes.isEmpty()) {
            ObservableList<PieChart.Data> pieChartDatas = nbPersonnes.stream().map(personne -> new PieChart.Data(personne.getNomInteret(), Double.parseDouble(personne.getNbPersonne() + ""))).collect(Collectors.collectingAndThen(Collectors.toList(), l -> FXCollections.observableArrayList(l)));
            participantsGroupesPieChart.setData(pieChartDatas);
        }
    }

    private void setNombreTotalOrganisateurs() {
        int nbOrganisateurs = societeServiceLocal.compterSociete();
        nbTotalOrganisateursLabel.setText(nbTotalOrganisateursLabel.getText() + " " + nbOrganisateurs + " organisateur(s)");
    }

    private void setCategoriePlusOrganisee() {
        SocieteDomaineDTO domaine = societeServiceLocal.chercherCategoriePlusOrganisee();
        maxDomaineLabel.setText(maxDomaineLabel.getText() + " " + domaine.getNomDomaine());
    }

    private void setCategorieMoinsOrganisee() {
        if (nbCategories > 1) {
            SocieteDomaineDTO domaine = societeServiceLocal.chercherCategorieMoinsOrganisee();
            minDomaineLabel.setText(minDomaineLabel.getText() + " " + domaine.getNomDomaine());
        } else {
            minDomaineLabel.setText("N/A");
        }
    }

    private void setNombreSocietesParCategories() {
        List<SocieteDomaineDTO> nbSocietes = societeServiceLocal.compterSocieteParDomaine();
        if (nbSocietes != null && !nbSocietes.isEmpty()) {
            ObservableList<PieChart.Data> pieChartDatas = nbSocietes.stream().map(societe -> new PieChart.Data(societe.getNomDomaine(), Double.parseDouble(societe.getNbSociete() + ""))).collect(Collectors.collectingAndThen(Collectors.toList(), l -> FXCollections.observableArrayList(l)));
            organisateursGroupesPieChart.setData(pieChartDatas);
        }
    }

}
