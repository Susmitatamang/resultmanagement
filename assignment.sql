-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 03, 2020 at 12:42 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `assignment`
--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `Result_ID` int(11) NOT NULL,
  `Student_Id` int(255) NOT NULL,
  `Subject_Code` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`Result_ID`, `Student_Id`, `Subject_Code`) VALUES
(100, 7, 'acvbff12'),
(67, 7, 'acvbff12');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `S_ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Roll_No` int(5) NOT NULL,
  `Class` varchar(10) NOT NULL,
  `Section` varchar(10) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `DOB` varchar(20) NOT NULL,
  `Address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`S_ID`, `Name`, `Roll_No`, `Class`, `Section`, `Gender`, `DOB`, `Address`) VALUES
(1, 'ram', 1, '25', 'A', 'Male', '1/aug/1990', 'as'),
(2, 'ram thapa', 7, '25', 'A', 'Male', '1/aug/1997', 'anamnagar'),
(3, 'ram', 2, '25', 'A', 'Male', '1/aug/1999', 'address'),
(4, 'ram thapa', 4, '25', 'A', 'Male', '2/aug/2001987', 'anamnagar');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `Sub_code` varchar(15) NOT NULL,
  `Subject` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`Sub_code`, `Subject`) VALUES
('asdfsgd45', 'C#'),
('asdfsgd50', 'php'),
('asdfsgd60', 'java'),
('asdfsgd65', 'bootstrap'),
('sasdfsgd67', 'css');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`Result_ID`),
  ADD KEY `Student_Id` (`Student_Id`),
  ADD KEY `Subject_Code` (`Subject_Code`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`S_ID`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`Sub_code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `S_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `result`
--
ALTER TABLE `result`
  ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`Student_Id`) REFERENCES `student` (`S_ID`),
  ADD CONSTRAINT `result_ibfk_2` FOREIGN KEY (`Subject_Code`) REFERENCES `subject` (`Sub_code`);
COMMIT;

--
ALTER TABLE `student`
MODIFY `rollno` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
