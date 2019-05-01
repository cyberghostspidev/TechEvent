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
public class PrincipalStage {

    private Stage stage;
    private static PrincipalStage principalStage;

    private PrincipalStage() {

    }

    public static PrincipalStage getInstance() {
        if (principalStage == null) {
            principalStage = new PrincipalStage();
        }
        return principalStage;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
