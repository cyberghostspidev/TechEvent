/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.GUI.Administrateur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TabPane;

/**
 * FXML Controller class
 *
 * @author Yacine Ben Ouirane
 */
public class MenuTabPaneViewController implements Initializable {

    @FXML
    private TabPane menuTabPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Parent tableauBord = FXMLLoader.load(getClass().getResource("TableauBordView.fxml"));
            Parent gestionEvenenments = FXMLLoader.load(getClass().getResource("GestionEvenementsView.fxml"));
            Parent gestionUtilisateurs = FXMLLoader.load(getClass().getResource("GestionUtilisateursView.fxml"));
            menuTabPane.getTabs().get(0).setContent(tableauBord);
            menuTabPane.getTabs().get(1).setContent(gestionEvenenments);
            menuTabPane.getTabs().get(2).setContent(gestionUtilisateurs);
        } catch (IOException ex) {

        }
    }

}
