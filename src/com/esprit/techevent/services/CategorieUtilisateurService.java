/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services;

import com.esprit.techevent.entities.CategorieUtilisateur;
import com.esprit.techevent.services.local.CategorieUtilisateurServiceLocal;
import com.esprit.techevent.utils.ConnectionDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class CategorieUtilisateurService implements CategorieUtilisateurServiceLocal {

    private final Connection cnx;
    private PreparedStatement st;

    public CategorieUtilisateurService() {
        cnx = ConnectionDataSource.getInstance().getConnection();
    }

    @Override
    public boolean ajouterCategorieUtilisateur(CategorieUtilisateur categorieUtilisateur) {
        try {
            String query = "INSERT INTO categorie_utilisateur "
                    + "VALUES "
                    + "(?,?)";
            st = cnx.prepareStatement(query);
            st.setInt(1, categorieUtilisateur.getIdCategorie());
            st.setInt(2, categorieUtilisateur.getIdUtilisateur());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerCategorieUtilisateur(CategorieUtilisateur categorieUtilisateur) {
        try {
            String query = "DELETE FROM categorie_utilisateur WHERE idCategorie = ? AND idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, categorieUtilisateur.getIdCategorie());
            st.setInt(2, categorieUtilisateur.getIdUtilisateur());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public CategorieUtilisateur chercherCategorieUtilisateur(int idCategorie, int idUtilisateur) {
        try {
            String query = "SELECT * FROM categorie_utilisateur WHERE idCategorie = ? AND idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idCategorie);
            st.setInt(2, idUtilisateur);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new CategorieUtilisateur(rs.getInt(1),
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
    public int compterCategorieUtilisateur() {
        try {
            String query = "SELECT COUNT(*) FROM categorie_utilisateur";
            st = cnx.prepareStatement(query);
            return st.executeQuery().getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
