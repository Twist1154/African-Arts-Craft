-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: african_arts_store
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
-- Table structure for table `discounts`
--

DROP TABLE IF EXISTS `discounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discounts` (
  `discount_id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount_percent` double NOT NULL,
  `end_date` date DEFAULT NULL,
  `max_uses` int NOT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discounts`
--

LOCK TABLES `discounts` WRITE;
/*!40000 ALTER TABLE `discounts` DISABLE KEYS */;
INSERT INTO `discounts` VALUES (1,'ARTS15','15% off on all art supplies',15,'2024-03-31',100,'2024-01-01'),(2,'CRAFTS20','20% off on handmade crafts',20,'2024-05-31',150,'2024-02-01'),(3,'SOUTHAFRICA10','10% off for South African customers',10,'2024-06-30',200,'2024-03-01'),(4,'EASTER25','25% off on Easter themed items',25,'2024-04-05',80,'2024-03-20'),(5,'WINTER20','20% off on winter art collections',20,'2024-07-31',120,'2024-05-01'),(6,'HERITAGE30','30% off on South African heritage art',30,'2024-09-30',100,'2024-08-01'),(7,'SPRING15','15% off on spring crafts and decor',15,'2024-11-30',150,'2024-09-01'),(8,'BLACKFRIDAY40','40% off on all items for Black Friday',40,'2024-11-30',300,'2024-11-24'),(9,'CHRISTMAS20','20% off on Christmas decorations and gifts',20,'2024-12-25',250,'2024-12-01'),(10,'NEWYEAR25','25% off sitewide for the New Year',25,'2025-01-05',200,'2024-12-26'),(11,'BEADWORK15','15% off on beadwork and jewelry',15,'2024-03-15',130,'2024-01-15'),(12,'PAINTINGS20','20% off on local paintings',20,'2024-06-30',140,'2024-04-01'),(13,'TEXTILES25','25% off on handmade textiles',25,'2024-07-31',90,'2024-05-01'),(14,'FALL20','20% off on fall-themed crafts',20,'2024-10-31',110,'2024-08-01'),(15,'THANKSGIVING15','15% off for Thanksgiving crafts',15,'2024-11-22',180,'2024-11-01'),(16,'HOLIDAY30','30% off holiday decor and gifts',30,'2024-12-31',150,'2024-11-01'),(17,'BACKTOSCHOOL10','10% off on craft supplies for school projects',10,'2024-08-31',170,'2024-07-01'),(18,'MOTHERSDAY20','20% off on Mother’s Day crafts and gifts',20,'2024-05-10',130,'2024-05-01'),(19,'FATHERSDAY15','15% off on Father’s Day art and decor',15,'2024-06-15',120,'2024-06-01'),(20,'SUMMER25','25% off on summer-themed crafts and decor',25,'2024-02-28',140,'2024-12-01'),(21,'WOMENSDAY20','20% off on Women’s Day specials',20,'2024-03-08',110,'2024-03-01'),(22,'ARTS15','15% off on all art supplies',15,'2021-03-31',100,'2021-01-01'),(23,'CRAFTS20','20% off on handmade crafts',20,'2021-05-31',150,'2021-02-01'),(24,'SOUTHAFRICA10','10% off for South African customers',10,'2021-06-30',200,'2021-03-01'),(25,'EASTER25','25% off on Easter themed items',25,'2021-04-05',80,'2021-03-20'),(26,'WINTER20','20% off on winter art collections',20,'2021-07-31',120,'2021-05-01'),(27,'HERITAGE30','30% off on South African heritage art',30,'2021-09-30',100,'2021-08-01'),(28,'SPRING15','15% off on spring crafts and decor',15,'2021-11-30',150,'2021-09-01'),(29,'BLACKFRIDAY40','40% off on all items for Black Friday',40,'2021-11-30',300,'2021-11-24'),(30,'CHRISTMAS20','20% off on Christmas decorations and gifts',20,'2021-12-25',250,'2021-12-01'),(31,'NEWYEAR25','25% off sitewide for the New Year',25,'2022-01-05',200,'2021-12-26'),(32,'BEADWORK15','15% off on beadwork and jewelry',15,'2022-03-15',130,'2022-01-15'),(33,'PAINTINGS20','20% off on local paintings',20,'2022-06-30',140,'2022-04-01'),(34,'TEXTILES25','25% off on handmade textiles',25,'2022-07-31',90,'2022-05-01'),(35,'FALL20','20% off on fall-themed crafts',20,'2022-10-31',110,'2022-08-01'),(36,'THANKSGIVING15','15% off for Thanksgiving crafts',15,'2022-11-22',180,'2022-11-01'),(37,'HOLIDAY30','30% off holiday decor and gifts',30,'2022-12-31',150,'2022-11-01'),(38,'BACKTOSCHOOL10','10% off on craft supplies for school projects',10,'2022-08-31',170,'2022-07-01'),(39,'MOTHERSDAY20','20% off on Mother’s Day crafts and gifts',20,'2022-05-10',130,'2022-05-01'),(40,'FATHERSDAY15','15% off on Father’s Day art and decor',15,'2022-06-15',120,'2022-06-01'),(41,'SUMMER25','25% off on summer-themed crafts and decor',25,'2023-02-28',140,'2022-12-01'),(42,'WOMENSDAY20','20% off on Women’s Day specials',20,'2022-03-08',110,'2022-03-01'),(43,'VALENTINE25','25% off on Valentine’s Day items',25,'2023-02-14',150,'2023-02-01'),(44,'EASTER20','20% off on Easter crafts',20,'2023-04-05',160,'2023-03-20'),(45,'HERITAGE25','25% off on Heritage Day items',25,'2023-09-24',100,'2023-08-01'),(46,'BLACKFRIDAY30','30% off for Black Friday',30,'2023-11-30',200,'2023-11-24'),(47,'CHRISTMAS25','25% off on Christmas items',25,'2023-12-25',220,'2023-12-01'),(48,'NEWYEAR30','30% off New Year specials',30,'2024-01-05',180,'2023-12-26');
/*!40000 ALTER TABLE `discounts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-23 16:02:26
