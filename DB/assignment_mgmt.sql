/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.31 : Database - assignment_mgmt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`assignment_mgmt` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `assignment_mgmt`;

/*Table structure for table `assignments` */

DROP TABLE IF EXISTS `assignments`;

CREATE TABLE `assignments` (
  `asId` int(11) NOT NULL AUTO_INCREMENT,
  `asName` varchar(300) NOT NULL,
  `asDetails` varchar(1000) NOT NULL,
  `asSubject` varchar(100) NOT NULL,
  `asFilePath` varchar(500) NOT NULL,
  `pubDate` date NOT NULL,
  `subDate` date NOT NULL,
  PRIMARY KEY (`asId`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `assignments` */

/*Table structure for table `marks` */

DROP TABLE IF EXISTS `marks`;

CREATE TABLE `marks` (
  `markId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `asId` int(11) NOT NULL,
  `asName` varchar(300) NOT NULL,
  `mark` int(11) NOT NULL,
  PRIMARY KEY (`markId`),
  KEY `userId` (`userId`),
  KEY `asId` (`asId`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `marks` */

/*Table structure for table `submited_assignments` */

DROP TABLE IF EXISTS `submited_assignments`;

CREATE TABLE `submited_assignments` (
  `subAsId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `asId` int(11) NOT NULL,
  `asName` varchar(300) NOT NULL,
  `asDetails` varchar(1000) NOT NULL,
  `pubDate` date DEFAULT NULL,
  `subDate` date DEFAULT NULL,
  `asFilePath` varchar(500) NOT NULL,
  PRIMARY KEY (`subAsId`),
  KEY `asId` (`asId`),
  KEY `userId` (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

/*Data for the table `submited_assignments` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(255) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(300) NOT NULL,
  `depertment` varchar(200) NOT NULL,
  `details` varchar(500) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `userType` int(11) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`userId`,`fullName`,`gender`,`address`,`depertment`,`details`,`userName`,`pass`,`userType`) values 
(1,'Abdullah Al Shafayet Bhuyan','MALE','Dhaka','CSE','Average student','shafayet','123',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
