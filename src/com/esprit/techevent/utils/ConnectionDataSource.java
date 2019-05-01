/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class ConnectionDataSource {

    private Connection connection;
    private static ConnectionDataSource connectionDataSource;

    private ConnectionDataSource() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TechEvent", "root", "");
            System.out.println("Connexion Etablie !!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionDataSource getInstance() {
        if (connectionDataSource == null) {
            connectionDataSource = new ConnectionDataSource();
        }
        return connectionDataSource;
    }

    public Connection getConnection() {
        return connection;
    }
    
}
