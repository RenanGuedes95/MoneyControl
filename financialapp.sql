-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: financialapp
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `cpf` varchar(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `login` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `department` varchar(45) NOT NULL,
  `position` varchar(20) NOT NULL,
  `dateOfRegister` datetime NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES ('12345678901','Zezinho Ze','ze123','ze@mail.com','FOG2ALH9V59HQzuI6NhSkQ==','desenvolvimento','Gerente','2024-06-18 15:45:06'),('12345678902','Joao Paulo','jp2024','jp@mail.com','FOG2ALH9V59HQzuI6NhSkQ==','gerenciamento','administrador','2024-06-18 15:48:25');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditors`
--

DROP TABLE IF EXISTS `auditors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditors` (
  `cpf` varchar(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `login` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `department` varchar(45) NOT NULL,
  `position` varchar(20) NOT NULL,
  `dateOfRegister` datetime NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditors`
--

LOCK TABLES `auditors` WRITE;
/*!40000 ALTER TABLE `auditors` DISABLE KEYS */;
INSERT INTO `auditors` VALUES ('12345678912','Carlos Henrique','carlos1','carlos@mail.com','2bHX20zW5wk1Nooe+xDjdw==','Fiscal','Gerente','2024-06-28 00:00:00');
/*!40000 ALTER TABLE `auditors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `cpf` varchar(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `login` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `profession` varchar(45) DEFAULT NULL,
  `maritalStatus` varchar(45) NOT NULL,
  `dateOfRegister` datetime NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES ('12345678900','Renan Guedes','renan','renan@mail.com','2bHX20zW5wk1Nooe+xDjdw==','estudante','solteiro','2024-06-28 11:39:30'),('12345678901','William Silva','william','william@mail.com','2bHX20zW5wk1Nooe+xDjdw==','estudante','solteiro','2024-06-28 11:39:55'),('12345678902','Raphael Guarnieri','raphael','raphael@mail.com','2bHX20zW5wk1Nooe+xDjdw==','estudante','solteiro','2024-06-28 11:40:28'),('12345678903','Samuel Costa','samuel','samuel@mail.com','2bHX20zW5wk1Nooe+xDjdw==','desenvolvedor','casado','2024-06-28 11:41:08');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses`
--

DROP TABLE IF EXISTS `expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses` (
  `idexpenses` int NOT NULL AUTO_INCREMENT,
  `value` decimal(20,2) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `date` date NOT NULL,
  `type_of_expense` enum('ALUGUEL','ALIMENTACAO','CARTAO','LUZ','AGUA','AUTOMOVEL','LAZER','EXTRA','OUTRO') NOT NULL,
  `cpf_client` varchar(11) NOT NULL,
  PRIMARY KEY (`idexpenses`,`cpf_client`),
  KEY `client_expenses_idx` (`cpf_client`),
  CONSTRAINT `client_expenses` FOREIGN KEY (`cpf_client`) REFERENCES `clients` (`cpf`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses`
--

LOCK TABLES `expenses` WRITE;
/*!40000 ALTER TABLE `expenses` DISABLE KEYS */;
INSERT INTO `expenses` VALUES (1,1200.00,'Boleto - Imob','2024-05-05','ALUGUEL','12345678900'),(2,400.00,'Supermercado','2024-05-10','ALIMENTACAO','12345678900'),(3,500.00,'Pneu do carro','2024-06-15','AUTOMOVEL','12345678900'),(4,150.00,'Boleto - Cemig','2024-06-04','LUZ','12345678900'),(5,900.00,'Boleto - Imobi','2024-06-05','ALUGUEL','12345678902'),(6,150.00,'Boleto - Cemig','2024-06-05','LUZ','12345678902'),(7,900.00,'Boleto - Imob','2024-05-05','ALUGUEL','12345678902'),(8,90.65,'Boleto - Cesama','2024-05-07','AGUA','12345678902'),(9,100.00,'Boleto - Cesama','2024-06-06','AGUA','12345678900'),(10,200.00,'Extra','2024-06-20','EXTRA','12345678900'),(11,120.00,'Fast food','2024-06-27','LAZER','12345678900');
/*!40000 ALTER TABLE `expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financial_goals`
--

DROP TABLE IF EXISTS `financial_goals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `financial_goals` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `value` decimal(20,2) NOT NULL,
  `actual_value` decimal(20,2) NOT NULL,
  `monthly_contribuition` decimal(20,2) NOT NULL,
  `inicial_date` date NOT NULL,
  `final_date` date NOT NULL,
  `owner` varchar(11) NOT NULL,
  `completed` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `owner_idx` (`owner`),
  CONSTRAINT `owner` FOREIGN KEY (`owner`) REFERENCES `clients` (`cpf`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financial_goals`
--

LOCK TABLES `financial_goals` WRITE;
/*!40000 ALTER TABLE `financial_goals` DISABLE KEYS */;
INSERT INTO `financial_goals` VALUES (1,'Celular','Comprar um celular novo',3600.00,750.00,250.00,'2024-04-05','2025-06-05','12345678900',0),(2,'Mouse Gamer','Comprar um mouse',300.00,300.00,100.00,'2024-03-20','2024-05-20','12345678900',1),(3,'Teclado Gamer','HyperX',350.00,350.00,65.00,'2023-12-15','2024-05-15','12345678902',1),(4,'Placa de Vídeo','GFORCE',2500.00,1875.00,625.00,'2024-04-05','2024-07-05','12345678902',0),(16,'Headset','HyperX',350.00,0.00,100.00,'2024-08-20','2024-11-20','12345678900',0);
/*!40000 ALTER TABLE `financial_goals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incomes`
--

DROP TABLE IF EXISTS `incomes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incomes` (
  `idincomes` int NOT NULL AUTO_INCREMENT,
  `value` decimal(20,2) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `date` date NOT NULL,
  `type_of_income` enum('SALARIO','INVESTIMENTO','HORA_EXTRA','OUTRO') NOT NULL,
  `cpf_client` varchar(11) NOT NULL,
  PRIMARY KEY (`idincomes`,`cpf_client`),
  KEY `cpf_client_idx` (`cpf_client`),
  CONSTRAINT `cpf_client` FOREIGN KEY (`cpf_client`) REFERENCES `clients` (`cpf`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incomes`
--

LOCK TABLES `incomes` WRITE;
/*!40000 ALTER TABLE `incomes` DISABLE KEYS */;
INSERT INTO `incomes` VALUES (1,2500.00,'Salário do mês de maio','2024-05-05','SALARIO','12345678900'),(2,1000.00,'Hora extra do mês de maio','2024-05-10','HORA_EXTRA','12345678900'),(3,2500.00,'Salário do mês de junho','2024-06-05','SALARIO','12345678900'),(4,650.50,'Investimento do mês de junho','2024-06-15','INVESTIMENTO','12345678900'),(5,3000.00,'Salário do mês de junho','2024-06-08','SALARIO','12345678902'),(6,3000.00,'Salário do mês de maio','2024-05-07','SALARIO','12345678902');
/*!40000 ALTER TABLE `incomes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-28 17:55:31
