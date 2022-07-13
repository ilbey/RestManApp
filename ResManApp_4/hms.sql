-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 17 Oca 2021, 21:44:03
-- Sunucu sürümü: 10.4.17-MariaDB
-- PHP Sürümü: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `hms`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `booking`
--

CREATE TABLE `booking` (
  `bookingID` int(11) NOT NULL DEFAULT 0,
  `bookingDate` text DEFAULT NULL,
  `customer_id` int(11) DEFAULT 11
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='booking data';

--
-- Tablo döküm verisi `booking`
--

INSERT INTO `booking` (`bookingID`, `bookingDate`, `customer_id`) VALUES
(10, '20/12/2009', 1),
(11, '14/08/2014', 2),
(12, '12/12/2005', 3),
(13, '25/04/2004', 1),
(14, '10/10/2010', 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL DEFAULT 0,
  `name` text COLLATE utf8_unicode_ci NOT NULL,
  `date_of_birth` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registration_date` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `creditcard` text COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='customer data';

--
-- Tablo döküm verisi `customer`
--

INSERT INTO `customer` (`id`, `name`, `date_of_birth`, `gender`, `registration_date`, `creditcard`) VALUES
(1, 'Neo', '01/01/1972', 'M', '10/02/2018', 'Iban: 8532467893456'),
(2, 'Trinity', '02/02/1978', 'F', '14/10/2008', 'Iban: 4896325471'),
(3, 'Morpheus', '22/05/1965', 'M', '18/07/2019', 'Iban: 65489650107');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookingID`),
  ADD KEY `FK` (`customer_id`);

--
-- Tablo için indeksler `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `FK` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
