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
-- Dumping data for table `amir_banner`
--

LOCK TABLES `amir_banner` WRITE;
/*!40000 ALTER TABLE `amir_banner` DISABLE KEYS */;
/*!40000 ALTER TABLE `amir_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `amir_prod_category`
--

LOCK TABLES `amir_prod_category` WRITE;
/*!40000 ALTER TABLE `amir_prod_category` DISABLE KEYS */;
INSERT INTO `amir_prod_category` VALUES (1,'2020-12-06 16:57:50',NULL,'Y','N','CATE00001','Amirthum Organic Sugars','Sugar'),(2,'2020-12-06 16:57:50',NULL,'Y','N','CATE00002','Amirthum HerbalPowder Powder','HerbalPowder'),(3,'2020-12-06 16:57:50',NULL,'Y','N','CATE00003','Amirthum Natural Sweetners','NaturalSweetners'),(4,'2020-12-06 16:57:50',NULL,'Y','N','CATE00004','Amirthum Organic Oils','Oils'),(5,'2020-12-06 16:57:50',NULL,'Y','N','CATE00005','Amirthum Seeds','Seed'),(6,'2020-12-06 16:57:50',NULL,'Y','N','CATE00006','Amirthum Organic Soaps','Soap');
/*!40000 ALTER TABLE `amir_prod_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `amir_sequnce`
--

LOCK TABLES `amir_sequnce` WRITE;
/*!40000 ALTER TABLE `amir_sequnce` DISABLE KEYS */;
INSERT INTO `amir_sequnce` VALUES (1,'2020-12-06 16:10:54','2020-12-06 17:31:41','Y','N','PROD',15,999999,'PRODUCT',16),(2,'2020-12-06 16:10:54','2020-12-06 16:57:50','Y','N','CATE',6,999999,'CATEGERY',7);
/*!40000 ALTER TABLE `amir_sequnce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `amir_user`
--

LOCK TABLES `amir_user` WRITE;
/*!40000 ALTER TABLE `amir_user` DISABLE KEYS */;
INSERT INTO `amir_user` VALUES (1,'2020-12-05 09:06:33',NULL,'Y','N','sankaraasn@gmail.com','Mari','selvam','$2a$10$qwdizHk21N.384eDI.gUY.0SsRp9dUIRAGCdfL5JU4vf6g0YME3Wq','9791255264');
/*!40000 ALTER TABLE `amir_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `amir_user_addr`
--

LOCK TABLES `amir_user_addr` WRITE;
/*!40000 ALTER TABLE `amir_user_addr` DISABLE KEYS */;
INSERT INTO `amir_user_addr` VALUES (2,'2020-12-05 09:06:33',NULL,'Y','N','73 KR garden','railway feeder road','Home','virudhunagar','626001','tamilnadu',1),(3,'2020-12-05 09:06:34',NULL,'Y','N','74 KR garden','railway feeder road','WORK','virudhunagar','626001','tamilnadu',1);
/*!40000 ALTER TABLE `amir_user_addr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `amir_user_role`
--

LOCK TABLES `amir_user_role` WRITE;
/*!40000 ALTER TABLE `amir_user_role` DISABLE KEYS */;
INSERT INTO `amir_user_role` VALUES (4,'Admin role','ROLE_ADMIN'),(5,'User role','ROLE_USER');
/*!40000 ALTER TABLE `amir_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_media_gallary`
--

LOCK TABLES `product_media_gallary` WRITE;
/*!40000 ALTER TABLE `product_media_gallary` DISABLE KEYS */;
INSERT INTO `product_media_gallary` VALUES (1,'2020-12-06 17:12:32',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',1),(2,'2020-12-06 17:12:32',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',1),(3,'2020-12-06 17:15:46',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',2),(4,'2020-12-06 17:15:46',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',2),(5,'2020-12-06 17:15:57',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',3),(6,'2020-12-06 17:15:57',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',3),(7,'2020-12-06 17:16:09',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',4),(8,'2020-12-06 17:16:09',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',4),(9,'2020-12-06 17:16:23',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',5),(10,'2020-12-06 17:16:23',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',5),(11,'2020-12-06 17:23:39',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',6),(12,'2020-12-06 17:23:39',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',6),(13,'2020-12-06 17:23:53',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',7),(14,'2020-12-06 17:23:53',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',7),(15,'2020-12-06 17:24:09',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',8),(16,'2020-12-06 17:24:09',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',8),(17,'2020-12-06 17:24:23',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',9),(18,'2020-12-06 17:24:23',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',9),(19,'2020-12-06 17:24:35',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',10),(20,'2020-12-06 17:24:35',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',10),(21,'2020-12-06 17:31:00',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',11),(22,'2020-12-06 17:31:00',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',11),(23,'2020-12-06 17:31:13',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',12),(24,'2020-12-06 17:31:13',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',12),(25,'2020-12-06 17:31:22',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',13),(26,'2020-12-06 17:31:22',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',13),(27,'2020-12-06 17:31:32',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',14),(28,'2020-12-06 17:31:32',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',14),(29,'2020-12-06 17:31:41',NULL,'Y','N','New Doc 2019-01-21 09.59.28_1.jpg','C:\\catalogs\\New Doc 2019-01-21 09.59.28_1.jpg',38524,'image/jpeg','http://localhost:8085/products/downloadFile/New%20Doc%202019-01-21%2009.59.28_1.jpg',15),(30,'2020-12-06 17:31:41',NULL,'Y','N','pho.jpg','C:\\catalogs\\pho.jpg',24845,'image/jpeg','http://localhost:8085/products/downloadFile/pho.jpg',15);
/*!40000 ALTER TABLE `product_media_gallary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'2020-12-06 17:12:32',NULL,'Y','N','PROD00001','Jaggery is popularly used as a natural sugar substitute. It is obtained from the concentrated cane sugar without separation of the molasses and crystals. The Amirutham Jaggery is made by evaporating the water from concentrated sugar cane juice and solidifying it.','Jaggery',NULL,1),(2,'2020-12-06 17:15:46',NULL,'Y','N','PROD00002','Brown sugar is a sucrose sugar product with a distinctive brown color due to the presence of molasses. It is unrefined soft sugar and has more liquid and has around 0.25 fewer calories per gram than white sugar. ','Brown Sugar',NULL,1),(3,'2020-12-06 17:15:57',NULL,'Y','N','PROD00003','Palm jaggery is a much sweeter variant of jaggery, which has a melt-in the mouth texture. This form of jaggery is made by extracting sap of palm which is manually boiled and churned to make the jaggery. Palm jaggery is considered to be better than the sugar cane jaggery because of its high medicinal properties.  ','Palm Jaggery',NULL,1),(4,'2020-12-06 17:16:09',NULL,'Y','N','PROD00004','Palm Candy has a number of minerals, vitamins, calcium, iron and phyto nutrients including zinc and potassium. It is a good source of Vitamin B1, B2, B3, B6 and B12. The sugar content in palm sugar is well balanced and it is a great natural substitute for sugar. ','Palm Candy – Small',NULL,1),(5,'2020-12-06 17:16:23',NULL,'Y','N','PROD00005','Palm Candy has a number of minerals, vitamins, calcium, iron and phyto nutrients including zinc and potassium. It is a good source of Vitamin B1, B2, B3, B6 and B12. The sugar content in palm sugar is well balanced and it is a great natural substitute for sugar. ','Palm Candy – Big',NULL,1),(6,'2020-12-06 17:23:39',NULL,'Y','N','PROD00006','The ashwagandha also known as the Indian ginseng is ancient medicinal herb with multiple health benefits.','Ashwagandha Powder',NULL,2),(7,'2020-12-06 17:23:53',NULL,'Y','N','PROD00007','The kadukkai powder also known Harad is made by grinding freshly obtained haritaki into fine powder.','Kadukkai Powder',NULL,2),(8,'2020-12-06 17:24:09',NULL,'Y','N','PROD00008','The fully grown moringa leaves from the homegrown moringa trees are plucked, sundried and grinded to fine powder.The moringa powder has vital mineral and vitamins. This leaf is said to possess 7 times more Vitamin C than oranges and 15 times more potassium than bananas. It has calcium, protein, iron, and amino acids, which heals body and helps in muscle building. ','Moringa Powder',NULL,2),(9,'2020-12-06 17:24:23',NULL,'Y','N','PROD00009','Arappu powder is made from the leaves of the arappu tree. When the leaves are fully grown, its plucked, sundried and made into fine powder. ','Arappu',NULL,2),(10,'2020-12-06 17:24:35',NULL,'Y','N','PROD00010','When it comes to external application, Kasturi Manjal is the king as it does not stain the skin like the regular turmeric. In addition to this, Kasturi Manjal has a pleasant fragrance to it and antibacterial and anti-inflammation properties.  ','Kasturi Manjal (Wild Turmeric)',NULL,2),(11,'2020-12-06 17:31:00',NULL,'Y','N','PROD00011','For making the sesame oil, the cleaned sesame seeds and palm jaggery are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction.','Sesame Oil',NULL,4),(12,'2020-12-06 17:31:13',NULL,'Y','N','PROD00012','For making the coconut oil, the cleaned coconut coprais are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction.','Coconut Oil',NULL,4),(13,'2020-12-06 17:31:22',NULL,'Y','N','PROD00013','For making the groundnut oil, the cleaned raw groundnuts are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction.','Groundnut Oil',NULL,4),(14,'2020-12-06 17:31:32',NULL,'Y','N','PROD00014','For making the mustard oil, the handpicked mustard seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction. ','Mustard Oil',NULL,4),(15,'2020-12-06 17:31:41',NULL,'Y','N','PROD00015','For making the flax seed oil, the handpicked flax seeds are crushed using the wooden cold press machine. The extracted oil is left for sedimentation before we pack it in bottles and offer it to our customers. The raw materials for these oils are hand-picked from farmers cultivating it and are cleaned in a highly sanitized area by our team before using it for oil extraction. ','Flax seed Oil',NULL,4);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,4);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-06 23:03:19
