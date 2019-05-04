/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services;

import com.esprit.techevent.DTO.PersonneInteretDTO;
import com.esprit.techevent.entities.Personne;
import com.esprit.techevent.services.local.PersonneServiceLocal;
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
public class PersonneService implements PersonneServiceLocal {

    private final Connection cnx;
    private PreparedStatement st;

    public PersonneService() {
        cnx = ConnectionDataSource.getInstance().getConnection();
    }

    @Override
    public boolean ajouterPersonne(Personne personne) {
        try {
            String query = "INSERT INTO personne "
                    + "VALUES "
                    + "(?,?,?,?,?,?)";
            st = cnx.prepareStatement(query);
            st.setInt(1, personne.getIdPersonne());
            st.setString(2, personne.getNom());
            st.setString(3, personne.getPrenom());
            st.setInt(4, personne.getAge());
            st.setString(5, personne.getProfession());
            st.setInt(6, personne.getIdUtilisateur());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerPersonne(Personne personne) {
        try {
            String query = "DELETE FROM personne WHERE idPersonne = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, personne.getIdPersonne());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifierPersonne(Personne personne) {
        try {
            String query = "UPDATE personne SET "
                    + "nom = ?, "
                    + "prenom = ?, "
                    + "age = ?, "
                    + "profession = ?, "
                    + "idUtilisateur = ? "
                    + "WHERE idPersonne = ?";
            st = cnx.prepareStatement(query);
            st.setString(1, personne.getNom());
            st.setString(2, personne.getPrenom());
            st.setInt(3, personne.getAge());
            st.setString(4, personne.getProfession());
            st.setInt(5, personne.getIdUtilisateur());
            st.setInt(6, personne.getIdPersonne());

            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Personne chercherPersonne(int idPersonne) {
        try {
            String query = "SELECT * FROM personne WHERE idPersonne = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idPersonne);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Personne(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
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
    public Personne chercherPersonneParIdUtilisateur(int idUtilisateur) {
        try {
            String query = "SELECT * FROM personne WHERE idUtilisateur = ?";
            st = cnx.prepareStatement(query);
            st.setInt(1, idUtilisateur);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Personne(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
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
    public int compterPersonne() {
        try {
            String query = "SELECT COUNT(*) FROM personne";
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
    public List<PersonneInteretDTO> compterPersonnesParInterets() {
        try {
            String query = "SELECT C.nom, COUNT(*) AS nbPersonnes"
                    + " FROM personne P, categorie C, categorie_utilisateur CU"
                    + " WHERE CU.idCategorie = C.idCategorie"
                    + " AND P.idUtilisateur = CU.idUtilisateur"
                    + " GROUP BY C.nom"
                    + " ORDER BY C.nom";
            st = cnx.prepareStatement(query);
            List<PersonneInteretDTO> personneInteretDTOs = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                personneInteretDTOs.add(
                        new PersonneInteretDTO(rs.getRow(),
                                rs.getString(1),
                                rs.getInt(2)
                        )
                );
            }
            return personneInteretDTOs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public PersonneInteretDTO chercherCategoriePlusInteressee() {
        try {
            String query = "SELECT C.nom, COUNT(*) AS nbPersonne"
                    + " FROM personne P, categorie C, categorie_utilisateur CU"
                    + " WHERE P.idUtilisateur = CU.idUtilisateur"
                    + " AND C.idCategorie = CU.idCategorie"
                    + " GROUP BY C.nom"
                    + " HAVING nbPersonne = (SELECT MAX(nbTotPersonne)"
                    + " FROM ( SELECT COUNT(*) AS nbTotPersonne"
                    + " FROM personne P, categorie C, categorie_utilisateur CU"
                    + " WHERE P.idUtilisateur = CU.idUtilisateur"
                    + " AND C.idCategorie = CU.idCategorie"
                    + " GROUP BY C.nom) AS MaxPersonne)";
            st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            st = cnx.prepareStatement(query);
            if (rs.next()) {
                return new PersonneInteretDTO(rs.getRow(),
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
    public PersonneInteretDTO chercherCategorieMoinsInteressee() {
        try {
            String query = "SELECT C.nom, COUNT(*) AS nbPersonne"
                    + " FROM personne P, categorie C, categorie_utilisateur CU"
                    + " WHERE P.idUtilisateur = CU.idUtilisateur"
                    + " AND C.idCategorie = CU.idCategorie"
                    + " GROUP BY C.nom"
                    + " HAVING nbPersonne = (SELECT MIN(nbTotPersonne)"
                    + " FROM ( SELECT COUNT(*) AS nbTotPersonne"
                    + " FROM personne P, categorie C, categorie_utilisateur CU"
                    + " WHERE P.idUtilisateur = CU.idUtilisateur"
                    + " AND C.idCategorie = CU.idCategorie"
                    + " GROUP BY C.nom) AS MinPersonne)";
            st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new PersonneInteretDTO(rs.getRow(),
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
