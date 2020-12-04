CREATE DATABASE  IF NOT EXISTS `amirutham` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
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
-- Table structure for table `amir_prod_category`
--

DROP TABLE IF EXISTS `amir_prod_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amir_prod_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) DEFAULT NULL,
  `deleted_yn` varchar(255) DEFAULT NULL,
  `cate_code` varchar(255) DEFAULT NULL,
  `cate_desc` varchar(255) DEFAULT NULL,
  `cate_nme` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `amir_user`
--

DROP TABLE IF EXISTS `amir_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amir_user` (
  `id` int NOT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) DEFAULT NULL,
  `deleted_yn` varchar(255) DEFAULT NULL,
  `amir_user_mail_addr` varchar(255) DEFAULT NULL,
  `amir_user_fst_nm` varchar(255) DEFAULT NULL,
  `amir_user_lst_nm` varchar(255) DEFAULT NULL,
  `amir_user_pwd` varchar(255) DEFAULT NULL,
  `amir_user_phn_nbr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `amir_user_addr`
--

DROP TABLE IF EXISTS `amir_user_addr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amir_user_addr` (
  `id` int NOT NULL,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) DEFAULT NULL,
  `deleted_yn` varchar(255) DEFAULT NULL,
  `amir_user_addr_lne1` varchar(255) DEFAULT NULL,
  `amir_user_addr_lne2` varchar(255) DEFAULT NULL,
  `amir_user_addr_type` varchar(255) DEFAULT NULL,
  `amir_user_addr_city` varchar(255) DEFAULT NULL,
  `amir_user_addr_zipcode` varchar(255) DEFAULT NULL,
  `amir_user_addr_state` varchar(255) DEFAULT NULL,
  `amir_user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKseqrs6ki68abxwgwl4nvtm30p` (`amir_user_id`),
  CONSTRAINT `FKseqrs6ki68abxwgwl4nvtm30p` FOREIGN KEY (`amir_user_id`) REFERENCES `amir_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `amir_user_role`
--

DROP TABLE IF EXISTS `amir_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amir_user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amir_user_rle` varchar(20) DEFAULT NULL,
  `amir_user_rle_dsc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_media_gallary`
--

DROP TABLE IF EXISTS `product_media_gallary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_media_gallary` (
  `prod_med_id` int NOT NULL AUTO_INCREMENT,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) DEFAULT NULL,
  `deleted_yn` varchar(255) DEFAULT NULL,
  `prod_med_nm` varchar(255) DEFAULT NULL,
  `prod_med_file_path` varchar(255) DEFAULT NULL,
  `prod_med_url` varchar(255) DEFAULT NULL,
  `prod_id` int DEFAULT NULL,
  PRIMARY KEY (`prod_med_id`),
  KEY `FK9c8hj2678cwtafn999h1xamys` (`prod_id`),
  CONSTRAINT `FK9c8hj2678cwtafn999h1xamys` FOREIGN KEY (`prod_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_ts` datetime DEFAULT NULL,
  `update_ts` datetime DEFAULT NULL,
  `active_yn` varchar(255) DEFAULT NULL,
  `deleted_yn` varchar(255) DEFAULT NULL,
  `prod_code` varchar(255) DEFAULT NULL,
  `prod_desc` varchar(855) DEFAULT NULL,
  `prod_nme` varchar(255) DEFAULT NULL,
  `prod_ben_use` varchar(855) DEFAULT NULL,
  `cate_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg2u34a9wwxec1jtp9p9l15m4y` (`cate_id`),
  CONSTRAINT `FKg2u34a9wwxec1jtp9p9l15m4y` FOREIGN KEY (`cate_id`) REFERENCES `amir_prod_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK46wdarhhkt7h25466c7n61h2r` (`role_id`),
  CONSTRAINT `FK46wdarhhkt7h25466c7n61h2r` FOREIGN KEY (`role_id`) REFERENCES `amir_user_role` (`id`),
  CONSTRAINT `FKq98yjmbyg8232bh3yn56tt37` FOREIGN KEY (`user_id`) REFERENCES `amir_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-04 22:05:50
