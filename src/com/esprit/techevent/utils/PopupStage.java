/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.utils;

import javafx.stage.Stage;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class PopupStage {

    private Stage stage;
    private static PopupStage popupStage;

    private PopupStage() {

    }

    public static PopupStage getInstance() {
        if (popupStage == null) {
            popupStage = new PopupStage();
        }
        return popupStage;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
