/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.GUI;

import com.esprit.techevent.entities.Utilisateur;
import com.esprit.techevent.utils.ConnectedUser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author HP EliteBook
 */
public class EnteteProfilViewController implements Initializable {

    @FXML
    private Label userNameLabel;
    @FXML
    private ImageView avatarImageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Utilisateur utilisateur = ConnectedUser.getInstance().getUtilisateur();
            userNameLabel.setText(utilisateur.getUsername());
            avatarImageView.setImage(new Image(new FileInputStream("C:\\WorkSpace\\TechEvent\\src\\com\\esprit\\techevent\\resources\\ImageButton\\edit.png")));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
