-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 07 mars 2022 à 22:06
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gym_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `appointment`
--

CREATE TABLE `appointment` (
  `id` int(11) NOT NULL,
  `start` date NOT NULL,
  `start_time` int(11) NOT NULL,
  `end_time` int(11) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `appointment`
--

INSERT INTO `appointment` (`id`, `start`, `start_time`, `end_time`, `description`, `location`) VALUES
(1, '2022-03-08', 12, 19, 'Add a trainer', 'loc'),
(4, '2022-03-08', 1, 6, 'Add a gym', 'ok'),
(5, '2022-03-10', 2, 6, 'Add a tip', 'my gym'),
(6, '2022-03-10', 7, 11, 'Check new members', 'null'),
(7, '2022-03-11', 2, 11, 'Add a product', 'null');

-- --------------------------------------------------------

--
-- Structure de la table `cart`
--

CREATE TABLE `cart` (
  `idC` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `total` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `nbr` int(11) NOT NULL,
  `category` int(11) NOT NULL,
  `planning` int(11) NOT NULL,
  `trainer` int(11) NOT NULL,
  `room` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `course_category`
--

CREATE TABLE `course_category` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `gym`
--

CREATE TABLE `gym` (
  `idG` int(11) NOT NULL,
  `location` varchar(255) NOT NULL,
  `facilities` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `gym`
--

INSERT INTO `gym` (`idG`, `location`, `facilities`) VALUES
(1, 'ok', 'ok'),
(2, 'ok2', 'okkkkk'),
(3, 'okk3', 'dkjfgbeg');

-- --------------------------------------------------------

--
-- Structure de la table `membership`
--

CREATE TABLE `membership` (
  `idm` int(11) NOT NULL,
  `expire_date` date NOT NULL,
  `start_date` date NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `membership`
--

INSERT INTO `membership` (`idm`, `expire_date`, `start_date`, `type`) VALUES
(1, '2020-04-18', '2020-04-18', '1 year'),
(5, '2023-02-27', '2022-02-27', '1 year'),
(6, '2022-03-27', '2022-02-27', '1 month'),
(7, '2022-05-27', '2022-02-27', '3 months'),
(8, '2022-05-29', '2022-01-22', '3 months'),
(9, '2022-06-01', '2022-03-01', '3 months'),
(10, '2022-06-01', '2022-03-01', '3 months'),
(11, '2022-04-06', '2022-03-06', '1 month'),
(12, '2022-06-06', '2022-03-06', '3 months'),
(13, '2022-06-06', '2022-03-06', '3 months'),
(14, '2022-06-07', '2022-03-07', '3 months');

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

CREATE TABLE `planning` (
  `id` int(11) NOT NULL,
  `start_date` int(11) NOT NULL,
  `end_date` int(11) DEFAULT NULL,
  `gym` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE `product` (
  `idP` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `quantity` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  `category` varchar(255) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`idP`, `name`, `quantity`, `description`, `category`, `price`) VALUES
(1, 'test', 22, 'test', 'gggg', 1222),
(2, 'test', 22, 'test', 'gggjjjjjj', 30);

-- --------------------------------------------------------

--
-- Structure de la table `purchase`
--

CREATE TABLE `purchase` (
  `idPu` int(11) NOT NULL,
  `idC` int(11) NOT NULL,
  `idP` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `user` int(11) NOT NULL,
  `course` int(11) NOT NULL,
  `trainer` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `room`
--

CREATE TABLE `room` (
  `idR` int(11) NOT NULL,
  `roomName` varchar(255) NOT NULL,
  `roomNumber` int(11) NOT NULL,
  `max_nbr` int(11) NOT NULL,
  `idgym` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `room`
--

INSERT INTO `room` (`idR`, `roomName`, `roomNumber`, `max_nbr`, `idgym`) VALUES
(1, 'Yoga', 2, 0, 1),
(3, 'Yoga', 2, 0, 1),
(5, 'piscine', 4, 0, 2),
(6, 'piscine', 4, 0, 2),
(8, 'tennis', 7, 0, 2),
(9, 'tennis', 7, 0, 3);

-- --------------------------------------------------------

--
-- Structure de la table `tip`
--

CREATE TABLE `tip` (
  `id` int(11) NOT NULL,
  `caption` varchar(200) NOT NULL,
  `category` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `role` varchar(20) NOT NULL,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `id_card` int(8) DEFAULT NULL,
  `height` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `training_level` varchar(30) DEFAULT NULL,
  `cost_per_hour` float DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `experience` varchar(200) DEFAULT NULL,
  `picture` varchar(300) DEFAULT 'file:/C:/Users/Asma/Downloads/img.png',
  `code` int(11) DEFAULT NULL,
  `membership` int(11) DEFAULT NULL,
  `gym` int(11) DEFAULT NULL,
  `block` varchar(10) DEFAULT NULL,
  `reports` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `role`, `first_name`, `last_name`, `email`, `password`, `id_card`, `height`, `weight`, `training_level`, `cost_per_hour`, `description`, `experience`, `picture`, `code`, `membership`, `gym`, `block`, `reports`) VALUES
(13, 'admin', 'Asma', 'Hejaiej', 'email@e.com', 'test', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'file:/C:/Users/Asma/Downloads/img.png', NULL, 8, NULL, 'n', NULL),
(18, 'trainer', 'trainerrrrr', 'trainer', 'test', 'train2', NULL, NULL, NULL, '', 5, 'tessssssst', 'trainer1234566', 'file:/C:/Users/Asma/Downloads/img.png', NULL, NULL, 1, 'y', 5),
(28, 'member', 'Asmaa', 'Hejaiej', 'asmah@gmail.com', 'gym2', 12345678, 1.69, 55, 'Intermediate', NULL, NULL, NULL, 'file:/C:/Users/Asma/Downloads/img.png', NULL, 5, NULL, 'n', NULL),
(46, 'trainer', 'f', 'f', 'hejaiej.asma@gmail.com', ';0+[pH6$\"l', NULL, NULL, NULL, '', 13, 'f', 'f', 'file:/C:/Users/Asma/Downloads/img.png', NULL, NULL, 2, 'n', 2),
(50, 'member', 'f', 'f', 'e@email.com', 'azerty9Z/', 12345678, 1, 1, 'Intermediate', NULL, NULL, NULL, 'file:/C:/Users/Asma/Downloads/img.png', NULL, 14, NULL, 'n', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`idC`),
  ADD KEY `user` (`user`) USING BTREE;

--
-- Index pour la table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category` (`category`),
  ADD KEY `planning` (`planning`),
  ADD KEY `trainer` (`trainer`),
  ADD KEY `room` (`room`);

--
-- Index pour la table `course_category`
--
ALTER TABLE `course_category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `gym`
--
ALTER TABLE `gym`
  ADD PRIMARY KEY (`idG`);

--
-- Index pour la table `membership`
--
ALTER TABLE `membership`
  ADD PRIMARY KEY (`idm`);

--
-- Index pour la table `planning`
--
ALTER TABLE `planning`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gym` (`gym`);

--
-- Index pour la table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`idP`);

--
-- Index pour la table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`idPu`),
  ADD UNIQUE KEY `idC_2` (`idC`,`idP`),
  ADD KEY `idC` (`idC`) USING BTREE,
  ADD KEY `idP` (`idP`) USING BTREE;

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user` (`user`),
  ADD KEY `course` (`course`),
  ADD KEY `trainer` (`trainer`) USING BTREE,
  ADD KEY `category` (`category`);

--
-- Index pour la table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`idR`),
  ADD KEY `idgym` (`idgym`);

--
-- Index pour la table `tip`
--
ALTER TABLE `tip`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category` (`category`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_ibfk_1` (`membership`),
  ADD KEY `gym` (`gym`) USING BTREE;

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `cart`
--
ALTER TABLE `cart`
  MODIFY `idC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `course_category`
--
ALTER TABLE `course_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `gym`
--
ALTER TABLE `gym`
  MODIFY `idG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `membership`
--
ALTER TABLE `membership`
  MODIFY `idm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `planning`
--
ALTER TABLE `planning`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `product`
--
ALTER TABLE `product`
  MODIFY `idP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `idPu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `room`
--
ALTER TABLE `room`
  MODIFY `idR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `tip`
--
ALTER TABLE `tip`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`category`) REFERENCES `course_category` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `course_ibfk_2` FOREIGN KEY (`planning`) REFERENCES `planning` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `course_ibfk_3` FOREIGN KEY (`trainer`) REFERENCES `user` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `course_ibfk_4` FOREIGN KEY (`room`) REFERENCES `room` (`idR`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `planning`
--
ALTER TABLE `planning`
  ADD CONSTRAINT `planning_ibfk_1` FOREIGN KEY (`gym`) REFERENCES `gym` (`idG`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`idC`) REFERENCES `cart` (`idC`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`idP`) REFERENCES `product` (`idP`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`trainer`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`trainer`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`category`) REFERENCES `course_category` (`id`),
  ADD CONSTRAINT `reservation_ibfk_4` FOREIGN KEY (`course`) REFERENCES `course` (`id`);

--
-- Contraintes pour la table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`idgym`) REFERENCES `gym` (`idG`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `tip`
--
ALTER TABLE `tip`
  ADD CONSTRAINT `tip_ibfk_1` FOREIGN KEY (`category`) REFERENCES `course_category` (`id`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_3` FOREIGN KEY (`gym`) REFERENCES `gym` (`idG`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_ibfk_4` FOREIGN KEY (`membership`) REFERENCES `membership` (`idm`) ON DELETE SET NULL ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
