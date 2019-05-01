/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services;

import com.esprit.techevent.entities.SponsorEvenement;
import com.esprit.techevent.services.local.SponsorEvenementServiceLocal;
import com.esprit.techevent.utils.ConnectionDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class SponsorEvenementService implements SponsorEvenementServiceLocal {

    private final Connection cnx;
    private PreparedStatement st;

    public SponsorEvenementService() {
        cnx = ConnectionDataSource.getInstance().getConnection();
    }

    @Override
    public boolean ajouterSponsorEvenement(SponsorEvenement sponsorEvenement) {
        try {
            String query = "INSERT INTO sponsor_evenement "
                    + "VALUES "
                    + "(?,?)";
            st = cnx.prepareStatement(query);
            st.setInt(1, sponsorEvenement.getIdSponsor());
            st.setInt(2, sponsorEvenement.getIdEvenement());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerSponsorEvenement(SponsorEvenement sponsorEvenement) {
        try {
            String query = "DELETE FROM sponsor_evenement WHERE idSponsor = ? AND idEvenement = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, sponsorEvenement.getIdSponsor());
            st.setInt(2, sponsorEvenement.getIdEvenement());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public SponsorEvenement chercherSponsorEvenement(int idSponsor, int idEvenement) {
        try {
            String query = "SELECT * FROM sponsor_evenement WHERE idSponsor = ? AND idEvenement = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idSponsor);
            st.setInt(2, idEvenement);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new SponsorEvenement(rs.getInt(1),
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
    public int compterSponsorEvenement() {
        try {
            String query = "SELECT COUNT(*) FROM sponsor_evenement";
            st = cnx.prepareStatement(query);
            return st.executeQuery().getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
