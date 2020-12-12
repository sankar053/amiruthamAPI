CREATE DATABASE  IF NOT EXISTS `amirutham` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `amirutham`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: amirutham
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `amir_banner`
--

DROP TABLE IF EXISTS `amir_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `amir_banner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_ban_desc` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_ban_file_nm` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_ban_file_pth` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_ban_file_size` bigint DEFAULT NULL,
  `amir_ban_file_type` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_ban_file_uri` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_ban_nm` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amir_banner`
--

LOCK TABLES `amir_banner` WRITE;
/*!40000 ALTER TABLE `amir_banner` DISABLE KEYS */;
INSERT INTO `amir_banner` VALUES (1,'2020-12-11 17:29:50',NULL,'Y','N','2021 15% Flat offer','viji.jpg','C:\\catalogs\\viji.jpg',22964,'image/jpeg','http://localhost:8085/banner/downloadFile/viji.jpg','New Year Mega Offer','Amirthum','Amirthum'),(2,'2020-12-11 17:34:52',NULL,'Y','N','2021 15% Flat offer','viji.jpg','C:\\Amirthum\\Banner\\viji.jpg',22964,'image/jpeg','http://localhost:8085/banner/downloadFile/viji.jpg','New Year Mega Offer','Amirthum','Amirthum'),(3,'2020-12-12 05:04:50',NULL,'Y','N','2021 15% Flat offer','Dump20201212.sql','C:\\Amirthum\\Banner\\Dump20201212.sql',67667,'application/octet-stream','http://localhost:8085/banner/downloadFile/Dump20201212.sql','New Year Mega Offer','Amirthum','Amirthum');
/*!40000 ALTER TABLE `amir_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amir_prod_category`
--

DROP TABLE IF EXISTS `amir_prod_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `amir_prod_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `cate_code` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `cate_desc` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `cate_nme` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amir_prod_category`
--

LOCK TABLES `amir_prod_category` WRITE;
/*!40000 ALTER TABLE `amir_prod_category` DISABLE KEYS */;
INSERT INTO `amir_prod_category` VALUES (1,'2020-12-06 16:57:50',NULL,'Y','N','CATE00001','Amirthum Natural Sweetners','NaturalSweetners',NULL,NULL),(2,'2020-12-06 16:57:50',NULL,'Y','N','CATE00002','Amirthum HerbalPowder Powder','HerbalPowder',NULL,NULL),(3,'2020-12-06 16:57:50',NULL,'Y','N','CATE00003','Amirthum Natural Sweetners','NaturalSweetners',NULL,NULL),(4,'2020-12-06 16:57:50',NULL,'Y','N','CATE00004','Amirthum Organic Oils','Oils',NULL,NULL),(5,'2020-12-06 16:57:50',NULL,'Y','N','CATE00005','Amirthum Seeds','Seed',NULL,NULL),(6,'2020-12-06 16:57:50',NULL,'Y','N','CATE00006','Amirthum Organic Soaps','Soap',NULL,NULL);
/*!40000 ALTER TABLE `amir_prod_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amir_sequnce`
--

DROP TABLE IF EXISTS `amir_sequnce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `amir_sequnce` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_seq_char` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_seq_cur_val` int DEFAULT NULL,
  `amir_seq_lim_val` int DEFAULT NULL,
  `amir_seq_nm` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_seq_nxt_val` int DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amir_sequnce`
--

LOCK TABLES `amir_sequnce` WRITE;
/*!40000 ALTER TABLE `amir_sequnce` DISABLE KEYS */;
INSERT INTO `amir_sequnce` VALUES (1,'2020-12-06 16:10:54','2020-12-06 17:31:41','Y','N','PROD',15,999999,'PRODUCT',16,NULL,NULL),(2,'2020-12-06 16:10:54','2020-12-06 16:57:50','Y','N','CATE',6,999999,'CATEGERY',7,NULL,NULL);
/*!40000 ALTER TABLE `amir_sequnce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amir_user`
--

DROP TABLE IF EXISTS `amir_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `amir_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_mail_addr` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_fst_nm` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_lst_nm` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_pwd` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_phn_nbr` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amir_user`
--

LOCK TABLES `amir_user` WRITE;
/*!40000 ALTER TABLE `amir_user` DISABLE KEYS */;
INSERT INTO `amir_user` VALUES (24,'2020-12-07 16:48:00',NULL,'Y','N','sankaraasn1@gmail.com','Mari','selvam','$2a$10$4KNk.XvWAhU23t7pIxO0Zu0GAEKokBlreGmDufqNe4zQqp4W1s1a2','9791255265',NULL,NULL),(27,'2020-12-07 18:11:07','2020-12-08 16:12:46','Y','N','sankaraasn@gmail.com','Mari','selvam','$2a$10$KrcntnhpUzuCMqTdaNlQxOzYrmLr5cvzWeQfCOJC1djxrrfR1gmG.','9791255264',NULL,NULL),(36,'2020-12-09 16:54:30',NULL,'Y','N','sankaraasn11@gmail.com','dfdsfsd','selvam','$2a$10$OQIJJwUGJfp.Yt1hWCsFR.aw9ZQ0A51SdWzoMHF70ZJGXY2SwRDAK','97912552641',NULL,NULL),(41,'2020-12-10 10:59:44',NULL,'Y','N','sankaraasn1111@gmail.com','dsds','gfdgfd','$2a$10$wY38xIMditgQQJVu3MY/W.hRAwVCRwKyiu97CPHTIY7HeDXxQTyay','9791255264111',NULL,NULL);
/*!40000 ALTER TABLE `amir_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amir_user_addr`
--

DROP TABLE IF EXISTS `amir_user_addr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `amir_user_addr` (
  `id` int NOT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_addr_lne1` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_addr_lne2` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_addr_type` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_addr_city` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_addr_zipcode` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_addr_state` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_id` int DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKseqrs6ki68abxwgwl4nvtm30p` (`amir_user_id`),
  CONSTRAINT `FKseqrs6ki68abxwgwl4nvtm30p` FOREIGN KEY (`amir_user_id`) REFERENCES `amir_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amir_user_addr`
--

LOCK TABLES `amir_user_addr` WRITE;
/*!40000 ALTER TABLE `amir_user_addr` DISABLE KEYS */;
INSERT INTO `amir_user_addr` VALUES (37,'2020-12-09 16:54:30',NULL,'Y','N','73 KR garden','railway feeder road','Home','virudhunagar','626001','tamilnadu',36,NULL,NULL),(38,'2020-12-09 16:54:30',NULL,'Y','N','74 KR garden','railway feeder road','WORK','virudhunagar','626001','tamilnadu',36,NULL,NULL),(42,'2020-12-10 10:59:44',NULL,'Y','N','73 KR garden','railway feeder road','Home','virudhunagar','626001','tamilnadu',41,NULL,NULL),(43,'2020-12-10 10:59:44',NULL,'Y','N','74 KR garden','railway feeder road','WORK','virudhunagar','626001','tamilnadu',41,NULL,NULL);
/*!40000 ALTER TABLE `amir_user_addr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amir_user_role`
--

DROP TABLE IF EXISTS `amir_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `amir_user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amir_user_rle_dsc` varchar(20) CHARACTER SET utf8  DEFAULT NULL,
  `amir_user_rle` varchar(20) CHARACTER SET utf8  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amir_user_role`
--

LOCK TABLES `amir_user_role` WRITE;
/*!40000 ALTER TABLE `amir_user_role` DISABLE KEYS */;
INSERT INTO `amir_user_role` VALUES (4,'Admin role','ROLE_ADMIN'),(5,'User role','ROLE_USER');
/*!40000 ALTER TABLE `amir_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (46),(46);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_token`
--

DROP TABLE IF EXISTS `password_reset_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `password_reset_token` (
  `id` bigint NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `one_time_password` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKflwjhvkb3ue9qihidt7p2u3na` (`user_id`),
  CONSTRAINT `FKflwjhvkb3ue9qihidt7p2u3na` FOREIGN KEY (`user_id`) REFERENCES `amir_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_token`
--

LOCK TABLES `password_reset_token` WRITE;
/*!40000 ALTER TABLE `password_reset_token` DISABLE KEYS */;
INSERT INTO `password_reset_token` VALUES (35,'2020-12-09 16:11:40','929508','4048be68-56e1-4054-9c3b-fb52c84fb887',27);
/*!40000 ALTER TABLE `password_reset_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_media_gallary`
--

DROP TABLE IF EXISTS `product_media_gallary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `product_media_gallary` (
  `prod_med_id` int NOT NULL AUTO_INCREMENT,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_med_nm` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_med_file_path` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_med_size` bigint DEFAULT NULL,
  `prod_med_type` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_med_url` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_id` int DEFAULT NULL,
  `med_prod_code` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  PRIMARY KEY (`prod_med_id`),
  KEY `FK9c8hj2678cwtafn999h1xamys` (`prod_id`),
  CONSTRAINT `FK9c8hj2678cwtafn999h1xamys` FOREIGN KEY (`prod_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_media_gallary`
--

LOCK TABLES `product_media_gallary` WRITE;
/*!40000 ALTER TABLE `product_media_gallary` DISABLE KEYS */;
INSERT INTO `product_media_gallary` VALUES (1,'2020-12-06 17:12:32',NULL,'Y','N','PROD0001.jpg','C:\\Amirthum\\CATE00001\\PROD0001\\PROD00001.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD0001.jpeg/CATE00001',1,NULL,NULL,NULL),(2,'2020-12-06 17:12:32',NULL,'Y','N','PROD0001_1.jpg','C:\\Amirthum\\CATE00001\\PROD00001\\PROD0001_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD0001_1.jpeg/CATE00001',1,NULL,NULL,NULL),(3,'2020-12-06 17:12:32',NULL,'Y','N','PROD0002.jpg','C:\\Amirthum\\CATE00001\\PROD0002.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD0002.jpeg/CATE00001',2,NULL,NULL,NULL),(4,'2020-12-06 17:12:32',NULL,'Y','N','PROD0002_1.jpg','C:\\Amirthum\\CATE00001\\PROD0002_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD0002_1.jpeg/CATE00001',2,NULL,NULL,NULL),(5,'2020-12-06 17:12:32',NULL,'Y','N','PROD0003.jpg','C:\\Amirthum\\CATE00001\\PROD0003.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD0003.jpeg/CATE00001',3,NULL,NULL,NULL),(6,'2020-12-06 17:12:32',NULL,'Y','N','PROD0003_1.jpg','C:\\Amirthum\\CATE00001\\PROD0003_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD0003_1.jpeg/CATE00001',3,NULL,NULL,NULL),(7,'2020-12-06 17:12:32',NULL,'Y','N','PROD0004.jpg','C:\\Amirthum\\CATE00001\\PROD0004.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD0004.jpeg/CATE00001',4,NULL,NULL,NULL),(8,'2020-12-06 17:12:32',NULL,'Y','N','PROD0004_1.jpg','C:\\Amirthum\\CATE00001\\PROD0004_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD0004_1.jpeg/CATE00001',4,NULL,NULL,NULL),(9,'2020-12-06 17:12:32',NULL,'Y','N','PROD0005.jpg','C:\\Amirthum\\CATE00001\\PROD0005.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD0005.jpeg',5,NULL,NULL,NULL),(10,'2020-12-06 17:12:32',NULL,'Y','N','PROD0005_1.jpg','C:\\Amirthum\\CATE00001\\PROD0005_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD0005_1.jpeg',5,NULL,NULL,NULL),(11,'2020-12-06 17:12:32',NULL,'Y','N','PROD00006.jpg','C:\\Amirthum\\CATE00002\\PROD00006.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00006.jpg',6,NULL,NULL,NULL),(12,'2020-12-06 17:12:32',NULL,'Y','N','PROD00006_1.jpg','C:\\Amirthum\\CATE00002\\PROD00006_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00006_1.jpg',6,NULL,NULL,NULL),(13,'2020-12-06 17:12:32',NULL,'Y','N','PROD00007.jpg','C:\\Amirthum\\CATE00002\\PROD00007.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00007.jpg',7,NULL,NULL,NULL),(14,'2020-12-06 17:12:32',NULL,'Y','N','PROD00007_1.jpg','C:\\Amirthum\\CATE00002\\PROD00007_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00007_1.jpg',7,NULL,NULL,NULL),(15,'2020-12-06 17:12:32',NULL,'Y','N','PROD00008.jpg','C:\\Amirthum\\CATE00002\\PROD00008.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00008.jpg',8,NULL,NULL,NULL),(16,'2020-12-06 17:12:32',NULL,'Y','N','PROD00008_1.jpg','C:\\Amirthum\\CATE00002\\PROD00008_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00008_1.jpg',8,NULL,NULL,NULL),(17,'2020-12-06 17:12:32',NULL,'Y','N','PROD00009.jpg','C:\\Amirthum\\CATE00002\\PROD00009.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00009.jpg',9,NULL,NULL,NULL),(18,'2020-12-06 17:12:32',NULL,'Y','N','PROD00009_1.jpg','C:\\Amirthum\\CATE00002\\PROD00009_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00009_1.jpg',9,NULL,NULL,NULL),(19,'2020-12-06 17:12:32',NULL,'Y','N','PROD000010.jpg','C:\\Amirthum\\CATE00002\\PROD000010.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000010.jpg',10,NULL,NULL,NULL),(20,'2020-12-06 17:12:32',NULL,'Y','N','PROD000010_1.jpg','C:\\Amirthum\\CATE00002\\PROD000010_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000010_1.jpg',10,NULL,NULL,NULL),(33,'2020-12-06 17:12:32',NULL,'Y','N','PROD000018.jpeg','C:\\Amirthum\\CATE00003\\PROD000018.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000018.jpeg/CATE00003',18,NULL,NULL,NULL),(34,'2020-12-06 17:12:32',NULL,'Y','N','PROD000018_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000018_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000018_1.jpeg',18,NULL,NULL,NULL),(35,'2020-12-06 17:12:32',NULL,'Y','N','PROD000019.jpeg','C:\\Amirthum\\CATE00003\\PROD000019.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000019.jpeg/CATE00003',19,NULL,NULL,NULL),(36,'2020-12-06 17:12:32',NULL,'Y','N','PROD000019_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000019_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000019_1.jpeg/CATE00003',19,NULL,NULL,NULL),(37,'2020-12-06 17:12:32',NULL,'Y','N','PROD000020.jpeg','C:\\Amirthum\\CATE00003\\PROD000020.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000020.jpeg/CATE00003',20,NULL,NULL,NULL),(38,'2020-12-06 17:12:32',NULL,'Y','N','PROD000020_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000020_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000020_1.jpeg/CATE00003',20,NULL,NULL,NULL),(39,'2020-12-06 17:12:32',NULL,'Y','N','PROD000021.jpeg','C:\\Amirthum\\CATE00003\\PROD000021.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000021.jpeg/CATE00003',21,NULL,NULL,NULL),(40,'2020-12-06 17:12:32',NULL,'Y','N','PROD000021_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000021_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000021_1.jpeg/CATE00003',21,NULL,NULL,NULL),(41,'2020-12-06 17:12:32',NULL,'Y','N','PROD000022.jpeg','C:\\Amirthum\\CATE00003\\PROD000022.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000022.jpeg/CATE00003',22,NULL,NULL,NULL),(42,'2020-12-06 17:12:32',NULL,'Y','N','PROD000022_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000022_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000022_1.jpeg/CATE00003',22,NULL,NULL,NULL),(43,'2020-12-06 17:12:32',NULL,'Y','N','PROD000023.jpeg','C:\\Amirthum\\CATE00003\\PROD000023.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000023.jpeg/CATE00003',23,NULL,NULL,NULL),(44,'2020-12-06 17:12:32',NULL,'Y','N','PROD000023_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000023_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000023_1.jpeg/CATE00003',23,NULL,NULL,NULL),(45,'2020-12-06 17:12:32',NULL,'Y','N','PROD000024.jpeg','C:\\Amirthum\\CATE00003\\PROD000024.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000024.jpeg/CATE00003',24,NULL,NULL,NULL),(46,'2020-12-06 17:12:32',NULL,'Y','N','PROD000024_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000024_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000024_1.jpeg/CATE00003',24,NULL,NULL,NULL),(47,'2020-12-06 17:12:32',NULL,'Y','N','PROD000025.jpeg','C:\\Amirthum\\CATE00003\\PROD000025.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000025.jpeg/CATE00003',25,NULL,NULL,NULL),(48,'2020-12-06 17:12:32',NULL,'Y','N','PROD000025_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000025_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000025_1.jpeg/CATE00003',25,NULL,NULL,NULL),(49,'2020-12-06 17:12:32',NULL,'Y','N','PROD000026.jpeg','C:\\Amirthum\\CATE00003\\PROD000026.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000026.jpeg/CATE00003',26,NULL,NULL,NULL),(50,'2020-12-06 17:12:32',NULL,'Y','N','PROD000026_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000026_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000026_1.jpeg/CATE00003',26,NULL,NULL,NULL),(51,'2020-12-06 17:12:32',NULL,'Y','N','PROD000027.jpeg','C:\\Amirthum\\CATE00003\\PROD000027.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000027.jpeg/CATE00003',27,NULL,NULL,NULL),(52,'2020-12-06 17:12:32',NULL,'Y','N','PROD000027_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000027_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000027_1.jpeg/CATE00003',27,NULL,NULL,NULL),(53,'2020-12-06 17:12:32',NULL,'Y','N','PROD000028.jpeg','C:\\Amirthum\\CATE00003\\PROD000028.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000028.jpeg/CATE00003',28,NULL,NULL,NULL),(54,'2020-12-06 17:12:32',NULL,'Y','N','PROD000028_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000028_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000028_1.jpeg/CATE00003',28,NULL,NULL,NULL),(55,'2020-12-06 17:12:32',NULL,'Y','N','PROD000017.jpeg','C:\\Amirthum\\CATE00003\\PROD000017.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000017.jpeg/CATE00003',17,NULL,NULL,NULL),(56,'2020-12-06 17:12:32',NULL,'Y','N','PROD000017_1.jpeg','C:\\Amirthum\\CATE00003\\PROD000017_1.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD000017_1.jpeg/CATE00003',17,NULL,NULL,NULL),(57,'2020-12-06 17:12:32',NULL,'Y','N','PROD000029.jpeg','C:\\Amirthum\\CATE00004\\PROD00029.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00029.jpg/CATE00004',29,NULL,NULL,NULL),(58,'2020-12-06 17:12:32',NULL,'Y','N','PROD000030.jpeg','C:\\Amirthum\\CATE00004\\PROD00030.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00030.jpg/CATE00004',30,NULL,NULL,NULL),(59,'2020-12-06 17:12:32',NULL,'Y','N','PROD000031.jpeg','C:\\Amirthum\\CATE00004\\PROD00031.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00031.jpg/CATE00004',31,NULL,NULL,NULL),(60,'2020-12-06 17:12:32',NULL,'Y','N','PROD000032.jpeg','C:\\Amirthum\\CATE00004\\PROD00032.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00032.jpg/CATE00004',32,NULL,NULL,NULL),(61,'2020-12-06 17:12:32',NULL,'Y','N','PROD000033.jpeg','C:\\Amirthum\\CATE00004\\PROD00033.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00033.jpg/CATE00004',33,NULL,NULL,NULL),(62,'2020-12-06 17:12:32',NULL,'Y','N','PROD000034.jpeg','C:\\Amirthum\\CATE00004\\PROD00034.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00034.jpg/CATE00004',34,NULL,NULL,NULL),(63,'2020-12-06 17:12:32',NULL,'Y','N','PROD000035.jpeg','C:\\Amirthum\\CATE00004\\PROD00038.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00035.jpg/CATE00004',35,NULL,NULL,NULL),(64,'2020-12-06 17:12:32',NULL,'Y','N','PROD000036.jpeg','C:\\Amirthum\\CATE00004\\PROD00036.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00036.jpg/CATE00004',36,NULL,NULL,NULL),(65,'2020-12-06 17:12:32',NULL,'Y','N','PROD000037.jpeg','C:\\Amirthum\\CATE00004\\PROD00037.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00037.jpg/CATE00004',37,NULL,NULL,NULL),(66,'2020-12-06 17:12:32',NULL,'Y','N','PROD000038.jpeg','C:\\Amirthum\\CATE00004\\PROD00038.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00038.jpg/CATE00004',38,NULL,NULL,NULL),(67,'2020-12-06 17:12:32',NULL,'Y','N','PROD000039.jpeg','C:\\Amirthum\\CATE00004\\PROD00039.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00039.jpg/CATE00004',39,NULL,NULL,NULL),(68,'2020-12-06 17:12:32',NULL,'Y','N','PROD000040.jpeg','C:\\Amirthum\\CATE00004\\PROD00040.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00040.jpg/CATE00004',40,NULL,NULL,NULL),(69,'2020-12-06 17:12:32',NULL,'Y','N','PROD000041.jpeg','C:\\Amirthum\\CATE00004\\PROD00041.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00041.jpg/CATE00004',41,NULL,NULL,NULL),(70,'2020-12-06 17:12:32',NULL,'Y','N','PROD000042.jpeg','C:\\Amirthum\\CATE00004\\PROD00042.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00042.jpg/CATE00004',42,NULL,NULL,NULL),(71,'2020-12-06 17:12:32',NULL,'Y','N','PROD000043.jpeg','C:\\Amirthum\\CATE00004\\PROD00043.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00043.jpg/CATE00004',43,NULL,NULL,NULL),(72,'2020-12-06 17:12:32',NULL,'Y','N','PROD000044.jpeg','C:\\Amirthum\\CATE00004\\PROD00044.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00044.jpg/CATE00004',44,NULL,NULL,NULL),(73,'2020-12-06 17:12:32',NULL,'Y','N','PROD000045.jpeg','C:\\Amirthum\\CATE00004\\PROD00045.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00045.jpg/CATE00004',45,NULL,NULL,NULL),(74,'2020-12-06 17:12:32',NULL,'Y','N','PROD000046.jpeg','C:\\Amirthum\\CATE00004\\PROD00046.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00046.jpg/CATE00004',46,NULL,NULL,NULL),(75,'2020-12-06 17:12:32',NULL,'Y','N','PROD000047.jpeg','C:\\Amirthum\\CATE00004\\PROD00047.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00047.jpg/CATE00004',47,NULL,NULL,NULL),(76,'2020-12-06 17:12:32',NULL,'Y','N','PROD000048.jpeg','C:\\Amirthum\\CATE00004\\PROD00048.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00048.jpg/CATE00004',48,NULL,NULL,NULL),(77,'2020-12-06 17:12:32',NULL,'Y','N','PROD000049.jpeg','C:\\Amirthum\\CATE00004\\PROD00049.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00049.jpg/CATE00004',49,NULL,NULL,NULL),(78,'2020-12-06 17:12:32',NULL,'Y','N','PROD000050.jpeg','C:\\Amirthum\\CATE00004\\PROD00050.jpeg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00050.jpg/CATE00004',50,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product_media_gallary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_varient`
--

DROP TABLE IF EXISTS `product_varient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `product_varient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_useby_date` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_discount_rate` int DEFAULT NULL,
  `prod_manufacture_date` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_mrp_price` double DEFAULT NULL,
  `prod_code` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_saved_price` double DEFAULT NULL,
  `prod_selling_price` double DEFAULT NULL,
  `prod_in_unit` int DEFAULT NULL,
  `prod_unit_type` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj5us0krt8g7e845oqrbig1pyh` (`prod_id`),
  CONSTRAINT `FKj5us0krt8g7e845oqrbig1pyh` FOREIGN KEY (`prod_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_varient`
--

LOCK TABLES `product_varient` WRITE;
/*!40000 ALTER TABLE `product_varient` DISABLE KEYS */;
INSERT INTO `product_varient` VALUES (1,'Amirthum','2020-12-11 14:56:52',NULL,'Y','N','Amirthum','09 Sep 2021',10,'15 Sep 2020',110,'PROD00001',11,99,1,'kg',1),(2,'Amirthum','2020-12-11 14:56:52',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',55,'PROD00001',3,52,500,'g',1),(3,'Amirthum','2020-12-11 14:56:53',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',55,'PROD00002',3,52,500,'g',2),(4,'Amirthum','2020-12-11 14:56:53',NULL,'Y','N','Amirthum','09 Sep 2021',7,'15 Sep 2020',185,'PROD00003',13,172,500,'g',3),(5,'Amirthum','2020-12-11 14:56:53',NULL,'Y','N','Amirthum','09 Sep 2021',7,'15 Sep 2020',160,'PROD00004',11,149,250,'g',4),(6,'Amirthum','2020-12-11 14:56:53',NULL,'Y','N','Amirthum','09 Sep 2021',30,'15 Sep 2020',330,'PROD00004',99,231,500,'g',4),(7,'Amirthum','2020-12-11 14:56:53',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',185,'PROD00005',9,176,250,'g',5),(8,'Amirthum','2020-12-11 15:36:16',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',370,'PROD00029',18,352,1,'L',29),(9,'Amirthum','2020-12-11 15:36:16',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',180,'PROD00029',9,171,500,'ml',29),(10,'Amirthum','2020-12-11 15:36:16',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',95,'PROD00029',5,90,250,'ml',29),(11,'Amirthum','2020-12-11 15:36:17',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',330,'PROD00030',16,314,1,'L',30),(12,'Amirthum','2020-12-11 15:36:17',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',170,'PROD00030',8,162,500,'ml',30),(13,'Amirthum','2020-12-11 15:36:17',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',90,'PROD00030',4,86,250,'ml',30),(14,'Amirthum','2020-12-11 15:36:17',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',270,'PROD00031',13,257,1,'L',31),(15,'Amirthum','2020-12-11 15:36:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',140,'PROD00031',7,133,500,'ml',31),(16,'Amirthum','2020-12-11 15:36:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',75,'PROD00031',4,71,250,'ml',31),(17,'Amirthum','2020-12-11 15:36:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',500,'PROD00047',25,475,200,'ml',47),(18,'Amirthum','2020-12-11 15:36:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',210,'PROD00047',10,200,100,'ml',47),(19,'Amirthum','2020-12-11 15:36:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',110,'PROD00047',5,105,50,'ml',47),(20,'Amirthum','2020-12-11 16:50:19',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',210,'PROD00049',10,200,100,'ml',49),(21,'Amirthum','2020-12-11 16:50:20',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',130,'PROD00033',6,124,100,'ml',33),(22,'Amirthum','2020-12-11 16:50:20',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',310,'PROD00040',15,295,100,'ml',40),(23,'Amirthum','2020-12-11 16:50:20',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',240,'PROD00035',12,228,100,'ml',35),(24,'Amirthum','2020-12-11 16:50:20',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',210,'PROD00038',10,200,100,'ml',38),(25,'Amirthum','2020-12-11 16:50:20',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',160,'PROD00032',8,152,500,'ml',32),(26,'Amirthum','2020-12-11 16:50:21',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',310,'PROD00032',15,295,1,'L',32),(27,'Amirthum','2020-12-11 16:50:21',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',310,'PROD00045',15,295,1,'L',45),(28,'Amirthum','2020-12-11 16:50:21',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',160,'PROD00045',8,152,500,'ml',45),(29,'Amirthum','2020-12-11 16:50:21',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',70,'PROD00045',3,67,200,'ml',45),(30,'Amirthum','2020-12-11 16:50:21',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',70,'PROD00046',3,67,200,'ml',46),(31,'Amirthum','2020-12-11 16:50:21',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',310,'PROD00050',15,295,1,'L',50),(32,'Amirthum','2020-12-11 16:50:22',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',160,'PROD00050',8,152,500,'ml',50),(33,'Amirthum','2020-12-11 16:50:22',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',70,'PROD00050',3,67,200,'ml',50),(34,'Amirthum','2020-12-11 16:57:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',260,'PROD00042',13,247,1,'L',42),(35,'Amirthum','2020-12-11 16:57:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',135,'PROD00042',7,128,500,'ml',42),(36,'Amirthum','2020-12-11 16:57:19',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',260,'PROD00043',13,247,1,'L',43),(37,'Amirthum','2020-12-11 16:57:19',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',135,'PROD00043',7,128,500,'ml',43),(38,'Amirthum','2020-12-11 16:57:19',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',85,'PROD00037',4,81,50,'ml',37),(39,'Amirthum','2020-12-11 16:57:19',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',110,'PROD00034',5,105,50,'ml',34),(40,'Amirthum','2020-12-11 16:57:19',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',185,'PROD00036',9,176,50,'ml',36),(41,'Amirthum','2020-12-11 16:57:19',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',160,'PROD00041',8,152,50,'ml',41),(42,'Amirthum','2020-12-11 16:57:19',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',160,'PROD00048',8,152,50,'ml',48),(43,'Amirthum','2020-12-11 16:57:20',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',310,'PROD00039',15,295,100,'ml',39),(44,'Amirthum','2020-12-11 16:57:20',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',310,'PROD00044',15,295,1,'L',44),(45,'Amirthum','2020-12-11 16:57:20',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',160,'PROD00044',8,152,500,'ml',44),(46,'Amirthum','2020-12-11 16:57:20',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',70,'PROD00044',3,67,200,'ml',44),(47,'Amirthum','2020-12-11 17:06:04',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',110,'PROD00052',5,105,250,'g',52),(48,'Amirthum','2020-12-11 17:06:05',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',110,'PROD00051',5,105,250,'g',51),(49,'Amirthum','2020-12-11 17:06:05',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',185,'PROD00053',9,176,250,'g',53),(50,'Amirthum','2020-12-11 17:06:05',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',100,'PROD00054',5,95,250,'g',54),(51,'Amirthum','2020-12-11 17:06:05',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',110,'PROD00055',5,105,100,'g',55),(52,'Amirthum','2020-12-11 17:06:05',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',75,'PROD00056',4,71,100,'g',56),(53,'Amirthum','2020-12-11 17:06:05',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',105,'PROD00057',5,100,100,'g',57),(54,'Amirthum','2020-12-11 17:15:26',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',85,'PROD00012',4,81,50,'g',12),(55,'Amirthum','2020-12-11 17:15:26',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',85,'PROD00011',4,81,50,'g',11),(56,'Amirthum','2020-12-11 17:15:26',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',105,'PROD00006',5,100,50,'g',6),(57,'Amirthum','2020-12-11 17:15:27',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',65,'PROD00007',3,62,50,'g',7),(58,'Amirthum','2020-12-11 17:15:27',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',75,'PROD00013',4,71,100,'g',13),(59,'Amirthum','2020-12-11 17:15:27',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',65,'PROD00024',3,62,100,'g',24),(60,'Amirthum','2020-12-11 17:15:27',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',65,'PROD00025',3,62,100,'g',25),(61,'Amirthum','2020-12-11 17:15:27',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',95,'PROD00022',5,90,1,'kg',22),(62,'Amirthum','2020-12-11 17:15:27',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',50,'PROD00022',2,48,500,'g',22),(63,'Amirthum','2020-12-11 17:22:17',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',55,'PROD00009',3,52,500,'g',9),(64,'Amirthum','2020-12-11 17:22:17',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',85,'PROD00016',4,81,100,'g',16),(65,'Amirthum','2020-12-11 17:22:17',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',75,'PROD00061',4,71,100,'g',61),(66,'Amirthum','2020-12-11 17:22:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',55,'PROD00017',3,52,100,'g',17),(67,'Amirthum','2020-12-11 17:22:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',55,'PROD00018',3,52,100,'g',18),(68,'Amirthum','2020-12-11 17:22:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',55,'PROD00019',3,52,100,'g',19),(69,'Amirthum','2020-12-11 17:22:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',100,'PROD00020',5,95,100,'g',20),(70,'Amirthum','2020-12-11 17:22:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',185,'PROD00021',9,176,1,'kg',21),(71,'Amirthum','2020-12-11 17:22:18',NULL,'Y','N','Amirthum','09 Sep 2021',5,'15 Sep 2020',360,'PROD00021',18,342,500,'g',21);
/*!40000 ALTER TABLE `product_varient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_code` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_desc` longtext CHARACTER SET utf8 ,
  `prod_nme` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_ben_use` longtext CHARACTER SET utf8 ,
  `cart_id` int NOT NULL,
  `prod_cat_code` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_brand` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `prod_spec_dtls` longtext CHARACTER SET utf8 ,
  `created_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf1gs7cc9cvdd28c3pqprafw2o` (`cart_id`),
  CONSTRAINT `FKf1gs7cc9cvdd28c3pqprafw2o` FOREIGN KEY (`cart_id`) REFERENCES `amir_prod_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'2020-12-06 17:12:32',NULL,'Y','N','PROD00001','Jaggery is popularly used as a natural sugar substitute. It is obtained from the concentrated cane sugar without separation of the molasses and crystals. The Amirutham Jaggery is made by evaporating the water from concentrated sugar cane juice and solidifying it.','Jaggery','Jaggery helps in maintaining the electrolyte balance and helps prevent water retention due to its potassium content. Replacing sugar with jaggery is a healthier option. It detoxes the liver, prevents constipation, acts as a blood purifier and boosts immunity. ',1,NULL,NULL,NULL,NULL,NULL),(2,'2020-12-06 17:15:46',NULL,'Y','N','PROD00002','Brown sugar is a sucrose sugar product with a distinctive brown color due to the presence of molasses. It is unrefined soft sugar and has more liquid and has around 0.25 fewer calories per gram than white sugar. ','Brown Sugar','Because of its molasses content, brown sugar does contain certain minerals, most notably calcium, potassium, iron and magnesium. Brown sugar eases menstrual cramps, prevents obesity and improves digestion. It is chemaical free and acts as an antiseptic. ',1,NULL,NULL,NULL,NULL,NULL),(3,'2020-12-06 17:15:57',NULL,'Y','N','PROD00003','Palm jaggery is a much sweeter variant of jaggery, which has a melt-in the mouth texture. This form of jaggery is made by extracting sap of palm which is manually boiled and churned to make the jaggery. Palm jaggery is considered to be better than the sugar cane jaggery because of its high medicinal properties.  ','Palm Jaggery','It has been observed that regular consumption of Palm Jaggery positively impacts digestive health. Palm Jaggery as a sugar substitute helps with regular bowel movement and cleanses the system. Among many other ailments that palm jaggery helps relieve, cold and cough is the most common one.',1,NULL,NULL,NULL,NULL,NULL),(4,'2020-12-06 17:16:09',NULL,'Y','N','PROD00004','Palm Candy has a number of minerals, vitamins, calcium, iron and phyto nutrients including zinc and potassium. It is a good source of Vitamin B1, B2, B3, B6 and B12. The sugar content in palm sugar is well balanced and it is a great natural substitute for sugar. ','Palm Candy – Small','The rich iron content in palm candy helps in treating anaemia and improves metabolism. Palm candy with water quenches thirst. Palm candy with milk relieves urinary trouble, urinary tract infection and heat. It is good remedy for sore throat & ear pain when used with warm milk, pepper & turmeric powder.',1,NULL,NULL,NULL,NULL,NULL),(5,'2020-12-06 17:16:23',NULL,'Y','N','PROD00005','Palm Candy has a number of minerals, vitamins, calcium, iron and phyto nutrients including zinc and potassium. It is a good source of Vitamin B1, B2, B3, B6 and B12. The sugar content in palm sugar is well balanced and it is a great natural substitute for sugar. ','Palm Candy – Big','The rich iron content in palm candy helps in treating anaemia and improves metabolism. Palm candy with water quenches thirst. Palm candy with milk relieves urinary trouble, urinary tract infection and heat. It is good remedy for sore throat & ear pain when used with warm milk, pepper & turmeric powder.',1,NULL,NULL,NULL,NULL,NULL),(6,'2020-12-06 17:23:39',NULL,'Y','N','PROD00006','The ashwagandha also known as the Indian ginseng is ancient medicinal herb with multiple health benefits.','Ashwagandha Powder','The Ashwagandha powder has umpteen health benefits. When consumed two teaspoons every day, it boosts brain function, reduces anxiety and stress, helps fight depression and boosts fertility and testosterone in men.',2,NULL,NULL,NULL,NULL,NULL),(7,'2020-12-06 17:23:53',NULL,'Y','N','PROD00007','The kadukkai powder also known Harad is made by grinding freshly obtained haritaki into fine powder.','Kadukkai Powder','The kadukkai powder is rich in vitamin C and has antioxidant and anti-inflammatory properties. It is used to promote healing from conditions like sore throat, allergies, constipation and indigestion.',2,NULL,NULL,NULL,NULL,NULL),(8,'2020-12-06 17:24:09',NULL,'Y','N','PROD00008','The fully grown moringa leaves from the homegrown moringa trees are plucked, sundried and grinded to fine powder.The moringa powder has vital mineral and vitamins. This leaf is said to possess 7 times more Vitamin C than oranges and 15 times more potassium than bananas. It has calcium, protein, iron, and amino acids, which heals body and helps in muscle building. ','Moringa Powder','The moringa powder can be consumed by boiling it in water. It is used to alleviate headaches, ease constipation, stimulate the immune system, promote weight loss, and increase libido. ',2,NULL,NULL,NULL,NULL,NULL),(9,'2020-12-06 17:24:23',NULL,'Y','N','PROD00009','Arappu powder is made from the leaves of the arappu tree. When the leaves are fully grown, its plucked, sundried and made into fine powder. ','Arappu','Arappu powder serves as a natural conditioner for the hair while washing and is very good for hair growth. It reduces the heat of the body and softens the hair. Mixing shikakai powder will give more shining to your hair.',2,NULL,NULL,NULL,NULL,NULL),(10,'2020-12-06 17:24:35',NULL,'Y','N','PROD00010','When it comes to external application, Kasturi Manjal is the king as it does not stain the skin like the regular turmeric. In addition to this, Kasturi Manjal has a pleasant fragrance to it and antibacterial and anti-inflammation properties.  ','Kasturi Manjal (Wild Turmeric)','A paste of Kasturi Manjal is a one stop solution for most of the skin problems. It treats acne, scars and removes unwanted facial hair.  It also anti-septic properties and aids in having a bright and a healthy skin. ',2,NULL,NULL,NULL,NULL,NULL),(11,'2020-12-06 17:24:35',NULL,'Y','N','PROD00011','Kabasura Kudineer is an herbal concoction used for effectively managing common respiratory ailments such as the flu and cold. It has the properties to relieve symptoms associated with respiratory health including severe phlegm, dry and wet cough and fever.','Kabasura Kudineer','The Kabasura Kudineer possesses strong anti-inflammatory, analgesic, anti-viral, anti-bacterial, anti-fungal, antioxidant, hepato-protective, anti-pyretic, anti-asthmatic and immunomodulatory properties.',2,NULL,NULL,NULL,NULL,NULL),(12,'2020-12-06 17:24:35',NULL,'Y','N','PROD00012','Amirutham\'s herbal tea is a star product which possess high healing properties. It is a concoction of a wide variety of herbs that offers the best health benefits. ','Herbal Tea','The herbal tea stimulates brain function, boosts immunity, improves digestion and relieves symptoms related to cold and flu.',2,NULL,NULL,NULL,NULL,NULL),(13,'2020-12-06 17:24:35',NULL,'Y','N','PROD00013','Sukku coffee as it’s called is the one of the best home remedies used commonly in tamil households. Sukku is nothing but dry ginger that has a lot of medicinal properties. This coffee has no caffeine content in it. ','Sukku coffee','The sukku coffee eliminates toxins and helps absorb minerals from the intestines. It gives great relief to cough, throat ache, cold, nasal congestion and headache. Sukku coffee also helps to cure the indigestion and diarrhoea problems.',2,NULL,NULL,NULL,NULL,NULL),(14,'2020-12-06 17:24:35',NULL,'Y','N','PROD00014','Nalangu maavu or Ubtan is a herbal bath powder. The benefits it offers are immense, and it was everyone’s choice of a good cleanser before chemical soaps and gels came into the picture. ','Nalangu maavu – women','Nalangu Maavu absorbs excess oil from the skin without drying it. It helps to restore the natural pH balance of skin and slows down visible signs of aging. Regular usage of herbal bath powder can help people with acne or pimples, by reducing oil secretion and help reduce body odour and excessive sweating.',2,NULL,NULL,NULL,NULL,NULL),(15,'2020-12-06 17:24:35',NULL,'Y','N','PROD00015','Nalangu maavu or Ubtan is a herbal bath powder. The benefits it offers are immense, and it was everyone’s choice of a good cleanser before chemical soaps and gels came into the picture.','Nalangu maavu – men','Nalangu Maavu absorbs excess oil from the skin without drying it. It helps to restore the natural pH balance of skin and slows down visible signs of aging. Regular usage of herbal bath powder can help people with acne or pimples, by reducing oil secretion and help reduce body odour and excessive sweating.',2,NULL,NULL,NULL,NULL,NULL),(16,'2020-12-06 17:24:35',NULL,'Y','N','PROD00016','The herbal remedy of Shikakai powder for hair growth has been coming down through ages in India. ','Shikkakai powder','Shikakai is traditionally used as a hair cleanser in several parts of our country. Shikakai makes the hair soft and shiny. It heals the scalp and prevents dandruff, dry scalp, itchy scalp and hair lice. It also boosts hair growth and acts as a gently detangler.',2,NULL,NULL,NULL,NULL,NULL),(17,'2020-12-06 16:57:50',NULL,'Y','N','PROD00017','Turmeric powder is one of the main essential powders that is used in Indian cooking. It is composed of 100 compounds that contributes to its health benefits. Curcumin which gives it the bright yellow colour hue to it is the active compound that\'s credited with most of turmeric\'s health benefits. It has anti-inflammatory property and is a very strong antioxidant.','Turmeric Powder','In India, turmeric is considered as a healer\'s spice. A pinch of turmeric is added in 90% of Indian cuisines.',3,NULL,NULL,NULL,NULL,NULL),(18,'2020-12-06 16:57:50',NULL,'Y','N','PROD00018','Chili powder is a red-coloured blend of powdered spices. Its prominent ingredient is red chili and is generally used for seasoning the dishes. Amirutham’s chili powder is slightly spicier than the usual store-bought chili powder.','Chili Powder','Chili powder is an important spice powder in the Indian cuisine and is used is almost all the dishes. ',3,NULL,NULL,NULL,NULL,NULL),(19,'2020-12-06 16:57:50',NULL,'Y','N','PROD00019','Coriander powder popularly known as dhania powder in India, is made from grinding coriander with curry leaves. It is extensively used across various regional cuisines to flavour curries, stir fries, snacks.','Coriander Powder','Coriander powders is generally used in cooking as a flavouring agent. This, when consumed with water alleviates gas and aids digestion. It keeps a check on cholesterol, cures cold and flu and prevents menstrual irregularities.',3,NULL,NULL,NULL,NULL,NULL),(20,'2020-12-06 16:57:50',NULL,'Y','N','PROD00020','Pepper corns are usually used as a spice mix for seasoning in various cuisines across the globe. It is mainly added as an important spice in Indian cooking because of its medicinal properties.','Pepper Corns','Pepper corns can be used directly or in powder form, as seasoning agent in cooking.',3,NULL,NULL,NULL,NULL,NULL),(21,'2020-12-06 16:57:50',NULL,'Y','N','PROD00021','Tamarind also known as the “Indian date” is a sour and sweet fruit that is an integral part of the Indian cuisine and has many health benefits. Tamarind is a tree. Its partially dried fruit which is to add a sour flavour to the cuisines and to make medicine as well. ','Tamarind','Tamarind is used in Indian cuisine as a flavouring agent. Tamarind fruit in a partially dried form is used to make medicine. ',3,NULL,NULL,NULL,NULL,NULL),(22,'2020-12-06 16:57:50',NULL,'Y','N','PROD00022','The Himalayan crystal salt contains certain minerals like potassium, calcium and magnesium that makes it so precious. This is by far the purest salt available on earth and is absolutely uncontaminated with any toxins or pollutants.','Himalayan Pink Salts (Crystals)','Himalayan oink salt contains all of the 84 elements found in the body and thus has multiple benefits. ',3,NULL,NULL,NULL,NULL,NULL),(23,'2020-12-06 16:57:50',NULL,'Y','N','PROD00023','The Himalayan crystal salt contains certain minerals like potassium, calcium and magnesium that makes it so precious. This is by far the purest salt available on earth and is absolutely uncontaminated with any toxins or pollutants.','Himalayan Pink Salt (Powder)','Himalayan oink salt contains all of the 84 elements found in the body and thus has multiple benefits. ',3,NULL,NULL,NULL,NULL,NULL),(24,'2020-12-06 16:57:50',NULL,'Y','N','PROD00024','Idli podi or milagai podi is a coarse spice powder, originating from the Indian subcontinent, with a mixture of ground dry spices. The spice mix is commonly referred to in informal speech as \"gunpowder\" or chutney powder.','Idli Podi',NULL,3,NULL,NULL,NULL,NULL,NULL),(25,'2020-12-06 16:57:50',NULL,'Y','N','PROD00025','Paruppu podi is a must have homemade powder in many of our pantry especially in Tamil Nadu. It is a ready to mix powder that can be used with a generous spoon of ghee. and relish with a toasted papad.','Paruppu Podi',NULL,3,NULL,NULL,NULL,NULL,NULL),(26,'2020-12-06 16:57:50',NULL,'Y','N','PROD00026','Amirutham ghee is made from cow’s pure and fresh milk using the traditional hand churning methods. It is best for cooking contains healthy fat-soluble vitamins which aids in the absorption of nutrients in foods and are essential for maintaining a good health.','Ghee',NULL,3,NULL,NULL,NULL,NULL,NULL),(27,'2020-12-06 16:57:50',NULL,'Y','N','PROD00027','Amirutham honey is known for its purity. It is viscous and packed with lots of minerals and nutrients. This honey can be used for raw consumption, cooking and for skin and hair as well. ','Honey',NULL,3,NULL,NULL,NULL,NULL,NULL),(28,'2020-12-06 16:57:50',NULL,'Y','N','PROD00028','Groundnuts are most healthy when they are consumed in their raw form. Amirutham raw groundnuts are especially a good source of healthy fats, protein, and fibre. They contain plenty of potassium, phosphorous, magnesium, and B vitamins. Despite being high in calories, these raw groundnuts are nutrient-rich and low in carbohydrates.','Packed raw groundnuts',NULL,3,NULL,NULL,NULL,NULL,NULL),(29,'2020-12-06 17:31:00',NULL,'Y','N','PROD00029','For making the sesame oil, the cleaned sesame seeds and palm jaggery are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction.','Sesame Oil','The cold pressed sesame oil is high in antioxidants and has a strong anti-inflammatory property. Hence, it is good for the heart and oral health. It helps control blood sugar and is widely used in arthritis treatment. It is also used in hair for a dandruff free scalp. ',4,NULL,NULL,NULL,NULL,NULL),(30,'2020-12-06 17:31:13',NULL,'Y','N','PROD00030','For making the coconut oil, the cleaned coconut coprais are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction.','Coconut Oil','Cold pressed coconut oil is rich in antioxidants and fatty acids. It helps in controlling blood sugar and in reducing stress. The coconut oil also makes the hair shining and smooth and yeilds amzing skin benefits on external application.',4,NULL,NULL,NULL,NULL,NULL),(31,'2020-12-06 17:31:22',NULL,'Y','N','PROD00031','For making the groundnut oil, the cleaned raw groundnuts are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction.','Groundnut Oil','The cold pressed groundnut oil is majorly used for cooking purposes. It may also help improve insulin sensitivity and lower the blood sugar levels in people with diabetes. It is also a great source of vitamin E, a powerful antioxidant that protects the body from free radical damage.',4,NULL,NULL,NULL,NULL,NULL),(32,'2020-12-06 17:31:32',NULL,'Y','N','PROD00032','For making the mustard oil, the handpicked mustard seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction. ','Mustard Oil','The cold pressed mustard oil is a spicy oil. It is used to fight harmful bacteria in the body. It helps in decreasing inflammation and reducing fever by stimulating the sweat glands.',4,NULL,NULL,NULL,NULL,NULL),(33,'2020-12-06 17:31:41',NULL,'Y','N','PROD00033','For making the flax seed oil, the handpicked flax seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction. ','Flax seed Oil','Flax seeds are termed as the super food due to their health protective properties. The cold pressed flax seed oil is loaded with nutrients and omega-3 fatty acids. It aids weight loss and contributes to a glowing skin and a stronger and an even hair growth due to the presence of high-quality protein in it. ',4,NULL,NULL,NULL,NULL,NULL),(34,'2020-12-06 17:31:41',NULL,'Y','N','PROD00034','For making the chia seed oil, the handpicked chia seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Chia seed Oil','Cold pressed chia seed oil are an abundant source antioxidants and omega-3 fatty acids. It can stabilize the blood sugar levels and fortify the bones. The chia seed oil is also capable of banishing the belly fat and promoting a younger looking skin.',4,NULL,NULL,NULL,NULL,NULL),(35,'2020-12-06 17:31:41',NULL,'Y','N','PROD00035','For making the pumpkin seed oil, the handpicked pumpkin seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Pumpkin seed Oil','The cold pressed pumpkin seed oil is often promoted as a health supplement as it is capable of relieving menopausal symptoms, overactive bladder and reducing blood cholesterol levels. Regular consumption of pumpkin seed oil is said regenerate hair growth by 40% over a span of 24 weeks. ',4,NULL,NULL,NULL,NULL,NULL),(36,'2020-12-06 17:31:41',NULL,'Y','N','PROD00036','For making the pomegranate seed oil, the handpicked pomegranate seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Pomegranate seed Oil','The cold pressed pomegranate oil regenerates and repairs skin and effectively reduces and prevents wrinkles in the epidermis. It has antimicrobial properties. It is an effective anti-inflammatory agent. It has superior moisturizing ability and can nourish and soften the skin to a greater extent.',4,NULL,NULL,NULL,NULL,NULL),(37,'2020-12-06 17:31:41',NULL,'Y','N','PROD00037','For making the sabja seed oil, the handpicked sabja seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Sabja seed Oil','The cold pressed sabja seed oil or the basil seed oil is used in ayurveda for cosmetic applications. Apart from this, the sabja oil improves digestion, relieves cold and vomiting and treats asthma and itching. This oil is also capable to releieving bloodshot eye and improves blood circulation.',4,NULL,NULL,NULL,NULL,NULL),(38,'2020-12-06 17:31:41',NULL,'Y','N','PROD00038','For making the kalonji oil, the handpicked kalonji seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Kalonji Oil','Cold pressed kalonji oil is widely known for its medicinal properties. It is packed with antioxidants. It aids weight loss, relieves joint pains and headache, lowers cholesterol and alleviates inflammation. The kalonji oil is capable of fighting cancer and preventing stomach ulcers. ',4,NULL,NULL,NULL,NULL,NULL),(39,'2020-12-06 17:31:41',NULL,'Y','N','PROD00039','For making the grapeseed oil, the handpicked grape seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Grapeseed Oil','Cold pressed grapeseed oil is used as a natural beauty product. It is generally marketed as a healthy alternative to skin moisturizer. The grapeseed oil can be used to heal acne, lighten skin, tighten pores and reduce the appearance of scars.',4,NULL,NULL,NULL,NULL,NULL),(40,'2020-12-06 17:31:41',NULL,'Y','N','PROD00040','For making the almond oil, the handpicked almonds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Almond Oil','Cold pressed almond oil is high in anti-oxidants and offers a lot of benefits to skin and hair on external application. It aids weight loss when paired with a reduced-calorie diet and is highly beneficial for the control of blood sugar levels.',4,NULL,NULL,NULL,NULL,NULL),(41,'2020-12-06 17:31:41',NULL,'Y','N','PROD00041','For making the moringa seed oil, the handpicked moringa seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Moringa seed Oil','The cold pressed moringa oil is a rich source of nutrients and vitamins. It moisturises the dry skin and speeds up the healing of wounds. The moringa oil can treat stomach disorders and inflammatory conditions. It can also promote sleep by relaxing the muscles and contribute to a lot of hair and skin health. ',4,NULL,NULL,NULL,NULL,NULL),(42,'2020-12-06 17:31:41',NULL,'Y','N','PROD00042','The Amirutham Mosquito repellent oil is made from a combination of 9 types of natural oils which effectively repels mosquitoes.','Mosquito Repellent Oil','The Amirutham mosquito repellent oil is a repellent produced by using 9 types of natural oils. It contains antifungal properties that allows treatment of parasitic infections and promotes wound healing.',4,NULL,NULL,NULL,NULL,NULL),(43,'2020-12-06 17:31:41',NULL,'Y','N','PROD00043','Lighting lamps with the Amirutham Panchadeepam Oil is said to bring peace, fame, wealth and prosperity to the house. It is made from a list of 5 different products which are mixed at a certain proportion. ','Panchadeepam Oil','The Amirutham panchadeepam oil is prepared in the right composition to help eliminate difficulties and remove obstacles from one\'s life. The ingredients are said to bring positivity to the house while used regularly by lighting a lamp with it. ',4,NULL,NULL,NULL,NULL,NULL),(44,'2020-12-06 17:31:41',NULL,'Y','N','PROD00044','For making the mahua oil, the handpicked mahua seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Mahua Oil','The cold pressed mahua oil is an effective medication for a number of ailments. It benefits oral health, treats rheumatism, constipation and asthma. For nursing mothers, regular consumption of mahua oil helps in breast milk secretion. Apart from this, it also has more health and skin benefits. ',4,NULL,NULL,NULL,NULL,NULL),(45,'2020-12-06 17:31:41',NULL,'Y','N','PROD00045','For making the castor oil, the handpicked castor seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Castor Oil','Cold pressed castor oil is a powerful laxative and a natural moisturizer. It promotes wound healing and aids in fighting acne and fungus. It has impressive anti-Inflammatory effects and keeps hair and scalp healthy.',4,NULL,NULL,NULL,NULL,NULL),(46,'2020-12-06 17:31:41',NULL,'Y','N','PROD00046','For making the pongamia oil or punga oil, the handpicked punga seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Pongamia Oil / Punga Oil','The cold pressed pongamia oil or punga oil is an herbal medicine used in Ayurveda which is predominantly used in treating the skin diseases. It aids in detoxifying the vagina and to treat uterine disorders. The punga oil has the properties of relieving piles, bloating, flatulence and stomach ailments. Traditionally, it was even used to treat poisoning.',4,NULL,NULL,NULL,NULL,NULL),(47,'2020-12-06 17:31:41',NULL,'Y','N','PROD00047','For making the Amirutham hair oil, we include 32 types of herbs which are handpicked and then processed with pure cold pressed coconut oil. The prepared oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Hair Oil','The Amirutham hair oil improves the hair growth and offers a more shining, soft and a even hair. It naturally reduces the frizz and contributes in regeneration of the hair. The regular usage of the Amirutham hair oil can improve the overall health of your hair.',4,NULL,NULL,NULL,NULL,NULL),(48,'2020-12-06 17:31:41',NULL,'Y','N','PROD00048','For making the walnut oil, the handpicked walnut seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Walnut Oil','Cold pressed walnut oil is a rich source of antioxidants, omega-3 and Vitamins A and D. It is known as the brain food as it is great for boosting the brain health. The walnut oil can fight fungal infections, reduce signs of ageing and dark circles and is also used as a remedy for psoriasis. ',4,NULL,NULL,NULL,NULL,NULL),(49,'2020-12-06 17:31:41',NULL,'Y','N','PROD00049','For making the Amirutham beard oil, we include 34 types of herbs which are handpicked and then processed with pure cold pressed coconut oil. The prepared oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Beard Oil','The Amirutham beard oil is a conditioner used to moisturize and soften beard hair. It promotes a even beard growth and is also effective in moisturizing the skin beneath your beard.',4,NULL,NULL,NULL,NULL,NULL),(50,'2020-12-06 17:31:41',NULL,'Y','N','PROD00050','For making the neem oil, the handpicked neem seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.','Neem Oil','Cold pressed neem oil is high in fatty acids and other nutrients inspite of its harsh odour. On external application, it relieves joint pains and can be included in the beauty regimen. Neem oil treats dry skin and wrinkles, reduces scars, heals wounds, minimises warts and moles and treats lies and dandruff. ',4,NULL,NULL,NULL,NULL,NULL),(51,'2020-12-06 16:57:50',NULL,'Y','N','PROD00051','Kalonji seed, also known as the black cumin, belongs to the buttercup family of flowering plants. These seeds have long been used in herbal medicine to treat various diseases and conditions ranging from diabetes to arthritis and as a flavourful spice in many cuisines.','Kalonji seed','Kalonji seeds can be consumed directly or in powdered form. The proportions in which one consumes may vary as per the need. At times, it acts as a salad dressing. ',5,NULL,NULL,NULL,NULL,NULL),(52,'2020-12-06 16:57:50',NULL,'Y','N','PROD00052','Flax seeds, also known as linseeds, are small oil seeds that are usually brown or yellow.','Flax Seed','Recently flax seeds are popular as a diet food. One can consume it by adding to water and drinking it. It can also be used as a salad dressing or mixed with yogurt and consumed. ',5,NULL,NULL,NULL,NULL,NULL),(53,'2020-12-06 16:57:50',NULL,'Y','N','PROD00053','Chia is an edible seed that comes from the desert plant Salvia hispanica. Despite their small size, chia seeds are full of essential nutrients. They are an excellent source of omega-3 fatty acids, rich in antioxidants, and they provide fiber, iron, and calcium.','Chia seed','One way of consuming chia seeds is by soaking it in water for 15 mins and then eating it. Else can also be added whole or ground to smoothies and juices, mixed into yogurt and oatmeal, or sprinkled on top of a salad.',5,NULL,NULL,NULL,NULL,NULL),(54,'2020-12-06 16:57:50',NULL,'Y','N','PROD00054','Sabja seeds, known by various names such as tukmaria or basil seeds, are the black seeds that look like chia seeds. They are native to India but is slightly different from the seeds of the tulsi plant. ','Sabja seed','To use sabja seeds for weight loss, soak one to two teaspoons of the seeds in a cup full of warm water and consume them directly after fifteen minutes. You can also sprinkle these seeds in salads and soups or mix them with lemonade or green tea.',5,NULL,NULL,NULL,NULL,NULL),(55,'2020-12-06 16:57:50',NULL,'Y','N','PROD00055','Pumpkin seeds—also known as pepitas—are flat, dark green seeds. They have a malleable, chewy texture and a subtly sweet, nutty flavor. Pumpkin seeds are a good source of antioxidants, magnesium, zinc, and fatty acids — all of which may help keep your heart healthy','Pumpkin seed','Pumpkin seeds can be eaten raw but taste incredibly delicious roasted. To roast them, toss them in oil or melted butter, with salt, pepper, and any other seasonings you desire.',5,NULL,NULL,NULL,NULL,NULL),(56,'2020-12-06 16:57:50',NULL,'Y','N','PROD00056','Amaranth species are cultivated as leaf vegetables, pseudo-cereals, and ornamental plants.','Amaranth seed','Toast a tablespoon of amaranth seeds at a time in a hot, dry skillet. Continually shake or stir until the seeds pop. Eat them as a snack or use them to top soups, salads, and vegetable dishes.',5,NULL,NULL,NULL,NULL,NULL),(57,'2020-12-06 16:57:50',NULL,'Y','N','PROD00057','Sunflower seeds are the fruits of the sunflower known as kernels. They are famed for their high nutritional value and a distinct nutty taste that makes these a must-have addition to our diet.  These seeds contain a potent extract called Thiamin (Vitamin B1), which plays an essential role in managing energy production in the body.','Sunflower seed','Sunflower seeds can be eaten raw or in dry roasted form. This will improve nutritional value significantly. The seeds can be easily sprinkled over healthy salads to add that extra flavor and nutrients.',5,NULL,NULL,NULL,NULL,NULL),(58,'2020-12-06 16:57:50',NULL,'Y','N','PROD00058','Aloevera soaps are well-known for their moisturizing properties. It is made from freshly extracted aloe vera and cold-pressed oil. ','Aloevera Soap','Aloe soaps possess anti-allergic and anti-inflammatory properties. It helps to reduce rashes, acne, and soreness to a great extent. This soap also works well on fine lines and stretch marks and acts as an excellent skin revitalizer.',6,NULL,NULL,NULL,NULL,NULL),(59,'2020-12-06 16:57:50',NULL,'Y','N','PROD00059','Kalonji soaps are made from cold-pressed kalonji oil and coconut oil. It has a potent skin brightening property. And it restores and controls essential moisture while cleansing your skin.','Kalonji Soap','The Amirutham Kalonji soap fades out pigmentations and blemishes caused by sunlight. It brightens and lightens the skin tone and cleanses impure skin pores. ',6,NULL,NULL,NULL,NULL,NULL),(60,'2020-12-06 16:57:50',NULL,'Y','N','PROD00060','The Pongamia soap is one of our exclusive soaps which is prepared using cold-pressed Pongamia oil and coconut oil. ','Pongamia Soap','The Amirutham Pongamia soaps are antiseptic and anti-bacterial. They have strong tendencies of healing any skin ailments. The Pongamia soaps brighten your skin and make it healthy. ',6,NULL,NULL,NULL,NULL,NULL),(61,'2020-12-06 16:57:50',NULL,'Y','N','PROD00061','Wild Tumeric, also known as kasturi manjal is the best for acne-prone skin with its anti-bacterial values. The wild turmeric soaps are made using wild turmeric powder and cold-pressed coconut oil.','Wild Turmeric Soap ','The wild turmeric soap bar makes the skin healthy. On continued usage, it fades dark spots, blemishes, acne and improves the skin complexion. It provides soft and glowing skin.',6,NULL,NULL,NULL,NULL,NULL),(62,'2020-12-06 16:57:50',NULL,'Y','N','PROD00062','Bamboo Charcoal Soap is made from powdered bamboo charcoal and cold-pressed coconut oil. It cleanses the skin by absorbing the dirt, grime, and pollutants that invade our pores every day. ','Bamboo Charcoal Soap','It helps in purifying and cleansing the skin of dirt by drawing impurities from deep within pores. It is used as both a facial and body cleanser. ',6,NULL,NULL,NULL,NULL,NULL),(63,'2020-12-06 16:57:50',NULL,'Y','N','PROD00063','Sandal Soap has sandalwood as its main ingredient along with cold-pressed coconut oil. It has excellent antiseptic properties, and soothes prickly heats and other skin rashes.','Sandal Soap ','Sandal soaps treats acne, dry skin and calms skin inflammation. It imparts a glow and brightens dull and ageing skin. It removes tanning, cures skin itching and detoxifies the skin. ',6,NULL,NULL,NULL,NULL,NULL),(64,'2020-12-06 16:57:50',NULL,'Y','N','PROD00064','Rakta Chandana or the red sandalwood is one of the finest ingredients for your skin. This is the key ingredient of the red sandal soaps. These soaps control the oil secretion in the skin due to its absorbing property.','Red Sandal Soap ','The benefits of red sandal soap include removing dead cells from the skin, thereby making the skin look fresh. It has the absorbing property, which controls excess oil secretion from the face and makes it less oily. It is useful in the treatment of skin irritations, and treatment of pimples, and removing scar marks.',6,NULL,NULL,NULL,NULL,NULL),(65,'2020-12-06 16:57:50',NULL,'Y','N','PROD00065','The Amirutham mulatni mitti soap is enriched with the goodness of pure and fresh multani mitti and cold-pressed coconut oil.','Multani Mitti Soap','Multani Mitti soaps deeply moisturizes the skin and remove sun tans and skin irritations. It is useful in treating blemishes and dark spots on the skin.',6,NULL,NULL,NULL,NULL,NULL),(66,'2020-12-06 16:57:50',NULL,'Y','N','PROD00066','Having made from cold press almond oil and cold-pressed coconut oil, Amirutham’s almond soap bar guarantees to offer you a luxury bath.','Almond Soap','Almond soap bar brightens the skin. Due to vitamin A & E\'s presence, it protects the skin from sun damage and aids in removing suntan. Due to almonds\' anti-aging properties, the soap bars allow skin regeneration naturally and impart a glow to the skin. ',6,NULL,NULL,NULL,NULL,NULL),(67,'2020-12-06 16:57:50',NULL,'Y','N','PROD00067','Coconut oil soap bar is highly cleansing and conditioning to the skin. It is made of cold-pressed coconut oil and has a mild fragrance to it.  ','Coconut Soap','Coconut oil soap is an excellent moisturizer for the skin. This soap bar helps in removing dead skin cells and prevents or reduces acne. It works on the fine lines on the face and provides a younger and a firm skin due to its antioxidant property. ',6,NULL,NULL,NULL,NULL,NULL),(68,'2020-12-06 16:57:50',NULL,'Y','N','PROD00068','Tulasi Soap is made from pure, homegrown tulasi leaves and cold-pressed coconut oil. It has the properties of curing any skin allergy leaving the skin healthy, soft, and protected naturally.','Tulasi Soap','Tulasi soap bar is anti-bacterial, antiseptic, and antiviral. Owing to its properties, tulasi can cure a variety of skin problems and improve the skin\'s health, leaving it healthy, soft and supple.',6,NULL,NULL,NULL,NULL,NULL),(69,'2020-12-06 16:57:50',NULL,'Y','N','PROD00069','Herbal soaps are made using natural herbs and cold-pressed oil. It has tulasi, neem, Indian copperleaf, hibiscus, and curry leaves. ','Herbal Soap','Herbal soaps are beneficial for the skin and are very good at soothing the inflammations on the skin. In the long run, they tend to improve the skin\'s overall health but protect it against natural damage.',6,NULL,NULL,NULL,NULL,NULL),(70,'2020-12-06 16:57:50',NULL,'Y','N','PROD00070','Neem is one of the most widely used skin care products in India. Rich in essential fatty acids and antioxidants, Amirtuham’s neem soap bars are hydrating, balancing, soothing and purifying for the skin. ','Neem Soap','Neem Soap is anti-bacterial that protects the skin from bacteria or any allergens. Its antiseptic properties give protection to the skin against infections making the skin healthier. ',6,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_location`
--

DROP TABLE IF EXISTS `user_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `user_location` (
  `id` bigint NOT NULL,
  `country` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5uab2358cxflwk5lkt9255twu` (`user_id`),
  CONSTRAINT `FK5uab2358cxflwk5lkt9255twu` FOREIGN KEY (`user_id`) REFERENCES `amir_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_location`
--

LOCK TABLES `user_location` WRITE;
/*!40000 ALTER TABLE `user_location` DISABLE KEYS */;
INSERT INTO `user_location` VALUES (25,'India',_binary '',24),(28,'India',_binary '',27),(39,'India',_binary '',36),(44,'India',_binary '',41);
/*!40000 ALTER TABLE `user_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK46wdarhhkt7h25466c7n61h2r` (`role_id`),
  CONSTRAINT `FK46wdarhhkt7h25466c7n61h2r` FOREIGN KEY (`role_id`) REFERENCES `amir_user_role` (`id`),
  CONSTRAINT `FKq98yjmbyg8232bh3yn56tt37` FOREIGN KEY (`user_id`) REFERENCES `amir_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (24,4),(27,4),(36,4),(41,4);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification_token`
--

DROP TABLE IF EXISTS `verification_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `verification_token` (
  `id` bigint NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8  DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_VERIFY_USER` (`user_id`),
  CONSTRAINT `FK_VERIFY_USER` FOREIGN KEY (`user_id`) REFERENCES `amir_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification_token`
--

LOCK TABLES `verification_token` WRITE;
/*!40000 ALTER TABLE `verification_token` DISABLE KEYS */;
INSERT INTO `verification_token` VALUES (26,'2020-12-08 16:48:12','85c6fd6a-9d92-4478-a6fd-4ab96cbf8b73',24),(29,'2020-12-08 18:11:08','0f9c5b9d-7b56-4e00-ad1a-13fb69fbea35',27),(40,'2020-12-10 16:54:31','964216f1-c22c-434c-a9b3-e27985476d01',36),(45,'2020-12-11 10:59:46','a2ae3a1f-09e2-4116-b7d3-964f3ba9c62b',41);
/*!40000 ALTER TABLE `verification_token` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-12 10:59:03
