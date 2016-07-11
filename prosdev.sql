-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sprint1_prosdev
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `date_received`
--

DROP TABLE IF EXISTS `date_received`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `date_received` (
  `date_received_ID` int(10) DEFAULT NULL,
  `ds_month` int(2) DEFAULT NULL,
  `ds_day` int(2) DEFAULT NULL,
  `ds_year` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_received`
--

LOCK TABLES `date_received` WRITE;
/*!40000 ALTER TABLE `date_received` DISABLE KEYS */;
/*!40000 ALTER TABLE `date_received` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_sent`
--

DROP TABLE IF EXISTS `date_sent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `date_sent` (
  `date_sent_ID` int(10) DEFAULT NULL,
  `ds_month` int(2) DEFAULT NULL,
  `ds_day` int(2) DEFAULT NULL,
  `ds_year` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_sent`
--

LOCK TABLES `date_sent` WRITE;
/*!40000 ALTER TABLE `date_sent` DISABLE KEYS */;
/*!40000 ALTER TABLE `date_sent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supply`
--

DROP TABLE IF EXISTS `supply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supply` (
  `supply_ID` int(11) DEFAULT NULL,
  `whouse_ID` int(11) DEFAULT NULL,
  `supply_name` varchar(255) DEFAULT NULL,
  `supply_quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supply`
--

LOCK TABLES `supply` WRITE;
/*!40000 ALTER TABLE `supply` DISABLE KEYS */;
/*!40000 ALTER TABLE `supply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supply_request`
--

DROP TABLE IF EXISTS `supply_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supply_request` (
  `requestor_ID` int(10) DEFAULT NULL,
  `supply_ID` int(10) DEFAULT NULL,
  `whouse_ID` int(10) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `date_received_ID` int(10) DEFAULT NULL,
  `date_sent_ID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supply_request`
--

LOCK TABLES `supply_request` WRITE;
/*!40000 ALTER TABLE `supply_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `supply_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supply_transfer`
--

DROP TABLE IF EXISTS `supply_transfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supply_transfer` (
  `requestor_ID` int(10) DEFAULT NULL,
  `supply_ID` int(10) DEFAULT NULL,
  `toWhouse_ID` int(10) DEFAULT NULL,
  `frWhouse_ID` int(10) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `date_received_ID` int(10) DEFAULT NULL,
  `date_sent_ID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supply_transfer`
--

LOCK TABLES `supply_transfer` WRITE;
/*!40000 ALTER TABLE `supply_transfer` DISABLE KEYS */;
/*!40000 ALTER TABLE `supply_transfer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_ID` int(10) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `user_pass` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouse` (
  `whouse_ID` int(11) DEFAULT NULL,
  `whouse_location` varchar(255) DEFAULT NULL,
  `whouse_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-11 22:21:42
