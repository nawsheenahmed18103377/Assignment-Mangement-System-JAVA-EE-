-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 29, 2022 at 08:29 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `assignment_mgmt`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignments`
--

CREATE TABLE `assignments` (
  `asId` int(11) NOT NULL,
  `asName` varchar(300) NOT NULL,
  `asDetails` varchar(1000) NOT NULL,
  `asSubject` varchar(100) NOT NULL,
  `asFilePath` varchar(500) NOT NULL,
  `pubDate` date NOT NULL,
  `subDate` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assignments`
--

INSERT INTO `assignments` (`asId`, `asName`, `asDetails`, `asSubject`, `asFilePath`, `pubDate`, `subDate`) VALUES
(25, 'Java basics', 'Java introduction', 'JAVA SE', 'E:/FileDir/Assignments/Java Basic.docx', '2022-01-27', '2022-01-31');

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `markId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `asId` int(11) NOT NULL,
  `asName` varchar(300) NOT NULL,
  `mark` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`markId`, `userId`, `fullName`, `asId`, `asName`, `mark`) VALUES
(10, 21, 'Mashfique Ahmed Chowdhury', 25, 'Java basics', 5);

-- --------------------------------------------------------

--
-- Table structure for table `submited_assignments`
--

CREATE TABLE `submited_assignments` (
  `subAsId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `asId` int(11) NOT NULL,
  `asName` varchar(300) NOT NULL,
  `asDetails` varchar(1000) NOT NULL,
  `pubDate` date DEFAULT NULL,
  `subDate` date DEFAULT NULL,
  `asFilePath` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `submited_assignments`
--

INSERT INTO `submited_assignments` (`subAsId`, `userId`, `fullName`, `asId`, `asName`, `asDetails`, `pubDate`, `subDate`, `asFilePath`) VALUES
(30, 22, 'Sanzida Sharmin', 25, 'Java basics', 'Java introduction', '2022-01-27', '2022-01-31', 'E:/FileDir/SubmitedAssignment/Polymorphism.docx'),
(29, 21, 'Mashfique Ahmed Chowdhury', 25, 'Java basics', 'Java introduction', '2022-01-27', '2022-01-31', 'E:/FileDir/SubmitedAssignment/Design Patterns.docx');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(300) NOT NULL,
  `depertment` varchar(200) NOT NULL,
  `details` varchar(500) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `userType` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userId`, `fullName`, `gender`, `address`, `depertment`, `details`, `userName`, `pass`, `userType`) VALUES
(1, 'Abdullah Al Shafayet Bhuyan', 'MALE', 'Dhaka', 'CSE', 'Teacher', 'shafayet', '123', 1),
(20, 'Nawsheen Ahmed Chowdhury', 'FEMALE', 'dhaka', 'CSE', 'Teacher', 'nawsheen', '123', 1),
(21, 'Mashfique Ahmed Chowdhury', 'MALE', 'sylhet', 'CSE', 'Average Student', 'mashfique', '123', 0),
(22, 'Sanzida Sharmin', 'FEMALE', 'Sector: 10, Road: 12, House: 29, Uttara, Dhaka-1230', 'CSE', 'Good Student', 'sharmin', '123', 0),
(13, 'Sujata Nuha', 'FEMALE', 'Kishorganj', 'CE', 'Good Student', 'hira', '123', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignments`
--
ALTER TABLE `assignments`
  ADD PRIMARY KEY (`asId`);

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`markId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `asId` (`asId`);

--
-- Indexes for table `submited_assignments`
--
ALTER TABLE `submited_assignments`
  ADD PRIMARY KEY (`subAsId`),
  ADD KEY `asId` (`asId`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `userName` (`userName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assignments`
--
ALTER TABLE `assignments`
  MODIFY `asId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `marks`
--
ALTER TABLE `marks`
  MODIFY `markId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `submited_assignments`
--
ALTER TABLE `submited_assignments`
  MODIFY `subAsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
