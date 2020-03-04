-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 04 Mars 2020 à 10:57
-- Version du serveur :  5.7.25-0ubuntu0.16.04.2
-- Version de PHP :  7.0.32-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `GestionnaireVisites`
--

-- --------------------------------------------------------

--
-- Structure de la table `Clients`
--

CREATE TABLE `Clients` (
  `idClient` int(11) NOT NULL,
  `nom` varchar(20) CHARACTER SET utf8 NOT NULL,
  `prenom` varchar(20) CHARACTER SET utf8 NOT NULL,
  `email` varchar(60) CHARACTER SET utf8 NOT NULL,
  `motDePasse` varchar(20) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Clients`
--

INSERT INTO `Clients` (`idClient`, `nom`, `prenom`, `email`, `motDePasse`) VALUES
(1, 'X', 'toto', 'toto@jee.com', '1'),
(2, 'Y', 'tata', 'tata@jee.com', '2'),
(3, 'Z', 'titi', 'titi@jee.com', '3');

-- --------------------------------------------------------

--
-- Structure de la table `Reservations`
--

CREATE TABLE `Reservations` (
  `idVisite` int(20) NOT NULL,
  `idClient` int(20) NOT NULL,
  `nombreplaces` int(10) NOT NULL,
  `booleenPaiementEffectue` tinyint(1) NOT NULL DEFAULT '0',
  `idReservation` int(20) NOT NULL,
  `codeReservation` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Visites`
--

CREATE TABLE `Visites` (
  `typeVisite` varchar(20) NOT NULL,
  `ville` varchar(20) NOT NULL,
  `dateVisite` date NOT NULL,
  `prixVisite` double UNSIGNED NOT NULL,
  `idVisite` int(20) NOT NULL,
  `codeVisite` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Visites`
--

INSERT INTO `Visites` (`typeVisite`, `ville`, `dateVisite`, `prixVisite`, `idVisite`, `codeVisite`) VALUES
('musée art', 'nantes', '2020-03-13', 49.99, 1, 'munantes130320'),
('croisière', 'angers', '2020-04-02', 19.99, 2, 'crangers020420'),
('monument cathédrale', 'angers', '2020-04-04', 1.99, 3, 'moangers040420'),
('parc', 'angers', '2020-04-04', 2.99, 4, 'paangers040420');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Clients`
--
ALTER TABLE `Clients`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `Reservations`
--
ALTER TABLE `Reservations`
  ADD PRIMARY KEY (`idReservation`),
  ADD UNIQUE KEY `codeReservation` (`codeReservation`),
  ADD KEY `idVisite` (`idVisite`),
  ADD KEY `idClient` (`idClient`);

--
-- Index pour la table `Visites`
--
ALTER TABLE `Visites`
  ADD PRIMARY KEY (`idVisite`),
  ADD UNIQUE KEY `codeVisite` (`codeVisite`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Clients`
--
ALTER TABLE `Clients`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Reservations`
--
ALTER TABLE `Reservations`
  MODIFY `idReservation` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Visites`
--
ALTER TABLE `Visites`
  MODIFY `idVisite` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Reservations`
--
ALTER TABLE `Reservations`
  ADD CONSTRAINT `Reservations_ibfk_1` FOREIGN KEY (`idVisite`) REFERENCES `Visites` (`idVisite`),
  ADD CONSTRAINT `Reservations_ibfk_2` FOREIGN KEY (`idClient`) REFERENCES `Clients` (`idClient`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;