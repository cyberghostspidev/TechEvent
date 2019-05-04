-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 04 Mai 2019 à 16:15
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
  `nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `description` varchar(500) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`idCategorie`, `nom`, `description`) VALUES
(1, 'Java J2EE', 'Langage de développement Web'),
(2, 'Java J2ME', 'Langage de développement Mobile'),
(3, 'Java J2SE', 'Langage de développement Java Standard');

-- --------------------------------------------------------

--
-- Structure de la table `categorie_utilisateur`
--

CREATE TABLE `categorie_utilisateur` (
  `idCategorie` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `categorie_utilisateur`
--

INSERT INTO `categorie_utilisateur` (`idCategorie`, `idUtilisateur`) VALUES
(1, 2),
(1, 3),
(2, 4),
(2, 5);

-- --------------------------------------------------------

--
-- Structure de la table `dialog`
--

CREATE TABLE `dialog` (
  `idDialog` int(11) NOT NULL,
  `idEmetteur` int(11) NOT NULL,
  `idRecepteur` int(11) NOT NULL,
  `objet` varchar(500) COLLATE utf8_bin NOT NULL,
  `message` varchar(1500) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `idEvenement` int(11) NOT NULL,
  `nom` varchar(100) COLLATE utf8_bin NOT NULL,
  `description` varchar(500) COLLATE utf8_bin NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `affiche` varchar(150) COLLATE utf8_bin NOT NULL,
  `nbMaxParticipant` int(11) NOT NULL,
  `observation` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `validite` int(1) DEFAULT '0',
  `cloture` int(1) DEFAULT '0',
  `idCategorie` int(10) NOT NULL,
  `idLocalisation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `evenement`
--

INSERT INTO `evenement` (`idEvenement`, `nom`, `description`, `dateDebut`, `dateFin`, `affiche`, `nbMaxParticipant`, `observation`, `validite`, `cloture`, `idCategorie`, `idLocalisation`) VALUES
(2, 'MyTek', 'evemetjdjf', '2019-05-01', '2019-05-31', 'fzerfe', 300, 'ferf', 0, 0, 1, 0),
(3, 'SCOOP', 'evemetjdjf', '2019-05-01', '2019-05-31', 'fzerfe', 300, 'ferf', 0, 0, 1, 0),
(4, 'TunisiaNet', 'sddfe', '2019-05-15', '2019-05-29', 'ejfhizhe', 250, 'vdvjed', 0, 0, 3, 0);

-- --------------------------------------------------------

--
-- Structure de la table `evenement_utilisateur`
--

CREATE TABLE `evenement_utilisateur` (
  `idEvenement` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `interaction`
--

CREATE TABLE `interaction` (
  `idInteraction` int(11) NOT NULL,
  `rating` float NOT NULL,
  `avis` varchar(1000) COLLATE utf8_bin NOT NULL,
  `idEvenement` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL
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
  `capacite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `idPersonne` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `profession` varchar(50) NOT NULL,
  `idUtilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`idPersonne`, `nom`, `prenom`, `age`, `profession`, `idUtilisateur`) VALUES
(1, 'ben Amor', 'Ahmed', 28, 'Ingenieur', 2),
(2, 'Ben Ouirane', 'Yacine', 25, 'Developpeur', 4);

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `idProfil` int(2) NOT NULL,
  `code` varchar(20) COLLATE utf8_bin NOT NULL,
  `description` varchar(100) COLLATE utf8_bin NOT NULL,
  `nature` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `profil`
--

INSERT INTO `profil` (`idProfil`, `code`, `description`, `nature`) VALUES
(1, 'ADMIN', 'administrateur de l''application', 1),
(2, 'PARTICIPANT', 'participant ', 2),
(3, 'ORGANISATEUR', 'Organisateur d''événement', 3);

-- --------------------------------------------------------

--
-- Structure de la table `profil_utilisateur`
--

CREATE TABLE `profil_utilisateur` (
  `idProfil` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `profil_utilisateur`
--

INSERT INTO `profil_utilisateur` (`idProfil`, `idUtilisateur`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `societe`
--

CREATE TABLE `societe` (
  `idSociete` int(11) NOT NULL,
  `raisonSociale` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `logo` varchar(500) DEFAULT NULL,
  `numTel` varchar(20) DEFAULT NULL,
  `idUtilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `societe`
--

INSERT INTO `societe` (`idSociete`, `raisonSociale`, `adresse`, `logo`, `numTel`, `idUtilisateur`) VALUES
(1, 'Esprit Cours du Soir', 'Charguia II', NULL, '71771771', 3),
(2, 'Esprit Cours du Jour', 'Ghazella', NULL, '71771771', 5);

-- --------------------------------------------------------

--
-- Structure de la table `sponsor`
--

CREATE TABLE `sponsor` (
  `idSponsor` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `affiche` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sponsor_evenement`
--

CREATE TABLE `sponsor_evenement` (
  `idSponsor` int(11) NOT NULL,
  `idEvenement` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `username` varchar(25) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `dateInscription` date NOT NULL,
  `dateExpiration` date DEFAULT NULL,
  `type` varchar(20) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `email`, `username`, `password`, `dateInscription`, `dateExpiration`, `type`) VALUES
(1, 'admin@esprit.tn', 'admin', 'admin', '2019-04-05', NULL, 'Administratreur'),
(2, 'dd@esprit.tn', 'dd', 'dd', '2019-04-05', NULL, 'Personne'),
(3, 'bb@esprit.tn', 'bb', 'bb', '2019-04-05', NULL, 'Société'),
(4, 'cc@esprit.tn', 'cc', 'cc', '2019-04-05', NULL, 'Personne'),
(5, 'aa@esprit.tn', 'aa', 'aa', '2019-04-05', NULL, 'Société');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`idCategorie`);

--
-- Index pour la table `categorie_utilisateur`
--
ALTER TABLE `categorie_utilisateur`
  ADD PRIMARY KEY (`idCategorie`,`idUtilisateur`),
  ADD KEY `fk_utilisateur2_idx` (`idUtilisateur`);

--
-- Index pour la table `dialog`
--
ALTER TABLE `dialog`
  ADD PRIMARY KEY (`idDialog`),
  ADD KEY `fk_id_ut_trans` (`idEmetteur`),
  ADD KEY `fk_id_ut_recep` (`idRecepteur`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`idEvenement`),
  ADD KEY `fk_id_categorie` (`idCategorie`),
  ADD KEY `fk_id_localisation` (`idLocalisation`);

--
-- Index pour la table `evenement_utilisateur`
--
ALTER TABLE `evenement_utilisateur`
  ADD PRIMARY KEY (`idEvenement`,`idUtilisateur`),
  ADD KEY `fk_utilisateur3_idx` (`idUtilisateur`);

--
-- Index pour la table `interaction`
--
ALTER TABLE `interaction`
  ADD PRIMARY KEY (`idInteraction`),
  ADD KEY `fk_id_ev_inter` (`idEvenement`),
  ADD KEY `fk_id_ut_inter` (`idUtilisateur`);

--
-- Index pour la table `localisation`
--
ALTER TABLE `localisation`
  ADD PRIMARY KEY (`idLocalisation`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`idPersonne`),
  ADD KEY `idUtilisateur` (`idUtilisateur`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`idProfil`);

--
-- Index pour la table `profil_utilisateur`
--
ALTER TABLE `profil_utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`,`idProfil`),
  ADD KEY `fk_profil_idx` (`idProfil`);

--
-- Index pour la table `societe`
--
ALTER TABLE `societe`
  ADD PRIMARY KEY (`idSociete`),
  ADD KEY `idUtilisateur` (`idUtilisateur`);

--
-- Index pour la table `sponsor`
--
ALTER TABLE `sponsor`
  ADD PRIMARY KEY (`idSponsor`);

--
-- Index pour la table `sponsor_evenement`
--
ALTER TABLE `sponsor_evenement`
  ADD PRIMARY KEY (`idSponsor`,`idEvenement`),
  ADD KEY `fk_evenement2_idx` (`idEvenement`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `dialog`
--
ALTER TABLE `dialog`
  MODIFY `idDialog` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `idEvenement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `interaction`
--
ALTER TABLE `interaction`
  MODIFY `idInteraction` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `localisation`
--
ALTER TABLE `localisation`
  MODIFY `idLocalisation` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `idPersonne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `profil`
--
ALTER TABLE `profil`
  MODIFY `idProfil` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `societe`
--
ALTER TABLE `societe`
  MODIFY `idSociete` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `categorie_utilisateur`
--
ALTER TABLE `categorie_utilisateur`
  ADD CONSTRAINT `categorie_fk_1` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `utilisateur_fk_3` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `dialog`
--
ALTER TABLE `dialog`
  ADD CONSTRAINT `fk_id_ut_recep` FOREIGN KEY (`idRecepteur`) REFERENCES `utilisateur` (`idUtilisateur`),
  ADD CONSTRAINT `fk_id_ut_trans` FOREIGN KEY (`idEmetteur`) REFERENCES `utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `fk_id_categorie` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `evenement_utilisateur`
--
ALTER TABLE `evenement_utilisateur`
  ADD CONSTRAINT `evenement_fk_1` FOREIGN KEY (`idEvenement`) REFERENCES `evenement` (`idEvenement`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `utilisateur_fk_4` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `interaction`
--
ALTER TABLE `interaction`
  ADD CONSTRAINT `fk_id_ev_inter` FOREIGN KEY (`idEvenement`) REFERENCES `evenement` (`idEvenement`),
  ADD CONSTRAINT `fk_id_ut_inter` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `utilisateur_fk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `profil_utilisateur`
--
ALTER TABLE `profil_utilisateur`
  ADD CONSTRAINT `fk_profil` FOREIGN KEY (`idProfil`) REFERENCES `profil` (`idProfil`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_utilisateur_5` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `societe`
--
ALTER TABLE `societe`
  ADD CONSTRAINT `utilisateur_fk_2` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `sponsor_evenement`
--
ALTER TABLE `sponsor_evenement`
  ADD CONSTRAINT `fk_evenement_2` FOREIGN KEY (`idEvenement`) REFERENCES `evenement` (`idEvenement`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_sponsor` FOREIGN KEY (`idSponsor`) REFERENCES `sponsor` (`idSponsor`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
