-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: demopatrones
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `ID_ADMINISTRADOR` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(1024) NOT NULL,
  `APELLIDO` varchar(1024) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  `TELEFONO` varchar(1024) NOT NULL,
  `EMAIL` varchar(1024) NOT NULL,
  `USUARIO` varchar(1024) NOT NULL,
  `CONTRASENA` varchar(1024) NOT NULL,
  PRIMARY KEY (`ID_ADMINISTRADOR`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'joel','bejar','1234569','123456789','joel@gmail.com','joel','joel');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avenida`
--

DROP TABLE IF EXISTS `avenida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avenida` (
  `ID_AVENIDA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(1024) NOT NULL,
  PRIMARY KEY (`ID_AVENIDA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avenida`
--

LOCK TABLES `avenida` WRITE;
/*!40000 ALTER TABLE `avenida` DISABLE KEYS */;
INSERT INTO `avenida` VALUES (1,'faucett56'),(3,'la marina');
/*!40000 ALTER TABLE `avenida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bus` (
  `ID_BUS` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ESTADO` int(11) DEFAULT NULL,
  `PLACA` varchar(7) NOT NULL,
  `SOAT` varchar(1024) NOT NULL,
  `CAPACIDAD` int(11) NOT NULL,
  `ANHO` int(11) NOT NULL,
  PRIMARY KEY (`ID_BUS`),
  KEY `FK_ESTADO` (`ID_ESTADO`),
  CONSTRAINT `FK_ESTADO` FOREIGN KEY (`ID_ESTADO`) REFERENCES `estado_bus` (`ID_ESTADO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` VALUES (1,1,'ABC-123','123',20,1998),(2,1,'789-456','789456123',20,1998),(3,1,'789-458','12345677',20,2000);
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conductor`
--

DROP TABLE IF EXISTS `conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conductor` (
  `ID_CONDUCTOR` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRES` varchar(1024) NOT NULL,
  `APELLIDOS` varchar(1024) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  `BREVETE` varchar(1024) NOT NULL,
  `TELEFONO` varchar(10) NOT NULL,
  `DIRECCION` varchar(1024) NOT NULL,
  `EMAIL` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`ID_CONDUCTOR`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conductor`
--

LOCK TABLES `conductor` WRITE;
/*!40000 ALTER TABLE `conductor` DISABLE KEYS */;
INSERT INTO `conductor` VALUES (1,'joel','bejar','74025623','123456','1234587','villa maria','bejar@gamil.com');
/*!40000 ALTER TABLE `conductor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_bus`
--

DROP TABLE IF EXISTS `estado_bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_bus` (
  `ID_ESTADO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(1024) NOT NULL,
  PRIMARY KEY (`ID_ESTADO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_bus`
--

LOCK TABLES `estado_bus` WRITE;
/*!40000 ALTER TABLE `estado_bus` DISABLE KEYS */;
INSERT INTO `estado_bus` VALUES (1,'activo');
/*!40000 ALTER TABLE `estado_bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialbus`
--

DROP TABLE IF EXISTS `historialbus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historialbus` (
  `ID_RUTA` int(11) NOT NULL,
  `ID_BUS` int(11) NOT NULL,
  `FECHA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_RUTA`,`ID_BUS`),
  KEY `FK_TIENE2` (`ID_BUS`),
  CONSTRAINT `FK_PERTENECE2` FOREIGN KEY (`ID_RUTA`) REFERENCES `ruta` (`ID_RUTA`),
  CONSTRAINT `FK_TIENE2` FOREIGN KEY (`ID_BUS`) REFERENCES `bus` (`ID_BUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialbus`
--

LOCK TABLES `historialbus` WRITE;
/*!40000 ALTER TABLE `historialbus` DISABLE KEYS */;
INSERT INTO `historialbus` VALUES (5,1,'2018-11-20 05:00:00'),(5,2,'2018-11-20 05:00:00'),(5,3,'2018-11-20 05:00:00');
/*!40000 ALTER TABLE `historialbus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialconductor`
--

DROP TABLE IF EXISTS `historialconductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historialconductor` (
  `ID_BUS` int(11) NOT NULL,
  `ID_CONDUCTOR` int(11) NOT NULL,
  `FECHA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_BUS`,`ID_CONDUCTOR`),
  KEY `FK_TIENE` (`ID_CONDUCTOR`),
  CONSTRAINT `FK_PERTENECE` FOREIGN KEY (`ID_BUS`) REFERENCES `bus` (`ID_BUS`),
  CONSTRAINT `FK_TIENE` FOREIGN KEY (`ID_CONDUCTOR`) REFERENCES `conductor` (`ID_CONDUCTOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialconductor`
--

LOCK TABLES `historialconductor` WRITE;
/*!40000 ALTER TABLE `historialconductor` DISABLE KEYS */;
/*!40000 ALTER TABLE `historialconductor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paradero`
--

DROP TABLE IF EXISTS `paradero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paradero` (
  `ID_PARADERO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_AVENIDA` int(11) DEFAULT NULL,
  `NOMBRE` varchar(1024) NOT NULL,
  `DIRECCION` varchar(1024) NOT NULL,
  PRIMARY KEY (`ID_PARADERO`),
  KEY `FK_TIENE3` (`ID_AVENIDA`),
  CONSTRAINT `FK_TIENE3` FOREIGN KEY (`ID_AVENIDA`) REFERENCES `avenida` (`ID_AVENIDA`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paradero`
--

LOCK TABLES `paradero` WRITE;
/*!40000 ALTER TABLE `paradero` DISABLE KEYS */;
INSERT INTO `paradero` VALUES (1,1,'entrada','cuadra 10'),(2,1,'colonial','cuadra 12'),(3,1,'argentina','cuadra 11'),(4,1,'venezuela','cuadra 13'),(5,1,'aero','cuadra20'),(6,1,'ovalo','cuadra25'),(7,3,'metro','cuadra 10');
/*!40000 ALTER TABLE `paradero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruta` (
  `ID_RUTA` int(11) NOT NULL AUTO_INCREMENT,
  `PARADERO_INICIO` int(11) NOT NULL,
  `PARADERO_FIN` int(11) NOT NULL,
  `NOMBRE` varchar(1024) NOT NULL,
  PRIMARY KEY (`ID_RUTA`),
  KEY `FK_FIN` (`PARADERO_FIN`),
  KEY `FK_INICIO` (`PARADERO_INICIO`),
  CONSTRAINT `FK_FIN` FOREIGN KEY (`PARADERO_FIN`) REFERENCES `paradero` (`ID_PARADERO`),
  CONSTRAINT `FK_INICIO` FOREIGN KEY (`PARADERO_INICIO`) REFERENCES `paradero` (`ID_PARADERO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruta`
--

LOCK TABLES `ruta` WRITE;
/*!40000 ALTER TABLE `ruta` DISABLE KEYS */;
INSERT INTO `ruta` VALUES (5,1,2,'faucett569');
/*!40000 ALTER TABLE `ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutaparaderos`
--

DROP TABLE IF EXISTS `rutaparaderos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutaparaderos` (
  `ID_RUTA` int(11) NOT NULL,
  `ID_PARADERO` int(11) NOT NULL,
  PRIMARY KEY (`ID_RUTA`,`ID_PARADERO`),
  KEY `FK_PERTENECE3` (`ID_PARADERO`),
  CONSTRAINT `FK_PERTENECE3` FOREIGN KEY (`ID_PARADERO`) REFERENCES `paradero` (`ID_PARADERO`),
  CONSTRAINT `FK_PERTENECE4` FOREIGN KEY (`ID_RUTA`) REFERENCES `ruta` (`ID_RUTA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutaparaderos`
--

LOCK TABLES `rutaparaderos` WRITE;
/*!40000 ALTER TABLE `rutaparaderos` DISABLE KEYS */;
INSERT INTO `rutaparaderos` VALUES (5,1),(5,2),(5,3);
/*!40000 ALTER TABLE `rutaparaderos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-20 10:56:31
