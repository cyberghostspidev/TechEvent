/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services;

import com.esprit.techevent.services.local.ProfilUtilisateurServiceLocal;
import com.esprit.techevent.entities.ProfilUtilisateur;
import com.esprit.techevent.utils.ConnectionDataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class ProfilUtilisateurService implements ProfilUtilisateurServiceLocal {

    private final Connection cnx;
    private PreparedStatement st;

    public ProfilUtilisateurService() {
        cnx = ConnectionDataSource.getInstance().getConnection();
    }

    @Override
    public boolean ajouterProfilUtilisateur(ProfilUtilisateur profilUtilisateur) {
        try {
            String query = "INSERT INTO profil_utilisateur "
                    + "VALUES "
                    + "(?,?)";
            st = cnx.prepareStatement(query);
            st.setInt(1, profilUtilisateur.getIdProfil());
            st.setInt(2, profilUtilisateur.getIdUtilisateur());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerProfilUtilisateur(ProfilUtilisateur profilUtilisateur) {
        try {
            String query = "DELETE FROM profil_utilisateur WHERE idProfil = ? AND idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, profilUtilisateur.getIdProfil());
            st.setInt(2, profilUtilisateur.getIdUtilisateur());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ProfilUtilisateur chercherProfilUtilisateur(int idProfil, int idUtilisateur) {
        try {
            String query = "SELECT * FROM profil_utilisateur WHERE idProfil = ? AND idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idProfil);
            st.setInt(2, idUtilisateur);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new ProfilUtilisateur(rs.getInt(1),
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
    public int compterProfilUtilisateur() {
        try {
            String query = "SELECT COUNT(*) FROM profil_utilisateur";
            st = cnx.prepareStatement(query);
            return st.executeQuery().getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public ProfilUtilisateur chercherProfilUtilisateurParIdUtilisateur(int idUtilisateur) {
        try {
            String query = "SELECT * FROM profil_utilisateur WHERE idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idUtilisateur);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new ProfilUtilisateur(rs.getInt(1),
                        rs.getInt(2)
                );
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
