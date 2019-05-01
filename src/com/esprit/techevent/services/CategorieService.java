/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services;

import com.esprit.techevent.entities.Categorie;
import com.esprit.techevent.services.local.CategorieServiceLocal;
import com.esprit.techevent.utils.ConnectionDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class CategorieService implements CategorieServiceLocal {

    private final Connection cnx;
    private PreparedStatement st;

    public CategorieService() {
        cnx = ConnectionDataSource.getInstance().getConnection();
    }

    @Override
    public boolean ajouterCategorie(Categorie categorie) {
        try {
            String query = "INSERT INTO categorie "
                    + "VALUES "
                    + "(?,?,?)";
            st = cnx.prepareStatement(query);
            st.setInt(1, categorie.getIdCategorie());
            st.setString(2, categorie.getNom());
            st.setString(3, categorie.getDescription());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerCategorie(Categorie categorie) {
        try {
            String query = "DELETE FROM categorie WHERE idCategorie = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, categorie.getIdCategorie());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifierCategorie(Categorie categorie) {
        try {
            String query = "UPDATE categorie SET "
                    + "nom = ?, "
                    + "description = ?, "
                    + "WHERE idCategorie = ?";
            st = cnx.prepareStatement(query);
            st.setString(1, categorie.getNom());
            st.setString(2, categorie.getDescription());
            st.setInt(3, categorie.getIdCategorie());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Categorie chercherCategorie(int idCategorie) {
        try {
            String query = "SELECT * FROM categorie WHERE idCategorie = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idCategorie);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Categorie(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                );
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int compterCategorie() {
        try {
            String query = "SELECT COUNT(*) FROM categorie";
            st = cnx.prepareStatement(query);
            return st.executeQuery().getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
