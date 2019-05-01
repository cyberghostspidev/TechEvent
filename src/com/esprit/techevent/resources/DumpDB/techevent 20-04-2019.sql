-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 26 Avril 2019 à 20:43
-- Version du serveur :  10.1.13-MariaDB
-- Version de PHP :  5.5.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `techevent`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `idCategorie` int(11) NOT NULL,
  `codeCategorie` varchar(50) COLLATE utf8_bin NOT NULL,
  `description` varchar(500) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`idCategorie`, `codeCategorie`, `description`) VALUES
(1, 'categorie', 'test categorie');

-- --------------------------------------------------------

--
-- Structure de la table `dialog_utilisateur`
--

CREATE TABLE `dialog_utilisateur` (
  `idDialog` int(11) NOT NULL,
  `idTrans` int(11) NOT NULL,
  `idRecep` int(11) NOT NULL,
  `message` varchar(1500) COLLATE utf8_bin DEFAULT NULL,
  `objet` varchar(500) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `idEvenement` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `idCategorie` int(10) NOT NULL,
  `idLocalisation` int(11) NOT NULL,
  `description` varchar(500) COLLATE utf8_bin NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `affiche` varchar(150) COLLATE utf8_bin NOT NULL,
  `sponsor` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `affiche_sponsor` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `observation` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `validite` int(1) DEFAULT '0',
  `cloture` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `evenement`
--

INSERT INTO `evenement` (`idEvenement`, `idUtilisateur`, `idCategorie`, `idLocalisation`, `description`, `dateDebut`, `dateFin`, `affiche`, `sponsor`, `affiche_sponsor`, `observation`, `validite`, `cloture`) VALUES
(1, 1, 1, 1, 'test evenement', '0000-00-00', '0000-00-00', 'test localisation', NULL, NULL, NULL, 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `evenement_profil_utilisateur`
--

CREATE TABLE `evenement_profil_utilisateur` (
  `idEvenement` int(11) NOT NULL,
  `idProfil` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `interaction`
--

CREATE TABLE `interaction` (
  `id_interaction` int(11) NOT NULL,
  `id_ev` int(11) NOT NULL,
  `id_u` int(11) NOT NULL,
  `id_createur` int(11) NOT NULL,
  `etat_interaction` char(3) CHARACTER SET latin1 NOT NULL DEFAULT 'VAL',
  `avis_ev_u` varchar(1000) COLLATE utf8_bin NOT NULL,
  `reclamation` varchar(1000) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `localisation`
--

CREATE TABLE `localisation` (
  `idLocalisation` int(11) NOT NULL,
  `descriptionPlace` varchar(500) COLLATE utf8_bin NOT NULL,
  `latitude` decimal(10,0) NOT NULL,
  `longitude` decimal(10,0) NOT NULL,
  `region` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `capacite` decimal(10,0) NOT NULL,
  `nbParticipantsMax` decimal(10,0) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `localisation`
--

INSERT INTO `localisation` (`idLocalisation`, `descriptionPlace`, `latitude`, `longitude`, `region`, `capacite`, `nbParticipantsMax`) VALUES
(1, 'test localisation', '654654654', '9999999999', 'test localisation', '100', NULL),
(2, 'qsdqsd', '545454', '645454', 'test localisation', '1000', '2');

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `idProfil` int(2) NOT NULL,
  `codeProfil` varchar(20) COLLATE utf8_bin NOT NULL,
  `descriptionProfil` varchar(100) COLLATE utf8_bin NOT NULL,
  `nature` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `profil`
--

INSERT INTO `profil` (`idProfil`, `codeProfil`, `descriptionProfil`, `nature`) VALUES
(4, 'ADMIN', 'administrateur de l''application', 1),
(5, 'PARTICIPANT', 'participant ', 3),
(6, 'CREATEUR', 'createur d''evennement', 2);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(50) COLLATE utf8_bin NOT NULL,
  `adresse` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `username` varchar(25) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `f_physique` int(1) NOT NULL DEFAULT '0' COMMENT 'personne physique / morale',
  `profession` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `raisonSociale` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `domaineActivite` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `dateInscription` date NOT NULL,
  `expiration` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `nom`, `prenom`, `adresse`, `email`, `username`, `password`, `f_physique`, `profession`, `raisonSociale`, `domaineActivite`, `dateInscription`, `expiration`) VALUES
(1, 'test', 'test', 'test', 'test@test.com', 'zz', 'test', 0, 'test', 'test', 'test test ', '2019-04-21', 1);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur_profil`
--

CREATE TABLE `utilisateur_profil` (
  `idUtilisateur` int(11) NOT NULL,
  `idProfil` int(11) NOT NULL,
  `codeProfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`idCategorie`);

--
-- Index pour la table `dialog_utilisateur`
--
ALTER TABLE `dialog_utilisateur`
  ADD PRIMARY KEY (`idDialog`),
  ADD KEY `fk_id_ut_trans` (`idTrans`),
  ADD KEY `fk_id_ut_recep` (`idRecep`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`idEvenement`),
  ADD KEY `fk_id_categorie` (`idCategorie`),
  ADD KEY `fk_id_utilisateur` (`idUtilisateur`),
  ADD KEY `fk_id_localisation` (`idLocalisation`);

--
-- Index pour la table `evenement_profil_utilisateur`
--
ALTER TABLE `evenement_profil_utilisateur`
  ADD PRIMARY KEY (`idEvenement`,`idProfil`,`idUtilisateur`),
  ADD KEY `fk_id_ut_ev_p_u` (`idUtilisateur`),
  ADD KEY `fk_id_profil_ev_p_u` (`idProfil`);

--
-- Index pour la table `interaction`
--
ALTER TABLE `interaction`
  ADD PRIMARY KEY (`id_interaction`),
  ADD KEY `fk_id_ev_inter` (`id_ev`),
  ADD KEY `fk_id_ut_inter` (`id_u`),
  ADD KEY `fk_id_createur_inter` (`id_createur`);

--
-- Index pour la table `localisation`
--
ALTER TABLE `localisation`
  ADD PRIMARY KEY (`idLocalisation`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`idProfil`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- Index pour la table `utilisateur_profil`
--
ALTER TABLE `utilisateur_profil`
  ADD PRIMARY KEY (`idProfil`,`idUtilisateur`),
  ADD KEY `id_utilisateur` (`idUtilisateur`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `dialog_utilisateur`
--
ALTER TABLE `dialog_utilisateur`
  MODIFY `idDialog` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `idEvenement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `interaction`
--
ALTER TABLE `interaction`
  MODIFY `id_interaction` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `localisation`
--
ALTER TABLE `localisation`
  MODIFY `idLocalisation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `profil`
--
ALTER TABLE `profil`
  MODIFY `idProfil` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `dialog_utilisateur`
--
ALTER TABLE `dialog_utilisateur`
  ADD CONSTRAINT `fk_id_ut_recep` FOREIGN KEY (`idRecep`) REFERENCES `utilisateur` (`idUtilisateur`),
  ADD CONSTRAINT `fk_id_ut_trans` FOREIGN KEY (`idTrans`) REFERENCES `utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `fk_id_categorie` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`),
  ADD CONSTRAINT `fk_id_localisation` FOREIGN KEY (`idLocalisation`) REFERENCES `localisation` (`idLocalisation`),
  ADD CONSTRAINT `fk_id_utilisateur` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `evenement_profil_utilisateur`
--
ALTER TABLE `evenement_profil_utilisateur`
  ADD CONSTRAINT `fk_id_evenement_ev_p_u` FOREIGN KEY (`idEvenement`) REFERENCES `evenement` (`idEvenement`),
  ADD CONSTRAINT `fk_id_profil_ev_p_u` FOREIGN KEY (`idProfil`) REFERENCES `profil` (`idProfil`),
  ADD CONSTRAINT `fk_id_ut_ev_p_u` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `interaction`
--
ALTER TABLE `interaction`
  ADD CONSTRAINT `fk_id_createur_inter` FOREIGN KEY (`id_createur`) REFERENCES `utilisateur` (`idUtilisateur`),
  ADD CONSTRAINT `fk_id_ev_inter` FOREIGN KEY (`id_ev`) REFERENCES `evenement` (`idEvenement`),
  ADD CONSTRAINT `fk_id_ut_inter` FOREIGN KEY (`id_u`) REFERENCES `utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `utilisateur_profil`
--
ALTER TABLE `utilisateur_profil`
  ADD CONSTRAINT `id_profil` FOREIGN KEY (`idProfil`) REFERENCES `profil` (`idProfil`),
  ADD CONSTRAINT `id_utilisateur` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
