-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 12 juin 2021 à 15:35
-- Version du serveur :  5.7.31
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `construction`
--

-- --------------------------------------------------------

--
-- Structure de la table `avoir`
--

DROP TABLE IF EXISTS `avoir`;
CREATE TABLE IF NOT EXISTS `avoir` (
  `numCommande` int(5) NOT NULL,
  `numProduit` int(5) NOT NULL,
  PRIMARY KEY (`numCommande`,`numProduit`),
  KEY `numCommande` (`numCommande`),
  KEY `numProduit` (`numProduit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `numCl` int(5) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `tel` int(10) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  PRIMARY KEY (`numCl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`numCl`, `nom`, `prenom`, `tel`, `adresse`) VALUES
(1, 'QASIMI', 'WALLID', 611898148, 'PARIS'),
(1213, 'NALISI', 'SAMIR', 611559056, 'CASA');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `numCommande` int(5) NOT NULL,
  `DateCommande` varchar(50) NOT NULL,
  `numCl` int(5) NOT NULL,
  PRIMARY KEY (`numCommande`),
  KEY `numCl` (`numCl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`numCommande`, `DateCommande`, `numCl`) VALUES
(2, '05/03/2021', 1),
(3, '22/06/2021', 1);

-- --------------------------------------------------------

--
-- Structure de la table `connexion`
--

DROP TABLE IF EXISTS `connexion`;
CREATE TABLE IF NOT EXISTS `connexion` (
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `connexion`
--

INSERT INTO `connexion` (`login`, `password`) VALUES
('Ahmed', '123'),
('Ahmed', '123');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `numFacture` int(5) NOT NULL,
  `DateFacture` varchar(50) NOT NULL,
  `montant` double NOT NULL,
  `numCommande` int(5) NOT NULL,
  PRIMARY KEY (`numFacture`),
  KEY `fk_facture` (`numCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`numFacture`, `DateFacture`, `montant`, `numCommande`) VALUES
(1001, '30/09/2020', 2000, 2),
(72690, '10/02/2021', 63890, 3);

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

DROP TABLE IF EXISTS `livraison`;
CREATE TABLE IF NOT EXISTS `livraison` (
  `numLivraison` int(5) NOT NULL,
  `dateLivraison` varchar(50) NOT NULL,
  `numCommande` int(5) NOT NULL,
  PRIMARY KEY (`numLivraison`),
  KEY `fk_livraison` (`numCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `livraison`
--

INSERT INTO `livraison` (`numLivraison`, `dateLivraison`, `numCommande`) VALUES
(12825, '12/12/2021', 3),
(45451, '28/07/2020', 2);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `numProduit` int(5) NOT NULL,
  `nomProduit` varchar(50) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`numProduit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`numProduit`, `nomProduit`, `quantite`, `prix`) VALUES
(9991, 'NANAH', 1, 100),
(66776, 'DELL', 5, 2000);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `avoir`
--
ALTER TABLE `avoir`
  ADD CONSTRAINT `fk1_avoir` FOREIGN KEY (`numCommande`) REFERENCES `commande` (`numCommande`),
  ADD CONSTRAINT `fk2_avoir` FOREIGN KEY (`numProduit`) REFERENCES `produit` (`numProduit`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`numCl`) REFERENCES `client` (`numCl`) ON DELETE CASCADE;

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `fk_facture` FOREIGN KEY (`numCommande`) REFERENCES `commande` (`numCommande`) ON DELETE CASCADE;

--
-- Contraintes pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD CONSTRAINT `fk_livraison` FOREIGN KEY (`numCommande`) REFERENCES `commande` (`numCommande`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
