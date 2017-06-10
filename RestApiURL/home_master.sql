-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 10, 2017 at 07:59 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `home_master`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(20) NOT NULL,
  `house` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `street`, `house`) VALUES
(11, 'street2', 'house2'),
(12, 'street', 'house'),
(13, 'street', 'house'),
(14, 'street', 'house');

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `mobile` varchar(15) NOT NULL,
  `address_id` int(10) NOT NULL,
  `birthday` date NOT NULL,
  `is_fnf` tinyint(1) NOT NULL,
  `email` varchar(100) NOT NULL,
  `type_of_contact` varchar(20) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `address_id` (`address_id`),
  UNIQUE KEY `address_id_2` (`address_id`),
  UNIQUE KEY `UKhdhcc7238a2lwr4yjw78qvlof` (`address_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`id`, `name`, `mobile`, `address_id`, `birthday`, `is_fnf`, `email`, `type_of_contact`, `description`) VALUES
(11, 'name21', 'mobile2', 11, '1992-11-11', 1, 'email', 'typeOfContact', 'description'),
(12, 'name', 'mobile', 12, '1992-11-11', 1, 'email', 'typeOfContact', 'description'),
(13, 'name', 'mobile', 13, '1992-11-11', 1, 'email', 'typeOfContact', 'description'),
(14, 'name', 'mobile', 14, '1992-11-11', 1, 'email', 'typeOfContact', 'description');

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE IF NOT EXISTS `task` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `task_description` varchar(200) NOT NULL,
  `date_of_creation` date NOT NULL,
  `schedule_date` date NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `status_id` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `task`
--


--
-- Constraints for dumped tables
--

--
-- Constraints for table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `contact_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKl0sju2uai8cgdtic18wy5hlfr` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`);
