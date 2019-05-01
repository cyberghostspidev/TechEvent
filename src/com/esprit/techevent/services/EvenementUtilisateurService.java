/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services;

import com.esprit.techevent.entities.EvenementUtilisateur;
import com.esprit.techevent.services.local.EvenementUtilisateurServiceLocal;
import com.esprit.techevent.utils.ConnectionDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class EvenementUtilisateurService implements EvenementUtilisateurServiceLocal {

    private final Connection cnx;
    private PreparedStatement st;

    public EvenementUtilisateurService() {
        cnx = ConnectionDataSource.getInstance().getConnection();
    }

    @Override
    public boolean ajouterEvenementUtilisateur(EvenementUtilisateur evenementUtilisateur) {
        try {
            String query = "INSERT INTO evenement_utilisateur "
                    + "VALUES "
                    + "(?,?)";
            st = cnx.prepareStatement(query);
            st.setInt(1, evenementUtilisateur.getIdEvenement());
            st.setInt(2, evenementUtilisateur.getIdUtilisateur());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerEvenementUtilisateur(EvenementUtilisateur evenementUtilisateur) {
        try {
            String query = "DELETE FROM evenement_utilisateur WHERE idEvenement = ? AND idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, evenementUtilisateur.getIdEvenement());
            st.setInt(2, evenementUtilisateur.getIdUtilisateur());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public EvenementUtilisateur chercherEvenementUtilisateur(int idEvenement, int idUtilisateur) {
        try {
            String query = "SELECT * FROM evenement_utilisateur WHERE idEvenement = ? AND idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idEvenement);
            st.setInt(2, idUtilisateur);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new EvenementUtilisateur(rs.getInt(1),
                        rs.getInt(2)
                );
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int compterEvenementUtilisateur() {
        try {
            String query = "SELECT COUNT(*) FROM evenement_utilisateur";
            st = cnx.prepareStatement(query);
            return st.executeQuery().getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
