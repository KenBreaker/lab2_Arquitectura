CREATE DATABASE IF NOT EXISTS `papeles`;
CREATE TABLE if not exists `papel_higienico` (
  `id` long NOT NULL primary key,
  `brand` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL
);