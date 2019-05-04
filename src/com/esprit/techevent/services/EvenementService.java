/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services;

import com.esprit.techevent.DTO.EvenementCategorieDTO;
import com.esprit.techevent.entities.Evenement;
import com.esprit.techevent.services.local.EvenementServiceLocal;
import com.esprit.techevent.utils.ConnectionDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class EvenementService implements EvenementServiceLocal {

    private final Connection cnx;
    private PreparedStatement st;

    public EvenementService() {
        cnx = ConnectionDataSource.getInstance().getConnection();
    }

    @Override
    public boolean ajouterEvenement(Evenement evenement) {
        try {
            String query = "INSERT INTO evenement "
                    + "VALUES "
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            st = cnx.prepareStatement(query);
            st.setInt(1, evenement.getIdEvenement());
            st.setString(2, evenement.getNom());
            st.setString(3, evenement.getDescription());
            st.setDate(4, evenement.getDateDebut());
            st.setDate(5, evenement.getDateFin());
            st.setString(6, evenement.getAffiche());
            st.setString(7, evenement.getSponsor());
            st.setString(8, evenement.getAfficheSponsor());
            st.setString(9, evenement.getObservation());
            st.setBoolean(10, evenement.getValidite());
            st.setBoolean(11, evenement.getCloture());
            st.setInt(12, evenement.getIdLocalisation());
            st.setInt(13, evenement.getIdCategorie());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerEvenement(Evenement evenement) {
        try {
            String query = "DELETE FROM evenement WHERE idEvenement = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, evenement.getIdCategorie());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifierEvenement(Evenement evenement) {
        try {
            String query = "UPDATE evenement SET "
                    + "nom = ?, "
                    + "description = ?, "
                    + "dateDebut = ?, "
                    + "dateFin = ?, "
                    + "affiche = ?, "
                    + "sponsor = ?, "
                    + "afficheSponsor = ?, "
                    + "observation = ?, "
                    + "validite = ?, "
                    + "cloture = ?, "
                    + "idLocalisation = ?, "
                    + "idCategorie = ?, "
                    + "WHERE idEvenement = ?";
            st = cnx.prepareStatement(query);
            st.setString(1, evenement.getNom());
            st.setString(2, evenement.getDescription());
            st.setDate(3, evenement.getDateDebut());
            st.setDate(4, evenement.getDateFin());
            st.setString(5, evenement.getAffiche());
            st.setString(6, evenement.getSponsor());
            st.setString(7, evenement.getAfficheSponsor());
            st.setString(8, evenement.getObservation());
            st.setBoolean(9, evenement.getValidite());
            st.setBoolean(10, evenement.getCloture());
            st.setInt(11, evenement.getIdLocalisation());
            st.setInt(12, evenement.getIdCategorie());
            st.setInt(13, evenement.getIdEvenement());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Evenement chercherEvenement(int idEvenement) {
        try {
            String query = "SELECT * FROM evenement WHERE idEvenement = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idEvenement);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Evenement(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getBoolean(10),
                        rs.getBoolean(11),
                        rs.getInt(12),
                        rs.getInt(13)
                );
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int compterEvenement() {
        try {
            String query = "SELECT COUNT(*) AS nbEvenements FROM evenement";
            st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<EvenementCategorieDTO> compterEvenementsParCategorie() {
        try {
            String query = "SELECT C.nom, COUNT(*) AS nbEvenements"
                    + " FROM evenement E, Categorie C"
                    + " WHERE E.idCategorie = C.idCategorie"
                    + " GROUP BY C.nom"
                    + " ORDER BY C.nom";
            st = cnx.prepareStatement(query);
            List<EvenementCategorieDTO> evenementCategorieDTOs = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                evenementCategorieDTOs.add(
                        new EvenementCategorieDTO(rs.getRow(),
                                rs.getString(1),
                                rs.getInt(2)
                        )
                );
            }
            return evenementCategorieDTOs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public EvenementCategorieDTO chercherCategorieDominante() {
        try {
            String query = "SELECT C.nom, COUNT(*) AS nbEvenement"
                    + " FROM evenement E, categorie C"
                    + " WHERE E.idCategorie = C.idCategorie"
                    + " GROUP BY C.nom"
                    + " HAVING nbEvenement = (SELECT MAX(nbTotEvenement)"
                    + " FROM ( SELECT COUNT(*) AS nbTotEvenement"
                    + "	FROM evenement E, categorie C"
                    + " WHERE E.idCategorie = C.idCategorie"
                    + " GROUP BY C.nom) AS MaxEvenement)";
            st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new EvenementCategorieDTO(rs.getRow(),
                        rs.getString(1),
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
    public EvenementCategorieDTO chercherCategorieIgnoree() {
        try {
            String query = "SELECT C.nom, COUNT(*) AS nbEvenement"
                    + " FROM evenement E, categorie C"
                    + " WHERE E.idCategorie = C.idCategorie"
                    + " GROUP BY C.nom"
                    + " HAVING nbEvenement = (SELECT MIN(nbTotEvenement)"
                    + " FROM ( SELECT COUNT(*) AS nbTotEvenement"
                    + "	FROM evenement E, categorie C"
                    + " WHERE E.idCategorie = C.idCategorie"
                    + " GROUP BY C.nom) AS MinEvenement)";
            st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new EvenementCategorieDTO(rs.getRow(),
                        rs.getString(1),
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
