-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 13, 2024 at 01:41 PM
-- Server version: 8.3.0
-- PHP Version: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mobimart`
--

-- --------------------------------------------------------

--
-- Table structure for table `addcart`
--

DROP TABLE IF EXISTS `addcart`;
CREATE TABLE IF NOT EXISTS `addcart` (
  `carttid` int NOT NULL AUTO_INCREMENT,
  `qty` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `pid` int DEFAULT NULL,
  PRIMARY KEY (`carttid`),
  KEY `addcart_ibfk_1` (`email`),
  KEY `addcart_ibfk_2` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `addcart`
--

INSERT INTO `addcart` (`carttid`, `qty`, `price`, `email`, `pid`) VALUES
(5, 1, 32999, 'jay@gmail.com', 16),
(9, 5, 164995, 'shyam1@gmail.com', 16),
(17, 2, 65998, 'jay@gmail.com', 16),
(18, 3, 98997, 'jay@gmail.com', 16),
(19, 1, 32999, 'jay@gmail.com', 16),
(20, 2, 65998, 'jay@gmail.com', 16),
(21, 2, 65998, 'jay@gmail.com', 16),
(23, 2, 65998, 'jay@gmail.com', 16),
(36, 1, 32999, 'abhi@gmail.com', 16),
(37, 1, 32999, 'abhi@gmail.com', 16),
(38, 1, 32999, 'abhi@gmail.com', 16),
(39, 1, 32999, 'abhi@gmail.com', 16),
(42, 1, 32999, 'abhi@gmail.com', 16),
(43, 1, 32999, 'abhi@gmail.com', 16),
(46, 1, 32999, 'abhi@gmail.com', 16),
(47, 1, 32999, 'abhi@gmail.com', 16),
(55, 1, 25000, 'abhi@gmail.com', 20),
(56, 1, 25000, 'abhi@gmail.com', 20),
(57, 1, 25000, 'jay@gmail.com', 20);

-- --------------------------------------------------------

--
-- Table structure for table `brandmaster`
--

DROP TABLE IF EXISTS `brandmaster`;
CREATE TABLE IF NOT EXISTS `brandmaster` (
  `bid` int NOT NULL AUTO_INCREMENT,
  `bname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `brandmaster`
--

INSERT INTO `brandmaster` (`bid`, `bname`) VALUES
(1, 'Samsung');

-- --------------------------------------------------------

--
-- Table structure for table `categorymaster`
--

DROP TABLE IF EXISTS `categorymaster`;
CREATE TABLE IF NOT EXISTS `categorymaster` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `categorymaster`
--

INSERT INTO `categorymaster` (`cid`, `cname`) VALUES
(4, 'mobile');

-- --------------------------------------------------------

--
-- Table structure for table `groupmaster`
--

DROP TABLE IF EXISTS `groupmaster`;
CREATE TABLE IF NOT EXISTS `groupmaster` (
  `gid` int NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `groupmaster`
--

INSERT INTO `groupmaster` (`gid`, `gname`) VALUES
(1, 'admin'),
(2, 'user'),
(3, '{0}');

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
CREATE TABLE IF NOT EXISTS `orderdetails` (
  `odid` int NOT NULL AUTO_INCREMENT,
  `qty` int DEFAULT NULL,
  `rate` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `oid` int DEFAULT NULL,
  `pid` int DEFAULT NULL,
  PRIMARY KEY (`odid`),
  KEY `oid` (`oid`),
  KEY `pid` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ordermaster`
--

DROP TABLE IF EXISTS `ordermaster`;
CREATE TABLE IF NOT EXISTS `ordermaster` (
  `oid` int NOT NULL AUTO_INCREMENT,
  `odate` date DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `totalamount` int DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ordermaster`
--

INSERT INTO `ordermaster` (`oid`, `odate`, `email`, `totalamount`, `status`) VALUES
(1, '2023-12-04', 'lkm', 500, 'pr');

-- --------------------------------------------------------

--
-- Table structure for table `paymentmaster`
--

DROP TABLE IF EXISTS `paymentmaster`;
CREATE TABLE IF NOT EXISTS `paymentmaster` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `payment_type` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `oid` int DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `oid` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `productmaster`
--

DROP TABLE IF EXISTS `productmaster`;
CREATE TABLE IF NOT EXISTS `productmaster` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) DEFAULT NULL,
  `ram` varchar(30) DEFAULT NULL,
  `processor` varchar(30) DEFAULT NULL,
  `screen_size` varchar(30) DEFAULT NULL,
  `color` varchar(30) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `internalstorage` varchar(30) DEFAULT NULL,
  `networktype` varchar(30) DEFAULT NULL,
  `batterycapacity` varchar(30) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `productimage` varchar(400) DEFAULT NULL,
  `cid` int DEFAULT NULL,
  `bid` int DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `productmaster_ibfk_1` (`cid`),
  KEY `productmaster_ibfk_2` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `productmaster`
--

INSERT INTO `productmaster` (`pid`, `pname`, `ram`, `processor`, `screen_size`, `color`, `price`, `internalstorage`, `networktype`, `batterycapacity`, `description`, `quantity`, `productimage`, `cid`, `bid`) VALUES
(16, 'Samsung S23', '8 GB', '8050', '7.5 inch', 'black', 32999, '256 GB', '5G', '5500', 'Good Camera visuals.', 20, 'samsung s23.jpg', 4, 1),
(20, 'Oppo', '8 GB', '7050', '7.5 inch', 'Silvery Grey', 25000, '256 GB', '5G', '4500', 'Game boost', 15, 'oppo.jpg', 4, 1),
(22, 'Vivo v20', '16 GB', 'Qualcomm Snapdragon 720G', '6.44 ', 'Light Blue ', 25399, '512 GB', '5G', '4000', 'Battery still needs to improve considering ', 15, 'vivo.jpg', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
CREATE TABLE IF NOT EXISTS `registration` (
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `mobileno` int DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `pincode` int DEFAULT NULL,
  `gid` int DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`),
  KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`username`, `email`, `mobileno`, `address`, `pincode`, `gid`, `password`) VALUES
('Abhi', 'abhi@gmail.com', 123456789, 'surat', 123456, 2, 'PBKDF2WithHmacSHA256:2048:6xc08eBJhTFy78yVGasrph8Ue0gKnhBtQGP5PxvGneM=:njRq5alKXyO5IXSy53FsUf36S3U0LliLLiVzTMKgQ7k='),
('varun', 'hdjhjcb', 1234567898, 'surat', 123456, 2, 'PBKDF2WithHmacSHA256:2048:0EDj/9LIKtWlPKXglogHf5+l1tFj0rjEFhR0FbGhCOU=:Vf/iyDEaAh6saq8augbOH3kYe5o29yn2ov17S3+z5R8='),
('hitesh', 'hitesh@gmail.com', 1234567890, 'vapi', 394210, 2, 'PBKDF2WithHmacSHA256:2048:HDhAmQ96QqlOgDngYpvUDDbMcGFjYUUfSrQX0fzAO5g=:V6Z36uuy8YWXjWdJ9ryYJA/RdgHY4Lhhu/2lwAQ+wFc='),
('jay', 'jay@gmail.com', 123456789, 'surat', 123456, 2, 'PBKDF2WithHmacSHA256:2048:25lzm9B1UrWPOh6iyI6I8T7NzcIGuqIbBhx/kK0odxk=:FKQ4Yl1XwWtsZ4w7beSnzrn1ov5wAW4RSThgv3VRxv0='),
('hitesh', 'jigu@gmail.com ', 1234567898, 'vapi', 123456, 2, 'PBKDF2WithHmacSHA256:2048:dv4TKU4GqIH+soA8fMDil1N05Ynmp7w/+mUwpofO37k=:R9u4tpcbCpbsqMyjpF6QC++IR9/X+0VLqMkt9PoaB9E='),
('kunal', 'kunal@gmail.com', 1234567890, 'surat', 234567, 2, 'PBKDF2WithHmacSHA256:2048:UarvvRWEFoN2ajvcfZ5FFSK6SpWrNT0Txgw86zz/zJo=:Ojc4fysgAZdm3wGcFZGFtjj505yhfLAP8eEHW9IBmgU='),
('nidhi', 'nidhi@gmail.com', 123456789, 'surat', 123456, 2, 'PBKDF2WithHmacSHA256:2048:XecqZhPkUxJWRkEmRgojxuETwpJEBukLLLbm6mdHlXM=:07OCf5vQKPpRHoBM31WI8CZZWCHaQdvdmsa4Iv67Mao='),
('priyu', 'priyu@gmail.com', 1234567890, 'surat', 123456, 2, 'PBKDF2WithHmacSHA256:2048:hN6zaunBankA9RsStAvAx4SjK2B2/qTbsR2d+Vj/BmE=:26IN1CYw6g1vW8fUsIGZ2R0sesYoETXmFPqehlfjtqQ='),
('varun', 'sanjeev@gmail.com', 1234567898, 'surat', 123456, 2, 'PBKDF2WithHmacSHA256:2048:kbV849i5/8rOlzi9SSTV0scrNCxVZ9mfEeQUk3fc5ro=:mTYFKu5rPE6WmtWLZ0b5Ni9eglZD3gKU0K02EHrDBjY='),
('shyam', 'shyam1@gmail.com', 123456789, 'surat', 123456, 2, 'PBKDF2WithHmacSHA256:2048:AwO8rJRW0RvQXZTIAlTjWaOh8uQf1H7cZHkSonpQ9rQ=:NHyDJZZm9dDVzrUeHThR4lHDd0Z7kAX3y3L9PHoC2l4='),
('varun', 'v@gmail.com', 1234567898, 'surat', 123456, 2, 'PBKDF2WithHmacSHA256:2048:sF0Pz3nD34bDR16CoHx9Agv716D8c98bVE6GCNauNVs=:YwzWIglNgq9H2eQ3EMWsNfvpMS5h9/M3DLdpOE5cL3k='),
('divya', 'varu@gmail.com', 1234567898, 'surat', 123456, 2, 'PBKDF2WithHmacSHA256:2048:Ep/wEj9bEzjTbXm3RrhqPL+5/qPfmRG3RQ0KvzOvHEg=:ocWbRCYwGQINJYPJirfzO6q743wnpQgV+cjXs0GuMn8='),
('Varun', 'varunrajput@gmail.com', 995522001, 'Surat', 394210, 1, 'PBKDF2WithHmacSHA256:2048:+Xo69t5fm8kaIil6ImzNiCTlzd2tgeC1EylF2tza1G8=:7Ko3DtHHkkt4wA1QoAsUU9xUzAXryPHETNElEKZD5Ew=');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `addcart`
--
ALTER TABLE `addcart`
  ADD CONSTRAINT `addcart_ibfk_1` FOREIGN KEY (`email`) REFERENCES `registration` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `addcart_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `productmaster` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `ordermaster` (`oid`),
  ADD CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `paymentmaster` (`pid`);

--
-- Constraints for table `paymentmaster`
--
ALTER TABLE `paymentmaster`
  ADD CONSTRAINT `paymentmaster_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `ordermaster` (`oid`);

--
-- Constraints for table `productmaster`
--
ALTER TABLE `productmaster`
  ADD CONSTRAINT `productmaster_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `categorymaster` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productmaster_ibfk_2` FOREIGN KEY (`bid`) REFERENCES `brandmaster` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `registration`
--
ALTER TABLE `registration`
  ADD CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`gid`) REFERENCES `groupmaster` (`gid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
