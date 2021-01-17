CREATE DATABASE  IF NOT EXISTS `amirutham` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
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
-- Table structure for table `addon_chatges`
--

DROP TABLE IF EXISTS `addon_chatges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addon_chatges` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `chargeamount` decimal(19,2) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `discount_percent` int NOT NULL,
  `discounted` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addon_chatges`
--

LOCK TABLES `addon_chatges` WRITE;
/*!40000 ALTER TABLE `addon_chatges` DISABLE KEYS */;
INSERT INTO `addon_chatges` VALUES (1,'Amirthum','2021-01-17 17:43:50','Y','N',NULL,NULL,40.00,'ShipmentCharges',0,_binary '\0'),(2,'Amirthum','2021-01-17 17:43:57','Y','N',NULL,NULL,40.00,'ShipmentCharges',0,_binary '\0'),(3,'Amirthum','2021-01-17 17:44:06','Y','N',NULL,NULL,40.00,'ShipmentCharges',0,_binary '\0'),(4,'Amirthum','2021-01-17 17:44:08','Y','N',NULL,NULL,40.00,'ShipmentCharges',0,_binary '\0');
/*!40000 ALTER TABLE `addon_chatges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int NOT NULL,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `address_line1` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `address_line2` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `address_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `postal_copde` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKda8tuywtf0gb6sedwk7la1pgi` (`user_id`),
  CONSTRAINT `FKda8tuywtf0gb6sedwk7la1pgi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (4,'Amirthum','2021-01-17 17:44:21','Y','N',NULL,NULL,'t6 b block','lakshmi appartment','Shipment','chennai','626001','Tamil Nadu',1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amir_prod_category`
--

DROP TABLE IF EXISTS `amir_prod_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amir_prod_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `cate_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `cate_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `cate_nme` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `cate_order` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7aes4b17r6osqjxtmqlns7o7d` (`cate_code`),
  UNIQUE KEY `UK_xtlmv7grqbtvyohd2996k8h` (`cate_order`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amir_prod_category`
--

LOCK TABLES `amir_prod_category` WRITE;
/*!40000 ALTER TABLE `amir_prod_category` DISABLE KEYS */;
INSERT INTO `amir_prod_category` VALUES (1,'Amirthum','2021-01-17 05:57:56','Y','N',NULL,NULL,'CATE00001','Amirutham Organic Oils','Oils',1),(2,'Amirthum','2021-01-17 06:03:12','Y','N',NULL,NULL,'CATE00002','Amirutham Natural Sweeteners','Natural Sweeteners',2);
/*!40000 ALTER TABLE `amir_prod_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `final_price_with_addons` decimal(19,2) NOT NULL,
  `final_price_without_addons` decimal(19,2) NOT NULL,
  `order_id` int DEFAULT NULL,
  `shp_cart_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `shp_cart_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `charge_cart_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fc9j09vyj5y8aojno8757vyco` (`shp_cart_code`),
  KEY `FKbg0kofx2b9njx9w4an35w69n8` (`charge_cart_id`),
  CONSTRAINT `FKbg0kofx2b9njx9w4an35w69n8` FOREIGN KEY (`charge_cart_id`) REFERENCES `addon_chatges` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,'Amirthum','2021-01-17 17:43:50','Y','N',NULL,NULL,1,40.00,0.00,NULL,'CART00001','Converted',1),(2,'Amirthum','2021-01-17 17:43:57','Y','N',NULL,NULL,1,40.00,0.00,NULL,'CART00002','Pending',2),(3,'Amirthum','2021-01-17 17:44:06','Y','N',NULL,NULL,1,216.00,176.00,NULL,'CART00003','Pending',3),(4,'Amirthum','2021-01-17 17:44:08','Y','N',NULL,NULL,1,40.00,0.00,NULL,'CART00004','Pending',4);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartitem`
--

DROP TABLE IF EXISTS `cartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartitem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `item_imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `cart_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `item_price` decimal(19,2) DEFAULT NULL,
  `product_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `item_seller` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sub_total` decimal(19,2) DEFAULT NULL,
  `product_varient_id` int NOT NULL,
  `cart_item_id` int DEFAULT NULL,
  `cartid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcw9wv9cf13gdhtakeu986hliw` (`cart_item_id`),
  KEY `FKtc9npvycs1rruynyqdhyrybqw` (`cartid`),
  CONSTRAINT `FKcw9wv9cf13gdhtakeu986hliw` FOREIGN KEY (`cart_item_id`) REFERENCES `cartitemattribute` (`id`),
  CONSTRAINT `FKtc9npvycs1rruynyqdhyrybqw` FOREIGN KEY (`cartid`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartitem`
--

LOCK TABLES `cartitem` WRITE;
/*!40000 ALTER TABLE `cartitem` DISABLE KEYS */;
INSERT INTO `cartitem` VALUES (1,'Amirthum','2021-01-17 17:44:06','Y','N',NULL,NULL,'http://localhost:8085/products/downloadFile/PROD00005_0.jpeg/CATE00002','CART00003','Palm Candy – Big',176.00,'PROD00005',5,1,'Amirum & Oil .co',176.00,7,1,3);
/*!40000 ALTER TABLE `cartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartitemattribute`
--

DROP TABLE IF EXISTS `cartitemattribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartitemattribute` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `prod_useby_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_discount_rate` int DEFAULT NULL,
  `prod_manufacture_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_mrp_price` double DEFAULT NULL,
  `prod_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_saved_price` double DEFAULT NULL,
  `prod_selling_price` double DEFAULT NULL,
  `prod_in_unit` int DEFAULT NULL,
  `prod_unit_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartitemattribute`
--

LOCK TABLES `cartitemattribute` WRITE;
/*!40000 ALTER TABLE `cartitemattribute` DISABLE KEYS */;
INSERT INTO `cartitemattribute` VALUES (1,'Amirthum','2021-01-17 17:44:06','Y','N',NULL,NULL,'2021-03-31T10:37:58.765Z',5,'2021-01-01T10:37:55.151Z',185,'PROD00005',9,176,250,'g');
/*!40000 ALTER TABLE `cartitemattribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_banner`
--

DROP TABLE IF EXISTS `category_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_banner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `banner_file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `banner_filepth` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `banner_file_size` bigint DEFAULT NULL,
  `banner_file_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `banner_file_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqqwybutmstq6hj7129rmfy19m` (`category_id`),
  CONSTRAINT `FKqqwybutmstq6hj7129rmfy19m` FOREIGN KEY (`category_id`) REFERENCES `amir_prod_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_banner`
--

LOCK TABLES `category_banner` WRITE;
/*!40000 ALTER TABLE `category_banner` DISABLE KEYS */;
INSERT INTO `category_banner` VALUES (1,'Amirthum','2021-01-17 05:57:57','Y','N',NULL,NULL,'CATE00001_0.jpg','C:\\Amirthum\\Banner\\category\\CATE00001\\CATE00001_0.jpg',69940,'image/jpeg','http://localhost:8085/category/downloadFile/CATE00001_0.jpg/CATE00001',1),(2,'Amirthum','2021-01-17 05:57:57','Y','N',NULL,NULL,'CATE00001_1.jpg','C:\\Amirthum\\Banner\\category\\CATE00001\\CATE00001_1.jpg',434912,'image/jpeg','http://localhost:8085/category/downloadFile/CATE00001_1.jpg/CATE00001',1),(3,'Amirthum','2021-01-17 05:57:57','Y','N',NULL,NULL,'CATE00001_2.jpg','C:\\Amirthum\\Banner\\category\\CATE00001\\CATE00001_2.jpg',14674,'image/jpeg','http://localhost:8085/category/downloadFile/CATE00001_2.jpg/CATE00001',1),(4,'Amirthum','2021-01-17 05:57:57','Y','N',NULL,NULL,'CATE00001_3.jpg','C:\\Amirthum\\Banner\\category\\CATE00001\\CATE00001_3.jpg',69940,'image/jpeg','http://localhost:8085/category/downloadFile/CATE00001_3.jpg/CATE00001',1),(5,'Amirthum','2021-01-17 06:03:13','Y','N',NULL,NULL,'CATE00002_0.jpg','C:\\Amirthum\\Banner\\category\\CATE00002\\CATE00002_0.jpg',483085,'image/jpeg','http://localhost:8085/category/downloadFile/CATE00002_0.jpg/CATE00002',2),(6,'Amirthum','2021-01-17 06:03:13','Y','N',NULL,NULL,'CATE00002_1.png','C:\\Amirthum\\Banner\\category\\CATE00002\\CATE00002_1.png',2065190,'image/png','http://localhost:8085/category/downloadFile/CATE00002_1.png/CATE00002',2),(7,'Amirthum','2021-01-17 06:03:13','Y','N',NULL,NULL,'CATE00002_2.jpg','C:\\Amirthum\\Banner\\category\\CATE00002\\CATE00002_2.jpg',206392,'image/jpeg','http://localhost:8085/category/downloadFile/CATE00002_2.jpg/CATE00002',2),(8,'Amirthum','2021-01-17 06:03:13','Y','N',NULL,NULL,'CATE00002_3.jpg','C:\\Amirthum\\Banner\\category\\CATE00002\\CATE00002_3.jpg',128077,'image/jpeg','http://localhost:8085/category/downloadFile/CATE00002_3.jpg/CATE00002',2);
/*!40000 ALTER TABLE `category_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `company_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `company_country` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `company_email` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `company_logo` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `company_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `company_city` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `company_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `company_postal_code` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i2jcjcejgnwuafxofwmgosd13` (`company_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (5);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homebanner`
--

DROP TABLE IF EXISTS `homebanner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `homebanner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `banner_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `banner_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `banner_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `home_facebook_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `home_insta_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `home_whatsapp_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `home_youtube_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homebanner`
--

LOCK TABLES `homebanner` WRITE;
/*!40000 ALTER TABLE `homebanner` DISABLE KEYS */;
INSERT INTO `homebanner` VALUES (1,'Amirthum','2021-01-17 05:24:55','Y','N',NULL,NULL,'BANNER00001','Amiruthum Store is an all natural skincare and cosmetics brand which makes skincare Goodies with freshest ingredients.','Amiruthum Product','https://www.facebook.com/amiruthumstore/','https://www.instagram.com/amiruthum_/','https://www.whatsapp.com/amiruthum_/','https://www.youtube.com/amiruthum_/');
/*!40000 ALTER TABLE `homebanner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homebannermedia`
--

DROP TABLE IF EXISTS `homebannermedia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `homebannermedia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `banner_file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `banner_filepth` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `banner_file_size` bigint DEFAULT NULL,
  `banner_file_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `banner_file_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `home_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkqihrpf9nwma1fy5jvk7qtd2o` (`home_id`),
  CONSTRAINT `FKkqihrpf9nwma1fy5jvk7qtd2o` FOREIGN KEY (`home_id`) REFERENCES `homebanner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homebannermedia`
--

LOCK TABLES `homebannermedia` WRITE;
/*!40000 ALTER TABLE `homebannermedia` DISABLE KEYS */;
INSERT INTO `homebannermedia` VALUES (1,'Amirthum','2021-01-17 05:24:55','Y','N',NULL,NULL,'BANNER00001_0.jpg','C:\\Amirthum\\Banner\\BANNER00001\\BANNER00001_0.jpg',32703,'image/jpeg','http://localhost:8085/banner/downloadFile/BANNER00001_0.jpg/BANNER00001',1),(2,'Amirthum','2021-01-17 05:24:55','Y','N',NULL,NULL,'BANNER00001_1.png','C:\\Amirthum\\Banner\\BANNER00001\\BANNER00001_1.png',525037,'image/png','http://localhost:8085/banner/downloadFile/BANNER00001_1.png/BANNER00001',1),(3,'Amirthum','2021-01-17 05:24:55','Y','N',NULL,NULL,'BANNER00001_2.jpg','C:\\Amirthum\\Banner\\BANNER00001\\BANNER00001_2.jpg',11967,'image/jpeg','http://localhost:8085/banner/downloadFile/BANNER00001_2.jpg/BANNER00001',1),(4,'Amirthum','2021-01-17 05:24:55','Y','N',NULL,NULL,'BANNER00001_3.png','C:\\Amirthum\\Banner\\BANNER00001\\BANNER00001_3.png',81392,'image/png','http://localhost:8085/banner/downloadFile/BANNER00001_3.png/BANNER00001',1);
/*!40000 ALTER TABLE `homebannermedia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderlineitems`
--

DROP TABLE IF EXISTS `orderlineitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderlineitems` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `order_quantity` int DEFAULT NULL,
  `order_product_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `order_product_id` int NOT NULL,
  `order_product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `order_product_imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `product_price` decimal(19,2) NOT NULL,
  `product_seller` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `product_sub_total` decimal(19,2) NOT NULL,
  `order_item_id` int DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8emtlsd0ty1pv9yrb1gxrfji1` (`order_item_id`),
  KEY `FK9cv7vdre1rg2vc5lchj75m8uh` (`order_id`),
  CONSTRAINT `FK8emtlsd0ty1pv9yrb1gxrfji1` FOREIGN KEY (`order_item_id`) REFERENCES `orderproductattribute` (`id`),
  CONSTRAINT `FK9cv7vdre1rg2vc5lchj75m8uh` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderlineitems`
--

LOCK TABLES `orderlineitems` WRITE;
/*!40000 ALTER TABLE `orderlineitems` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderlineitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderproductattribute`
--

DROP TABLE IF EXISTS `orderproductattribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderproductattribute` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prod_useby_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_discount_rate` int DEFAULT NULL,
  `prod_manufacture_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_mrp_price` double DEFAULT NULL,
  `prod_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_saved_price` double DEFAULT NULL,
  `prod_selling_price` double DEFAULT NULL,
  `prod_in_unit` int DEFAULT NULL,
  `prod_unit_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderproductattribute`
--

LOCK TABLES `orderproductattribute` WRITE;
/*!40000 ALTER TABLE `orderproductattribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderproductattribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `channel` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `date_purchased` date DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `order_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `order_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `order_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `payment_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `order_receiver_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `order_receiver_phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `cart_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `order_total` decimal(19,2) DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf5464gxwc32ongdvka2rtvw96` (`address_id`),
  KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`),
  CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKf5464gxwc32ongdvka2rtvw96` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'Amirthum','2021-01-17 17:44:22','Y','N',NULL,NULL,'OFFLINE','2021-01-17','2021-01-17 17:44:21','AMIR_OD00001','ORDERED','ORDER','COD','sankar narayanan','9791255264','CART00001',40.00,4,1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_token`
--

DROP TABLE IF EXISTS `password_reset_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_reset_token` (
  `id` bigint NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `one_time_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5lwtbncug84d4ero33v3cfxvl` (`user_id`),
  CONSTRAINT `FK5lwtbncug84d4ero33v3cfxvl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_token`
--

LOCK TABLES `password_reset_token` WRITE;
/*!40000 ALTER TABLE `password_reset_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_reset_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_media_gallary`
--

DROP TABLE IF EXISTS `product_media_gallary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_media_gallary` (
  `prod_med_id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `prod_med_nm` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_med_file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_med_size` bigint DEFAULT NULL,
  `prod_med_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_med_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `med_prod_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_id` int DEFAULT NULL,
  PRIMARY KEY (`prod_med_id`),
  KEY `FK9c8hj2678cwtafn999h1xamys` (`prod_id`),
  CONSTRAINT `FK9c8hj2678cwtafn999h1xamys` FOREIGN KEY (`prod_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_media_gallary`
--

LOCK TABLES `product_media_gallary` WRITE;
/*!40000 ALTER TABLE `product_media_gallary` DISABLE KEYS */;
INSERT INTO `product_media_gallary` VALUES (1,'Amirthum','2021-01-17 09:54:11','Y','N',NULL,NULL,'PROD00001_0.jpeg','C:\\Amirthum\\CATE00002\\PROD00001_0.jpeg',17492,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00001_0.jpeg/CATE00002',NULL,1),(2,'Amirthum','2021-01-17 09:54:11','Y','N',NULL,NULL,'PROD00001_1.jpeg','C:\\Amirthum\\CATE00002\\PROD00001_1.jpeg',23448,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00001_1.jpeg/CATE00002',NULL,1),(3,'Amirthum','2021-01-17 09:54:11','Y','N',NULL,NULL,'PROD00001_2.jpeg','C:\\Amirthum\\CATE00002\\PROD00001_2.jpeg',39891,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00001_2.jpeg/CATE00002',NULL,1),(4,'Amirthum','2021-01-17 09:59:04','Y','N',NULL,NULL,'PROD00002_0.jpeg','C:\\Amirthum\\CATE00002\\PROD00002_0.jpeg',14411,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00002_0.jpeg/CATE00002',NULL,2),(5,'Amirthum','2021-01-17 09:59:04','Y','N',NULL,NULL,'PROD00002_1.jpeg','C:\\Amirthum\\CATE00002\\PROD00002_1.jpeg',11282,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00002_1.jpeg/CATE00002',NULL,2),(6,'Amirthum','2021-01-17 09:59:04','Y','N',NULL,NULL,'PROD00002_2.jpeg','C:\\Amirthum\\CATE00002\\PROD00002_2.jpeg',13162,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00002_2.jpeg/CATE00002',NULL,2),(7,'Amirthum','2021-01-17 09:59:04','Y','N',NULL,NULL,'PROD00002_3.jpeg','C:\\Amirthum\\CATE00002\\PROD00002_3.jpeg',42311,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00002_3.jpeg/CATE00002',NULL,2),(8,'Amirthum','2021-01-17 10:00:47','Y','N',NULL,NULL,'PROD00003_0.jpeg','C:\\Amirthum\\CATE00002\\PROD00003_0.jpeg',21681,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00003_0.jpeg/CATE00002',NULL,3),(9,'Amirthum','2021-01-17 10:00:47','Y','N',NULL,NULL,'PROD00003_1.jpeg','C:\\Amirthum\\CATE00002\\PROD00003_1.jpeg',40006,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00003_1.jpeg/CATE00002',NULL,3),(10,'Amirthum','2021-01-17 10:00:47','Y','N',NULL,NULL,'PROD00003_2.jpeg','C:\\Amirthum\\CATE00002\\PROD00003_2.jpeg',25099,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00003_2.jpeg/CATE00002',NULL,3),(11,'Amirthum','2021-01-17 10:00:47','Y','N',NULL,NULL,'PROD00003_3.jpeg','C:\\Amirthum\\CATE00002\\PROD00003_3.jpeg',29585,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00003_3.jpeg/CATE00002',NULL,3),(12,'Amirthum','2021-01-17 10:02:51','Y','N',NULL,NULL,'PROD00004_0.jpeg','C:\\Amirthum\\CATE00002\\PROD00004_0.jpeg',19874,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00004_0.jpeg/CATE00002',NULL,4),(13,'Amirthum','2021-01-17 10:02:51','Y','N',NULL,NULL,'PROD00004_1.jpeg','C:\\Amirthum\\CATE00002\\PROD00004_1.jpeg',23119,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00004_1.jpeg/CATE00002',NULL,4),(14,'Amirthum','2021-01-17 10:02:51','Y','N',NULL,NULL,'PROD00004_2.jpeg','C:\\Amirthum\\CATE00002\\PROD00004_2.jpeg',26680,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00004_2.jpeg/CATE00002',NULL,4),(15,'Amirthum','2021-01-17 10:02:51','Y','N',NULL,NULL,'PROD00004_3.jpeg','C:\\Amirthum\\CATE00002\\PROD00004_3.jpeg',23183,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00004_3.jpeg/CATE00002',NULL,4),(16,'Amirthum','2021-01-17 10:04:48','Y','N',NULL,NULL,'PROD00005_0.jpeg','C:\\Amirthum\\CATE00002\\PROD00005_0.jpeg',21511,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00005_0.jpeg/CATE00002',NULL,5),(17,'Amirthum','2021-01-17 10:04:48','Y','N',NULL,NULL,'PROD00005_1.jpeg','C:\\Amirthum\\CATE00002\\PROD00005_1.jpeg',16655,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00005_1.jpeg/CATE00002',NULL,5),(18,'Amirthum','2021-01-17 10:04:48','Y','N',NULL,NULL,'PROD00005_2.jpeg','C:\\Amirthum\\CATE00002\\PROD00005_2.jpeg',24835,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00005_2.jpeg/CATE00002',NULL,5),(19,'Amirthum','2021-01-17 10:04:48','Y','N',NULL,NULL,'PROD00005_3.jpeg','C:\\Amirthum\\CATE00002\\PROD00005_3.jpeg',13064,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00005_3.jpeg/CATE00002',NULL,5),(20,'Amirthum','2021-01-17 11:31:50','Y','N',NULL,NULL,'PROD00006_0.jpeg','C:\\Amirthum\\CATE00001\\PROD00006_0.jpeg',11398,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00006_0.jpeg/CATE00001',NULL,6),(21,'Amirthum','2021-01-17 11:31:50','Y','N',NULL,NULL,'PROD00006_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00006_1.jpeg',9358,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00006_1.jpeg/CATE00001',NULL,6),(22,'Amirthum','2021-01-17 11:31:50','Y','N',NULL,NULL,'PROD00006_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00006_2.jpeg',26695,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00006_2.jpeg/CATE00001',NULL,6),(23,'Amirthum','2021-01-17 11:31:50','Y','N',NULL,NULL,'PROD00006_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00006_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00006_3.jpeg/CATE00001',NULL,6),(24,'Amirthum','2021-01-17 11:40:43','Y','N',NULL,NULL,'PROD00007_0.jpg','C:\\Amirthum\\CATE00001\\PROD00007_0.jpg',2425268,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00007_0.jpg/CATE00001',NULL,7),(25,'Amirthum','2021-01-17 11:40:43','Y','N',NULL,NULL,'PROD00007_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00007_1.jpeg',22726,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00007_1.jpeg/CATE00001',NULL,7),(26,'Amirthum','2021-01-17 11:40:43','Y','N',NULL,NULL,'PROD00007_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00007_2.jpeg',19212,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00007_2.jpeg/CATE00001',NULL,7),(27,'Amirthum','2021-01-17 11:40:43','Y','N',NULL,NULL,'PROD00007_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00007_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00007_3.jpeg/CATE00001',NULL,7),(28,'Amirthum','2021-01-17 11:49:43','Y','N',NULL,NULL,'PROD00008_0.jpg','C:\\Amirthum\\CATE00001\\PROD00008_0.jpg',2530895,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00008_0.jpg/CATE00001',NULL,8),(29,'Amirthum','2021-01-17 11:49:43','Y','N',NULL,NULL,'PROD00008_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00008_1.jpeg',22886,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00008_1.jpeg/CATE00001',NULL,8),(30,'Amirthum','2021-01-17 11:49:43','Y','N',NULL,NULL,'PROD00008_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00008_2.jpeg',21842,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00008_2.jpeg/CATE00001',NULL,8),(31,'Amirthum','2021-01-17 11:49:43','Y','N',NULL,NULL,'PROD00008_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00008_3.jpeg',15387,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00008_3.jpeg/CATE00001',NULL,8),(32,'Amirthum','2021-01-17 11:53:47','Y','N',NULL,NULL,'PROD00009_0.jpg','C:\\Amirthum\\CATE00001\\PROD00009_0.jpg',2601522,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00009_0.jpg/CATE00001',NULL,9),(33,'Amirthum','2021-01-17 11:53:47','Y','N',NULL,NULL,'PROD00009_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00009_1.jpeg',27248,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00009_1.jpeg/CATE00001',NULL,9),(34,'Amirthum','2021-01-17 11:53:47','Y','N',NULL,NULL,'PROD00009_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00009_2.jpeg',16586,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00009_2.jpeg/CATE00001',NULL,9),(35,'Amirthum','2021-01-17 11:53:47','Y','N',NULL,NULL,'PROD00009_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00009_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00009_3.jpeg/CATE00001',NULL,9),(36,'Amirthum','2021-01-17 12:03:04','Y','N',NULL,NULL,'PROD00010_0.jpg','C:\\Amirthum\\CATE00001\\PROD00010_0.jpg',3042335,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00010_0.jpg/CATE00001',NULL,10),(37,'Amirthum','2021-01-17 12:03:04','Y','N',NULL,NULL,'PROD00010_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00010_1.jpeg',25774,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00010_1.jpeg/CATE00001',NULL,10),(38,'Amirthum','2021-01-17 12:03:04','Y','N',NULL,NULL,'PROD00010_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00010_2.jpeg',48195,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00010_2.jpeg/CATE00001',NULL,10),(39,'Amirthum','2021-01-17 12:03:04','Y','N',NULL,NULL,'PROD00010_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00010_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00010_3.jpeg/CATE00001',NULL,10),(40,'Amirthum','2021-01-17 12:06:09','Y','N',NULL,NULL,'PROD00011_0.jpg','C:\\Amirthum\\CATE00001\\PROD00011_0.jpg',2002198,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00011_0.jpg/CATE00001',NULL,11),(41,'Amirthum','2021-01-17 12:06:09','Y','N',NULL,NULL,'PROD00011_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00011_1.jpeg',30545,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00011_1.jpeg/CATE00001',NULL,11),(42,'Amirthum','2021-01-17 12:06:09','Y','N',NULL,NULL,'PROD00011_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00011_2.jpeg',22962,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00011_2.jpeg/CATE00001',NULL,11),(43,'Amirthum','2021-01-17 12:06:09','Y','N',NULL,NULL,'PROD00011_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00011_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00011_3.jpeg/CATE00001',NULL,11),(44,'Amirthum','2021-01-17 12:09:55','Y','N',NULL,NULL,'PROD00012_0.jpg','C:\\Amirthum\\CATE00001\\PROD00012_0.jpg',2425623,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00012_0.jpg/CATE00001',NULL,12),(45,'Amirthum','2021-01-17 12:09:55','Y','N',NULL,NULL,'PROD00012_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00012_1.jpeg',20272,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00012_1.jpeg/CATE00001',NULL,12),(46,'Amirthum','2021-01-17 12:09:55','Y','N',NULL,NULL,'PROD00012_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00012_2.jpeg',25320,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00012_2.jpeg/CATE00001',NULL,12),(47,'Amirthum','2021-01-17 12:09:55','Y','N',NULL,NULL,'PROD00012_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00012_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00012_3.jpeg/CATE00001',NULL,12),(48,'Amirthum','2021-01-17 12:14:05','Y','N',NULL,NULL,'PROD00013_0.jpg','C:\\Amirthum\\CATE00001\\PROD00013_0.jpg',2123421,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00013_0.jpg/CATE00001',NULL,13),(49,'Amirthum','2021-01-17 12:14:05','Y','N',NULL,NULL,'PROD00013_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00013_1.jpeg',35287,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00013_1.jpeg/CATE00001',NULL,13),(50,'Amirthum','2021-01-17 12:14:05','Y','N',NULL,NULL,'PROD00013_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00013_2.jpeg',26985,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00013_2.jpeg/CATE00001',NULL,13),(51,'Amirthum','2021-01-17 12:14:05','Y','N',NULL,NULL,'PROD00013_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00013_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00013_3.jpeg/CATE00001',NULL,13),(52,'Amirthum','2021-01-17 12:21:52','Y','N',NULL,NULL,'PROD00014_0.jpeg','C:\\Amirthum\\CATE00001\\PROD00014_0.jpeg',28015,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00014_0.jpeg/CATE00001',NULL,14),(53,'Amirthum','2021-01-17 12:21:52','Y','N',NULL,NULL,'PROD00014_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00014_1.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00014_1.jpeg/CATE00001',NULL,14),(54,'Amirthum','2021-01-17 12:26:34','Y','N',NULL,NULL,'PROD00015_0.jpg','C:\\Amirthum\\CATE00001\\PROD00015_0.jpg',2503478,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00015_0.jpg/CATE00001',NULL,15),(55,'Amirthum','2021-01-17 12:26:34','Y','N',NULL,NULL,'PROD00015_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00015_1.jpeg',29516,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00015_1.jpeg/CATE00001',NULL,15),(56,'Amirthum','2021-01-17 12:26:34','Y','N',NULL,NULL,'PROD00015_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00015_2.jpeg',31545,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00015_2.jpeg/CATE00001',NULL,15),(57,'Amirthum','2021-01-17 12:26:34','Y','N',NULL,NULL,'PROD00015_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00015_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00015_3.jpeg/CATE00001',NULL,15),(58,'Amirthum','2021-01-17 12:29:49','Y','N',NULL,NULL,'PROD00016_0.jpg','C:\\Amirthum\\CATE00001\\PROD00016_0.jpg',2134127,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00016_0.jpg/CATE00001',NULL,16),(59,'Amirthum','2021-01-17 12:29:49','Y','N',NULL,NULL,'PROD00016_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00016_1.jpeg',28582,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00016_1.jpeg/CATE00001',NULL,16),(60,'Amirthum','2021-01-17 12:29:49','Y','N',NULL,NULL,'PROD00016_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00016_2.jpeg',25461,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00016_2.jpeg/CATE00001',NULL,16),(61,'Amirthum','2021-01-17 12:29:49','Y','N',NULL,NULL,'PROD00016_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00016_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00016_3.jpeg/CATE00001',NULL,16),(62,'Amirthum','2021-01-17 12:34:52','Y','N',NULL,NULL,'PROD00017_0.jpg','C:\\Amirthum\\CATE00001\\PROD00017_0.jpg',2836306,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00017_0.jpg/CATE00001',NULL,17),(63,'Amirthum','2021-01-17 12:34:52','Y','N',NULL,NULL,'PROD00017_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00017_1.jpeg',25227,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00017_1.jpeg/CATE00001',NULL,17),(64,'Amirthum','2021-01-17 12:34:52','Y','N',NULL,NULL,'PROD00017_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00017_2.jpeg',26088,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00017_2.jpeg/CATE00001',NULL,17),(65,'Amirthum','2021-01-17 12:34:52','Y','N',NULL,NULL,'PROD00017_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00017_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00017_3.jpeg/CATE00001',NULL,17),(66,'Amirthum','2021-01-17 17:00:10','Y','N',NULL,NULL,'PROD00018_0.jpg','C:\\Amirthum\\CATE00001\\PROD00018_0.jpg',1947929,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00018_0.jpg/CATE00001',NULL,18),(67,'Amirthum','2021-01-17 17:00:10','Y','N',NULL,NULL,'PROD00018_1.jpg','C:\\Amirthum\\CATE00001\\PROD00018_1.jpg',150635,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00018_1.jpg/CATE00001',NULL,18),(68,'Amirthum','2021-01-17 17:00:10','Y','N',NULL,NULL,'PROD00018_2.jpg','C:\\Amirthum\\CATE00001\\PROD00018_2.jpg',69353,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00018_2.jpg/CATE00001',NULL,18),(69,'Amirthum','2021-01-17 17:00:10','Y','N',NULL,NULL,'PROD00018_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00018_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00018_3.jpeg/CATE00001',NULL,18),(70,'Amirthum','2021-01-17 17:06:46','Y','N',NULL,NULL,'PROD00019_0.jpg','C:\\Amirthum\\CATE00001\\PROD00019_0.jpg',2428080,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00019_0.jpg/CATE00001',NULL,19),(71,'Amirthum','2021-01-17 17:06:46','Y','N',NULL,NULL,'PROD00019_1.jpg','C:\\Amirthum\\CATE00001\\PROD00019_1.jpg',42780,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00019_1.jpg/CATE00001',NULL,19),(72,'Amirthum','2021-01-17 17:06:46','Y','N',NULL,NULL,'PROD00019_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00019_2.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00019_2.jpeg/CATE00001',NULL,19),(73,'Amirthum','2021-01-17 17:12:22','Y','N',NULL,NULL,'PROD00020_0.jpg','C:\\Amirthum\\CATE00001\\PROD00020_0.jpg',3047031,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00020_0.jpg/CATE00001',NULL,20),(74,'Amirthum','2021-01-17 17:12:22','Y','N',NULL,NULL,'PROD00020_1.jpg','C:\\Amirthum\\CATE00001\\PROD00020_1.jpg',48172,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00020_1.jpg/CATE00001',NULL,20),(75,'Amirthum','2021-01-17 17:12:22','Y','N',NULL,NULL,'PROD00020_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00020_2.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00020_2.jpeg/CATE00001',NULL,20),(76,'Amirthum','2021-01-17 17:16:11','Y','N',NULL,NULL,'PROD00021_0.jpg','C:\\Amirthum\\CATE00001\\PROD00021_0.jpg',3138933,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00021_0.jpg/CATE00001',NULL,21),(77,'Amirthum','2021-01-17 17:16:11','Y','N',NULL,NULL,'PROD00021_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00021_1.jpeg',19871,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00021_1.jpeg/CATE00001',NULL,21),(78,'Amirthum','2021-01-17 17:16:11','Y','N',NULL,NULL,'PROD00021_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00021_2.jpeg',20061,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00021_2.jpeg/CATE00001',NULL,21),(79,'Amirthum','2021-01-17 17:16:11','Y','N',NULL,NULL,'PROD00021_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00021_3.jpeg',20298,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00021_3.jpeg/CATE00001',NULL,21),(80,'Amirthum','2021-01-17 17:21:48','Y','N',NULL,NULL,'PROD00022_0.jpg','C:\\Amirthum\\CATE00001\\PROD00022_0.jpg',2125914,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00022_0.jpg/CATE00001',NULL,22),(81,'Amirthum','2021-01-17 17:21:48','Y','N',NULL,NULL,'PROD00022_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00022_1.jpeg',23522,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00022_1.jpeg/CATE00001',NULL,22),(82,'Amirthum','2021-01-17 17:21:48','Y','N',NULL,NULL,'PROD00022_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00022_2.jpeg',31993,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00022_2.jpeg/CATE00001',NULL,22),(83,'Amirthum','2021-01-17 17:21:48','Y','N',NULL,NULL,'PROD00022_3.jpeg','C:\\Amirthum\\CATE00001\\PROD00022_3.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00022_3.jpeg/CATE00001',NULL,22),(84,'Amirthum','2021-01-17 17:25:34','Y','N',NULL,NULL,'PROD00023_0.jpg','C:\\Amirthum\\CATE00001\\PROD00023_0.jpg',2503478,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00023_0.jpg/CATE00001',NULL,23),(85,'Amirthum','2021-01-17 17:25:34','Y','N',NULL,NULL,'PROD00023_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00023_1.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00023_1.jpeg/CATE00001',NULL,23),(86,'Amirthum','2021-01-17 17:27:33','Y','N',NULL,NULL,'PROD00024_0.jpg','C:\\Amirthum\\CATE00001\\PROD00024_0.jpg',2842731,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00024_0.jpg/CATE00001',NULL,24),(87,'Amirthum','2021-01-17 17:27:33','Y','N',NULL,NULL,'PROD00024_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00024_1.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00024_1.jpeg/CATE00001',NULL,24),(88,'Amirthum','2021-01-17 17:31:23','Y','N',NULL,NULL,'PROD00025_0.jpg','C:\\Amirthum\\CATE00001\\PROD00025_0.jpg',2534280,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00025_0.jpg/CATE00001',NULL,25),(89,'Amirthum','2021-01-17 17:31:23','Y','N',NULL,NULL,'PROD00025_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00025_1.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00025_1.jpeg/CATE00001',NULL,25),(90,'Amirthum','2021-01-17 17:32:57','Y','N',NULL,NULL,'PROD00026_0.jpg','C:\\Amirthum\\CATE00001\\PROD00026_0.jpg',2833228,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00026_0.jpg/CATE00001',NULL,26),(91,'Amirthum','2021-01-17 17:32:57','Y','N',NULL,NULL,'PROD00026_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00026_1.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00026_1.jpeg/CATE00001',NULL,26),(92,'Amirthum','2021-01-17 17:35:35','Y','N',NULL,NULL,'PROD00027_0.jpg','C:\\Amirthum\\CATE00001\\PROD00027_0.jpg',2718725,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00027_0.jpg/CATE00001',NULL,27),(93,'Amirthum','2021-01-17 17:35:35','Y','N',NULL,NULL,'PROD00027_1.jpeg','C:\\Amirthum\\CATE00001\\PROD00027_1.jpeg',26113,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00027_1.jpeg/CATE00001',NULL,27),(94,'Amirthum','2021-01-17 17:35:35','Y','N',NULL,NULL,'PROD00027_2.jpeg','C:\\Amirthum\\CATE00001\\PROD00027_2.jpeg',21314,'image/jpeg','http://localhost:8085/products/downloadFile/PROD00027_2.jpeg/CATE00001',NULL,27);
/*!40000 ALTER TABLE `product_media_gallary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_reviews`
--

DROP TABLE IF EXISTS `product_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_reviews` (
  `rev_id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `rev_comments` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `rev_parent_id` int DEFAULT NULL,
  `rev_rating` int DEFAULT NULL,
  `prod_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`rev_id`),
  KEY `FK45p4m0dc7eqwpaw8xm29m68wg` (`prod_id`),
  KEY `FKprw698ufih2fylrb5rhavjatf` (`user_id`),
  CONSTRAINT `FK45p4m0dc7eqwpaw8xm29m68wg` FOREIGN KEY (`prod_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FKprw698ufih2fylrb5rhavjatf` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_reviews`
--

LOCK TABLES `product_reviews` WRITE;
/*!40000 ALTER TABLE `product_reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_varient`
--

DROP TABLE IF EXISTS `product_varient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_varient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `prod_useby_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_discount_rate` int DEFAULT NULL,
  `prod_manufacture_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_mrp_price` double DEFAULT NULL,
  `prod_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_saved_price` double DEFAULT NULL,
  `prod_selling_price` double DEFAULT NULL,
  `prod_stock` int NOT NULL,
  `prod_in_unit` int DEFAULT NULL,
  `prod_unit_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj5us0krt8g7e845oqrbig1pyh` (`prod_id`),
  CONSTRAINT `FKj5us0krt8g7e845oqrbig1pyh` FOREIGN KEY (`prod_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_varient`
--

LOCK TABLES `product_varient` WRITE;
/*!40000 ALTER TABLE `product_varient` DISABLE KEYS */;
INSERT INTO `product_varient` VALUES (1,'Amirthum','2021-01-17 10:26:19','Y','N',NULL,NULL,'2021-08-16T10:26:08.458Z',10,'2021-01-01T10:26:06.291Z',110,'PROD00001',11,99,100,1,'kg',1),(2,'Amirthum','2021-01-17 10:27:34','Y','N',NULL,NULL,'2021-03-31T10:27:25.145Z',5,'2021-01-01T10:27:22.926Z',55,'PROD00001',3,52,100,500,'g',1),(3,'Amirthum','2021-01-17 10:30:35','Y','N',NULL,NULL,'2021-03-31T10:30:29.747Z',5,'2021-01-01T10:30:26.545Z',55,'PROD00002',3,52,100,500,'g',2),(4,'Amirthum','2021-01-17 10:33:35','Y','N',NULL,NULL,'2021-02-25T10:33:18.166Z',7,'2021-01-01T10:33:15.622Z',185,'PROD00003',13,172,100,500,'g',3),(5,'Amirthum','2021-01-17 10:35:32','Y','N',NULL,NULL,'2021-03-31T10:35:23.340Z',25,'2021-01-01T10:35:20.823Z',330,'PROD00004',82,248,100,500,'g',4),(6,'Amirthum','2021-01-17 10:36:45','Y','N',NULL,NULL,'2021-03-31T10:36:39.268Z',7,'2021-01-01T10:36:36.478Z',140,'PROD00004',10,130,100,250,'g',4),(7,'Amirthum','2021-01-17 10:38:03','Y','N',NULL,NULL,'2021-03-31T10:37:58.765Z',5,'2021-01-01T10:37:55.151Z',185,'PROD00005',9,176,100,250,'g',5),(8,'Amirthum','2021-01-17 11:33:57','Y','N',NULL,NULL,'2021-06-30T11:33:49.417Z',5,'2021-01-01T11:33:47.199Z',370,'PROD00006',18,352,100,1,'l',6),(9,'Amirthum','2021-01-17 11:34:51','Y','N',NULL,NULL,'2021-06-30T11:34:44.246Z',5,'2021-01-01T11:34:42.075Z',180,'PROD00006',9,171,100,500,'ml',6),(10,'Amirthum','2021-01-17 11:37:10','Y','N',NULL,NULL,'2021-07-31T11:36:59.607Z',5,'2021-01-01T11:36:57.732Z',95,'PROD00006',5,90,100,250,'ml',6),(11,'Amirthum','2021-01-17 11:41:51','Y','N',NULL,NULL,'2021-03-31T11:41:44.646Z',55,'2021-01-01T11:41:42.739Z',330,'PROD00007',181,149,100,1,'l',7),(12,'Amirthum','2021-01-17 11:42:29','Y','N',NULL,'2021-01-17 11:43:26','2021-03-31T11:42:24.361Z',5,'2021-01-01T11:42:22.800Z',170,'PROD00007',8,162,100,500,'ml',7),(13,'Amirthum','2021-01-17 11:44:09','Y','N',NULL,NULL,'2021-03-31T11:44:03.720Z',5,'2021-01-01T11:44:01.418Z',90,'PROD00007',4,86,100,250,'ml',7),(14,'Amirthum','2021-01-17 11:55:32','Y','N',NULL,NULL,'2021-04-30T11:55:27.960Z',5,'2021-01-01T11:55:25.951Z',270,'PROD00008',13,257,100,1,'l',8),(15,'Amirthum','2021-01-17 11:56:15','Y','N',NULL,NULL,'2021-05-31T11:56:09.322Z',5,'2021-01-01T11:56:07.725Z',140,'PROD00008',7,133,100,500,'ml',8),(16,'Amirthum','2021-01-17 11:57:07','Y','N',NULL,NULL,'2021-06-30T11:56:46.697Z',5,'2021-01-01T11:56:44.311Z',75,'PROD00008',4,71,100,250,'ml',8),(17,'Amirthum','2021-01-17 11:58:51','Y','N',NULL,NULL,'2021-05-31T11:58:46.005Z',5,'2021-01-01T11:58:43.950Z',310,'PROD00009',15,295,100,1,'l',9),(18,'Amirthum','2021-01-17 11:59:32','Y','N',NULL,NULL,'2021-04-30T11:59:26.814Z',5,'2021-01-01T11:59:22.609Z',160,'PROD00009',8,152,100,500,'ml',9),(19,'Amirthum','2021-01-17 12:04:00','Y','N',NULL,NULL,'2021-06-30T12:03:55.544Z',5,'2021-01-01T12:03:53.577Z',130,'PROD00010',6,124,100,100,'ml',10),(20,'Amirthum','2021-01-17 12:07:10','Y','N',NULL,NULL,'2021-04-30T12:07:05.454Z',5,'2021-01-01T12:07:02.775Z',110,'PROD00011',5,105,100,50,'ml',11),(21,'Amirthum','2021-01-17 12:10:59','Y','N',NULL,NULL,'2021-04-30T12:10:53.233Z',5,'2021-01-01T12:10:51.316Z',240,'PROD00012',12,228,100,100,'ml',12),(22,'Amirthum','2021-01-17 12:15:03','Y','N',NULL,NULL,'2021-04-30T12:14:59.040Z',5,'2021-01-01T12:14:56.740Z',185,'PROD00013',9,176,100,50,'ml',13),(23,'Amirthum','2021-01-17 12:23:15','Y','N',NULL,NULL,'2021-03-31T12:23:10.584Z',5,'2021-01-01T12:23:09.056Z',85,'PROD00014',4,81,100,50,'ml',14),(24,'Amirthum','2021-01-17 12:27:30','Y','N',NULL,NULL,'2021-04-30T12:27:22.210Z',5,'2021-01-01T12:27:20.095Z',210,'PROD00015',10,200,100,100,'ml',15),(25,'Amirthum','2021-01-17 12:31:10','Y','N',NULL,NULL,'2021-05-28T12:30:59.361Z',5,'2021-01-01T12:30:56.818Z',310,'PROD00016',15,295,100,100,'ml',16),(26,'Amirthum','2021-01-17 12:35:53','Y','N',NULL,NULL,'2021-04-30T12:35:48.030Z',5,'2021-01-01T12:35:46.091Z',310,'PROD00017',15,295,100,100,'ml',17),(27,'Amirthum','2021-01-17 17:01:42','Y','N',NULL,NULL,'2021-04-30T17:01:34.852Z',5,'2021-01-01T17:01:32.952Z',160,'PROD00018',8,152,100,50,'ml',18),(28,'Amirthum','2021-01-17 17:07:51','Y','N',NULL,NULL,'2022-01-01T17:07:45.789Z',5,'2021-01-01T17:07:43.873Z',260,'PROD00019',13,247,100,1,'l',19),(29,'Amirthum','2021-01-17 17:08:37','Y','N',NULL,NULL,'2022-01-01T17:08:32.419Z',5,'2021-01-01T17:08:30.054Z',135,'PROD00019',7,128,100,500,'ml',19),(30,'Amirthum','2021-01-17 17:13:30','Y','N',NULL,NULL,'2022-01-01T17:13:24.850Z',5,'2021-01-01T17:13:23.348Z',260,'PROD00020',13,247,100,1,'l',20),(31,'Amirthum','2021-01-17 17:14:08','Y','N',NULL,NULL,'2022-01-07T17:14:04.019Z',5,'2021-01-17T17:14:02.180Z',135,'PROD00020',7,128,100,500,'ml',20),(32,'Amirthum','2021-01-17 17:17:42','Y','N',NULL,'2021-01-17 17:20:18','2022-01-16T17:17:37.527Z',5,'2021-01-17T17:17:35.855Z',310,'PROD00021',15,295,100,1,'l',21),(33,'Amirthum','2021-01-17 17:18:22','Y','N',NULL,'2021-01-17 17:19:50','2022-01-19T17:18:17.794Z',5,'2021-01-01T17:18:15.750Z',70,'PROD00021',3,67,100,500,'ml',21),(34,'Amirthum','2021-01-17 17:19:28','Y','N',NULL,NULL,'2022-01-14T17:19:23.940Z',5,'2021-01-15T17:19:22.106Z',70,'PROD00021',3,67,100,200,'ml',21),(35,'Amirthum','2021-01-17 17:22:43','Y','N',NULL,NULL,'2022-01-15T17:22:39.097Z',5,'2021-01-17T17:22:37.254Z',310,'PROD00022',15,295,100,1,'l',22),(36,'Amirthum','2021-01-17 17:23:29','Y','N',NULL,NULL,'2022-01-07T17:23:25.061Z',5,'2021-01-08T17:23:23.362Z',160,'PROD00022',8,152,100,500,'ml',22),(37,'Amirthum','2021-01-17 17:24:12','Y','N',NULL,NULL,'2022-01-07T17:24:07.842Z',5,'2021-01-08T17:24:00.293Z',70,'PROD00022',3,67,100,200,'ml',22),(38,'Amirthum','2021-01-17 17:26:22','Y','N',NULL,NULL,'2022-01-18T17:26:16.309Z',5,'2021-01-19T17:26:14.889Z',70,'PROD00023',3,67,100,200,'ml',23),(39,'Amirthum','2021-01-17 17:28:42','Y','N',NULL,NULL,'2022-01-21T17:28:37.174Z',5,'2021-01-21T17:28:35.239Z',500,'PROD00024',25,475,100,200,'ml',24),(40,'Amirthum','2021-01-17 17:29:29','Y','N',NULL,NULL,'2022-01-10T17:29:25.278Z',5,'2021-01-11T17:29:23.763Z',210,'PROD00024',10,200,100,100,'ml',24),(41,'Amirthum','2021-01-17 17:30:27','Y','N',NULL,NULL,'2022-01-11T17:30:22.682Z',5,'2021-01-12T17:30:20.754Z',110,'PROD00024',5,105,100,50,'ml',24),(42,'Amirthum','2021-01-17 17:32:15','Y','N',NULL,NULL,'2022-01-19T17:32:10.938Z',5,'2021-01-20T17:32:09.192Z',160,'PROD00025',8,152,100,50,'ml',25),(43,'Amirthum','2021-01-17 17:33:57','Y','N',NULL,NULL,'2022-01-29T17:33:53.280Z',5,'2021-01-01T17:33:50.137Z',210,'PROD00026',10,200,100,100,'ml',26),(44,'Amirthum','2021-01-17 17:36:31','Y','N',NULL,NULL,'2022-01-21T17:36:26.684Z',5,'2021-01-01T17:36:25.249Z',310,'PROD00027',15,295,100,1,'l',27),(45,'Amirthum','2021-01-17 17:37:13','Y','N',NULL,NULL,'2022-01-07T17:37:08.069Z',5,'2021-01-08T17:37:05.847Z',160,'PROD00027',8,152,100,500,'ml',27),(46,'Amirthum','2021-01-17 17:38:00','Y','N',NULL,NULL,'2022-01-05T17:37:56.200Z',5,'2021-01-08T17:37:55.008Z',70,'PROD00027',3,67,100,200,'ml',27);
/*!40000 ALTER TABLE `product_varient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `prod_available` bit(1) DEFAULT NULL,
  `prod_best_selling_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_cat_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `prod_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_desc` longtext CHARACTER SET utf8 COLLATE utf8_bin,
  `prod_highlight` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_nme` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `prod_incredience_dtls` longtext CHARACTER SET utf8 COLLATE utf8_bin,
  `prod_spec_dtls` longtext CHARACTER SET utf8 COLLATE utf8_bin,
  `prod_ben_use` longtext CHARACTER SET utf8 COLLATE utf8_bin,
  `category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2kil1gjac1npi28eimylmeyb1` (`category_id`),
  CONSTRAINT `FK2kil1gjac1npi28eimylmeyb1` FOREIGN KEY (`category_id`) REFERENCES `amir_prod_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Amirthum','2021-01-17 09:54:10','Y','N',NULL,NULL,_binary '','Y','Amirutham','CATE00002','PROD00001','Jaggery is popularly used as a natural sugar substitute. It is obtained from the concentrated cane sugar without separation of the molasses and crystals. The Amirutham Jaggery is made by evaporating the water from concentrated sugar cane juice and solidifying it.',NULL,'Jaggery','Jaggery helps in maintaining the electrolyte balance and helps prevent water retention due to its potassium content. Replacing sugar with jaggery is a healthier option. It detoxes the liver, prevents constipation, acts as a blood purifier and boosts immunity. ',NULL,'Jaggery helps in maintaining the electrolyte balance and helps prevent water retention due to its potassium content. Replacing sugar with jaggery is a healthier option. It detoxes the liver, prevents constipation, acts as a blood purifier and boosts immunity. ',2),(2,'Amirthum','2021-01-17 09:59:04','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00002','PROD00002','Brown sugar is a sucrose sugar product with a distinctive brown color due to the presence of molasses. It is unrefined soft sugar and has more liquid and has around 0.25 fewer calories per gram than white sugar. ',NULL,'Brown Sugar','Brown sugar is a sucrose sugar product with a distinctive brown color due to the presence of molasses. It is unrefined soft sugar and has more liquid and has around 0.25 fewer calories per gram than white sugar. ',NULL,'Because of its molasses content, brown sugar does contain certain minerals, most notably calcium, potassium, iron and magnesium. Brown sugar eases menstrual cramps, prevents obesity and improves digestion. It is chemaical free and acts as an antiseptic. ',2),(3,'Amirthum','2021-01-17 10:00:47','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00002','PROD00003','Palm jaggery is a much sweeter variant of jaggery, which has a melt-in the mouth texture. This form of jaggery is made by extracting sap of palm which is manually boiled and churned to make the jaggery. Palm jaggery is considered to be better than the sugar cane jaggery because of its high medicinal properties.  ',NULL,'Palm Jaggery','Palm jaggery is a much sweeter variant of jaggery, which has a melt-in the mouth texture. This form of jaggery is made by extracting sap of palm which is manually boiled and churned to make the jaggery. Palm jaggery is considered to be better than the sugar cane jaggery because of its high medicinal properties.  ',NULL,'It has been observed that regular consumption of Palm Jaggery positively impacts digestive health. Palm Jaggery as a sugar substitute helps with regular bowel movement and cleanses the system. Among many other ailments that palm jaggery helps relieve, cold and cough is the most common one.',2),(4,'Amirthum','2021-01-17 10:02:51','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00002','PROD00004','Palm Candy has a number of minerals, vitamins, calcium, iron and phyto nutrients including zinc and potassium. It is a good source of Vitamin B1, B2, B3, B6 and B12. The sugar content in palm sugar is well balanced and it is a great natural substitute for sugar. ',NULL,'Palm Candy – Small','The rich iron content in palm candy helps in treating anaemia and improves metabolism. Palm candy with water quenches thirst. Palm candy with milk relieves urinary trouble, urinary tract infection and heat. It is good remedy for sore throat & ear pain when used with warm milk, pepper & turmeric powder.',NULL,'The rich iron content in palm candy helps in treating anaemia and improves metabolism. Palm candy with water quenches thirst. Palm candy with milk relieves urinary trouble, urinary tract infection and heat. It is good remedy for sore throat & ear pain when used with warm milk, pepper & turmeric powder.',2),(5,'Amirthum','2021-01-17 10:04:48','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00002','PROD00005','Palm Candy has a number of minerals, vitamins, calcium, iron and phyto nutrients including zinc and potassium. It is a good source of Vitamin B1, B2, B3, B6 and B12. The sugar content in palm sugar is well balanced and it is a great natural substitute for sugar. ',NULL,'Palm Candy – Big','The rich iron content in palm candy helps in treating anaemia and improves metabolism. Palm candy with water quenches thirst. Palm candy with milk relieves urinary trouble, urinary tract infection and heat. It is good remedy for sore throat & ear pain when used with warm milk, pepper & turmeric powder.',NULL,'The rich iron content in palm candy helps in treating anaemia and improves metabolism. Palm candy with water quenches thirst. Palm candy with milk relieves urinary trouble, urinary tract infection and heat. It is good remedy for sore throat & ear pain when used with warm milk, pepper & turmeric powder.',2),(6,'Amirthum','2021-01-17 11:31:50','Y','N',NULL,NULL,_binary '','Y','Amirutham','CATE00001','PROD00006','For making the sesame oil, the cleaned sesame seeds and palm jaggery are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction.',NULL,'Sesame Oil',NULL,NULL,'The cold pressed sesame oil is high in antioxidants and has a strong anti-inflammatory property. Hence, it is good for the heart and oral health. It helps control blood sugar and is widely used in arthritis treatment. It is also used in hair for a dandruff free scalp. ',1),(7,'Amirthum','2021-01-17 11:40:43','Y','N',NULL,NULL,_binary '','Y','Amirutham','CATE00001','PROD00007','For making the coconut oil, the cleaned coconut coprais are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction.',NULL,'Coconut Oil','For making the coconut oil, the cleaned coconut coprais are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction.',NULL,'Cold pressed coconut oil is rich in antioxidants and fatty acids. It helps in controlling blood sugar and in reducing stress. The coconut oil also makes the hair shining and smooth and yeilds amzing skin benefits on external application.',1),(8,'Amirthum','2021-01-17 11:49:43','Y','N',NULL,NULL,_binary '','Y','Amirutham','CATE00001','PROD00008','For making the groundnut oil, the cleaned raw groundnuts are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction.',NULL,'Groundnut Oil','The cold pressed groundnut oil is majorly used for cooking purposes. It may also help improve insulin sensitivity and lower the blood sugar levels in people with diabetes. It is also a great source of vitamin E, a powerful antioxidant that protects the body from free radical damage.',NULL,'The cold pressed groundnut oil is majorly used for cooking purposes. It may also help improve insulin sensitivity and lower the blood sugar levels in people with diabetes. It is also a great source of vitamin E, a powerful antioxidant that protects the body from free radical damage.',1),(9,'Amirthum','2021-01-17 11:53:47','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00009','For making the mustard oil, the handpicked mustard seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction. ',NULL,'Mustard Oil','The cold pressed mustard oil is a spicy oil. It is used to fight harmful bacteria in the body. It helps in decreasing inflammation and reducing fever by stimulating the sweat glands.',NULL,'The cold pressed mustard oil is a spicy oil. It is used to fight harmful bacteria in the body. It helps in decreasing inflammation and reducing fever by stimulating the sweat glands.',1),(10,'Amirthum','2021-01-17 12:03:04','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00010','For making the flax seed oil, the handpicked flax seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction. ',NULL,'Flax seed Oil','Flax seeds are termed as the super food due to their health protective properties. The cold pressed flax seed oil is loaded with nutrients and omega-3 fatty acids. It aids weight loss and contributes to a glowing skin and a stronger and an even hair growth due to the presence of high-quality protein in it. ',NULL,'Flax seeds are termed as the super food due to their health protective properties. The cold pressed flax seed oil is loaded with nutrients and omega-3 fatty acids. It aids weight loss and contributes to a glowing skin and a stronger and an even hair growth due to the presence of high-quality protein in it. ',1),(11,'Amirthum','2021-01-17 12:06:09','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00011','For making the chia seed oil, the handpicked chia seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Chia seed Oil','For making the chia seed oil, the handpicked chia seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Cold pressed chia seed oil are an abundant source antioxidants and omega-3 fatty acids. It can stabilize the blood sugar levels and fortify the bones. The chia seed oil is also capable of banishing the belly fat and promoting a younger looking skin.',1),(12,'Amirthum','2021-01-17 12:09:55','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00012','For making the pumpkin seed oil, the handpicked pumpkin seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Pumpkin seed Oil','For making the pumpkin seed oil, the handpicked pumpkin seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'The cold pressed pumpkin seed oil is often promoted as a health supplement as it is capable of relieving menopausal symptoms, overactive bladder and reducing blood cholesterol levels. Regular consumption of pumpkin seed oil is said regenerate hair growth by 40% over a span of 24 weeks. ',1),(13,'Amirthum','2021-01-17 12:14:05','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00013','For making the pomegranate seed oil, the handpicked pomegranate seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Pomegranate seed Oil','The cold pressed pomegranate oil regenerates and repairs skin and effectively reduces and prevents wrinkles in the epidermis. It has antimicrobial properties. It is an effective anti-inflammatory agent. It has superior moisturizing ability and can nourish and soften the skin to a greater extent.',NULL,'The cold pressed pomegranate oil regenerates and repairs skin and effectively reduces and prevents wrinkles in the epidermis. It has antimicrobial properties. It is an effective anti-inflammatory agent. It has superior moisturizing ability and can nourish and soften the skin to a greater extent.',1),(14,'Amirthum','2021-01-17 12:21:52','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00014','For making the sabja seed oil, the handpicked sabja seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Sabja seed Oil','The cold pressed sabja seed oil or the basil seed oil is used in ayurveda for cosmetic applications. Apart from this, the sabja oil improves digestion, relieves cold and vomiting and treats asthma and itching. This oil is also capable to releieving bloodshot eye and improves blood circulation.',NULL,'The cold pressed sabja seed oil or the basil seed oil is used in ayurveda for cosmetic applications. Apart from this, the sabja oil improves digestion, relieves cold and vomiting and treats asthma and itching. This oil is also capable to releieving bloodshot eye and improves blood circulation.',1),(15,'Amirthum','2021-01-17 12:26:34','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00015','For making the kalonji oil, the handpicked kalonji seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Kalonji Oil',NULL,NULL,'Cold pressed kalonji oil is widely known for its medicinal properties. It is packed with antioxidants. It aids weight loss, relieves joint pains and headache, lowers cholesterol and alleviates inflammation. The kalonji oil is capable of fighting cancer and preventing stomach ulcers. ',1),(16,'Amirthum','2021-01-17 12:29:49','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00016','For making the grapeseed oil, the handpicked grape seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Grapeseed Oil','Cold pressed grapeseed oil is used as a natural beauty product. It is generally marketed as a healthy alternative to skin moisturizer. The grapeseed oil can be used to heal acne, lighten skin, tighten pores and reduce the appearance of scars.',NULL,'Cold pressed grapeseed oil is used as a natural beauty product. It is generally marketed as a healthy alternative to skin moisturizer. The grapeseed oil can be used to heal acne, lighten skin, tighten pores and reduce the appearance of scars.',1),(17,'Amirthum','2021-01-17 12:34:52','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00017','For making the almond oil, the handpicked almonds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Almond Oil','Cold pressed almond oil is high in anti-oxidants and offers a lot of benefits to skin and hair on external application. It aids weight loss when paired with a reduced-calorie diet and is highly beneficial for the control of blood sugar levels.',NULL,'Cold pressed almond oil is high in anti-oxidants and offers a lot of benefits to skin and hair on external application. It aids weight loss when paired with a reduced-calorie diet and is highly beneficial for the control of blood sugar levels.',1),(18,'Amirthum','2021-01-17 17:00:10','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00018','For making the moringa seed oil, the handpicked moringa seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Moringa seed Oil','The cold pressed moringa oil is a rich source of nutrients and vitamins. It moisturises the dry skin and speeds up the healing of wounds. The moringa oil can treat stomach disorders and inflammatory conditions. It can also promote sleep by relaxing the muscles and contribute to a lot of hair and skin health. ',NULL,'The cold pressed moringa oil is a rich source of nutrients and vitamins. It moisturises the dry skin and speeds up the healing of wounds. The moringa oil can treat stomach disorders and inflammatory conditions. It can also promote sleep by relaxing the muscles and contribute to a lot of hair and skin health. ',1),(19,'Amirthum','2021-01-17 17:06:46','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00019','The Amirutham Mosquito repellent oil is made from a combination of 9 types of natural oils which effectively repels mosquitoes.',NULL,'Mosquito Repellent Oil','The Amirutham mosquito repellent oil is a repellent produced by using 9 types of natural oils. It contains antifungal properties that allows treatment of parasitic infections and promotes wound healing.',NULL,'The Amirutham mosquito repellent oil is a repellent produced by using 9 types of natural oils. It contains antifungal properties that allows treatment of parasitic infections and promotes wound healing.',1),(20,'Amirthum','2021-01-17 17:12:22','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00020','Lighting lamps with the Amirutham Panchadeepam Oil is said to bring peace, fame, wealth and prosperity to the house. It is made from a list of 5 different products which are mixed at a certain proportion. ',NULL,'Panchadeepam Oil','The Amirutham panchadeepam oil is prepared in the right composition to help eliminate difficulties and remove obstacles from one\'s life. The ingredients are said to bring positivity to the house while used regularly by lighting a lamp with it. ',NULL,'The Amirutham panchadeepam oil is prepared in the right composition to help eliminate difficulties and remove obstacles from one\'s life. The ingredients are said to bring positivity to the house while used regularly by lighting a lamp with it. ',1),(21,'Amirthum','2021-01-17 17:16:11','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00021','For making the mahua oil, the handpicked mahua seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Mahua Oil','The cold pressed mahua oil is an effective medication for a number of ailments. It benefits oral health, treats rheumatism, constipation and asthma. For nursing mothers, regular consumption of mahua oil helps in breast milk secretion. Apart from this, it also has more health and skin benefits. ',NULL,'The cold pressed mahua oil is an effective medication for a number of ailments. It benefits oral health, treats rheumatism, constipation and asthma. For nursing mothers, regular consumption of mahua oil helps in breast milk secretion. Apart from this, it also has more health and skin benefits. ',1),(22,'Amirthum','2021-01-17 17:21:48','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00022','For making the castor oil, the handpicked castor seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Castor Oil','For making the castor oil, the handpicked castor seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Cold pressed castor oil is a powerful laxative and a natural moisturizer. It promotes wound healing and aids in fighting acne and fungus. It has impressive anti-Inflammatory effects and keeps hair and scalp healthy.',1),(23,'Amirthum','2021-01-17 17:25:34','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00023','For making the pongamia oil or punga oil, the handpicked punga seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Pongamia Oil / Punga Oil',NULL,NULL,'The cold pressed pongamia oil or punga oil is an herbal medicine used in Ayurveda which is predominantly used in treating the skin diseases. It aids in detoxifying the vagina and to treat uterine disorders. The punga oil has the properties of relieving piles, bloating, flatulence and stomach ailments. Traditionally, it was even used to treat poisoning.',1),(24,'Amirthum','2021-01-17 17:27:33','Y','N',NULL,NULL,_binary '','Y','Amirutham','CATE00001','PROD00024','For making the Amirutham hair oil, we include 32 types of herbs which are handpicked and then processed with pure cold pressed coconut oil. The prepared oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Hair Oil',NULL,NULL,'The Amirutham hair oil improves the hair growth and offers a more shining, soft and a even hair. It naturally reduces the frizz and contributes in regeneration of the hair. The regular usage of the Amirutham hair oil can improve the overall health of your hair.',1),(25,'Amirthum','2021-01-17 17:31:23','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00025','For making the walnut oil, the handpicked walnut seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Walnut Oil','Cold pressed walnut oil is a rich source of antioxidants, omega-3 and Vitamins A and D. It is known as the brain food as it is great for boosting the brain health. The walnut oil can fight fungal infections, reduce signs of ageing and dark circles and is also used as a remedy for psoriasis. ',NULL,'Cold pressed walnut oil is a rich source of antioxidants, omega-3 and Vitamins A and D. It is known as the brain food as it is great for boosting the brain health. The walnut oil can fight fungal infections, reduce signs of ageing and dark circles and is also used as a remedy for psoriasis. ',1),(26,'Amirthum','2021-01-17 17:32:57','Y','N',NULL,NULL,_binary '','Y','Amirutham','CATE00001','PROD00026','For making the Amirutham beard oil, we include 34 types of herbs which are handpicked and then processed with pure cold pressed coconut oil. The prepared oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Beard Oil','The Amirutham beard oil is a conditioner used to moisturize and soften beard hair. It promotes a even beard growth and is also effective in moisturizing the skin beneath your beard.',NULL,'The Amirutham beard oil is a conditioner used to moisturize and soften beard hair. It promotes a even beard growth and is also effective in moisturizing the skin beneath your beard.',1),(27,'Amirthum','2021-01-17 17:35:35','Y','N',NULL,NULL,_binary '','N','Amirutham','CATE00001','PROD00027','For making the neem oil, the handpicked neem seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers.',NULL,'Neem Oil','Cold pressed neem oil is high in fatty acids and other nutrients inspite of its harsh odour. On external application, it relieves joint pains and can be included in the beauty regimen. Neem oil treats dry skin and wrinkles, reduces scars, heals wounds, minimises warts and moles and treats lies and dandruff. ',NULL,'Cold pressed neem oil is high in fatty acids and other nutrients inspite of its harsh odour. On external application, it relieves joint pains and can be included in the beauty regimen. Neem oil treats dry skin and wrinkles, reduces scars, heals wounds, minimises warts and moles and treats lies and dandruff. ',1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_desc` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin role','ROLE_ADMIN'),(2,'User role','ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `sequencecharacter` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sequencecurrentvalue` int DEFAULT NULL,
  `sequencelimitvalue` int DEFAULT NULL,
  `sequencename` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sequencenextvalue` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES (1,NULL,'2020-12-06 16:10:54','Y','N',NULL,'2021-01-17 17:35:35','PROD',27,999999,'PRODUCT',28),(2,NULL,'2020-12-06 16:10:54','Y','N',NULL,'2021-01-17 06:03:03','CATE',2,999999,'CATEGERY',3),(3,NULL,'2020-12-06 16:10:54','Y','N',NULL,'2021-01-17 17:44:08','CART',4,999999,'CART',5),(4,NULL,'2020-12-06 16:10:54','Y','N',NULL,'2021-01-17 17:44:21','AMIR_OD',1,999999,'ORDER',2),(5,NULL,'2020-12-06 16:10:54','Y','N',NULL,'2021-01-17 05:24:54','BANNER',1,999999,'BANNER',2);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `deleted_yn` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `email_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Amirthum','2021-01-17 04:57:59','Y','N',NULL,NULL,'sankaraasn@gmail.com','Sankar','Narayanan','$2a$10$vQQR7/f7ERUpkNHixCPy6eX8XCz27qduOGpk7j6lBjCjeLAqd/lom','9791255264');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_location`
--

DROP TABLE IF EXISTS `user_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_location` (
  `id` bigint NOT NULL,
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2mdfae92my5ewgowa6avt8uof` (`user_id`),
  CONSTRAINT `FK2mdfae92my5ewgowa6avt8uof` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_location`
--

LOCK TABLES `user_location` WRITE;
/*!40000 ALTER TABLE `user_location` DISABLE KEYS */;
INSERT INTO `user_location` VALUES (2,'India',_binary '',1);
/*!40000 ALTER TABLE `user_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userrole` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKf9a7cojfuvf40x6co16kxa1jb` (`role_id`),
  CONSTRAINT `FKf9a7cojfuvf40x6co16kxa1jb` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKtbick5dbrpnos6ll2175dt5qr` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES (1,1);
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification_token`
--

DROP TABLE IF EXISTS `verification_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verification_token` (
  `id` bigint NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_VERIFY_USER` (`user_id`),
  CONSTRAINT `FK_VERIFY_USER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification_token`
--

LOCK TABLES `verification_token` WRITE;
/*!40000 ALTER TABLE `verification_token` DISABLE KEYS */;
INSERT INTO `verification_token` VALUES (3,'2021-01-18 04:58:00','82f433da-03e6-44f8-bd31-167aaeac7e41',1);
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

-- Dump completed on 2021-01-17 23:15:44
