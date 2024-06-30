# cat data.sql
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS db_tamaraw;

--DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
`id` BIGINT NOT NULL AUTO_INCREMENT ,
`user_id` VARCHAR(100) CHARACTER SET utf16 COLLATE utf16_spanish_ci NOT NULL ,
`password` VARCHAR(100) CHARACTER SET utf16 COLLATE utf16_spanish_ci NOT NULL ,
`user_name` VARCHAR(100) CHARACTER SET utf16 COLLATE utf16_spanish_ci NOT NULL ,
`first_name` VARCHAR(100) CHARACTER SET utf16 COLLATE utf16_spanish_ci NOT NULL ,
`last_name` VARCHAR(100) CHARACTER SET utf16 COLLATE utf16_spanish_ci ,
`mail` VARCHAR(100) CHARACTER SET utf16 COLLATE utf16_spanish_ci NOT NULL ,
PRIMARY KEY (`id`)) ENGINE = InnoDB;

-- Starting user_id=1000
ALTER TABLE users AUTO_INCREMENT = 1000;

-- Coment if we don't want to insert data.

--#insert initial value

INSERT INTO `users` (`user_id`,`password`,`user_name`, `first_name`, `last_name`,`mail`) VALUES
('id-luke','password-luke','Luke', 'Skywalker', 'Starwars','luke@starwars.com'),
('id-obi-wan','password-obi-wan','Obi-Wan', 'Kenobi', 'Starwars','obi-wan@starwars.com');