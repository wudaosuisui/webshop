-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2017-12-18 01:11:05
-- 服务器版本： 5.7.18
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fairybook`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE `admin` (
  `loginName` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `admin`
--

INSERT INTO `admin` (`loginName`, `password`) VALUES
('admin', '123');

-- --------------------------------------------------------

--
-- 表的结构 `book`
--

CREATE TABLE `book` (
  `id` int(10) NOT NULL,
  `category` int(10) NOT NULL,
  `name` char(20) NOT NULL,
  `img` char(100) DEFAULT NULL,
  `press` char(20) DEFAULT NULL,
  `author` char(20) DEFAULT NULL,
  `price` int(20) DEFAULT NULL,
  `sell` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `book`
--

INSERT INTO `book` (`id`, `category`, `name`, `img`, `press`, `author`, `price`, `sell`) VALUES
(2, 1, 'JAVA', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 30, 1),
(3, 2, 'Linux', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 40, 1),
(5, 3, 'Spring', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(6, 1, 'Hibernate', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 30, 1),
(8, 1, 'JavaEE', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 0),
(9, 1, 'JavaBook1', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(10, 1, 'JavaBook2', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(11, 1, 'JavaBook3', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(12, 1, 'JavaBook4', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(13, 1, 'JavaBook5', '', 'ChuBanshe', 'ZuoZhe', 45, 1),
(14, 1, 'JavaBook6', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(15, 1, 'JavaBook7', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(16, 1, 'JavaBook8', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(17, 1, 'JavaBook9', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(18, 1, 'JavaBook10', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(19, 1, 'JavaBook11', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(20, 1, 'JavaBook12', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(21, 1, 'JavaBook13', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(22, 1, 'JavaBook14', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(23, 1, 'JavaBook15', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(24, 1, 'JavaBook16', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(25, 1, 'JavaBook17', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(26, 1, 'JavaBook18', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1),
(27, 1, 'JavaBook19', 'E:\\Program Files\\JavaEE\\eclipseWork\\FairyBook\\WebContent\\img\\Linux1.jpg', 'ChuBanshe', 'ZuoZhe', 45, 1);

-- --------------------------------------------------------

--
-- 表的结构 `cart`
--

CREATE TABLE `cart` (
  `userInfoId` int(20) DEFAULT NULL,
  `bookId` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `cart`
--

INSERT INTO `cart` (`userInfoId`, `bookId`) VALUES
(2, 2),
(2, 3),
(2, 2),
(3, 2),
(3, 2),
(3, 2),
(3, 2);

-- --------------------------------------------------------

--
-- 表的结构 `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(1024) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'java'),
(2, 'linux'),
(3, 'Spring'),
(4, 'Hibernates'),
(5, 'JavaEE'),
(6, 'WEB'),
(7, 'JavaScript'),
(8, 'JavaEE'),
(9, 'JavaSE'),
(10, 'test'),
(11, 'test');

-- --------------------------------------------------------

--
-- 表的结构 `orders`
--

CREATE TABLE `orders` (
  `id` int(20) NOT NULL,
  `Time` date DEFAULT NULL,
  `userInfo` int(20) DEFAULT NULL,
  `price` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `orders`
--

INSERT INTO `orders` (`id`, `Time`, `userInfo`, `price`) VALUES
(1, '2017-12-06', 1, 0),
(2, '2017-12-07', 1, 10),
(3, '2017-12-07', 1, 0),
(4, '2017-12-14', 2, 110),
(5, '2017-12-14', 2, 140),
(6, '2017-12-14', 2, 175),
(7, '2017-12-14', 2, 85),
(8, '2017-12-14', 2, 225),
(9, '2017-12-14', 2, 80),
(10, '2017-12-14', 2, 40),
(11, '2017-12-14', 3, 145),
(12, '2017-12-14', 3, 85),
(13, '2017-12-14', 4, 60),
(14, '2017-12-14', 4, 60),
(15, '2017-12-14', 4, 40),
(16, '2017-12-14', 4, 60),
(17, '2017-12-15', 3, 80),
(18, '2017-12-15', 3, 80),
(19, '2017-12-15', 3, 80),
(20, '2017-12-15', 3, 80),
(21, '2017-12-15', 3, 80),
(22, '2017-12-15', 3, 80),
(23, '2017-12-15', 3, 125),
(24, '2017-12-15', 3, 170),
(25, '2017-12-16', 3, 280),
(26, '2017-12-16', 3, 190),
(27, '2017-12-16', 3, 150),
(28, '2017-12-16', 3, 180),
(29, '2017-12-16', 3, 85),
(30, '2017-12-16', 3, 85),
(31, '2017-12-17', 3, 85),
(32, '2017-12-17', 3, 190),
(33, '2017-12-17', 3, 265),
(34, '2017-12-17', 3, 190),
(35, '2017-12-17', 3, 75),
(36, '2017-12-17', 3, 265),
(37, '2017-12-17', 3, 265),
(38, '2017-12-17', 3, 220),
(39, '2017-12-17', 3, 295),
(40, '2017-12-17', 3, 90);

-- --------------------------------------------------------

--
-- 表的结构 `ordersitem`
--

CREATE TABLE `ordersitem` (
  `id` int(20) NOT NULL,
  `bookid` int(20) DEFAULT NULL,
  `number` int(20) DEFAULT NULL,
  `price` int(20) DEFAULT NULL,
  `ordersid` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `ordersitem`
--

INSERT INTO `ordersitem` (`id`, `bookid`, `number`, `price`, `ordersid`) VALUES
(1, 2, 1, 30, 2),
(2, 3, 1, 40, 2),
(3, 5, 1, 45, 2),
(4, 6, 1, 30, 2),
(5, 2, 1, 30, 3),
(6, 3, 1, 40, 3),
(7, 5, 1, 45, 3),
(8, 6, 1, 30, 3),
(9, 2, 1, 30, 4),
(10, 3, 2, 80, 4),
(11, 2, 2, 60, 5),
(12, 3, 2, 80, 5),
(13, 2, 2, 60, 6),
(14, 3, 1, 40, 6),
(15, 5, 1, 45, 6),
(16, 6, 1, 30, 6),
(17, 3, 1, 40, 7),
(18, 5, 1, 45, 7),
(19, 5, 3, 135, 8),
(20, 6, 3, 90, 8),
(21, 3, 2, 80, 9),
(22, 3, 1, 40, 10),
(23, 2, 2, 60, 11),
(24, 3, 1, 40, 11),
(25, 5, 1, 45, 11),
(26, 3, 1, 40, 12),
(27, 5, 1, 45, 12),
(28, 2, 2, 60, 13),
(29, 2, 2, 60, 14),
(30, 3, 1, 40, 15),
(31, 2, 2, 60, 16),
(32, 3, 2, 80, 17),
(33, 3, 2, 80, 18),
(34, 3, 2, 80, 19),
(35, 3, 2, 80, 20),
(36, 3, 2, 80, 21),
(37, 3, 2, 80, 22),
(38, 3, 2, 80, 23),
(39, 5, 1, 45, 23),
(40, 3, 2, 80, 24),
(41, 5, 2, 90, 24),
(42, 2, 5, 150, 25),
(43, 8, 1, 45, 25),
(44, 3, 1, 40, 25),
(45, 5, 1, 45, 25),
(46, 2, 5, 150, 26),
(47, 3, 1, 40, 26),
(48, 2, 5, 150, 27),
(49, 2, 6, 180, 28),
(50, 3, 1, 40, 29),
(51, 5, 1, 45, 29),
(52, 3, 1, 40, 30),
(53, 5, 1, 45, 30),
(54, 3, 1, 40, 31),
(55, 5, 1, 45, 31),
(56, 2, 5, 150, 32),
(57, 3, 1, 40, 32),
(58, 2, 5, 150, 33),
(59, 3, 1, 40, 33),
(60, 5, 1, 45, 33),
(61, 6, 1, 30, 33),
(62, 2, 5, 150, 34),
(63, 3, 1, 40, 34),
(64, 5, 1, 45, 35),
(65, 6, 1, 30, 35),
(66, 2, 5, 150, 36),
(67, 3, 1, 40, 36),
(68, 5, 1, 45, 36),
(69, 6, 1, 30, 36),
(70, 2, 5, 150, 37),
(71, 3, 1, 40, 37),
(72, 5, 1, 45, 37),
(73, 6, 1, 30, 37),
(74, 2, 6, 180, 38),
(75, 3, 1, 40, 38),
(76, 2, 6, 180, 39),
(77, 3, 1, 40, 39),
(78, 5, 1, 45, 39),
(79, 6, 1, 30, 39),
(80, 19, 1, 45, 40),
(81, 26, 1, 45, 40);

-- --------------------------------------------------------

--
-- 表的结构 `userinfo`
--

CREATE TABLE `userinfo` (
  `id` int(20) NOT NULL,
  `userLogin` varchar(40) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `slogan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `userinfo`
--

INSERT INTO `userinfo` (`id`, `userLogin`, `name`, `slogan`) VALUES
(1, 'user', 'username', 'I\'m user!!'),
(2, 'user2', 'user2name', 'I\'m user2!!'),
(3, 'user3', 'user3name', 'I\'m user3!!'),
(4, 'user4', 'user4name', 'I\'m user4!!'),
(5, 'user5', 'user5name', 'I\'m user5!!!'),
(6, 'user6', 'user6name', 'I\'m user6!!!'),
(7, 'user7', 'user7name', 'I\'m user7!!!'),
(8, 'user8', 'user8name', 'I\'m user8!!!');

-- --------------------------------------------------------

--
-- 表的结构 `userlogin`
--

CREATE TABLE `userlogin` (
  `LoginName` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `userlogin`
--

INSERT INTO `userlogin` (`LoginName`, `Password`) VALUES
('user', '123'),
('user2', '123'),
('user3', '123'),
('user4', '123'),
('user5', '123'),
('user6', '123'),
('user7', '123'),
('user8', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`loginName`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ordersitem`
--
ALTER TABLE `ordersitem`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userlogin`
--
ALTER TABLE `userlogin`
  ADD PRIMARY KEY (`LoginName`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
