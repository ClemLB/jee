-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 13 Mars 2020 à 16:29
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

--
-- Contenu de la table `Reservations`
--

INSERT INTO `Reservations` (`idVisite`, `idClient`, `nombreplaces`, `booleenPaiementEffectue`, `idReservation`, `codeReservation`) VALUES
(10, 1, 5, 0, 2, 'JsrZmwh'),
(2, 1, 1, 1, 3, 'gQcUecl');

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
('musee art', 'Nantes', '2020-03-13', 49.99, 1, 'munantes13032020'),
('croisiere', 'Angers', '2020-04-02', 19.99, 2, 'crangers02042020'),
('monument cathedrale', 'Angers', '2020-04-04', 1.99, 3, 'moangers04042020'),
('parc', 'Angers', '2020-04-04', 2.99, 4, 'paangers04042020'),
('city tour', 'Paris', '2020-04-09', 29.99, 5, 'ctparis09042020'),
('gastronomie', 'Strasbourg', '2020-03-31', 34.99, 6, 'gastrasbourg31032020'),
('catacombe', 'Paris', '2020-05-27', 14.99, 7, 'caparis27052020'),
('spatial', 'CVFC-02', '3042-02-28', 149.99, 8, 'spcvfc28023042'),
('cybercore', 'The Grid', '3000-04-30', 49.99, 9, 'cythegrid30043000'),
('World Trade Center', 'New York', '2021-06-08', 17.53, 10, 'WTCnewyork08062021');

--
-- Index pour les tables exportées
--

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
-- AUTO_INCREMENT pour la table `Reservations`
--
ALTER TABLE `Reservations`
  MODIFY `idReservation` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Visites`
--
ALTER TABLE `Visites`
  MODIFY `idVisite` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Reservations`
--
ALTER TABLE `Reservations`
  ADD CONSTRAINT `Reservations_ibfk_1` FOREIGN KEY (`idVisite`) REFERENCES `Visites` (`idVisite`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
