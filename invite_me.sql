-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2023 at 05:33 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `invite.me`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendee`
--

CREATE TABLE `attendee` (
  `attendeetId` int(11) NOT NULL,
  `fullName` int(11) NOT NULL,
  `contactDetails` int(11) NOT NULL,
  `dob` int(11) NOT NULL,
  `eventName` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `eventId` int(11) NOT NULL,
  `eventName` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `date` varchar(10) NOT NULL,
  `duration` varchar(5) NOT NULL,
  `price` varchar(10) NOT NULL,
  `venue` text NOT NULL,
  `type` text NOT NULL,
  `speaker` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`eventId`, `eventName`, `description`, `date`, `duration`, `price`, `venue`, `type`, `speaker`) VALUES
(3, 'C++', 'sf', 'df', 'sdfwe', 'wr', 'wet', 'workshop', 'MUNTASWIR'),
(6, 'FRCI', 'test', 'test', 'test', 'test', 'PHOENIX', 'seminar', 'Akthar'),
(9, 'DevCon', 'Test', 'Test', 'Test', 'Test', 'Test', 'Conference', 'Faar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendee`
--
ALTER TABLE `attendee`
  ADD PRIMARY KEY (`attendeetId`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`eventId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendee`
--
ALTER TABLE `attendee`
  MODIFY `attendeetId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `eventId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
