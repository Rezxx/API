CREATE SCHEMA IF NOT EXISTS `API`;
USE `API`;

DROP TABLE IF EXISTS `Book`;
CREATE TABLE `Book` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `author` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `Book` 
VALUE
	(1,'Game of Thrones','George R. R. Martin'), 
	(2, 'A Tale of Two Cities', 'Charles Dickens'),
	(3, 'Don Quixote', 'Miguel de Cervantes');
