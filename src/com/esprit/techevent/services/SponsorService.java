/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services;

import com.esprit.techevent.entities.Sponsor;
import com.esprit.techevent.services.local.SponsorServiceLocal;
import com.esprit.techevent.utils.ConnectionDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class SponsorService implements SponsorServiceLocal {
        private final Connection cnx;
    private PreparedStatement st;

    public SponsorService() {
        cnx = ConnectionDataSource.getInstance().getConnection();
    }

    @Override
    public boolean ajouterSponsor(Sponsor sponsor) {
        try {
            String query = "INSERT INTO sponsor "
                    + "VALUES "
                    + "(?,?,?)";
            st = cnx.prepareStatement(query);
            st.setInt(1, sponsor.getIdSponsor());
            st.setString(2, sponsor.getNom());
            st.setString(3, sponsor.getAffiche());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerSponsor(Sponsor sponsor) {
        try {
            String query = "DELETE FROM sponsor WHERE idSponsor = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, sponsor.getIdSponsor());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifierSponsor(Sponsor sponsor) {
        try {
            String query = "UPDATE sponsor SET "
                    + "nom = ?, "
                    + "affiche = ?, "
                    + "WHERE idSponsor = ?";
            st = cnx.prepareStatement(query);
            st.setString(1, sponsor.getNom());
            st.setString(2, sponsor.getAffiche());
            st.setInt(3, sponsor.getIdSponsor());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Sponsor chercherSponsor(int idSponsor) {
        try {
            String query = "SELECT * FROM sponsor WHERE idSponsor = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idSponsor);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Sponsor(rs.getInt(1),
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
    public int compterSponsor() {
        try {
            String query = "SELECT COUNT(*) FROM sponsor";
            st = cnx.prepareStatement(query);
            return st.executeQuery().getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
