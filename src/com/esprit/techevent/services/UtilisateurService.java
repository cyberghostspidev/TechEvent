/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services;

import com.esprit.techevent.entities.Utilisateur;
import com.esprit.techevent.services.local.UtilisateurServiceLocal;
import com.esprit.techevent.utils.ConnectionDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class UtilisateurService implements UtilisateurServiceLocal {

    private final Connection cnx;
    private PreparedStatement st;

    public UtilisateurService() {
        cnx = ConnectionDataSource.getInstance().getConnection();

    }

    @Override
    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
        try {
            String query = "INSERT INTO utilisateur "
                    + "VALUES "
                    + "(?,?,?,?,?,?,?,?,?)";
            st = cnx.prepareStatement(query);
            st.setInt(1, utilisateur.getIdUtilisateur());
            st.setString(2, utilisateur.getUsername());
            st.setString(3, utilisateur.getPassword());
            st.setString(4, utilisateur.getEmail());
            st.setDate(5, utilisateur.getDateInscription());
            st.setDate(6, utilisateur.getDateExpiration());
            st.setString(7, utilisateur.getType());
            st.setInt(8, utilisateur.getIdPersonne());
            st.setInt(9, utilisateur.getIdSociete());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerUtilisateur(Utilisateur utilisateur) {
        try {
            String query = "DELETE FROM utilisateur WHERE idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, utilisateur.getIdUtilisateur());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifierUtilisateur(Utilisateur utilisateur) {
        try {
            String query = "UPDATE utilisateur SET "
                    + "username = ?, "
                    + "password = ?, "
                    + "email = ?, "
                    + "dateInscription = ?, "
                    + "dateExpiration = ?, "
                    + "type = ?, "
                    + "idPersonne = ?, "
                    + "idSociete = ?, "
                    + "WHERE idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setString(1, utilisateur.getUsername());
            st.setString(2, utilisateur.getPassword());
            st.setDate(3, utilisateur.getDateInscription());
            st.setString(4, utilisateur.getEmail());
            st.setDate(5, utilisateur.getDateExpiration());
            st.setString(6, utilisateur.getType());
            st.setInt(7, utilisateur.getIdPersonne());
            st.setInt(8, utilisateur.getIdSociete());
            st.setInt(9, utilisateur.getIdUtilisateur());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Utilisateur chercherUtilisateur(int idUtilisateur) {
        try {
            String query = "SELECT * FROM utilisateur WHERE idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idUtilisateur);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Utilisateur(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)
                );
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int compterUtilisateur() {
        try {
            String query = "SELECT COUNT(*) FROM utilisateur";
            st = cnx.prepareStatement(query);
            return st.executeQuery().getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public Utilisateur chercherUtilisateurParUsernameEtPassword(String username, String password) {
        try {
            String query = "SELECT * FROM utilisateur WHERE username = ? AND password= ?";
            st = cnx.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Utilisateur(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)
                );
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
