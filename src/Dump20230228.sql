CREATE DATABASE  IF NOT EXISTS `escola` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `escola`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: escola
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `login` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `senha` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `id_classe` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `nome_UNIQUE` (`nome`),
  KEY `id_classe_idx` (`id_classe`),
  CONSTRAINT `id_classe` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'João','joao','123',2),(2,'Pedro','pedro','123',1),(3,'Marta','marta','123',2),(4,'Clara','clara','123',2),(6,'Taís','tais','123',5),(7,'Mauro','mauro','123',5),(14,'Luiz','luiz','123',20),(22,'Laura','laura','123',1),(23,'Luciano','luciano','123',1),(34,'Paulo','paulo','123',5),(38,'Flávia','fla','123',7);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area_conhecimento`
--

DROP TABLE IF EXISTS `area_conhecimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area_conhecimento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_conhecimento`
--

LOCK TABLES `area_conhecimento` WRITE;
/*!40000 ALTER TABLE `area_conhecimento` DISABLE KEYS */;
INSERT INTO `area_conhecimento` VALUES (1,'Ciências Exatas e da Natureza'),(2,'Ciências Humanas'),(3,'Linguagens e Comunicação');
/*!40000 ALTER TABLE `area_conhecimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ano` int NOT NULL,
  `turma` varchar(1) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `anoTurma` (`ano`,`turma`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe`
--

LOCK TABLES `classe` WRITE;
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
INSERT INTO `classe` VALUES (1,1,'A'),(2,1,'B'),(18,1,'C'),(5,2,'A'),(15,2,'B'),(16,2,'C'),(7,3,'A'),(17,3,'B'),(20,3,'C');
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplina` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `id_area_conhecimento` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`),
  KEY `id_area_conhecimento_idx` (`id_area_conhecimento`),
  CONSTRAINT `id_area_conhecimento` FOREIGN KEY (`id_area_conhecimento`) REFERENCES `area_conhecimento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (1,'Matemática',1),(3,'Física',1),(5,'História',2),(6,'Geografia',2),(14,'Química',1),(17,'Biologia',1),(25,'Redação',3),(26,'Inglês',3),(27,'Gramática',3),(28,'Literatura Brasileira',3),(29,'Literatura Estrangeira',3),(30,'Sociologia',2),(31,'Filosofia',2),(40,'Artes',2),(48,'Psicologia',2),(49,'Cálculo',1);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `cargo` enum('Diretor','Professor','Coordenador') COLLATE utf8mb4_general_ci NOT NULL,
  `login` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `senha` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `leciona` int DEFAULT NULL,
  `coordena` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `leciona_idx` (`leciona`),
  KEY `coordena_idx` (`coordena`),
  CONSTRAINT `coordena` FOREIGN KEY (`coordena`) REFERENCES `area_conhecimento` (`id`),
  CONSTRAINT `leciona` FOREIGN KEY (`leciona`) REFERENCES `disciplina` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'José','Diretor','jose','123',NULL,NULL),(2,'Ana','Coordenador','ana','123',NULL,1),(3,'Platão','Professor','pla','123',31,NULL),(4,'Machado de Assis','Professor','mac','123',28,NULL),(5,'Hipátia','Professor','hip','123',1,NULL),(14,'Milton Santos','Professor','milton','123',6,NULL),(18,'Fernanda','Coordenador','fer','123',NULL,3),(20,'Emerson','Professor','eme','123',25,NULL),(21,'Darwin','Professor','dar','123',17,NULL),(22,'Herman Hesse','Professor','her','123',29,NULL),(23,'Einstein','Professor','ein','123',3,NULL),(24,'Homero','Professor','hom','123',5,NULL),(25,'Homo Sapiens','Coordenador','sap','123',NULL,2),(27,'Marie Curie','Professor','mar','123',14,NULL);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leciona`
--

DROP TABLE IF EXISTS `leciona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leciona` (
  `id_professor` int NOT NULL,
  `id_aluno` int NOT NULL,
  `nota_1bi` double DEFAULT NULL,
  `nota_2bi` double DEFAULT NULL,
  `nota_3bi` double DEFAULT NULL,
  `nota_4bi` double DEFAULT NULL,
  UNIQUE KEY `ProfAlu` (`id_professor`,`id_aluno`),
  KEY `id_professor_idx` (`id_professor`),
  KEY `id_aluno_idx` (`id_aluno`),
  CONSTRAINT `id_aluno` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id`),
  CONSTRAINT `id_professor` FOREIGN KEY (`id_professor`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leciona`
--

LOCK TABLES `leciona` WRITE;
/*!40000 ALTER TABLE `leciona` DISABLE KEYS */;
INSERT INTO `leciona` VALUES (4,1,6.5,NULL,NULL,NULL),(4,2,5.5,NULL,NULL,NULL),(4,7,7.99,6.8,4.77,8.4569),(4,14,8,0,0,0),(5,1,4,0,0,0),(5,2,5.6,0,0,0),(5,3,8,0,9.9,0),(5,4,6,5.9,0,5.6),(5,7,6.8,5.6,4.9,8.4),(5,22,7.9,7.56745,0.7,0),(14,7,2,0,0,0),(14,14,1.6,9,9.8,0),(21,6,1,4,5,2),(21,7,2,5,1,0),(21,23,5,0,2,0),(23,3,8,7,8,9),(23,4,8,7,0,0),(23,34,1,7,0,0),(24,1,2,4,1,6),(24,4,9,6,7,9),(24,22,6,8,5,8),(27,1,2,0,0,0),(27,4,5,2,0,0),(27,6,5,2,6,2),(27,22,1,2,5,0),(27,38,2,6,6.6,8);
/*!40000 ALTER TABLE `leciona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-28 14:50:48
