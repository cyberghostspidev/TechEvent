/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.GUI.Administrateur;

import com.esprit.techevent.DTO.UtilisateurDTO;
import com.esprit.techevent.entities.Utilisateur;
import com.esprit.techevent.services.UtilisateurService;
import com.esprit.techevent.services.local.UtilisateurServiceLocal;
import com.esprit.techevent.utils.PopupStage;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HP EliteBook
 */
public class GestionUtilisateursViewController implements Initializable {

    @FXML
    private TableView<UtilisateurDTO> utilisateursTableView;
    @FXML
    private TableColumn<UtilisateurDTO, CheckBox> checkTableColumn;
    @FXML
    private TableColumn<UtilisateurDTO, Integer> idTableColumn;
    @FXML
    private TableColumn<UtilisateurDTO, String> mailTableColumn;
    @FXML
    private TableColumn<UtilisateurDTO, String> usernameTableColumn;
    @FXML
    private TableColumn<UtilisateurDTO, String> passwordTableColumn;
    @FXML
    private TableColumn<UtilisateurDTO, Date> dateCreationTableColumn;
    @FXML
    private TableColumn<UtilisateurDTO, Date> dateExpirationTableColumn;
    @FXML
    private TableColumn<UtilisateurDTO, String> typeTableColumn;
    @FXML
    private TableColumn<UtilisateurDTO, Button> actionTableColumn;
    @FXML
    private Button deleteButton;
    @FXML
    private RadioButton tousRadioButton;
    @FXML
    private RadioButton societeRadioButton;
    @FXML
    private CheckBox expireCheckBox;
    @FXML
    private TextField rechercheTextField;
    @FXML
    private RadioButton personneRadioButton;
    @FXML
    private CheckBox nonExpireCheckBox;

    private List<Utilisateur> utilisateurs;
    private UtilisateurServiceLocal utilisateurServiceLocal = new UtilisateurService();
    private final ToggleGroup typeToggleGroup = new ToggleGroup();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setRadioButtonInGroup();
        utilisateurs = utilisateurServiceLocal.chercherTousUtilisateurs();
//        Image imageOk = new Image(getClass().getResourceAsStream("/resources/ImageButton/edit.png"));
        List<UtilisateurDTO> dTOs = setUtilisateurInDTO(utilisateurs);
        dTOs.forEach(dTO -> dTO.getDetails().setOnAction((event) -> {
            FXMLLoader loader = new FXMLLoader();
            switch (dTO.getUtilisateur().getType()) {
                case "Personne":
                    try {
                        Pane root = loader.load(getClass().getResource("DetailsPersonneView.fxml").openStream());
                        DetailsPersonneViewController controller = (DetailsPersonneViewController) loader.getController();
                        controller.setUtilisateur(dTO.getUtilisateur());
                        controller.show();
                        PopupStage.getInstance().getStage().setScene(new Scene(root));
                        PopupStage.getInstance().getStage().show();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "Société":
                    try {
                        Pane root = loader.load(getClass().getResource("DetailsSocieteView.fxml").openStream());
                        DetailsSocieteViewController controller = (DetailsSocieteViewController) loader.getController();
                        controller.setUtilisateur(dTO.getUtilisateur());
                        controller.show();
                        PopupStage.getInstance().getStage().setScene(new Scene(root));
                        PopupStage.getInstance().getStage().show();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
            }
        }));
        utilisateursTableView.getItems().setAll(dTOs);
        checkTableColumn.setCellValueFactory(new PropertyValueFactory("checkBox"));
        idTableColumn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getUtilisateur().getIdUtilisateur()));
        mailTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUtilisateur().getEmail()));
        usernameTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUtilisateur().getUsername()));
        passwordTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUtilisateur().getPassword()));
        dateCreationTableColumn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getUtilisateur().getDateInscription()));
        dateExpirationTableColumn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getUtilisateur().getDateExpiration()));
        typeTableColumn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getUtilisateur().getType()));
        actionTableColumn.setCellValueFactory(new PropertyValueFactory("details"));
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        List<UtilisateurDTO> dTOs = utilisateursTableView.getItems().stream()
                .filter(utilisateur -> utilisateur.getCheckBox().isSelected())
                .collect(Collectors.toList());
        dTOs.forEach(selectedUtilisateur -> {
            utilisateurServiceLocal.supprimerUtilisateur(selectedUtilisateur.getUtilisateur());
            utilisateursTableView.getItems().remove(selectedUtilisateur);
        });
    }

    @FXML
    private void tousAction(ActionEvent event) {
        utilisateursTableView.getItems().setAll(setUtilisateurInDTO(utilisateurServiceLocal.chercherTousUtilisateurs()));
    }

    @FXML
    private void societeAction(ActionEvent event) {
        utilisateursTableView.getItems().setAll(setUtilisateurInDTO(utilisateurs.stream().filter(utilisateur -> utilisateur.getType().equals("Société")).collect(Collectors.toList())));
    }

    @FXML
    private void PersonneAction(ActionEvent event) {
        utilisateursTableView.getItems().setAll(setUtilisateurInDTO(utilisateurs.stream().filter(utilisateur -> utilisateur.getType().equals("Personne")).collect(Collectors.toList())));
    }

    private void setRadioButtonInGroup() {
        tousRadioButton.setToggleGroup(typeToggleGroup);
        personneRadioButton.setToggleGroup(typeToggleGroup);
        societeRadioButton.setToggleGroup(typeToggleGroup);
    }

    private List<UtilisateurDTO> setUtilisateurInDTO(List<Utilisateur> utilisateurs) {
        return utilisateurs.stream()
                .filter(u -> !u.getType().equals("Administratreur"))
                .map(ut -> new UtilisateurDTO(new CheckBox(), ut, new Button("details", new ImageView(/*imageOk*/))))
                .collect(Collectors.toList());
    }

    @FXML
    private void chercherAction(ActionEvent event) {
        utilisateursTableView.getItems().setAll(setUtilisateurInDTO(utilisateurs.stream()
                .filter(utilisateur -> utilisateur.getUsername().contains(rechercheTextField.getText())
                || utilisateur.getEmail().contains(rechercheTextField.getText())
                || utilisateur.getPassword().contains(rechercheTextField.getText())).collect(Collectors.toList())));

    }

}
