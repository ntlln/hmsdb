-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 27, 2023 at 02:25 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hmsdb`
--
CREATE DATABASE IF NOT EXISTS `hmsdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `hmsdb`;

-- --------------------------------------------------------

--
-- Table structure for table `accountsTable`
--

CREATE TABLE `accountsTable` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `appointmentTable`
--

CREATE TABLE `appointmentTable` (
  `ID` int(11) NOT NULL,
  `Patient Name` text NOT NULL,
  `Guardian Name` text NOT NULL,
  `Phone Number` text NOT NULL,
  `Concern` text NOT NULL,
  `Date and Time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointmentTable`
--

INSERT INTO `appointmentTable` (`ID`, `Patient Name`, `Guardian Name`, `Phone Number`, `Concern`, `Date and Time`) VALUES
(1, ' John Smith', ' Mary Smith', ' 09012345678', ' General Check-up', ' Jan-05-2023 09:00 AM'),
(2, ' Jane Doe', ' Michael Doe', ' 09123456789', ' Flu Symptoms', ' Jan-07-2023 02:30 PM'),
(3, ' David Johnson', ' Sarah Johnson', ' 09234567890', ' Abdominal Pain', ' Jan-10-2023 11:15 AM'),
(4, ' Emily Brown', ' James Brown', ' 09345678901', ' Allergic Reaction', ' Jan-12-2023 04:45 PM'),
(5, ' Michael Davis', ' Lisa Davis', ' 09456789012', ' Headache', ' Jan-15-2023 10:30 AM'),
(6, ' Jessica Wilson', ' Robert Wilson', ' 09567890123', ' Sprained Ankle', ' Jan-20-2023 03:00 PM'),
(7, ' Andrew Thompson', ' Jennifer Thompson', ' 09678901234', ' Asthma Check-up', ' Jan-25-2023 01:45 PM'),
(8, ' Samantha Anderson', ' Daniel Anderson', ' 09789012345', ' High Fever', ' Jan-30-2023 09:30 AM'),
(9, ' Benjamin Martinez', ' Maria Martinez', ' 09890123456', ' Sore Throat', ' Feb-02-2023 11:00 AM'),
(10, ' Olivia Taylor', ' Christopher Taylor', ' 09901234567', ' Broken Arm', ' Feb-06-2023 02:15 PM'),
(11, ' Ethan Garcia', ' Kimberly Garcia', ' 09012345678', ' Allergic Rhinitis', ' Feb-10-2023 10:45 AM'),
(12, ' Ava Hernandez', ' Richard Hernandez', ' 09123456789', ' Eye Infection', ' Feb-13-2023 04:00 PM'),
(13, ' Noah Lopez', ' Amanda Lopez', ' 09234567890', ' Back Pain', ' Feb-16-2023 09:30 AM'),
(14, ' Mia Gonzalez', ' Jose Gonzalez', ' 09345678901', ' Cough and Cold', ' Feb-20-2023 01:45 PM'),
(15, ' James Smith', ' Emily Smith', ' 09456789012', ' Fatigue', ' Feb-23-2023 11:30 AM'),
(16, ' Sophia Johnson', ' Daniel Johnson', ' 09567890123', ' Urinary Tract Infection', ' Feb-28-2023 03:30 PM'),
(17, ' Jackson Brown', ' Sarah Brown', ' 09678901234', ' Sprained Wrist', ' Mar-05-2023 09:15 AM'),
(18, ' Olivia Davis', ' Michael Davis', ' 09789012345', ' Sinusitis', ' Mar-09-2023 02:00 PM'),
(19, ' Lucas Wilson', ' Jessica Wilson', ' 09890123456', ' Migraine', ' Mar-14-2023 10:45 AM'),
(20, ' Emma Thompson', ' Andrew Thompson', ' 09901234567', ' Stomach Flu', ' Mar-18-2023 04:30 PM'),
(21, ' Alexander Anderson', ' Samantha Anderson', ' 09012345678', ' Diabetes Check-up', ' Mar-22-2023 11:30 AM'),
(22, ' Isabella Martinez', ' Benjamin Martinez', ' 09123456789', ' Joint Pain', ' Mar-26-2023 03:15 PM'),
(23, ' Aiden Taylor', ' Olivia Taylor', ' 09234567890', ' Anxiety', ' Mar-30-2023 09:45 AM'),
(24, ' Sofia Garcia', ' Ethan Garcia', ' 09345678901', ' Skin Rash', ' Apr-04-2023 01:00 PM'),
(25, ' Liam Hernandez', ' Richard Hernandez', ' 09567890123', ' Ear Infection', ' Apr-08-2023 10:00 AM'),
(26, ' Harper Lopez', ' Noah Lopez', ' 09678901234', ' Sore Throat', ' Apr-12-2023 02:30 PM'),
(27, ' Benjamin Gonzalez', ' Mia Gonzalez', ' 09789012345', ' Fatigue', ' Apr-16-2023 11:15 AM'),
(28, ' Amelia Smith', ' Emily Smith', ' 09890123456', ' Allergic Rhinitis', ' Apr-20-2023 04:45 PM'),
(29, ' Oliver Johnson', ' Daniel Johnson', ' 09901234567', ' Eye Infection', ' Apr-24-2023 10:30 AM'),
(30, ' Evelyn Brown', ' Sarah Brown', ' 09012345678', ' Back Pain', ' Apr-28-2023 03:00 PM'),
(31, ' Henry Davis', ' Michael Davis', ' 09123456789', ' Cough and Cold', ' May-02-2023 01:45 PM'),
(32, ' Charlotte Wilson', ' Jessica Wilson', ' 09234567890', ' Fatigue', ' May-06-2023 09:30 AM'),
(33, ' William Thompson', ' Andrew Thompson', ' 09345678901', ' Urinary Tract Infection', ' May-10-2023 11:00 AM'),
(34, ' Amelia Anderson', ' Samantha Anderson', ' 09456789012', ' Sprained Ankle', ' May-14-2023 02:15 PM'),
(35, ' Noah Martinez', ' Benjamin Martinez', ' 09567890123', ' Sinusitis', ' May-18-2023 10:45 AM'),
(36, ' Emma Taylor', ' Olivia Taylor', ' 09678901234', ' Migraine', ' May-22-2023 04:00 PM'),
(37, ' James Garcia', ' Ethan Garcia', ' 09789012345', ' Stomach Pain', ' May-26-2023 09:30 AM'),
(38, ' Sophia Hernandez', ' Richard Hernandez', ' 09890123456', ' Fever', ' May-30-2023 01:45 PM'),
(39, ' Liam Johnson', ' Daniel Johnson', ' 09901234567', ' Sore Throat', ' Jun-03-2023 11:30 AM'),
(40, ' Olivia Brown', ' Sarah Brown', ' 09012345678', ' Sprained Wrist', ' Jun-07-2023 03:30 PM'),
(41, ' Lucas Davis', ' Michael Davis', ' 09123456789', ' Allergies', ' Jun-11-2023 09:15 AM'),
(42, ' Ava Wilson', ' Jessica Wilson', ' 09234567890', ' Headache', ' Jun-15-2023 02:00 PM'),
(43, ' Noah Thompson', ' Andrew Thompson', ' 09345678901', ' Abdominal Pain', ' Jun-19-2023 10:45 AM'),
(44, ' Mia Anderson', ' Samantha Anderson', ' 09456789012', ' Flu Symptoms', ' Jun-23-2023 04:30 PM'),
(45, ' Ethan Martinez', ' Benjamin Martinez', ' 09567890123', ' Sore Throat', ' Jun-27-2023 11:30 AM'),
(46, ' Isabella Taylor', ' Olivia Taylor', ' 09678901234', ' Eye Infection', ' Jul-01-2023 03:15 PM'),
(47, ' Aiden Garcia', ' Ethan Garcia', ' 09789012345', ' Rash', ' Jul-05-2023 09:45 AM'),
(48, ' Sofia Hernandez', ' Richard Hernandez', ' 09890123456', ' Earache', ' Jul-09-2023 01:00 PM'),
(49, ' Oliver Johnson', ' Daniel Johnson', ' 09901234567', ' Cough and Cold', ' Jul-13-2023 11:15 AM'),
(50, ' Mia Smith', ' Emily Smith', ' 09012345678', ' Fatigue', ' Jul-17-2023 04:30 PM'),
(51, ' Liam Hernandez', ' Richard Hernandez', ' 09567890123', ' Sinusitis', ' Jul-21-2023 10:30 AM'),
(52, ' Harper Lopez', ' Noah Lopez', ' 09678901234', ' Allergic Reaction', ' Jul-25-2023 03:45 PM'),
(53, ' Benjamin Gonzalez', ' Mia Gonzalez', ' 09789012345', ' Sore Throat', ' Jul-29-2023 11:00 AM'),
(54, ' Amelia Smith', ' Emily Smith', ' 09890123456', ' Sprained Ankle', ' Aug-02-2023 02:15 PM'),
(55, ' Oliver Johnson', ' Daniel Johnson', ' 09901234567', ' Eye Infection', ' Aug-06-2023 09:45 AM'),
(56, ' Evelyn Brown', ' Sarah Brown', ' 09012345678', ' Back Pain', ' Aug-10-2023 01:30 PM'),
(57, ' Henry Davis', ' Michael Davis', ' 09123456789', ' Migraine', ' Aug-14-2023 10:15 AM'),
(58, ' Charlotte Wilson', ' Jessica Wilson', ' 09234567890', ' Stomach Pain', ' Aug-18-2023 03:30 PM'),
(59, ' William Thompson', ' Andrew Thompson', ' 09345678901', ' Allergies', ' Aug-22-2023 09:30 AM'),
(60, ' Amelia Anderson', ' Samantha Anderson', ' 09456789012', ' Fever', ' Aug-26-2023 01:45 PM'),
(61, ' Noah Martinez', ' Benjamin Martinez', ' 09567890123', ' Sore Throat', ' Aug-30-2023 11:30 AM'),
(62, ' Emma Taylor', ' Olivia Taylor', ' 09678901234', ' Fatigue', ' Sep-03-2023 04:00 PM'),
(63, ' James Garcia', ' Ethan Garcia', ' 09789012345', ' Sprained Wrist', ' Sep-07-2023 09:45 AM'),
(64, ' Sophia Hernandez', ' Richard Hernandez', ' 09890123456', ' Earache', ' Sep-11-2023 01:30 PM'),
(65, ' Liam Johnson', ' Daniel Johnson', ' 09901234567', ' Cough and Cold', ' Sep-15-2023 11:15 AM'),
(66, ' Olivia Brown', ' Sarah Brown', ' 09012345678', ' Abdominal Pain', ' Sep-19-2023 03:45 PM'),
(67, ' Lucas Davis', ' Michael Davis', ' 09123456789', ' Rash', ' Sep-23-2023 10:30 AM'),
(68, ' Ava Wilson', ' Jessica Wilson', ' 09234567890', ' Headache', ' Sep-27-2023 02:45 PM'),
(69, ' Noah Thompson', ' Andrew Thompson', ' 09345678901', ' Fatigue', ' Oct-01-2023 09:15 AM'),
(70, ' Mia Anderson', ' Samantha Anderson', ' 09456789012', ' Sore Throat', ' Oct-05-2023 01:30 PM'),
(71, ' Ethan Martinez', ' Benjamin Martinez', ' 09567890123', ' Allergies', ' Oct-09-2023 10:45 AM'),
(72, ' Ava Taylor', ' Olivia Taylor', ' 09678901234', ' Back Pain', ' Oct-13-2023 03:15 PM'),
(73, ' Benjamin Garcia', ' Ethan Garcia', ' 09789012345', ' Sprained Ankle', ' Oct-17-2023 09:30 AM'),
(74, ' Harper Hernandez', ' Richard Hernandez', ' 09890123456', ' Sinusitis', ' Oct-21-2023 01:45 PM'),
(75, ' Sophia Johnson', ' Daniel Johnson', ' 09901234567', ' Cough and Cold', ' Oct-25-2023 11:30 AM'),
(76, ' Noah Smith', ' Emily Smith', ' 09012345678', ' Fever', ' Oct-29-2023 02:30 PM'),
(77, ' Mia Brown', ' Sarah Brown', ' 09123456789', ' Abdominal Pain', ' Nov-02-2023 10:00 AM'),
(78, ' Oliver Davis', ' Michael Davis', ' 09234567890', ' Sore Throat', ' Nov-06-2023 04:15 PM'),
(79, ' Emma Wilson', ' Jessica Wilson', ' 09345678901', ' Headache', ' Nov-10-2023 09:45 AM'),
(80, ' William Thompson', ' Andrew Thompson', ' 09456789012', ' Fatigue', ' Nov-14-2023 01:30 PM'),
(81, ' Amelia Anderson', ' Samantha Anderson', ' 09567890123', ' Rash', ' Nov-18-2023 11:15 AM'),
(82, ' James Martinez', ' Benjamin Martinez', ' 09678901234', ' Sprained Wrist', ' Nov-22-2023 03:45 PM'),
(83, ' Charlotte Taylor', ' Olivia Taylor', ' 09789012345', ' Allergic Reaction', ' Nov-26-2023 10:30 AM'),
(84, ' Lucas Garcia', ' Ethan Garcia', ' 09890123456', ' Earache', ' Nov-30-2023 01:45 PM'),
(85, ' Henry Hernandez', ' Richard Hernandez', ' 09901234567', ' Cough and Cold', ' Dec-04-2023 09:30 AM'),
(86, ' Evelyn Johnson', ' Daniel Johnson', ' 09012345678', ' Fatigue', ' Dec-08-2023 02:15 PM'),
(87, ' Benjamin Smith', ' Emily Smith', ' 09123456789', ' Sore Throat', ' Dec-12-2023 11:00 AM'),
(88, ' Mia Davis', ' Michael Davis', ' 09234567890', ' Allergies', ' Dec-16-2023 04:30 PM'),
(89, ' Oliver Wilson', ' Jessica Wilson', ' 09345678901', ' Sinusitis', ' Dec-20-2023 10:15 AM'),
(90, ' Harper Thompson', ' Andrew Thompson', ' 09456789012', ' Back Pain', ' Dec-24-2023 02:45 PM'),
(91, ' Sophia Anderson', ' Samantha Anderson', ' 09567890123', ' Migraine', ' Dec-28-2023 09:15 AM'),
(92, ' Noah Martinez', ' Benjamin Martinez', ' 09678901234', ' Stomach Pain', ' Jan-01-2024 01:30 PM'),
(93, ' Ava Taylor', ' Olivia Taylor', ' 09789012345', ' Allergic Reaction', ' Jan-05-2024 10:45 AM'),
(94, ' Ethan Garcia', ' Ethan Garcia', ' 09890123456', ' Sprained Ankle', ' Jan-09-2024 03:15 PM'),
(95, ' Mia Hernandez', ' Richard Hernandez', ' 09901234567', ' Sore Throat', ' Jan-13-2024 11:30 AM'),
(96, ' Benjamin Johnson', ' Daniel Johnson', ' 09012345678', ' Fatigue', ' Jan-17-2024 02:30 PM'),
(97, ' Harper Smith', ' Emily Smith', ' 09123456789', ' Eye Infection', ' Jan-21-2024 10:00 AM'),
(98, ' Sophia Brown', ' Sarah Brown', ' 09234567890', ' Back Pain', ' Jan-25-2024 04:15 PM'),
(99, ' Oliver Davis', ' Michael Davis', ' 09345678901', ' Migraine', ' Jan-29-2024 09:45 AM'),
(100, ' Emma Wilson', ' Jessica Wilson', ' 09456789012', ' Stomach Pain', ' Feb-02-2024 01:30 PM');

-- --------------------------------------------------------

--
-- Table structure for table `billingTable`
--

CREATE TABLE `billingTable` (
  `PID` int(11) NOT NULL,
  `Patient Name` text NOT NULL,
  `Guardian Name` text NOT NULL,
  `Phone Number` text NOT NULL,
  `Address` text NOT NULL,
  `Number of Stay` text NOT NULL,
  `Medication Total` text DEFAULT NULL,
  `Total Bill` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `inventoryTable`
--

CREATE TABLE `inventoryTable` (
  `ID` int(11) NOT NULL,
  `Product Name` text NOT NULL,
  `Manufacturer` text NOT NULL,
  `Quantity` text NOT NULL,
  `Price` text NOT NULL,
  `Expiry Date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventoryTable`
--

INSERT INTO `inventoryTable` (`ID`, `Product Name`, `Manufacturer`, `Quantity`, `Price`, `Expiry Date`) VALUES
(1, ' Aspirin           ', ' Bayer              ', ' 100      ', '329.45', ' 2023-12-31'),
(2, ' Ibuprofen         ', ' Advil              ', ' 50       ', '191.95', ' 2024-06-30'),
(3, ' Acetaminophen     ', ' Tylenol            ', ' 75       ', '274.45', ' 2023-11-15'),
(4, ' Omeprazole        ', ' Prilosec           ', ' 30       ', '494.45', ' 2024-04-30'),
(5, ' Simvastatin       ', ' Zocor              ', ' 60       ', '356.95', ' 2023-09-28'),
(6, ' Amoxicillin       ', ' Pfizer             ', ' 25       ', '549.45', ' 2024-02-15'),
(7, ' Loratadine        ', ' Claritin           ', ' 40       ', '411.95', ' 2023-10-31'),
(8, ' Prozac            ', ' Eli Lilly          ', ' 20       ', '714.45', ' 2024-03-15'),
(9, ' Metformin         ', ' Glucophage         ', ' 80       ', '329.45', ' 2023-08-30'),
(10, ' Albuterol         ', ' Ventolin           ', ' 15       ', '824.45', ' 2024-01-31'),
(11, ' Hydrochlorothiazide ', ' Microzide        ', ' 35       ', '384.45', ' 2023-07-31'),
(12, ' Sertraline        ', ' Zoloft             ', ' 45       ', '659.45', ' 2024-05-31'),
(13, ' Lipitor           ', ' Pfizer             ', ' 10       ', '989.45', ' 2023-11-30'),
(14, ' Cetirizine        ', ' Zyrtec             ', ' 55       ', '246.95', ' 2024-03-31'),
(15, ' Metoprolol        ', ' Toprol XL          ', ' 30       ', '466.95', ' 2023-09-30'),
(16, ' Amlodipine        ', ' Norvasc            ', ' 25       ', '439.45', ' 2024-02-29'),
(17, ' Escitalopram      ', ' Lexapro            ', ' 20       ', '604.45', ' 2023-08-31'),
(18, ' Azithromycin      ', ' Zithromax          ', ' 40       ', '521.95', ' 2024-01-31'),
(19, ' Losartan          ', ' Cozaar             ', ' 60       ', '384.45', ' 2023-07-31'),
(20, ' Warfarin          ', ' Coumadin           ', ' 90       ', '219.45', ' 2024-01-31'),
(21, ' Pantoprazole      ', ' Protonix           ', ' 15       ', '686.95', ' 2023-07-31'),
(22, ' Prednisone        ', ' Deltasone          ', ' 25       ', '301.95', ' 2024-01-31'),
(23, ' Zolpidem          ', ' Ambien             ', ' 30       ', '549.45', ' 2023-07-31'),
(24, ' Citalopram        ', ' Celexa             ', ' 50       ', '411.95', ' 2024-01-31'),
(25, ' Furosemide        ', ' Lasix              ', ' 40       ', '274.45', ' 2023-07-31'),
(26, ' Amphetamine       ', ' Adderall           ', ' 10       ', '824.45', ' 2024-01-31'),
(27, ' Trazodone         ', ' Desyrel            ', ' 20       ', '494.45', ' 2023-07-31'),
(28, ' Bupropion         ', ' Wellbutrin         ', ' 30       ', '384.45', ' 2024-01-31'),
(29, ' Atorvastatin      ', ' Lipitor            ', ' 40       ', '549.45', ' 2023-07-31'),
(30, ' Gabapentin        ', ' Neurontin          ', ' 50       ', '329.45', ' 2024-01-31'),
(31, ' Methotrexate      ', ' Trexall            ', ' 15       ', '714.45', ' 2023-07-31'),
(32, ' Fluticasone       ', ' Flonase            ', ' 25       ', '411.95', ' 2024-01-31'),
(33, ' Quetiapine        ', ' Seroquel           ', ' 35       ', '549.45', ' 2023-07-31'),
(34, ' Tamsulosin        ', ' Flomax             ', ' 30       ', '356.95', ' 2024-01-31'),
(35, ' Ciprofloxacin     ', ' Cipro              ', ' 20       ', '494.45', ' 2023-07-31'),
(36, ' Lisinopril        ', ' Prinivil           ', ' 40       ', '274.45', ' 2024-01-31'),
(37, ' Venlafaxine       ', ' Effexor            ', ' 50       ', '659.45', ' 2023-07-31'),
(38, ' Metronidazole     ', ' Flagyl             ', ' 15       ', '439.45', ' 2024-01-31'),
(39, ' Risperidone       ', ' Risperdal          ', ' 25       ', '549.45', ' 2023-07-31'),
(40, ' Atenolol          ', ' Tenormin           ', ' 30       ', '329.45', ' 2024-01-31'),
(41, ' Hydrocodone       ', ' Vicodin            ', ' 10       ', '824.45', ' 2023-07-31'),
(42, ' Escitalopram      ', ' Lexapro            ', ' 20       ', '494.45', ' 2024-01-31'),
(43, ' Azithromycin      ', ' Zithromax          ', ' 30       ', '384.45', ' 2023-07-31'),
(44, ' Alprazolam        ', ' Xanax              ', ' 25       ', '549.45', ' 2024-01-31'),
(45, ' Cephalexin        ', ' Keflex             ', ' 35       ', '301.95', ' 2023-07-31'),
(46, ' Ondansetron       ', ' Zofran             ', ' 40       ', '439.45', ' 2024-01-31'),
(47, ' Carvedilol        ', ' Coreg              ', ' 50       ', '466.95', ' 2023-07-31'),
(48, ' Clindamycin       ', ' Cleocin            ', ' 15       ', '659.45', ' 2024-01-31'),
(49, ' Tadalafil         ', ' Cialis             ', ' 20       ', '714.45', ' 2023-07-31'),
(50, ' Metformin         ', ' Glucophage         ', ' 30       ', '356.95', ' 2024-01-31'),
(51, ' Amoxicillin       ', ' Amoxil             ', ' 40       ', '549.45', ' 2023-07-31'),
(52, ' Oxycodone         ', ' OxyContin          ', ' 10       ', '824.45', ' 2024-01-31'),
(53, ' Tramadol          ', ' Ultram             ', ' 20       ', '466.95', ' 2023-07-31'),
(54, ' Fluoxetine        ', ' Prozac             ', ' 30       ', '384.45', ' 2024-01-31'),
(55, ' Levothyroxine     ', ' Synthroid          ', ' 25       ', '549.45', ' 2023-07-31'),
(56, ' Pravastatin       ', ' Pravachol          ', ' 35       ', '329.45', ' 2024-01-31'),
(57, ' Sertraline        ', ' Zoloft             ', ' 40       ', '439.45', ' 2023-07-31'),
(58, ' Amlodipine        ', ' Norvasc            ', ' 15       ', '659.45', ' 2024-01-31'),
(59, ' Allopurinol       ', ' Zyloprim           ', ' 20       ', '494.45', ' 2023-07-31'),
(60, ' Prednisone        ', ' Deltasone          ', ' 30       ', '384.45', ' 2024-01-31'),
(61, ' Montelukast       ', ' Singulair          ', ' 40       ', '549.45', ' 2023-07-31'),
(62, ' Losartan          ', ' Cozaar             ', ' 25       ', '411.95', ' 2024-01-31'),
(63, ' Hydrochlorothiazide ', ' Microzide        ', ' 35       ', '549.45', ' 2023-07-31'),
(64, ' Azithromycin      ', ' Zithromax          ', ' 40       ', '384.45', ' 2024-01-31'),
(65, ' Levothyroxine     ', ' Synthroid          ', ' 50       ', '494.45', ' 2023-07-31'),
(66, ' Atenolol          ', ' Tenormin           ', ' 30       ', '329.45', ' 2024-01-31'),
(67, ' Furosemide        ', ' Lasix              ', ' 20       ', '439.45', ' 2023-07-31'),
(68, ' Sertraline        ', ' Zoloft             ', ' 40       ', '549.45', ' 2024-01-31'),
(69, ' Lisinopril        ', ' Prinivil           ', ' 25       ', '356.95', ' 2023-07-31'),
(70, ' Quetiapine        ', ' Seroquel           ', ' 30       ', '494.45', ' 2024-01-31'),
(71, ' Trazodone         ', ' Desyrel            ', ' 35       ', '274.45', ' 2023-07-31'),
(72, ' Metoprolol        ', ' Lopressor          ', ' 40       ', '411.95', ' 2024-01-31'),
(73, ' Omeprazole        ', ' Prilosec           ', ' 25       ', '549.45', ' 2023-07-31'),
(74, ' Ciprofloxacin     ', ' Cipro              ', ' 30       ', '301.95', ' 2024-01-31'),
(75, ' Paroxetine        ', ' Paxil              ', ' 20       ', '494.45', ' 2023-07-31'),
(76, ' Metformin         ', ' Glucophage         ', ' 40       ', '549.45', ' 2024-01-31'),
(77, ' Fluticasone       ', ' Flonase            ', ' 50       ', '384.45', ' 2023-07-31'),
(78, ' Albuterol         ', ' Ventolin           ', ' 15       ', '659.45', ' 2024-01-31'),
(79, ' Amoxicillin       ', ' Amoxil             ', ' 20       ', '439.45', ' 2023-07-31'),
(80, ' Bupropion         ', ' Wellbutrin         ', ' 30       ', '549.45', ' 2024-01-31'),
(81, ' Hydrochlorothiazide ', ' Microzide        ', ' 35       ', '384.45', ' 2023-07-31'),
(82, ' Escitalopram      ', ' Lexapro            ', ' 25       ', '521.95', ' 2024-01-31'),
(83, ' Metronidazole     ', ' Flagyl             ', ' 30       ', '439.45', ' 2023-07-31'),
(84, ' Tamsulosin        ', ' Flomax             ', ' 40       ', '549.45', ' 2024-01-31'),
(85, ' Lisinopril        ', ' Prinivil           ', ' 25       ', '356.95', ' 2023-07-31'),
(86, ' Atenolol          ', ' Tenormin           ', ' 30       ', '494.45', ' 2024-01-31'),
(87, ' Fluoxetine        ', ' Prozac             ', ' 35       ', '301.95', ' 2023-07-31'),
(88, ' Montelukast       ', ' Singulair          ', ' 40       ', '439.45', ' 2024-01-31'),
(89, ' Alprazolam        ', ' Xanax              ', ' 20       ', '549.45', ' 2023-07-31'),
(90, ' Cephalexin        ', ' Keflex             ', ' 30       ', '466.95', ' 2024-01-31'),
(91, ' Pravastatin       ', ' Pravachol          ', ' 35       ', '384.45', ' 2023-07-31'),
(92, ' Metformin         ', ' Glucophage         ', ' 40       ', '549.45', ' 2024-01-31'),
(93, ' Levothyroxine     ', ' Synthroid          ', ' 25       ', '439.45', ' 2023-07-31'),
(94, ' Lisinopril        ', ' Prinivil           ', ' 30       ', '549.45', ' 2024-01-31'),
(95, ' Sertraline        ', ' Zoloft             ', ' 35       ', '329.45', ' 2023-07-31'),
(96, ' Amlodipine        ', ' Norvasc            ', ' 40       ', '494.45', ' 2024-01-31'),
(97, ' Azithromycin      ', ' Zithromax          ', ' 20       ', '356.95', ' 2023-07-31'),
(98, ' Venlafaxine       ', ' Effexor            ', ' 30       ', '549.45', ' 2024-01-31'),
(99, ' Metoprolol        ', ' Toprol XL          ', ' 25       ', '411.95', ' 2023-07-31'),
(100, ' Escitalopram      ', ' Lexapro            ', ' 30       ', '549.45', ' 2024-01-31');

-- --------------------------------------------------------

--
-- Table structure for table `patientTable`
--

CREATE TABLE `patientTable` (
  `PID` int(11) NOT NULL,
  `Patient Name` text NOT NULL,
  `Guardian Name` text NOT NULL,
  `Phone Number` text NOT NULL,
  `Address` text NOT NULL,
  `Allergies` text NOT NULL,
  `Admit` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patientTable`
--

INSERT INTO `patientTable` (`PID`, `Patient Name`, `Guardian Name`, `Phone Number`, `Address`, `Allergies`, `Admit`) VALUES
(1, ' John Smith', ' Mary Smith', ' 09012345678', ' 123 Main St', ' None', ' Yes'),
(2, ' Jane Doe', ' Michael Doe', ' 09123456789', ' 456 Elm St', ' Penicillin', ' No'),
(3, ' David Johnson', ' Sarah Johnson', ' 09234567890', ' 789 Oak Ave', ' None', ' Yes'),
(4, ' Emily Brown', ' James Brown', ' 09345678901', ' 321 Pine St', ' Latex', ' Yes'),
(5, ' Michael Davis', ' Lisa Davis', ' 09456789012', ' 567 Maple Ln', ' None', ' No'),
(6, ' Jessica Wilson', ' Robert Wilson', ' 09567890123', ' 890 Cedar Rd', ' None', ' Yes'),
(7, ' Andrew Thompson', ' Jennifer Thompson', ' 09678901234', ' 432 Birch Ave', ' Peanuts', ' Yes'),
(8, ' Samantha Anderson', ' Daniel Anderson', ' 09789012345', ' 765 Willow Ln', ' None', ' No'),
(9, ' Benjamin Martinez', ' Maria Martinez', ' 09890123456', ' 1098 Oak St', ' None', ' Yes'),
(10, ' Olivia Taylor', ' Christopher Taylor', ' 09901234567', ' 876 Pine Rd', ' None', ' No'),
(11, ' Ethan Garcia', ' Kimberly Garcia', ' 09012345678', ' 543 Elm St', ' None', ' Yes'),
(12, ' Ava Hernandez', ' Richard Hernandez', ' 09123456789', ' 210 Cedar Ave', ' None', ' No'),
(13, ' Noah Lopez', ' Amanda Lopez', ' 09234567890', ' 987 Maple Ln', ' None', ' Yes'),
(14, ' Mia Gonzalez', ' Jose Gonzalez', ' 09345678901', ' 654 Birch Rd', ' Eggs', ' Yes'),
(15, ' James Smith', ' Emily Smith', ' 09456789012', ' 321 Willow St', ' None', ' No'),
(16, ' Sophia Johnson', ' Daniel Johnson', ' 09567890123', ' 234 Oak Ave', ' None', ' Yes'),
(17, ' Jackson Brown', ' Sarah Brown', ' 09678901234', ' 567 Pine St', ' Peanuts', ' Yes'),
(18, ' Olivia Davis', ' Michael Davis', ' 09789012345', ' 890 Elm St', ' None', ' No'),
(19, ' Lucas Wilson', ' Jessica Wilson', ' 09890123456', ' 123 Cedar Rd', ' None', ' Yes'),
(20, ' Emma Thompson', ' Andrew Thompson', ' 09901234567', ' 456 Birch Ave', ' None', ' No'),
(21, ' Alexander Anderson', ' Samantha Anderson', ' 09012345678', ' 789 Willow Ln', ' None', ' Yes'),
(22, ' Isabella Martinez', ' Benjamin Martinez', ' 09123456789', ' 210 Oak St', ' Shellfish', ' No'),
(23, ' Aiden Taylor', ' Olivia Taylor', ' 09234567890', ' 543 Pine Rd', ' None', ' Yes'),
(24, ' Sofia Garcia', ' Ethan Garcia', ' 09345678901', ' 876 Elm St', ' None', ' Yes'),
(25, ' Liam Hernandez', ' Ava Hernandez', ' 09456789012', ' 1098 Cedar Ave', ' None', ' No'),
(26, ' Mia Lopez', ' Noah Lopez', ' 09567890123', ' 321 Maple Ln', ' None', ' Yes'),
(27, ' Lucas Gonzalez', ' Mia Gonzalez', ' 09678901234', ' 654 Birch Rd', ' None', ' Yes'),
(28, ' Olivia Smith', ' James Smith', ' 09789012345', ' 321 Willow St', ' Peanuts', ' No'),
(29, ' Emma Johnson', ' Sophia Johnson', ' 09890123456', ' 234 Oak Ave', ' None', ' Yes'),
(30, ' Alexander Brown', ' Jackson Brown', ' 09901234567', ' 567 Pine St', ' None', ' No'),
(31, ' Isabella Davis', ' Olivia Davis', ' 09012345678', ' 890 Elm St', ' None', ' Yes'),
(32, ' Aiden Wilson', ' Lucas Wilson', ' 09123456789', ' 123 Cedar Rd', ' None', ' Yes'),
(33, ' Sofia Thompson', ' Emma Thompson', ' 09234567890', ' 456 Birch Ave', ' None', ' No'),
(34, ' Liam Anderson', ' Alexander Anderson', ' 09345678901', ' 789 Willow Ln', ' None', ' Yes'),
(35, ' Mia Martinez', ' Isabella Martinez', ' 09456789012', ' 210 Oak St', ' None', ' No'),
(36, ' Lucas Taylor', ' Aiden Taylor', ' 09567890123', ' 543 Pine Rd', ' Peanuts', ' Yes'),
(37, ' Olivia Garcia', ' Sofia Garcia', ' 09678901234', ' 876 Elm St', ' None', ' Yes'),
(38, ' Emma Hernandez', ' Liam Hernandez', ' 09789012345', ' 1098 Cedar Ave', ' None', ' No'),
(39, ' Alexander Lopez', ' Mia Lopez', ' 09890123456', ' 321 Maple Ln', ' None', ' Yes'),
(40, ' Isabella Gonzalez', ' Lucas Gonzalez', ' 09901234567', ' 654 Birch Rd', ' None', ' No'),
(41, ' Aiden Smith', ' Olivia Smith', ' 09012345678', ' 321 Willow St', ' None', ' Yes'),
(42, ' Sofia Johnson', ' Emma Johnson', ' 09123456789', ' 234 Oak Ave', ' Eggs', ' Yes'),
(43, ' Liam Brown', ' Alexander Brown', ' 09234567890', ' 567 Pine St', ' None', ' No'),
(44, ' Mia Davis', ' Isabella Davis', ' 09345678901', ' 890 Elm St', ' None', ' Yes'),
(45, ' Lucas Wilson', ' Aiden Wilson', ' 09456789012', ' 123 Cedar Rd', ' None', ' Yes'),
(46, ' Olivia Thompson', ' Sofia Thompson', ' 09567890123', ' 456 Birch Ave', ' None', ' No'),
(47, ' Emma Anderson', ' Liam Anderson', ' 09678901234', ' 789 Willow Ln', ' Peanuts', ' Yes'),
(48, ' Alexander Martinez', ' Mia Martinez', ' 09789012345', ' 210 Oak St', ' None', ' No'),
(49, ' Isabella Taylor', ' Lucas Taylor', ' 09890123456', ' 543 Pine Rd', ' None', ' Yes'),
(50, ' Aiden Garcia', ' Olivia Garcia', ' 09901234567', ' 876 Elm St', ' None', ' No'),
(51, ' Sofia Hernandez', ' Emma Hernandez', ' 09012345678', ' 1098 Cedar Ave', ' None', ' Yes'),
(52, ' Liam Lopez', ' Alexander Lopez', ' 09123456789', ' 321 Maple Ln', ' None', ' Yes'),
(53, ' Mia Gonzalez', ' Isabella Gonzalez', ' 09234567890', ' 654 Birch Rd', ' None', ' No'),
(54, ' Lucas Smith', ' Aiden Smith', ' 09345678901', ' 321 Willow St', ' Peanuts', ' Yes'),
(55, ' Olivia Johnson', ' Sofia Johnson', ' 09456789012', ' 234 Oak Ave', ' None', ' Yes'),
(56, ' Emma Brown', ' Liam Brown', ' 09567890123', ' 567 Pine St', ' None', ' No'),
(57, ' Alexander Davis', ' Mia Davis', ' 09678901234', ' 890 Elm St', ' None', ' Yes'),
(58, ' Isabella Wilson', ' Lucas Wilson', ' 09789012345', ' 123 Cedar Rd', ' None', ' No'),
(59, ' Aiden Thompson', ' Olivia Thompson', ' 09890123456', ' 456 Birch Ave', ' Shellfish', ' Yes'),
(60, ' Sofia Anderson', ' Emma Anderson', ' 09901234567', ' 789 Willow Ln', ' None', ' No'),
(61, ' Liam Martinez', ' Alexander Martinez', ' 09012345678', ' 210 Oak St', ' None', ' Yes'),
(62, ' Mia Taylor', ' Isabella Taylor', ' 09123456789', ' 543 Pine Rd', ' None', ' Yes'),
(63, ' Lucas Garcia', ' Aiden Garcia', ' 09234567890', ' 876 Elm St', ' None', ' No'),
(64, ' Olivia Hernandez', ' Sofia Hernandez', ' 09345678901', ' 1098 Cedar Ave', ' None', ' Yes'),
(65, ' Emma Lopez', ' Liam Lopez', ' 09456789012', ' 321 Maple Ln', ' None', ' No'),
(66, ' Alexander Gonzalez', ' Mia Gonzalez', ' 09567890123', ' 654 Birch Rd', ' None', ' Yes'),
(67, ' Isabella Smith', ' Lucas Smith', ' 09678901234', ' 321 Willow St', ' Peanuts', ' Yes'),
(68, ' Aiden Johnson', ' Olivia Johnson', ' 09789012345', ' 234 Oak Ave', ' None', ' No'),
(69, ' Sofia Brown', ' Emma Brown', ' 09890123456', ' 567 Pine St', ' None', ' Yes'),
(70, ' Liam Davis', ' Alexander Davis', ' 09901234567', ' 890 Elm St', ' None', ' No'),
(71, ' Mia Wilson', ' Isabella Wilson', ' 09012345678', ' 123 Cedar Rd', ' None', ' Yes'),
(72, ' Lucas Thompson', ' Aiden Thompson', ' 09123456789', ' 456 Birch Ave', ' None', ' No'),
(73, ' Olivia Anderson', ' Sofia Anderson', ' 09234567890', ' 789 Willow Ln', ' None', ' Yes'),
(74, ' Emma Martinez', ' Liam Martinez', ' 09345678901', ' 210 Oak St', ' None', ' No'),
(75, ' Alexander Taylor', ' Mia Taylor', ' 09456789012', ' 543 Pine Rd', ' None', ' Yes'),
(76, ' Isabella Garcia', ' Lucas Garcia', ' 09567890123', ' 876 Elm St', ' Peanuts', ' Yes'),
(77, ' Aiden Hernandez', ' Olivia Hernandez', ' 09678901234', ' 1098 Cedar Ave', ' None', ' No'),
(78, ' Sofia Lopez', ' Emma Lopez', ' 09789012345', ' 321 Maple Ln', ' None', ' Yes'),
(79, ' Liam Gonzalez', ' Alexander Gonzalez', ' 09890123456', ' 654 Birch Rd', ' None', ' No'),
(80, ' Mia Smith', ' Isabella Smith', ' 09901234567', ' 321 Willow St', ' None', ' Yes'),
(81, ' Lucas Johnson', ' Aiden Johnson', ' 09012345678', ' 234 Oak Ave', ' None', ' Yes'),
(82, ' Olivia Brown', ' Sofia Brown', ' 09123456789', ' 567 Pine St', ' Eggs', ' No'),
(83, ' Emma Davis', ' Liam Davis', ' 09234567890', ' 890 Elm St', ' None', ' Yes'),
(84, ' Alexander Wilson', ' Mia Wilson', ' 09345678901', ' 123 Cedar Rd', ' None', ' Yes'),
(85, ' Isabella Thompson', ' Lucas Thompson', ' 09456789012', ' 456 Birch Ave', ' None', ' No'),
(86, ' Aiden Anderson', ' Olivia Anderson', ' 09567890123', ' 789 Willow Ln', ' None', ' Yes'),
(87, ' Sofia Martinez', ' Emma Martinez', ' 09678901234', ' 210 Oak St', ' None', ' No'),
(88, ' Liam Taylor', ' Alexander Taylor', ' 09789012345', ' 543 Pine Rd', ' None', ' Yes'),
(89, ' Mia Garcia', ' Isabella Garcia', ' 09890123456', ' 876 Elm St', ' None', ' No'),
(90, ' Lucas Hernandez', ' Aiden Hernandez', ' 09901234567', ' 1098 Cedar Ave', ' None', ' Yes'),
(91, ' Olivia Lopez', ' Sofia Lopez', ' 09012345678', ' 321 Maple Ln', ' None', ' Yes'),
(92, ' Emma Gonzalez', ' Liam Gonzalez', ' 09123456789', ' 654 Birch Rd', ' Peanuts', ' No'),
(93, ' Alexander Smith', ' Mia Smith', ' 09234567890', ' 321 Willow St', ' None', ' Yes'),
(94, ' Isabella Johnson', ' Lucas Johnson', ' 09345678901', ' 234 Oak Ave', ' None', ' Yes'),
(95, ' Aiden Brown', ' Olivia Brown', ' 09456789012', ' 567 Pine St', ' None', ' No'),
(96, ' Sofia Davis', ' Emma Davis', ' 09567890123', ' 890 Elm St', ' None', ' Yes'),
(97, ' Liam Wilson', ' Alexander Wilson', ' 09678901234', ' 123 Cedar Rd', ' None', ' No'),
(98, ' Mia Thompson', ' Isabella Thompson', ' 09789012345', ' 456 Birch Ave', ' Shellfish', ' Yes'),
(99, ' Lucas Anderson', ' Aiden Anderson', ' 09890123456', ' 789 Willow Ln', ' None', ' No'),
(100, ' Olivia Martinez', ' Sofia Martinez', ' 09901234567', ' 210 Oak St', ' None', ' Yes');

-- --------------------------------------------------------

--
-- Table structure for table `salesTable`
--

CREATE TABLE `salesTable` (
  `ID` int(11) NOT NULL,
  `Product Name` text NOT NULL,
  `Manufacturer` text NOT NULL,
  `Quantity` text NOT NULL,
  `Price` text NOT NULL,
  `Expiry Date` text NOT NULL,
  `Date and Time Sold` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `staffsTable`
--

CREATE TABLE `staffsTable` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Phone Number` text NOT NULL,
  `Date of Birth` text NOT NULL,
  `Gender` text NOT NULL,
  `Specialization` text NOT NULL,
  `Employment` text NOT NULL,
  `Availability` text NOT NULL,
  `Shift` text NOT NULL,
  `Additional Info` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staffsTable`
--

INSERT INTO `staffsTable` (`ID`, `Name`, `Phone Number`, `Date of Birth`, `Gender`, `Specialization`, `Employment`, `Availability`, `Shift`, `Additional Info`) VALUES
(127836, ' Sarah Wilson', ' 09789012345', ' Aug-22-1987', ' Female', ' Dermatology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(129563, ' Christopher Bell', ' 09890123456', ' Jan-23-1985', ' Male', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(174369, ' Emily Ross', ' 09123456789', ' Dec-28-1995', ' Female', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(187543, ' Noah Lee', ' 09890123456', ' Jul-07-1980', ' Male', ' Neurology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(196783, ' Olivia Turner', ' 09890123456', ' May-02-1988', ' Female', ' Neurology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(206847, ' Mia Lewis', ' 09567890123', ' Apr-08-1991', ' Female', ' Pediatrics', ' Part-time', ' Wed', ' Fri', ' Evening'),
(207596, ' Evelyn Foster', ' 09567890123', ' Apr-23-1989', ' Female', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(207913, ' Sofia Turner', ' 09901234567', ' Jun-01-1994', ' Female', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(208475, ' Olivia Sanders', ' 09901234567', ' Dec-07-1984', ' Female', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(247893, ' Elijah Hill', ' 09345678901', ' Oct-11-1983', ' Male', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(275914, ' Daniel Parker', ' 09345678901', ' Jun-05-1979', ' Male', ' Neurology', ' Part-time', ' Tue', ' Thu', ' Afternoon'),
(276830, ' Charlotte Carter', ' 09567890123', ' Feb-28-1989', ' Female', ' Neurology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(294785, ' Sophia Morris', ' 09456789012', ' Nov-16-1991', ' Female', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(305481, ' Victoria Russell', ' 09678901234', ' Jan-14-1986', ' Female', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(307894, ' Emily Simmons', ' 09345678901', ' Dec-06-1975', ' Female', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(309578, ' Olivia Flores', ' 09901234567', ' Oct-31-1986', ' Female', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(310869, ' Sofia Hayes', ' 09123456789', ' Jun-21-1978', ' Female', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(317982, ' Aiden Adams', ' 09234567890', ' Nov-27-1982', ' Male', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(318429, ' Emily Taylor', ' 09901234567', ' Oct-30-1992', ' Female', ' Orthopedics', ' Part-time', ' Tue', ' Thu', ' Afternoon'),
(318490, ' Mary Johnson', ' 09123456789', ' Feb-12-1985', ' Female', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(318740, ' Sophia Hayes', ' 09345678901', ' Apr-14-1982', ' Female', ' Dermatology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(341796, ' Samuel Cooper', ' 09123456789', ' Aug-04-1980', ' Male', ' Dermatology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(410827, ' Emily Scott', ' 09890123456', ' Mar-27-1987', ' Female', ' Dermatology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(418795, ' Samuel Thompson', ' 09012345678', ' Sep-09-1982', ' Male', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(428597, ' Charlotte Butler', ' 09567890123', ' Jun-22-1978', ' Female', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(428765, ' Ethan Hernandez', ' 09234567890', ' Jan-02-1975', ' Male', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(429168, ' Alexander Reynolds', ' 09678901234', ' Nov-12-1974', ' Male', ' Neurology', ' Part-time', ' Mon', ' Wed', ' Evening'),
(437826, ' William Lee', ' 09678901234', ' Mar-28-1987', ' Male', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(437926, ' Lillian Richardson', ' 09234567890', ' May-16-1991', ' Female', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(451970, ' Penelope Simmons', ' 09890123456', ' Mar-26-1992', ' Female', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(469328, ' Alexander Cox', ' 09345678901', ' Oct-21-1986', ' Male', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(469570, ' Jessica Davis', ' 09567890123', ' Jun-10-1988', ' Female', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(469825, ' Scarlett Ross', ' 09890123456', ' Nov-23-1990', ' Female', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(479631, ' Evelyn Morris', ' 09234567890', ' Sep-24-1977', ' Female', ' Neurology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(492710, ' Ava Rodriguez', ' 09789012345', ' Jun-23-1986', ' Female', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(493752, ' Charlotte Carter', ' 09345678901', ' Feb-25-1988', ' Female', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(497361, ' Samuel Nelson', ' 09456789012', ' Jan-21-1974', ' Male', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(518697, ' James Wood', ' 09567890123', ' Dec-31-1981', ' Male', ' Dermatology', ' Part-time', ' Tue', ' Thu', ' Afternoon'),
(524201, ' John Smith', ' 09012345678', ' Jan-05-1980', ' Male', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(532407, ' Ava Rogers', ' 09678901234', ' Sep-28-1987', ' Female', ' Dermatology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(532647, ' Benjamin Diaz', ' 09890123456', ' Jul-15-1980', ' Male', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(536294, ' Amelia Mitchell', ' 09789012345', ' Apr-23-1979', ' Female', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(546293, ' Henry Scott', ' 09678901234', ' Jul-16-1985', ' Male', ' Gynecology', ' Part-time', ' Mon', ' Wed', ' Evening'),
(549208, ' Avery Diaz', ' 09012345678', ' May-08-1984', ' Female', ' Psychiatry', ' Part-time', ' Wed', ' Fri', ' Evening'),
(573162, ' Olivia Wright', ' 09123456789', ' Oct-28-1994', ' Female', ' Neurology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(573942, ' Daniel Martinez', ' 09012345678', ' Nov-07-1981', ' Male', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(581349, ' Benjamin Clark', ' 09456789012', ' Mar-11-1983', ' Male', ' Dermatology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(581693, ' Samuel Bennett', ' 09789012345', ' Feb-08-1993', ' Male', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(583297, ' Scarlett Ford', ' 09567890123', ' Oct-07-1990', ' Female', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(587214, ' Mia Jenkins', ' 09012345678', ' Jul-23-1985', ' Female', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(596231, ' James Bryant', ' 09012345678', ' Jan-29-1992', ' Male', ' Neurology', ' Part-time', ' Wed', ' Fri', ' Evening'),
(618257, ' Joseph Patterson', ' 09456789012', ' Mar-18-1976', ' Male', ' Neurology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(618359, ' Benjamin Cox', ' 09123456789', ' Apr-27-1980', ' Male', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(631428, ' Harper Evans', ' 09123456789', ' Aug-09-1985', ' Female', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(638157, ' Mia Smith', ' 09678901234', ' Jan-13-1980', ' Female', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(649283, ' Isabella Green', ' 09123456789', ' Oct-12-1988', ' Female', ' Dermatology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(672853, ' David Williams', ' 09234567890', ' Mar-20-1976', ' Male', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(678219, ' Daniel Stanley', ' 09234567890', ' Jul-13-1982', ' Male', ' Dermatology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(689145, ' Andrew Ortiz', ' 09789012345', ' Feb-07-1980', ' Male', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(691432, ' Mia Russell', ' 09789012345', ' Jun-24-1987', ' Female', ' Dermatology', ' Part-time', ' Tue', ' Thu', ' Evening'),
(691754, ' Benjamin Ramirez', ' 09456789012', ' May-27-1994', ' Male', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(694251, ' Olivia Garcia', ' 09123456789', ' Dec-14-1995', ' Female', ' Neurology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(694581, ' Samuel Morgan', ' 09567890123', ' Aug-09-1983', ' Male', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(695732, ' Emma Hall', ' 09901234567', ' Aug-17-1984', ' Female', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(698541, ' Charlotte Harris', ' 09567890123', ' Feb-16-1983', ' Female', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(721876, ' Robert Jones', ' 09456789012', ' May-25-1982', ' Male', ' Neurology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(731598, ' Joseph Rivera', ' 09456789012', ' Sep-19-1983', ' Male', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(731685, ' Samuel Coleman', ' 09890123456', ' Sep-06-1977', ' Male', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(735198, ' Alexander Young', ' 09678901234', ' May-26-1977', ' Male', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(739581, ' Alexander Walker', ' 09234567890', ' Jan-12-1982', ' Male', ' Orthopedics', ' Part-time', ' Wed', ' Fri', ' Afternoon'),
(745813, ' Harper Foster', ' 09901234567', ' Feb-11-1993', ' Female', ' Dermatology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(749831, ' Grace Flores', ' 09456789012', ' Nov-02-1989', ' Female', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(756942, ' Benjamin Gonzalez', ' 09901234567', ' Apr-19-1979', ' Male', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(781423, ' Henry Perez', ' 09678901234', ' Mar-15-1985', ' Male', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(783542, ' Alexander Mitchell', ' 09234567890', ' Mar-25-1988', ' Male', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(814936, ' William Bell', ' 09789012345', ' Oct-06-1982', ' Male', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(839641, ' Daniel Davis', ' 09234567890', ' Nov-09-1988', ' Male', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(850647, ' Harper Nelson', ' 09789012345', ' Apr-11-1981', ' Female', ' Gynecology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(850724, ' Daniel Reed', ' 09012345678', ' Nov-11-1981', ' Male', ' Dermatology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(851397, ' William Phillips', ' 09678901234', ' May-05-1983', ' Male', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(853914, ' Jackson Wright', ' 09012345678', ' Sep-04-1993', ' Male', ' Cardiology', ' Part-time', ' Thu', ' Fri', ' Afternoon'),
(856492, ' Michael Miller', ' 09678901234', ' Jul-18-1979', ' Male', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(856942, ' Evelyn Patterson', ' 09234567890', ' Sep-30-1992', ' Female', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(859374, ' Abigail Baker', ' 09345678901', ' Dec-03-1996', ' Female', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(860321, ' Zoey Coleman', ' 09789012345', ' Dec-29-1988', ' Female', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(873964, ' Samuel Griffin', ' 09901234567', ' Apr-18-1988', ' Male', ' Neurology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(893264, ' William Phillips', ' 09012345678', ' Jul-28-1981', ' Male', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(921436, ' Benjamin Price', ' 09901234567', ' Jun-20-1974', ' Male', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(924678, ' Amelia Simmons', ' 09123456789', ' Feb-19-1976', ' Female', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(927413, ' Alexander Murphy', ' 09456789012', ' Jan-24-1989', ' Male', ' Dermatology', ' Part-time', ' Mon', ' Wed', ' Afternoon'),
(928675, ' Joseph Richardson', ' 09567890123', ' Dec-30-1985', ' Male', ' Neurology', ' Part-time', ' Tue', ' Thu', ' Afternoon'),
(935187, ' Victoria Peterson', ' 09456789012', ' Jul-02-1988', ' Female', ' Psychiatry', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(935710, ' Sophia Lopez', ' 09345678901', ' Feb-19-1989', ' Female', ' Cardiology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(943567, ' Christopher Anderson', ' 09890123456', ' Sep-09-1984', ' Male', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(964217, ' Matthew Roberts', ' 09890123456', ' May-09-1987', ' Male', ' Dermatology', ' Part-time', ' Mon', ' Wed', ' Evening'),
(975347, ' Jennifer Brown', ' 09345678901', ' Apr-15-1990', ' Female', ' Gynecology', ' Part-time', ' Mon', ' Evening', ' -'),
(982153, ' Isabella Campbell', ' 09901234567', ' Aug-27-1986', ' Female', ' Orthopedics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(982163, ' Mia Morgan', ' 09789012345', ' Aug-12-1989', ' Female', ' Neurology', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(982647, ' Grace Howard', ' 09012345678', ' Mar-19-1987', ' Female', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -'),
(984751, ' Mila Long', ' 09345678901', ' Aug-25-1989', ' Female', ' Pediatrics', ' Full-time', ' Mon-Fri', ' Morning', ' -');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accountsTable`
--
ALTER TABLE `accountsTable`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `appointmentTable`
--
ALTER TABLE `appointmentTable`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `billingTable`
--
ALTER TABLE `billingTable`
  ADD PRIMARY KEY (`PID`);

--
-- Indexes for table `inventoryTable`
--
ALTER TABLE `inventoryTable`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `patientTable`
--
ALTER TABLE `patientTable`
  ADD PRIMARY KEY (`PID`);

--
-- Indexes for table `staffsTable`
--
ALTER TABLE `staffsTable`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
