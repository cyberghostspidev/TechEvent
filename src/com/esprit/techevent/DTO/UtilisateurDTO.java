/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.DTO;

import com.esprit.techevent.entities.Utilisateur;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class UtilisateurDTO {

    private CheckBox checkBox;
    private Utilisateur utilisateur;
    private Button details;

    public UtilisateurDTO() {
    }

    public UtilisateurDTO(CheckBox checkBox, Utilisateur utilisateur, Button details) {
        this.checkBox = checkBox;
        this.utilisateur = utilisateur;
        this.details = details;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Button getDetails() {
        return details;
    }

    public void setDetails(Button details) {
        this.details = details;
    }

}
