-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 25, 2026 at 01:29 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurantdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `email`, `password`) VALUES
(1, 'Nimra', 'nimra12@gmail.com', 'nimo');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `email`, `password`) VALUES
(1, 'Banin ', 'banin23@gmail.com', 'bano'),
(2, 'Mahnoor', 'mahnoor56@gmail.com', 'mahnoo'),
(3, 'Emaan', 'emaan@gmail.com', 'emaan123'),
(5, 'aqsa', 'aqsa@gmail.com', 'red');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `category` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `name`, `price`, `category`) VALUES
(1, 'Chicken Nuggets', 350, 'Appetizers'),
(2, 'Spring Rolls', 300, 'Appetizers'),
(3, 'French Fries', 200, 'Appetizers'),
(4, 'Coke 500ml', 120, 'Cold Drinks'),
(5, 'Sprite 500ml', 120, 'Cold Drinks'),
(6, 'Mineral Water 500ml', 60, 'Cold Drinks'),
(7, 'Masala Chai', 100, 'Chai'),
(8, 'Green Tea', 120, 'Chai'),
(9, 'Chicken Manchurian', 650, 'Chinese Dishes'),
(10, 'Sweet & Sour Chicken', 650, 'Chinese Dishes'),
(11, 'Chow Mein (Veg)', 400, 'Chinese Dishes'),
(12, 'Spaghetti Bolognese', 700, 'Italian Dishes'),
(13, 'Margherita Pizza', 1000, 'Italian Dishes'),
(14, 'Lasagna', 900, 'Italian Dishes'),
(15, 'Chicken Biryani 1 Plate', 550, 'Pakistani Dishes'),
(16, 'Beef Karahi 1 Plate', 700, 'Pakistani Dishes'),
(17, 'Nihari 1 Plate', 800, 'Pakistani Dishes'),
(18, 'Vanilla Ice Cream Scoop', 150, 'Ice Cream'),
(19, 'Chocolate Ice Cream Scoop', 150, 'Ice Cream'),
(21, 'Shami Kabab ', 600, 'Pakistani Dishes'),
(22, 'Shawarma', 150, 'Fast Food');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
