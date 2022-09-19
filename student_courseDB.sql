-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.8.3-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for studentcoursedb
DROP DATABASE IF EXISTS `studentcoursedb`;
CREATE DATABASE IF NOT EXISTS `studentcoursedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `studentcoursedb`;

-- Dumping structure for table studentcoursedb.course
DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL,
  `instructor` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table studentcoursedb.course: ~10 rows (approximately)
INSERT INTO `course` (`id`, `instructor`, `name`) VALUES
	(1, 'Anderea \r\nScamaden', 'English'),
	(2, 'Eustace \r\nNiemetz', 'Mathematics'),
	(3, 'Reynolds Pastor', 'Anatomy'),
	(4, 'Odessa \r\nBelcher', 'Organic Chemistry'),
	(5, 'Dani Swallow', 'Physics'),
	(6, 'Glenden \r\nReilingen', 'Digital Logic'),
	(7, 'Giselle Ardy', 'Object Oriented Programming'),
	(8, 'Carolan \r\nStoller', 'Data Structures'),
	(9, 'Carmita De \r\nMaine', 'Politics'),
	(10, 'Kingsly Doxsey', 'Art');

-- Dumping structure for table studentcoursedb.student
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table studentcoursedb.student: ~10 rows (approximately)
INSERT INTO `student` (`email`, `name`, `password`) VALUES
	('aiannitti7@is.gd', 'Alexandra \r\nIannitti', 'TWP4hf5j'),
	('cjaulme9@bing.com', 'Cahra \r\nJaulme', 'FnVklVgC6r6'),
	('cstartin3@flickr.com', 'Clem \r\nStartin', 'XYHzJ1S'),
	('hguerre5@deviantart.com', 'Harcourt Guerre', 'OzcxzD1PGs'),
	('hluckham0@google.ru', 'Hazel \r\nLuckham', 'X1uZcoIh0dj'),
	('htaffley6@columbia.edu', 'Holmes Taffley', 'xowtOQ'),
	('ljiroudek8@sitemeter.com', 'Laryssa Jiroudek', 'bXRoLUP'),
	('qllorens2@howstuffworks.com', 'Quillan Llorens', 'W6rJuxd'),
	('sbowden1@yellowbook.com', 'Sonnnie Bowden', 'SJc4aWSU'),
	('tattwool4@biglobe.ne.jp', 'Thornie Attwool', 'Hjt0SoVmuBz');

-- Dumping structure for table studentcoursedb.students_courses
DROP TABLE IF EXISTS `students_courses`;
CREATE TABLE IF NOT EXISTS `students_courses` (
  `Student_email` varchar(255) NOT NULL,
  `sCourses_id` int(11) NOT NULL,
  KEY `FKe5ph8jl3vy8bp2a9b6lt01dnn` (`sCourses_id`),
  KEY `FK6a720ot36hf1w0fxarh76d6rm` (`Student_email`),
  CONSTRAINT `FK6a720ot36hf1w0fxarh76d6rm` FOREIGN KEY (`Student_email`) REFERENCES `student` (`email`),
  CONSTRAINT `FKe5ph8jl3vy8bp2a9b6lt01dnn` FOREIGN KEY (`sCourses_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table studentcoursedb.students_courses: ~13 rows (approximately)
INSERT INTO `students_courses` (`Student_email`, `sCourses_id`) VALUES
	('hluckham0@google.ru', 1),
	('sbowden1@yellowbook.com', 2),
	('qllorens2@howstuffworks.com', 3),
	('cstartin3@flickr.com', 4),
	('tattwool4@biglobe.ne.jp', 5),
	('hguerre5@deviantart.com', 6),
	('htaffley6@columbia.edu', 7),
	('aiannitti7@is.gd', 8),
	('ljiroudek8@sitemeter.com', 8),
	('cjaulme9@bing.com', 1),
	('hluckham0@google.ru', 9),
	('hluckham0@google.ru', 10),
	('hluckham0@google.ru', 7),
	('hluckham0@google.ru', 8);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
