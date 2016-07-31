-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: supply_distribution
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery` (
  `order_ID` int(11) DEFAULT NULL,
  `date_sent` varchar(255) DEFAULT NULL,
  `date_received` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distributions`
--

DROP TABLE IF EXISTS `distributions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distributions` (
  `dist_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `to_location_id` int(11) NOT NULL,
  `from_location_id` int(11) NOT NULL,
  `date_filed` datetime NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'Pending',
  `percent_completed` float NOT NULL DEFAULT '0',
  `date_completed` datetime DEFAULT NULL,
  PRIMARY KEY (`dist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distributions`
--

LOCK TABLES `distributions` WRITE;
/*!40000 ALTER TABLE `distributions` DISABLE KEYS */;
INSERT INTO `distributions` VALUES (1,'transfer',0,1,'2016-08-16 10:00:00','Pending',0,NULL),(2,'transfer',0,1,'2016-07-30 02:30:52','Pending',0,NULL);
/*!40000 ALTER TABLE `distributions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `inv_id` int(11) NOT NULL,
  `location` varchar(45) NOT NULL,
  `supply` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `count` float NOT NULL,
  `unit` varchar(45) NOT NULL,
  PRIMARY KEY (`inv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (0,'Laguna','Nail','1 inch',1000,'pieces'),(1,'Laguna','Wood','2x10x50 inch',2000,'pieces'),(2,'Laguna','Cement','General Purpose',3000,'kilograms'),(3,'Manila','Nail','1 inch',0,'pieces'),(4,'Manila','Wood','2x10x50 inch',100,'pieces'),(5,'Manila','Cement','General Purpose',200,'kilograms');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (0,'Sta Rosa Main Warehouse','12 Street St., Sta Rosa City, Laguna','warehouse'),(1,'Manila Main Warehouse','13 Street St., Manila','warehouse'),(2,'Binan Jollibee No. 1','14 Street St., Binan, Laguna','project site'),(3,'Binan Jollibee No. 2','15 Street St., Binan, Laguna','project site');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `requestor_ID` int(11) DEFAULT NULL,
  `supply_ID` int(11) DEFAULT NULL,
  `date_received` varchar(255) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_id` varchar(45) NOT NULL,
  `supply_id` int(11) NOT NULL,
  `count` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('0',1,1000),('T8',0,1),('T9',0,1),('T9',1,2),('T9',2,3),('',0,10),('',1,20),('',2,30),('',0,10),('',1,300),('',2,20),('2',0,10),('2',1,20),('2',2,30);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supply`
--

DROP TABLE IF EXISTS `supply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supply` (
  `supply_id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(100) NOT NULL,
  `count` float NOT NULL,
  `unit` varchar(45) NOT NULL,
  PRIMARY KEY (`supply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supply`
--

LOCK TABLES `supply` WRITE;
/*!40000 ALTER TABLE `supply` DISABLE KEYS */;
INSERT INTO `supply` VALUES (0,0,'Nail','1 inch',1000,'pieces'),(1,0,'Wood','2x10x50 inch',2000,'pieces'),(2,0,'Cement','General Purpose',3000,'kilograms'),(3,1,'Nail','1 inch',0,'pieces'),(4,1,'Wood','2x10x50 inch',100,'pieces'),(5,1,'Cement','General Purpose',200,'kilograms');
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
  `transfer_id` int(10) NOT NULL AUTO_INCREMENT,
  `to_whouse_id` int(11) NOT NULL,
  `from_whouse_id` int(11) NOT NULL,
  `order_id` varchar(45) NOT NULL,
  `date_filed` datetime NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'Pending',
  `percent_completed` float NOT NULL DEFAULT '0',
  `date_completed` datetime DEFAULT NULL,
  PRIMARY KEY (`transfer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supply_transfer`
--

LOCK TABLES `supply_transfer` WRITE;
/*!40000 ALTER TABLE `supply_transfer` DISABLE KEYS */;
INSERT INTO `supply_transfer` VALUES (0,0,1,'0','2016-08-16 10:00:00','Pending',0,NULL),(5,0,1,'0','2016-08-16 10:00:00','Pending',0,NULL),(6,0,1,'T6','2016-08-16 10:00:00','Pending',0,NULL),(7,0,1,'T7','2016-07-17 09:31:01','Pending',0,NULL),(8,0,1,'T8','2016-07-17 10:02:36','Pending',0,NULL),(9,0,1,'T9','2016-07-17 10:04:20','Pending',0,NULL);
/*!40000 ALTER TABLE `supply_transfer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'suppdist','supply'),(2,'projman','project');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouse` (
  `whouse_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  PRIMARY KEY (`whouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES (0,'Warehouse ABC','Laguna'),(1,'Warehouse XYZ','Manila');
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

-- Dump completed on 2016-07-31  1:19:12
