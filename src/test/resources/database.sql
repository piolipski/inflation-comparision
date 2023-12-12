-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 04 Cze 2023, 00:54
-- Wersja serwera: 10.4.25-MariaDB
-- Wersja PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `database`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `average_income`
--

CREATE TABLE `average_income` (
  `id` bigint(20) NOT NULL,
  `year` int(11) DEFAULT NULL,
  `value` double NOT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `country_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `average_income`
--

INSERT INTO `average_income` (`id`, `year`, `value`, `currency`, `country_name`) VALUES
(1, 1995, 8431.44, 'PLN', 'POLAND'),
(2, 1996, 10476, 'PLN', 'POLAND'),
(3, 1997, 12743.16, 'PLN', 'POLAND'),
(4, 1998, 14873.88, 'PLN', 'POLAND'),
(5, 1999, 20480.88, 'PLN', 'POLAND'),
(6, 2000, 23085.72, 'PLN', 'POLAND'),
(7, 2001, 24742.2, 'PLN', 'POLAND'),
(8, 2002, 25598.52, 'PLN', 'POLAND'),
(9, 2003, 26417.64, 'PLN', 'POLAND'),
(10, 2004, 27474.84, 'PLN', 'POLAND'),
(11, 2005, 28563.48, 'PLN', 'POLAND'),
(12, 2006, 29726.76, 'PLN', 'POLAND'),
(13, 2007, 32292.36, 'PLN', 'POLAND'),
(14, 2008, 35326.56, 'PLN', 'POLAND'),
(15, 2009, 37235.52, 'PLN', 'POLAND'),
(16, 2010, 38699.76, 'PLN', 'POLAND'),
(17, 2011, 40794.24, 'PLN', 'POLAND'),
(18, 2012, 42260.04, 'PLN', 'POLAND'),
(19, 2013, 43800.72, 'PLN', 'POLAND'),
(20, 2014, 45401.52, 'PLN', 'POLAND'),
(21, 2015, 46797.36, 'PLN', 'POLAND'),
(22, 2016, 48566.52, 'PLN', 'POLAND'),
(23, 2017, 51258.12, 'PLN', 'POLAND'),
(24, 2018, 55020.36, 'PLN', 'POLAND'),
(25, 2019, 59018.04, 'PLN', 'POLAND'),
(26, 2020, 62009.64, 'PLN', 'POLAND'),
(27, 2021, 67950.36, 'PLN', 'POLAND'),
(28, 2022, 76153.8, 'PLN', 'POLAND');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `base_retirement_income`
--

CREATE TABLE `base_retirement_income` (
  `id` bigint(20) NOT NULL,
  `year` int(11) DEFAULT NULL,
  `value` double NOT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `country_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `base_retirement_income`
--

INSERT INTO `base_retirement_income` (`id`, `year`, `value`, `currency`, `country_name`) VALUES
(1, 1999, 1327.44, 'PLN', 'POLAND'),
(2, 2000, 1540.2, 'PLN', 'POLAND'),
(3, 2001, 1638.27, 'PLN', 'POLAND'),
(4, 2002, 1775.89, 'PLN', 'POLAND'),
(5, 2003, 1862.62, 'PLN', 'POLAND'),
(6, 2004, 1829.24, 'PLN', 'POLAND'),
(7, 2005, 1903.03, 'PLN', 'POLAND'),
(8, 2006, 1977.2, 'PLN', 'POLAND'),
(9, 2007, 2059.92, 'PLN', 'POLAND'),
(10, 2008, 2275.37, 'PLN', 'POLAND'),
(11, 2009, 2578.26, 'PLN', 'POLAND'),
(12, 2010, 2716.71, 'PLN', 'POLAND'),
(13, 2011, 2822.66, 'PLN', 'POLAND'),
(14, 2012, 2974.69, 'PLN', 'POLAND'),
(15, 2013, 3080.84, 'PLN', 'POLAND'),
(16, 2014, 3191.93, 'PLN', 'POLAND'),
(17, 2015, 3308.33, 'PLN', 'POLAND'),
(18, 2016, 3408.62, 'PLN', 'POLAND'),
(19, 2017, 3536.87, 'PLN', 'POLAND'),
(20, 2018, 3731.13, 'PLN', 'POLAND'),
(21, 2019, 4003.88, 'PLN', 'POLAND'),
(22, 2020, 4294.67, 'PLN', 'POLAND'),
(23, 2021, 4512.41, 'PLN', 'POLAND'),
(24, 2022, 4944.79, 'PLN', 'POLAND');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `gdp`
--

CREATE TABLE `gdp` (
  `id` bigint(20) NOT NULL,
  `year` int(11) DEFAULT NULL,
  `value` double NOT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `country_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `gdp`
--

INSERT INTO `gdp` (`id`, `year`, `value`, `currency`, `country_name`) VALUES
(1, 2000, 172200000000, 'USD', 'POLAND'),
(2, 2001, 190900000000, 'USD', 'POLAND'),
(3, 2002, 199100000000, 'USD', 'POLAND'),
(4, 2003, 217800000000, 'USD', 'POLAND'),
(5, 2004, 255100000000, 'USD', 'POLAND'),
(6, 2005, 306100000000, 'USD', 'POLAND'),
(7, 2006, 344600000000, 'USD', 'POLAND'),
(8, 2007, 429000000000, 'USD', 'POLAND'),
(9, 2008, 533600000000, 'USD', 'POLAND'),
(10, 2009, 439700000000, 'USD', 'POLAND'),
(11, 2010, 475700000000, 'USD', 'POLAND'),
(12, 2011, 524400000000, 'USD', 'POLAND'),
(13, 2012, 495200000000, 'USD', 'POLAND'),
(14, 2013, 515800000000, 'USD', 'POLAND'),
(15, 2014, 539100000000, 'USD', 'POLAND'),
(16, 2015, 477100000000, 'USD', 'POLAND'),
(17, 2016, 470000000000, 'USD', 'POLAND'),
(18, 2017, 524600000000, 'USD', 'POLAND'),
(19, 2018, 588800000000, 'USD', 'POLAND'),
(20, 2019, 596100000000, 'USD', 'POLAND'),
(21, 2020, 599400000000, 'USD', 'POLAND'),
(22, 2021, 679400000000, 'USD', 'POLAND'),
(23, 2022, 712690000000, 'USD', 'POLAND');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `inflation`
--

CREATE TABLE `inflation` (
  `id` bigint(20) NOT NULL,
  `year` int(11) DEFAULT NULL,
  `value` double NOT NULL,
  `country_name` varchar(255) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `inflation`
--

INSERT INTO `inflation` (`id`, `year`, `value`, `country_name`, `currency`) VALUES
(1, 2000, 10.1, 'POLAND', 'CPI'),
(2, 2001, 5.5, 'POLAND', 'CPI'),
(3, 2002, 1.9, 'POLAND', 'CPI'),
(4, 2003, 0.8, 'POLAND', 'CPI'),
(5, 2004, 3.5, 'POLAND', 'CPI'),
(6, 2005, 2.1, 'POLAND', 'CPI'),
(7, 2006, 1, 'POLAND', 'CPI'),
(8, 2007, 2.5, 'POLAND', 'CPI'),
(9, 2008, 4.2, 'POLAND', 'CPI'),
(10, 2009, 3.5, 'POLAND', 'CPI'),
(11, 2010, 2.6, 'POLAND', 'CPI'),
(12, 2011, 4.3, 'POLAND', 'CPI'),
(13, 2012, 3.7, 'POLAND', 'CPI'),
(14, 2013, 0.9, 'POLAND', 'CPI'),
(15, 2014, 0, 'POLAND', 'CPI'),
(16, 2015, -0.9, 'POLAND', 'CPI'),
(17, 2016, -0.6, 'POLAND', 'CPI'),
(18, 2017, 2, 'POLAND', 'CPI'),
(19, 2018, 1.6, 'POLAND', 'CPI'),
(20, 2019, 2.3, 'POLAND', 'CPI'),
(21, 2020, 3.4, 'POLAND', 'CPI'),
(22, 2021, 5.1, 'POLAND', 'CPI'),
(23, 2022, 14.4, 'POLAND', 'CPI');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `minimal_income`
--

CREATE TABLE `minimal_income` (
  `id` bigint(20) NOT NULL,
  `year` int(11) DEFAULT NULL,
  `value` double NOT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `country_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `minimal_income`
--

INSERT INTO `minimal_income` (`id`, `year`, `value`, `currency`, `country_name`) VALUES
(1, 2000, 700, 'PLN', 'POLAND'),
(2, 2001, 760, 'PLN', 'POLAND'),
(3, 2002, 760, 'PLN', 'POLAND'),
(4, 2003, 800, 'PLN', 'POLAND'),
(5, 2004, 824, 'PLN', 'POLAND'),
(6, 2005, 849, 'PLN', 'POLAND'),
(7, 2006, 899.1, 'PLN', 'POLAND'),
(8, 2007, 936, 'PLN', 'POLAND'),
(9, 2008, 1126, 'PLN', 'POLAND'),
(10, 2009, 1276, 'PLN', 'POLAND'),
(11, 2010, 1317, 'PLN', 'POLAND'),
(12, 2011, 1386, 'PLN', 'POLAND'),
(13, 2012, 1500, 'PLN', 'POLAND'),
(14, 2013, 1600, 'PLN', 'POLAND'),
(15, 2014, 1680, 'PLN', 'POLAND'),
(16, 2015, 1750, 'PLN', 'POLAND'),
(17, 2016, 1850, 'PLN', 'POLAND'),
(18, 2017, 2000, 'PLN', 'POLAND'),
(19, 2018, 2100, 'PLN', 'POLAND'),
(20, 2019, 2250, 'PLN', 'POLAND'),
(21, 2020, 2600, 'PLN', 'POLAND'),
(22, 2021, 2800, 'PLN', 'POLAND'),
(23, 2022, 3010, 'PLN', 'POLAND');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` enum('ROLE_ADMIN','ROLE_USER') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `password` varchar(120) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`id`, `password`, `username`) VALUES
(1, '$2a$10$EYO9rV0a1Dnyi9sXpGCQD.pvebZwXdbE12AJnfeumk3qijXXKv.wK', 'admin');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 2);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `average_income`
--
ALTER TABLE `average_income`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `base_retirement_income`
--
ALTER TABLE `base_retirement_income`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `gdp`
--
ALTER TABLE `gdp`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `inflation`
--
ALTER TABLE `inflation`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `minimal_income`
--
ALTER TABLE `minimal_income`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`);

--
-- Indeksy dla tabeli `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `average_income`
--
ALTER TABLE `average_income`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT dla tabeli `base_retirement_income`
--
ALTER TABLE `base_retirement_income`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT dla tabeli `gdp`
--
ALTER TABLE `gdp`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT dla tabeli `inflation`
--
ALTER TABLE `inflation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT dla tabeli `minimal_income`
--
ALTER TABLE `minimal_income`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT dla tabeli `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
