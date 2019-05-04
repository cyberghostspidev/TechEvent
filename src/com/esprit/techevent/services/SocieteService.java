/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services;

import com.esprit.techevent.DTO.SocieteDomaineDTO;
import com.esprit.techevent.entities.Societe;
import com.esprit.techevent.services.local.SocieteServiceLocal;
import com.esprit.techevent.utils.ConnectionDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class SocieteService implements SocieteServiceLocal {

    private final Connection cnx;
    private PreparedStatement st;

    public SocieteService() {
        cnx = ConnectionDataSource.getInstance().getConnection();
    }

    @Override
    public boolean ajouterSociete(Societe societe) {
        try {
            String query = "INSERT INTO societe "
                    + "VALUES "
                    + "(?,?,?,?,?,?)";
            st = cnx.prepareStatement(query);
            st.setInt(1, societe.getIdSociete());
            st.setString(2, societe.getRaisonSociale());
            st.setString(3, societe.getAdresse());
            st.setString(4, societe.getLogo());
            st.setString(5, societe.getNumTel());
            st.setInt(6, societe.getIdUtilisateur());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerSociete(Societe societe) {
        try {
            String query = "DELETE FROM societe WHERE idSociete = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, societe.getIdSociete());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifierSociete(Societe societe) {
        try {
            String query = "UPDATE societe SET "
                    + "raispnSociale = ?, "
                    + "adresse = ?, "
                    + "logo = ?, "
                    + "numTel = ?, "
                    + "idUtilisateur = ? "
                    + "WHERE idSociete = ?";
            st = cnx.prepareStatement(query);
            st.setString(1, societe.getRaisonSociale());
            st.setString(2, societe.getAdresse());
            st.setString(3, societe.getLogo());
            st.setString(4, societe.getNumTel());
            st.setInt(5, societe.getIdUtilisateur());
            st.setInt(6, societe.getIdSociete());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Societe chercherSociete(int idSociete) {
        try {
            String query = "SELECT * FROM societe WHERE idSociete = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idSociete);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Societe(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    
    @Override
    public Societe chercherSocieteParIdUtilisateur(int idUtilisateur) {
        try {
            String query = "SELECT * FROM societe WHERE idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idUtilisateur);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Societe(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int compterSociete() {
        try {
            String query = "SELECT COUNT(*) FROM societe";
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
    public List<SocieteDomaineDTO> compterSocieteParDomaine() {
        try {
            String query = "SELECT C.nom, COUNT(*) AS nbSocietes"
                    + " FROM societe S, categorie C, categorie_utilisateur CU"
                    + " WHERE CU.idCategorie = C.idCategorie"
                    + " AND S.idUtilisateur = CU.idUtilisateur"
                    + " GROUP BY C.nom"
                    + " ORDER BY C.nom";
            st = cnx.prepareStatement(query);
            List<SocieteDomaineDTO> societeDomaineDTOs = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                societeDomaineDTOs.add(
                        new SocieteDomaineDTO(rs.getRow(),
                                rs.getString(1),
                                rs.getInt(2)
                        )
                );
            }
            return societeDomaineDTOs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public SocieteDomaineDTO chercherCategoriePlusOrganisee() {
        try {
            String query = "SELECT C.nom, COUNT(*) AS nbSociete"
                    + " FROM societe S, categorie C, categorie_utilisateur CU"
                    + " WHERE S.idUtilisateur = CU.idUtilisateur"
                    + " AND C.idCategorie = CU.idCategorie"
                    + " GROUP BY C.nom"
                    + " HAVING nbSociete = (SELECT MAX(nbTotSociete)"
                    + " FROM ( SELECT COUNT(*) AS nbTotSociete"
                    + " FROM societe S, categorie C, categorie_utilisateur CU"
                    + " WHERE S.idUtilisateur = CU.idUtilisateur"
                    + " AND C.idCategorie = CU.idCategorie"
                    + " GROUP BY C.nom) AS MaxSociete)";
            st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            st = cnx.prepareStatement(query);
            if (rs.next()) {
                return new SocieteDomaineDTO(rs.getRow(),
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
    public SocieteDomaineDTO chercherCategorieMoinsOrganisee() {
        try {
            String query = "SELECT C.nom, COUNT(*) AS nbSociete"
                    + " FROM societe S, categorie C, categorie_utilisateur CU"
                    + " WHERE S.idUtilisateur = CU.idUtilisateur"
                    + " AND C.idCategorie = CU.idCategorie"
                    + " GROUP BY C.nom"
                    + " HAVING nbSociete = (SELECT MIN(nbTotSociete)"
                    + " FROM ( SELECT COUNT(*) AS nbTotSociete"
                    + " FROM personne p, categorie C, categorie_utilisateur cu"
                    + " WHERE p.idUtilisateur = cu.idUtilisateur"
                    + " AND c.idCategorie = cu.idCategorie"
                    + " GROUP BY C.nom) AS MinSociete)";
            st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new SocieteDomaineDTO(rs.getRow(),
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
