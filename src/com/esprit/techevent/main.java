/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent;

import com.esprit.techevent.utils.PopupStage;
import com.esprit.techevent.utils.PrincipalStage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            PrincipalStage.getInstance().setStage(primaryStage);
            PopupStage.getInstance().setStage(new Stage());
            Parent root = FXMLLoader.load(getClass().getResource("GUI/AuthentificationView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Authentification");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
