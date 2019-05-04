/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.GUI;

import com.esprit.techevent.utils.ConnectedUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author HP EliteBook
 */
public class GeneralGridPaneViewController implements Initializable {

    @FXML
    private GridPane grilleGridPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            grilleGridPane.add(FXMLLoader.load(getClass().getResource("EnteteProfilView.fxml")), 0, 0);
            switch (ConnectedUser.getInstance().getProfil().getCode()) {
                case "ADMIN":
                    grilleGridPane.add(FXMLLoader.load(getClass().getResource("Administrateur/MenuTabPaneView.fxml")), 0, 1);
                    break;
                case "PARTICIPANT":
                    grilleGridPane.add(FXMLLoader.load(getClass().getResource("Participant/MenuTabPaneView.fxml")), 0, 1);
                    break;
                case "ORGANISATEUR":
                    grilleGridPane.add(FXMLLoader.load(getClass().getResource("Organisateur/MenuTabPaneView.fxml")), 0, 1);
                    break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
