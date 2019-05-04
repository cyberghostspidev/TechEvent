/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.GUI;

import com.esprit.techevent.entities.Profil;
import com.esprit.techevent.entities.ProfilUtilisateur;
import java.net.URL;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import com.esprit.techevent.entities.Utilisateur;
import com.esprit.techevent.services.ProfilService;
import com.esprit.techevent.services.ProfilUtilisateurService;
import com.esprit.techevent.services.UtilisateurService;
import com.esprit.techevent.services.local.ProfilServiceLocal;
import com.esprit.techevent.services.local.ProfilUtilisateurServiceLocal;
import com.esprit.techevent.services.local.UtilisateurServiceLocal;
import com.esprit.techevent.utils.ConnectedUser;
import com.esprit.techevent.utils.PrincipalStage;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yacine Ben Ouirane
 */
public class AuthentificationViewController implements Initializable {

    @FXML
    private TextField userNameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    private UtilisateurServiceLocal utilisateurServiceLocal;
    private ProfilServiceLocal profilServiceLocal;
    private ProfilUtilisateurServiceLocal profilUtilisateurServiceLocal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utilisateurServiceLocal = new UtilisateurService();
        profilServiceLocal = new ProfilService();
        profilUtilisateurServiceLocal = new ProfilUtilisateurService();
    }

    @FXML
    private void SignUpAction(ActionEvent event) {
        Utilisateur utilisateur = new Utilisateur();

        if (utilisateurServiceLocal.ajouterUtilisateur(utilisateur)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Inscription Réussie");
            alert.setContentText("Votre inscritption a été effectuée");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Inscription Echoué");
            alert.setContentText("Votre inscritption a echouée");
            alert.showAndWait();
        }
    }

    @FXML
    private void SignInAction(ActionEvent event) {
        Utilisateur utilisateur = utilisateurServiceLocal.chercherUtilisateurParUsernameEtPassword(userNameTextField.getText(), passwordPasswordField.getText());
        ProfilUtilisateur profilUtilisateur = profilUtilisateurServiceLocal.chercherProfilUtilisateurParIdUtilisateur(utilisateur.getIdUtilisateur());
        Profil profil = profilServiceLocal.chercherProfil(profilUtilisateur.getIdProfil());
        if (utilisateur != null) {
            try {
                ConnectedUser.getInstance().setUtilisateur(utilisateur);
                ConnectedUser.getInstance().setProfil(profil);
                PrincipalStage.getInstance().getStage().setScene(new Scene(FXMLLoader.load(getClass().getResource("GeneralGridPaneView.fxml"))));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Connexion Echouée");
            alert.setContentText("Username ou Mot de passe invalide");
            alert.showAndWait();
        }
    }

}
