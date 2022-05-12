-- Adminer 4.8.1 MySQL 8.0.24 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

CREATE DATABASE `db_cards` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_cards`;

CREATE TABLE `card` (
                        `id` int unsigned NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) NOT NULL,
                        `description` varchar(255) DEFAULT NULL,
                        `strength` int DEFAULT '1',
                        `speed` int DEFAULT '1',
                        `skill` int DEFAULT '1',
                        `gear` int DEFAULT '1',
                        `intellect` int DEFAULT '1',
                        `image_url` varchar(255) DEFAULT NULL,
                        `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                        `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        `originId` int unsigned NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `card_FK` (`originId`),
                        CONSTRAINT `card_FK` FOREIGN KEY (`originId`) REFERENCES `origin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `card` (`id`, `name`, `description`, `strength`, `speed`, `skill`, `gear`, `intellect`, `image_url`, `created_at`, `updated_at`, `originId`) VALUES
    (1,	'Iron Man',	'Homem de ferro',	1,	1,	1,	1,	1,	'https://conteudo.imguol.com.br/c/entretenimento/96/2020/08/07/iron-man-1596813808466_v2_900x506.jpg.webp',	'2022-05-02 12:43:36',	'2022-05-02 12:43:36',	1);

CREATE TABLE `origin` (
                          `id` int unsigned NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) NOT NULL,
                          `description` varchar(1024) NOT NULL,
                          `creator` varchar(255) NOT NULL,
                          `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                          `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `origin` (`id`, `name`, `description`, `creator`, `created_at`, `updated_at`) VALUES
    (1,	'Marvel',	'Marvel',	'Stan Lee',	'2022-05-02 12:42:17',	'2022-05-02 12:42:17');

-- 2022-05-02 12:44:31