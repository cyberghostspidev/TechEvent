/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services;

import com.esprit.techevent.entities.Profil;
import com.esprit.techevent.services.local.ProfilServiceLocal;
import com.esprit.techevent.utils.ConnectionDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class ProfilService implements ProfilServiceLocal {

    private final Connection cnx;
    private PreparedStatement st;

    public ProfilService() {
        cnx = ConnectionDataSource.getInstance().getConnection();
    }

    @Override
    public boolean ajouterProfil(Profil profil) {
        try {
            String query = "INSERT INTO profil "
                    + "VALUES "
                    + "(?,?,?,?)";
            st = cnx.prepareStatement(query);
            st.setInt(1, profil.getIdProfil());
            st.setString(2, profil.getCode());
            st.setString(3, profil.getDescription());
            st.setInt(4, profil.getNature());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerProfil(Profil profil) {
        try {
            String query = "DELETE FROM profil WHERE idProfil = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, profil.getIdProfil());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifierProfil(Profil profil) {
        try {
            String query = "UPDATE profil SET "
                    + "code = ?, "
                    + "description = ?, "
                    + "nature = ?, "
                    + "WHERE idProfil = ?";
            st = cnx.prepareStatement(query);
            st.setString(1, profil.getCode());
            st.setString(2, profil.getDescription());
            st.setInt(3, profil.getNature());
            st.setInt(4, profil.getIdProfil());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public Profil chercherProfil(int idProfil) {
        try {
            String query = "SELECT * FROM profil WHERE idProfil = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idProfil);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Profil(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public int compterProfil() {
        try {
            String query = "SELECT COUNT(*) FROM profil";
            st = cnx.prepareStatement(query);
            return st.executeQuery().getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
