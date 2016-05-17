CREATE DATABASE  IF NOT EXISTS `timetableplanner_big` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `timetableplanner_big`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: timetableplanner_big
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'ROLE_SYS_ADMIN'),(2,'ROLE_LECTURER'),(3,'ROLE_DEP_TIMETABLE_RESP'),(4,'ROLE_DEGREE_RESP'),(5,'ROLE_COURSE_RESP'),(6,'ROLE_ADMINISTRATOR');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `credit` int(11) NOT NULL,
  `curricula` int(11) DEFAULT NULL,
  `hours_per_week` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `period` int(11) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `responsible` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rljyeum2tn724mapjdd3d34qr` (`responsible`),
  CONSTRAINT `FK_rljyeum2tn724mapjdd3d34qr` FOREIGN KEY (`responsible`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=522 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,4,2011,4,'A programozás alapjai',2,'kötelező',1),(2,4,2011,4,'Tájékoztatás, információforrások 3',2,'kötelező',NULL),(3,4,2011,4,'Multimédia',2,'szabadon választható',NULL),(4,2,2011,4,'Webdesign',2,'kötelező',NULL),(5,4,2011,4,'Elektronikus könyvtári gyűjtemények',2,'kötelező',NULL),(6,4,2011,4,'Különgyűjtemények',2,'kötelező',NULL),(7,4,2011,4,'Az ifjúság könyvtári ellátása',2,'kötelező',NULL),(8,4,2011,4,'Projektmenedzsment',2,'kötelező',NULL),(9,4,2007,4,'Információelmélet',2,'kötelező',NULL),(10,3,2007,4,'Statisztika számítógéppel',2,'kötelező',NULL),(11,3,2007,4,'A valószínűségszámítás alkalmazásai',2,'kötelező',NULL),(12,4,2007,4,'Szoftverfejlesztés mobil eszközökre',2,'kötelező',NULL),(13,3,2007,4,'Tartalomszolgáltatás',2,'kötelező',NULL),(14,4,2007,4,'E-menedzsment',2,'kötelező',NULL),(15,3,2007,4,'Kódelmélet',1,'kötelező',NULL),(16,6,2007,4,'Adatbiztonság',1,'kötelező',NULL),(17,4,2007,4,'Nemzetközi marketing',1,'kötelező',NULL),(18,3,2010,4,'Információelmélet',1,'kötelező',NULL),(19,3,2010,4,'A valószínűségszámítás alkalmazásai',1,'kötelező',NULL),(20,5,2010,4,'Szoftverfejlesztés mobil eszközökre',1,'kötelező',NULL),(21,3,2010,4,'Tartalomszolgáltatás',1,'kötelező',NULL),(22,4,2010,4,'E-menedzsment',1,'kötelező',NULL),(23,3,2010,4,'Kódelmélet',1,'kötelező',NULL),(24,7,2010,4,'Adatbiztonság',1,'kötelező',NULL),(25,4,2010,4,'Nemzetközi marketing',1,'kötelező',NULL),(26,3,2010,4,'Statisztika számítógéppel',1,'kötelező',NULL),(27,5,2007,4,'Gazdasági matematika 1',1,'kötelező',NULL),(28,4,2007,4,'Az informatika logikai alapjai',1,'kötelező',NULL),(29,3,2007,4,'Bevezetés a közgazdaságtanba',1,'kötelező',NULL),(30,3,2007,4,'Vállalatgazdaságtan',1,'kötelező',NULL),(31,4,2007,4,'Szervezeti magatartás',1,'kötelező',NULL),(32,5,2007,4,'Számvitel 1',1,'kötelező',NULL),(33,5,2007,4,'Magas szintű programozási nyelvek 1',1,'kötelező',NULL),(34,4,2007,4,'Emberi erőforrás menedzsment',1,'kötelező',NULL),(35,5,2007,4,'Gazdasági matematika 2',1,'kötelező',NULL),(36,4,2007,4,'Operációs rendszerek 1',1,'kötelező',NULL),(37,4,2007,4,'Adatszerkezetek és algoritmusok',1,'kötelező',NULL),(38,5,2007,4,'Mikroökonómia',1,'kötelező',NULL),(39,3,2007,4,'Gazdasági magánjog',1,'kötelező',NULL),(40,5,2007,4,'Magas szintű programozási nyelvek 2',1,'kötelező',NULL),(41,5,2007,4,'Statisztika 1',1,'kötelező',NULL),(42,4,2007,4,'Operációs rendszerek 2',1,'kötelező',NULL),(43,5,2007,4,'Makroökonómia',1,'kötelező',NULL),(44,4,2007,4,'Marketing',1,'kötelező',NULL),(45,4,2007,4,'Vállalati pénzügyek 1',1,'kötelező',NULL),(46,5,2007,4,'Statisztika 2',1,'kötelező',NULL),(47,4,2007,4,'Numerikus matematika',1,'kötelező',NULL),(48,6,2007,4,'Programozás labor 1',1,'kötelező',NULL),(49,3,2007,4,'Számításelmélet',1,'kötelező',NULL),(50,5,2007,4,'A mesterséges intelligencia alapjai',1,'kötelező',NULL),(51,5,2007,4,'Adatbázisrendszerek',1,'kötelező',NULL),(52,4,2007,4,'Hálózati architektúrák és protokollok',1,'kötelező',NULL),(53,4,2007,4,'EU ismeretek',1,'kötelező',NULL),(54,2,2007,4,'Az informatikai biztonság alapjai',1,'kötelező',NULL),(55,2,2007,4,'Informatikai rendszerek modellezése és analízise',1,'kötelező',NULL),(56,4,2007,4,'Adatkezelés',1,'kötelező',NULL),(57,2,2007,4,'Döntéstámogató rendszerek',1,'kötelező',NULL),(58,2,2007,4,'Infokommunikációs rendszerek üzemeltetése',1,'szabadon választható',NULL),(59,2,2007,4,'Informatikai versenyfeladatok',1,'szabadon választható',NULL),(60,2,2007,4,'Bevezetés a Python programozási nyelvbe',1,'szabadon választható',NULL),(61,5,2010,4,'Gazdasági matematika 1',1,'kötelező',NULL),(62,5,2010,4,'Az informatika logikai alapjai',1,'kötelező',NULL),(63,3,2010,4,'Bevezetés a közgazdaságtanba',1,'kötelező',NULL),(64,3,2010,4,'Vállalatgazdaságtan',1,'kötelező',NULL),(65,4,2010,4,'Szervezeti magatartás',1,'kötelező',NULL),(66,5,2010,4,'Magas szintű programozási nyelvek 1',1,'kötelező',NULL),(67,5,2010,4,'Magas szintű programozási nyelvek 1',2,'kötelező',NULL),(68,5,2010,2,'Gazdasági matematika 2',2,'kötelező',NULL),(69,5,2010,2,'Operációs rendszerek 1',2,'kötelező',NULL),(70,5,2010,2,'Adatszerkezetek és algoritmusok',2,'kötelező',NULL),(71,5,2010,2,'Mikroökonómia',1,'kötelező',NULL),(72,3,2010,2,'Gazdasági magánjog',1,'kötelező',NULL),(73,5,2010,3,'Magas szintű programozási nyelvek 2',1,'kötelező',NULL),(74,5,2010,3,'Statisztika 1',1,'kötelező',NULL),(75,5,2010,3,'Operációs rendszerek 2',1,'kötelező',NULL),(76,5,2010,3,'Makroökonómia',1,'kötelező',NULL),(77,4,2010,3,'Marketing',1,'kötelező',NULL),(78,5,2010,3,'Számvitel 1',1,'kötelező',NULL),(79,4,2010,3,'Vállalati pénzügyek 1',1,'kötelező',NULL),(80,5,2010,4,'Statisztika 2',1,'kötelező',NULL),(81,5,2010,4,'Numerikus matematika',1,'kötelező',NULL),(82,6,2010,4,'Programozás labor 1',1,'kötelező',NULL),(83,3,2010,4,'Számításelmélet',1,'kötelező',NULL),(84,5,2010,4,'A mesterséges intelligencia alapjai',1,'kötelező',NULL),(85,5,2010,4,'Adatbázisrendszerek',1,'kötelező',NULL),(86,5,2010,4,'Hálózati architektúrák és protokollok',1,'kötelező',NULL),(87,3,2010,4,'EU ismeretek',1,'kötelező',NULL),(88,3,2010,6,'Az informatikai biztonság alapjai',1,'kötelező',NULL),(89,5,2010,6,'Adatkezelés',1,'kötelező',NULL),(90,3,2010,7,'Döntéstámogató rendszerek',1,'kötelező',NULL),(91,2,2010,2,'Infokommunikációs rendszerek üzemeltetése',1,'szabadon választható',NULL),(92,4,2010,2,'Emberi erőforrás menedzsment',1,'szabadon választható',NULL),(93,2,2010,2,'Informatikai versenyfeladatok',1,'szabadon választható',NULL),(94,2,2010,2,'Bevezetés a Python programozási nyelvbe',1,'szabadon választható',NULL),(95,6,2009,2,'Adat- és rendszermodellek',1,'szabadon választható',NULL),(96,5,2009,2,'Haladó módszertani ismeretek',1,'szabadon választható',NULL),(97,5,2009,2,'Termelés- és folyamatmenedzsment',1,'szabadon választható',NULL),(98,6,2009,2,'Adatbányászat',1,'kötelező',NULL),(99,5,2009,2,'Haladó stratégiai menedzsment',1,'kötelező',NULL),(100,5,2009,2,'Kontrolling',1,'kötelező',NULL),(101,6,2009,2,'Adatvédelem, adatbiztonság',1,'kötelező',NULL),(102,15,2009,3,'Diplomamunka 1',1,'kötelező',NULL),(103,15,2009,4,'Diplomamunka 2',1,'kötelező',NULL),(104,2,2009,4,'C, C++ esettanulmányok',1,'szabadon választható',NULL),(105,4,2009,4,'Programozás GNU/Linux környezetben',1,'szabadon választható',NULL),(106,2,2009,2,'Genetikus algoritmusok',1,'szabadon választható',NULL),(107,6,2009,2,'Prototípuskészítés Verilog nyelven',1,'szabadon választható',NULL),(108,6,2009,2,'Hálózatok teljesítményelemzése',1,'szabadon választható',NULL),(109,6,2009,2,'Kommunikációs eszközök és technológiák',1,'szabadon választható',NULL),(110,6,2009,2,'Párhuzamos programozás',1,'szabadon választható',NULL),(111,6,2009,3,'Térinformatika',1,'szabadon választható',NULL),(112,4,2009,3,'Új számítási paradigmák',1,'szabadon választható',NULL),(113,6,2009,3,'Mikrokontrollerek programozása',1,'szabadon választható',NULL),(114,2,2009,4,'Új irányzatok a hardverfejlesztésben',1,'szabadon választható',NULL),(115,6,2009,4,'Perifériák és meghajtóik',1,'szabadon választható',NULL),(116,4,2009,4,'Bioinformatika',1,'szabadon választható',NULL),(117,6,2009,4,'Nukleáris orvosi képalkotó eszközök',1,'szabadon választható',NULL),(118,4,2009,4,'Ismeretalapú technológia',1,'szabadon választható',NULL),(119,6,2009,4,'Játékelmélet',1,'szabadon választható',NULL),(120,2,2009,4,'Bevezetés a robotikába',1,'szabadon választható',NULL),(121,6,2009,4,'Formális nyelvek kombinatorikus és algoritmikus tulajdonságai',1,'kötelező',NULL),(122,4,2009,4,'Többértékű logikák',1,'kötelező',NULL),(123,6,2009,4,'Párhuzamos és osztott algoritmusok',1,'kötelező',NULL),(124,2,2009,4,'Gráfalgoritmusok',1,'kötelező',NULL),(125,6,2009,4,'Sztringalgoritmusok',1,'kötelező',NULL),(126,4,2009,4,'Adatsűrítés',1,'kötelező',NULL),(127,6,2009,4,'Vállalati hálózatok kialakítása HP Networking alapokon',1,'kötelező',NULL),(128,6,2009,3,'Adat- és rendszermodellek',1,'kötelező',NULL),(129,6,2009,4,'Szemantikus web',1,'kötelező',NULL),(130,2,2009,4,'E-learning',1,'kötelező',NULL),(131,4,2009,4,'E-menedzsment',1,'kötelező',NULL),(132,2,2009,4,'Az Európai Unió intézményrendszere és információforrásai 2',1,'kötelező',NULL),(133,6,2009,4,'Térinformatika',1,'kötelező',NULL),(134,4,2009,4,'Ismeretalapú technológia',1,'kötelező',NULL),(135,2,2007,4,'Önálló projektfejlesztés',1,'kötelező',NULL),(136,6,2007,4,'Távközlő hálózatok',1,'kötelező',NULL),(137,4,2007,4,'Önálló laboratórium 2',1,'kötelező',NULL),(138,4,2007,4,'Információ- és kódelmélet',1,'kötelező',NULL),(139,4,2007,4,'Bevezetés a Cisco eszközök programozásába 2',1,'kötelező',NULL),(140,4,2007,4,'Bevezetés a Cisco eszközök programozásába 3',1,'kötelező',NULL),(141,4,2007,4,'Nagysebességű hálózatok',1,'kötelező',NULL),(142,3,2007,4,'Hálózatmodellezés',1,'szabadon választható',NULL),(143,2,2007,4,'Számítógépes tervezés',1,'szabadon választható',NULL),(144,5,2007,4,'Logikai tervezés programozható áramkörökkel',1,'szabadon választható',NULL),(145,5,2007,4,'Újrakonfigurálható beágyazott rendszerek',1,'szabadon választható',NULL),(146,2,2007,4,'LAN hálózatok felépítése ProCurve eszközökkel 1',1,'szabadon választható',NULL),(147,5,2009,4,'Távközlő hálózatok',1,'kötelező',NULL),(148,4,2009,6,'Önálló laboratórium 2',1,'kötelező',NULL),(149,4,2009,6,'Információ- és kódelmélet',1,'kötelező',NULL),(150,6,2009,6,'Multimédia',1,'kötelező',NULL),(151,4,2009,6,'Bevezetés a Cisco eszközök programozásába 2',1,'kötelező',NULL),(152,6,2009,7,'Adatbiztonság',1,'kötelező',NULL),(153,4,2009,7,'Nagysebességű hálózatok',1,'kötelező',NULL),(154,2,2009,2,'Önálló projektfejlesztés',1,'szabadon választható',NULL),(155,4,2009,2,'Bevezetés a Cisco eszközök programozásába 3',1,'szabadon választható',NULL),(156,3,2009,2,'Hálózatmodellezés',1,'szabadon választható',NULL),(157,2,2009,2,'Számítógépes tervezés',1,'szabadon választható',NULL),(158,5,2009,2,'Logikai tervezés programozható áramkörökkel',1,'szabadon választható',NULL),(159,5,2009,2,'Újrakonfigurálható beágyazott rendszerek',2,'szabadon választható',NULL),(160,3,2009,2,'Hálózatmodellezés',2,'szabadon választható',NULL),(161,2,2009,2,'LAN hálózatok felépítése ProCurve eszközökkel 1',2,'szabadon választható',NULL),(162,4,2007,2,'Információs rendszerek architektúrái',2,'kötelező',NULL),(163,6,2007,2,'Információs rendszerek menedzselése',2,'kötelező',NULL),(164,6,2007,2,'Adatbányászat',2,'kötelező',NULL),(165,6,2007,2,'Szoftverrendszerek tervezése',2,'kötelező',NULL),(166,4,2007,2,'Szoftverminőség-biztosítás',2,'kötelező',NULL),(167,4,2007,2,'Ismeretalapú technológia',2,'kötelező',NULL),(168,4,2007,4,'Információs rendszerek implementációs kérdései',2,'kötelező',NULL),(169,6,2007,4,'Statisztikus tanuló algoritmusok',2,'szabadon választható',NULL),(170,6,2007,4,'Adatvédelem, adatbiztonság',2,'szabadon választható',NULL),(171,4,2007,4,'Bioinformatika',2,'szabadon választható',NULL),(172,6,2007,4,'Információs rendszerek a gyakorlatban',2,'szabadon választható',NULL),(173,6,2007,4,'A képfeldolgozás matematikája',2,'szabadon választható',NULL),(174,6,2007,4,'Térinformatika',2,'szabadon választható',NULL),(175,6,2007,4,'Nukleáris orvosi képalkotó eszközök',2,'szabadon választható',NULL),(176,6,2007,4,'Automatikus tételbizonyítás',2,'szabadon választható',NULL),(177,6,2007,4,'Játékelmélet',2,'szabadon választható',NULL),(178,2,2007,4,'Bevezetés a robotikába',2,'szabadon választható',NULL),(179,4,2007,4,'Algoritmus- és bonyolultságelmélet',2,'szabadon választható',NULL),(180,6,2007,4,'Formális nyelvek kombinatorikus és algoritmikus tulajdonságai',2,'szabadon választható',NULL),(181,4,2007,4,'Többértékű logikák',2,'szabadon választható',NULL),(182,4,2007,4,'Új számítási paradigmák',2,'szabadon választható',NULL),(183,6,2007,4,'Párhuzamos és osztott algoritmusok',2,'szabadon választható',NULL),(184,2,2007,4,'Gráfalgoritmusok',2,'szabadon választható',NULL),(185,6,2007,4,'Sztringalgoritmusok',2,'szabadon választható',NULL),(186,4,2007,4,'Adatsűrítés',2,'szabadon választható',NULL),(187,6,2007,4,'Hálózatok teljesítményelemzése',2,'szabadon választható',NULL),(188,2,2007,4,'Ismeretalapú rendszer esettanulmány',2,'szabadon választható',NULL),(189,3,2007,1,'Bevezetés az esztétikába',2,'kötelező',NULL),(190,3,2007,2,'Írás-, könyv-, sajtó- és könyvtártörténet 2',2,'kötelező',NULL),(191,2,2007,2,'Olvasásszociológia, -pedagógia és -pszichológia',2,'kötelező',NULL),(192,3,2007,2,'Bibliográfiai adatfeldolgozás 2',2,'kötelező',NULL),(193,2,2007,2,'Könyvtártan 2',2,'kötelező',NULL),(194,2,2007,2,'Információkereső nyelvek 2',2,'kötelező',NULL),(195,2,2007,2,'Szövegfeldolgozás 2',2,'kötelező',NULL),(196,4,2007,2,'Tájékoztatás, információforrások 1',2,'kötelező',NULL),(197,2,2007,2,'Az informatika matematikai alapjai 2',2,'kötelező',NULL),(198,3,2007,2,'A pszichológia főbb területei',2,'kötelező',NULL),(199,3,2007,2,'Szigorlat 1',2,'kötelező',NULL),(200,4,2007,4,'Könyvtári gyakorlat 1',2,'kötelező',NULL),(201,3,2007,4,'Információs rendszerek 1',2,'kötelező',NULL),(202,4,2007,4,'Hálózati ismeretek',2,'kötelező',NULL),(203,2,2007,4,'Információs rendszerek 2',2,'kötelező',NULL),(204,2,2007,4,'Adatbáziskezelés és könyvtári rendszerszervezés 2',2,'kötelező',NULL),(205,3,2007,4,'Szigorlat 2',2,'kötelező',NULL),(206,2,2007,4,'Menedzsment',2,'kötelező',NULL),(207,6,2007,4,'Könyvtári gyakorlat 2',2,'kötelező',NULL),(208,5,2007,4,'Könyvtári gyakorlat 3',2,'kötelező',NULL),(209,2,2007,4,'Európai uniós információforrások',2,'kötelező',NULL),(210,2,2007,4,'Fejezetek a könyvtár-informatikából',2,'kötelező',NULL),(211,2,2007,4,'Etikett, protokoll 2',2,'kötelező',NULL),(212,3,2009,2,'Írás-, könyv-, sajtó- és könyvtártörténet 2',2,'kötelező',NULL),(213,2,2009,2,'Olvasásszociológia, -pedagógia és -pszichológia',2,'kötelező',NULL),(214,4,2009,2,'Bibliográfiai adatfeldolgozás 2',2,'kötelező',NULL),(215,2,2009,2,'Könyvtártan 2',2,'kötelező',NULL),(216,2,2009,2,'Információkereső nyelvek 2',2,'kötelező',NULL),(217,2,2009,2,'Szövegfeldolgozás 2',2,'kötelező',NULL),(218,4,2009,2,'Tájékoztatás, információforrások 1',2,'kötelező',NULL),(219,2,2009,2,'Az informatika matematikai alapjai 2',2,'kötelező',NULL),(220,3,2009,2,'A pszichológia főbb területei',2,'kötelező',NULL),(221,6,2009,2,'Könyvtári gyakorlat 1',2,'kötelező',NULL),(222,4,2009,2,'Könyvtári gyakorlat 2',2,'kötelező',NULL),(223,3,2009,2,'Információs rendszerek 1',2,'kötelező',NULL),(224,3,2009,2,'Hálózati ismeretek',2,'kötelező',NULL),(225,4,2009,4,'Könyvtári gyakorlat 3',2,'kötelező',NULL),(226,2,2009,4,'Információs rendszerek 2',2,'kötelező',NULL),(227,3,2009,4,'Adatbáziskezelés és könyvtári rendszerszervezés 2',2,'kötelező',NULL),(228,3,2009,4,'Menedzsment',2,'kötelező',NULL),(229,8,2009,4,'Könyvtári gyakorlat 4',2,'kötelező',NULL),(230,2,2009,4,'Bevezetés az esztétikába',2,'kötelező',NULL),(231,2,2009,4,'Európai uniós információforrások',2,'kötelező',NULL),(232,2,2009,4,'Fejezetek a könyvtár-informatikából',2,'kötelező',NULL),(233,2,2009,4,'Etikett, protokoll 2',2,'kötelező',NULL),(234,3,2012,2,'Írás-, könyv-, sajtó- és könyvtártörténet 2',2,'kötelező',NULL),(235,2,2012,2,'Olvasásszociológia, -pedagógia és -pszichológia',2,'kötelező',NULL),(236,5,2012,2,'Bibliográfiai adatfeldolgozás 2',2,'kötelező',NULL),(237,3,2012,2,'Könyvtártan 2',2,'kötelező',NULL),(238,5,2012,2,'Információkereső nyelvek 2',2,'kötelező',NULL),(239,5,2012,2,'Az informatika matematikai alapjai 2',2,'kötelező',NULL),(240,5,2012,2,'A programozás alapjai',2,'kötelező',NULL),(241,3,2012,2,'A pszichológia főbb területei',2,'kötelező',NULL),(242,3,2012,4,'Könyvtári gyakorlat 3',2,'kötelező',NULL),(243,6,2012,2,'Gazdasági matematika 2',2,'kötelező',NULL),(244,2,2012,2,'A tudás reprezentálása a világhálón és az internetes keresőrendszerek működése',2,'kötelező',NULL),(245,4,2012,2,'Tájékoztatási intézmények, eszközök itthon és külföldön',2,'kötelező',NULL),(246,4,2012,2,'Logika',2,'kötelező',NULL),(247,4,2012,2,'Vállalatgazdaságtan',2,'kötelező',NULL),(248,4,2012,2,'Információ- és tudásmenedzsment a könyvtárakban',2,'kötelező',NULL),(249,4,2012,2,'Megismeréstudomány',2,'kötelező',NULL),(250,2,2009,2,'Szigorlat A',2,'kötelező',NULL),(251,2,2009,2,'Logika',2,'kötelező',NULL),(252,3,2009,2,'Információ- és tudásmenedzsment a könyvtárakban',2,'kötelező',NULL),(253,3,2009,2,'Megismeréstudomány',2,'kötelező',NULL),(254,10,2009,2,'Diplomamunka 1',2,'kötelező',NULL),(255,10,2009,2,'Diplomamunka 2',2,'kötelező',NULL),(256,5,2009,2,'Gazdasági matematika 2',2,'kötelező',NULL),(257,4,2009,2,'Dinamikus weblapok készítése',2,'kötelező',NULL),(258,2,2009,2,'Szigorlat B',2,'kötelező',NULL),(259,4,2009,3,'Multimédia',2,'kötelező',NULL),(260,4,2009,4,'Szigorlat 1',2,'kötelező',NULL),(261,4,2009,4,'Szigorlat 2',2,'kötelező',NULL),(262,4,2009,4,'Szigorlat 3',2,'kötelező',NULL),(263,6,2009,4,'A képfeldolgozás matematikája',2,'kötelező',NULL),(264,6,2009,4,'Geometriai alapozás a komputergrafikához',2,'kötelező',NULL),(265,6,2009,4,'Alakfelismerés',2,'kötelező',NULL),(266,6,2009,4,'Térinformatika',2,'kötelező',NULL),(267,6,2009,4,'Statisztikus tanuló algoritmusok',2,'kötelező',NULL),(268,6,2009,4,'Görbék és felületek modellezése',2,'kötelező',NULL),(269,6,2009,2,'Adatvédelem, adatbiztonság',2,'szabadon választható',NULL),(270,4,2009,2,'Bioinformatika',2,'szabadon választható',NULL),(271,6,2009,2,'Adatbányászat',2,'szabadon választható',NULL),(272,6,2009,2,'Nukleáris orvosi képalkotó eszközök',2,'szabadon választható',NULL),(273,4,2009,2,'Ismeretalapú technológia',2,'szabadon választható',NULL),(274,6,2009,2,'Játékelmélet',2,'szabadon választható',NULL),(275,2,2009,2,'Bevezetés a robotikába',2,'szabadon választható',NULL),(276,6,2009,2,'Formális nyelvek kombinatorikus és algoritmikus tulajdonságai',2,'szabadon választható',NULL),(277,4,2009,2,'Többértékű logikák',2,'szabadon választható',NULL),(278,4,2009,2,'Új számítási paradigmák',2,'szabadon választható',NULL),(279,6,2009,2,'Párhuzamos és osztott algoritmusok',2,'szabadon választható',NULL),(280,2,2009,2,'Gráfalgoritmusok',2,'szabadon választható',NULL),(281,6,2009,2,'Sztringalgoritmusok',2,'szabadon választható',NULL),(282,4,2009,2,'Adatsűrítés',2,'szabadon választható',NULL),(283,6,2009,2,'Hálózatok teljesítményelemzése',2,'szabadon választható',NULL),(284,4,2009,2,'Multimédia',2,'kötelező',NULL),(285,4,2009,4,'Iskolai könyvtár 2',2,'kötelező',NULL),(286,3,2009,4,'Iskolai gyakorlat',2,'kötelező',NULL),(287,2,2009,4,'E-learning',2,'kötelező',NULL),(288,2,2009,4,'Információ- és tudásmenedzsment a könyvtárakban',2,'kötelező',NULL),(289,3,2009,4,'Zárószigorlat',2,'kötelező',NULL),(290,4,2007,4,'Önálló laboratórium 2',2,'kötelező',NULL),(291,3,2007,4,'Mikrokontrollerek',2,'kötelező',NULL),(292,5,2007,4,'Méréstechnika',2,'kötelező',NULL),(293,3,2007,4,'Érzékelők és beavatkozók',2,'kötelező',NULL),(294,5,2007,4,'DSP, digitális jelfeldolgozás és jelprocesszorok',2,'kötelező',NULL),(295,6,2007,4,'Távközlő hálózatok',2,'kötelező',NULL),(296,2,2007,4,'Számítógépes tervezés',2,'kötelező',NULL),(297,5,2007,4,'Logikai tervezés programozható áramkörökkel',2,'kötelező',NULL),(298,5,2007,4,'Újrakonfigurálható beágyazott rendszerek',2,'kötelező',NULL),(299,4,2009,4,'Önálló laboratórium 2',2,'kötelező',NULL),(300,3,2009,4,'Mikrokontrollerek',2,'kötelező',NULL),(301,5,2009,4,'DSP, digitális jelfeldolgozás és jelprocesszorok',2,'kötelező',NULL),(302,5,2009,4,'Méréstechnika',2,'kötelező',NULL),(303,3,2009,4,'Érzékelők és beavatkozók',2,'kötelező',NULL),(304,6,2009,4,'Távközlő hálózatok',2,'kötelező',NULL),(305,2,2009,4,'Számítógépes tervezés',2,'kötelező',NULL),(306,5,2009,4,'Logikai tervezés programozható áramkörökkel',2,'kötelező',NULL),(307,4,2007,4,'Diszkrét matematika 1',2,'kötelező',NULL),(308,4,2007,4,'Kalkulus 1',2,'kötelező',NULL),(309,4,2007,4,'Bevezetés az informatikába',2,'kötelező',NULL),(310,4,2007,4,'Az informatika logikai alapjai',2,'kötelező',NULL),(311,4,2007,4,'Fizika 1',2,'kötelező',NULL),(312,3,2007,4,'Elektronika 1',2,'kötelező',NULL),(313,5,2007,4,'Magas szintű programozási nyelvek 1',2,'kötelező',NULL),(314,4,2007,4,'Kalkulus 2',2,'kötelező',NULL),(315,4,2007,4,'Operációs rendszerek',2,'kötelező',NULL),(316,4,2007,4,'Adatszerkezetek és algoritmusok',2,'kötelező',NULL),(317,2,2007,4,'Elektronika 2',2,'kötelező',NULL),(318,2,2007,4,'Digitális technika',2,'kötelező',NULL),(319,4,2007,4,'Diszkrét matematika 2',2,'kötelező',NULL),(320,5,2007,4,'Magas szintű programozási nyelvek 2',2,'kötelező',NULL),(321,5,2007,4,'Adatbázisrendszerek',2,'kötelező',NULL),(322,0,2007,4,'Szigorlat',2,'kötelező',NULL),(323,4,2007,4,'Valószínűségszámítás és matematikai statisztika',2,'kötelező',NULL),(324,4,2007,4,'Bevezetés a számítógépi grafikába',2,'kötelező',NULL),(325,4,2007,4,'Hálózati architektúrák',2,'kötelező',NULL),(326,2,2007,4,'Jelek és rendszerek',2,'kötelező',NULL),(327,3,2007,4,'Számításelmélet',2,'kötelező',NULL),(328,5,2007,4,'A mesterséges intelligencia alapjai',2,'kötelező',NULL),(329,2,2007,4,'Az informatikai biztonság alapjai',2,'kötelező',NULL),(330,2,2007,4,'Vállalati információs rendszerek',2,'kötelező',NULL),(331,2,2007,4,'Informatikai rendszerek modellezése, analízise',2,'kötelező',NULL),(332,2,2007,4,'Elektronika labor',2,'kötelező',NULL),(333,4,2007,4,'Irányítástechnika',2,'kötelező',NULL),(334,6,2007,4,'Programozás labor 1',2,'kötelező',NULL),(335,2,2007,4,'Döntéstámogató rendszerek',2,'kötelező',NULL),(336,2,2007,4,'Társadalomismeretek',2,'kötelező',NULL),(337,3,2007,4,'Rendszerszervezés',2,'kötelező',NULL),(338,2,2007,4,'Infokommunikációs rendszerek üzemeltetése',2,'kötelező',NULL),(339,3,2007,4,'Bevezetés a Microsoft .NET 3.5 framework és Windows Communication Foundation-be',2,'kötelező',NULL),(340,2,2007,4,'Informatikai versenyfeladatok',2,'kötelező',NULL),(341,2,2007,4,'Bevezetés a Python programozási nyelvbe',2,'kötelező',NULL),(342,5,2009,4,'Diszkrét matematika',2,'kötelező',NULL),(343,5,2009,4,'Kalkulus 1',2,'kötelező',NULL),(344,5,2009,4,'Bevezetés az informatikába',2,'kötelező',NULL),(345,5,2009,4,'Az informatika logikai alapjai',2,'kötelező',NULL),(346,4,2009,4,'Fizika 1',2,'kötelező',NULL),(347,3,2009,4,'Elektronika 1',2,'kötelező',NULL),(348,5,2009,2,'Magas szintű programozási nyelvek 1',2,'kötelező',NULL),(349,5,2009,2,'Kalkulus 2',2,'kötelező',NULL),(350,5,2009,2,'Operációs rendszerek',2,'kötelező',NULL),(351,5,2009,2,'Adatszerkezetek és algoritmusok',2,'kötelező',NULL),(352,3,2009,2,'Fizika 2',2,'kötelező',NULL),(353,3,2009,2,'Elektronika 2',2,'kötelező',NULL),(354,3,2009,2,'Digitális technika',2,'kötelező',NULL),(355,2,2009,2,'Társadalomismeretek',2,'kötelező',NULL),(356,5,2009,2,'Magas szintű programozási nyelvek 2',2,'kötelező',NULL),(357,5,2009,2,'Adatbázisrendszerek',2,'kötelező',NULL),(358,5,2009,2,'Valószínűségszámítás és matematikai statisztika',2,'kötelező',NULL),(359,5,2009,2,'Hálózati architektúrák',2,'kötelező',NULL),(360,3,2009,2,'Jelek és rendszerek',2,'kötelező',NULL),(361,5,2009,4,'Hardverközeli programozás 1',2,'kötelező',NULL),(362,3,2009,4,'Bevezetés a LabView programozásba',2,'kötelező',NULL),(363,5,2009,4,'A mesterséges intelligencia alapjai',2,'kötelező',NULL),(364,2,2009,4,'Az informatikai biztonság alapjai',2,'kötelező',NULL),(365,3,2009,4,'Vállalati információs rendszerek',2,'kötelező',NULL),(366,3,2009,4,'Informatikai rendszerek modellezése, analízise',2,'kötelező',NULL),(367,1,2009,4,'Elektronika labor',2,'kötelező',NULL),(368,5,2009,4,'Irányítástechnika',2,'kötelező',NULL),(369,4,2009,4,'Vállalati gazdasági folyamatok',2,'kötelező',NULL),(370,2,2009,4,'Döntéstámogató rendszerek',2,'kötelező',NULL),(371,2,2009,4,'Bevezetés a számítógépi grafikába',2,'kötelező',NULL),(372,2,2009,4,'Jogi és közigazgatási ismeretek',2,'kötelező',NULL),(373,3,2009,4,'Rendszerszervezés',2,'kötelező',NULL),(374,2,2009,4,'Infokommunikációs rendszerek üzemeltetése',2,'kötelező',NULL),(375,3,2009,4,'Bevezetés a Microsoft .NET 3.5 framework és Windows Communication Foundation-be',2,'kötelező',NULL),(376,2,2009,4,'Informatikai versenyfeladatok',2,'kötelező',NULL),(377,2,2009,4,'Bevezetés a Python programozási nyelvbe',2,'kötelező',NULL),(378,6,2007,2,'Szemantikus web',2,'kötelező',NULL),(379,6,2007,2,'Automatikus tételbizonyítás',2,'kötelező',NULL),(380,2,2007,2,'Genetikus algoritmusok',2,'kötelező',NULL),(381,4,2007,2,'Algoritmus- és bonyolultságelmélet',2,'kötelező',NULL),(382,6,2007,2,'Statisztikus tanuló algoritmusok',2,'kötelező',NULL),(383,6,2007,2,'Játékelmélet',2,'kötelező',NULL),(384,4,2007,2,'Új számítási paradigmák',2,'kötelező',NULL),(385,5,2007,2,'Diszkrét matematika 1',2,'kötelező',NULL),(386,5,2007,2,'Kalkulus 1',2,'kötelező',NULL),(387,5,2007,2,'Bevezetés az informatikába',2,'kötelező',NULL),(388,5,2007,2,'Az informatika logikai alapjai',2,'kötelező',NULL),(389,5,2007,2,'Számítógép architektúrák',2,'kötelező',NULL),(390,5,2007,2,'Diszkrét matematika 2',2,'kötelező',NULL),(391,5,2007,2,'Kalkulus 2',2,'kötelező',NULL),(392,5,2007,2,'Valószínűségszámítás és statisztika',2,'kötelező',NULL),(393,5,2007,2,'Operációs rendszerek 1',2,'kötelező',NULL),(394,5,2007,2,'Adatszerkezetek és algoritmusok',2,'kötelező',NULL),(395,5,2007,2,'Numerikus módszerek',2,'kötelező',NULL),(396,5,2007,2,'Operációs rendszerek 2',2,'kötelező',NULL),(397,5,2007,2,'Automaták és formális nyelvek',2,'kötelező',NULL),(398,5,2007,2,'Bevezetés a számítógépi grafikába',2,'kötelező',NULL),(399,2,2007,4,'Programozási környezetek',2,'kötelező',NULL),(400,5,2007,4,'Programozási technológiák',2,'kötelező',NULL),(401,5,2007,4,'Hálózati architektúrák és protokollok',2,'kötelező',NULL),(402,3,2007,4,'Adatbázis adminisztráció',2,'kötelező',NULL),(403,5,2007,4,'A rendszerfejlesztés technológiája',2,'kötelező',NULL),(404,3,2007,4,'Az internet eszközei és szolgáltatásai',2,'kötelező',NULL),(405,5,2007,4,'Algoritmusok tervezése és elemzése',2,'kötelező',NULL),(406,3,2007,4,'Információelmélet',2,'kötelező',NULL),(407,3,2007,4,'Hálózatmodellezés',2,'kötelező',NULL),(408,5,2007,4,'Operációkutatás',2,'kötelező',NULL),(409,5,2007,4,'Neurális hálók',2,'kötelező',NULL),(410,5,2007,4,'Komputerstatisztika',2,'kötelező',NULL),(411,3,2007,4,'A bioinformatika alapjai',2,'kötelező',NULL),(412,5,2007,4,'Fordítóprogramok',2,'kötelező',NULL),(413,5,2007,4,'Mesterséges intelligencia nyelvek',2,'kötelező',NULL),(414,3,2007,4,'Mesterséges intelligencia alkalmazások',2,'kötelező',NULL),(415,3,2007,4,'Adatbázisrendszerek megvalósítása 1',2,'kötelező',NULL),(416,5,2007,4,'Haladó DBMS ismeretek 1',2,'kötelező',NULL),(417,5,2007,4,'Komputergrafika',2,'kötelező',NULL),(418,5,2007,4,'Grafikus rendszerek',2,'kötelező',NULL),(419,5,2007,4,'OpenGL',2,'kötelező',NULL),(420,3,2007,4,'Nagysebességű lokális és városi hálózatok',2,'kötelező',NULL),(421,2,2007,4,'Web-technológia PHP-vel',2,'kötelező',NULL),(422,2,2007,4,'LAN hálózatok felépítése ProCurve eszközökkel 1',2,'kötelező',NULL),(423,0,2005,2,'Magas szintű programozási nyelvek 1 gy.',2,'kötelező',NULL),(424,5,2005,2,'Magas szintű programozási nyelvek 1 ea.',2,'kötelező',NULL),(425,4,2005,2,'Diszkrét matematika 2 ea.',2,'kötelező',NULL),(426,4,2005,2,'Kalkulus 2 ea.',2,'kötelező',NULL),(427,0,2005,2,'Kalkulus 2 gy.',2,'kötelező',NULL),(428,4,2005,2,'Numerikus matematika ea.',2,'kötelező',NULL),(429,4,2005,2,'Komputerstatisztika ea.',2,'kötelező',NULL),(430,0,2005,2,'Komputerstatisztika gy.',2,'kötelező',NULL),(431,0,2005,2,'Szigorlat',2,'kötelező',NULL),(432,4,2005,4,'Programozási technológiák ea.',2,'kötelező',NULL),(433,0,2005,4,'Programozási technológiák gy.',2,'kötelező',NULL),(434,5,2005,4,'A mesterséges intelligencia alapjai ea.',2,'kötelező',NULL),(435,0,2005,4,'A mesterséges intelligencia alapjai gy.',2,'kötelező',NULL),(436,2,2005,4,'Adatbázisrendszerek megvalósítása ea.',2,'kötelező',NULL),(437,4,2005,4,'Hálózati architektúrák és protokollok ea.',2,'kötelező',NULL),(438,0,2005,4,'Hálózati architektúrák és protokollok gy.',2,'kötelező',NULL),(439,4,2005,4,'Fordítóprogramok ea.',2,'kötelező',NULL),(440,0,2005,4,'Fordítóprogramok gy.',2,'kötelező',NULL),(441,2,2005,4,'Az internet eszközei és szolgáltatásai ea.',2,'kötelező',NULL),(442,3,2005,4,'Számítógép az oktatásban',2,'kötelező',NULL),(443,2,2005,4,'Elemi informatika 2',2,'kötelező',NULL),(444,2,2005,4,'Infokommunikációs rendszerek üzemeltetése',2,'kötelező',NULL),(445,2,2005,4,'Információelmélet ea.',2,'kötelező',NULL),(446,4,2005,4,'Neurális hálók ea.',2,'kötelező',NULL),(447,4,2005,4,'Haladó DBMS ismeretek 1 ea.',2,'kötelező',NULL),(448,0,2005,4,'Haladó DBMS ismeretek 1 gy.',2,'kötelező',NULL),(449,4,2005,4,'Komputergrafika ea.',2,'kötelező',NULL),(450,0,2005,4,'Komputergrafika gy.',2,'kötelező',NULL),(451,2,2005,4,'Nagysebességű lokális és városi hálózatok ea.',2,'kötelező',NULL),(452,6,2007,4,'Alkalmazott matematika',2,'kötelező',NULL),(453,6,2007,4,'Alkalmazott statisztika',2,'kötelező',NULL),(454,6,2007,4,'Adat- és rendszermodellek',2,'kötelező',NULL),(455,10,2007,4,'Diplomamunka 1',2,'kötelező',NULL),(456,10,2007,4,'Diplomamunka 2',2,'kötelező',NULL),(457,2,2007,4,'C, C++ esettanulmányok',2,'kötelező',NULL),(458,4,2007,4,'Programozás GNU/Linux környezetben',2,'kötelező',NULL),(459,6,2007,4,'Formális nyelvek kombinatorikus és algoritmikus tulajdonságai',2,'kötelező',NULL),(460,6,2007,4,'Sztringalgoritmusok',2,'kötelező',NULL),(461,4,2007,4,'Adatsűrítés',2,'kötelező',NULL),(462,2,2007,4,'Genetikus algoritmusok',2,'kötelező',NULL),(463,4,2007,4,'Ismeretalapú technológia',2,'kötelező',NULL),(464,6,2009,2,'Információs rendszerek menedzselése',2,'kötelező',NULL),(465,4,2009,2,'Ismeretalapú technológia',2,'kötelező',NULL),(466,2,2009,2,'Ismeretalapú rendszer esettanulmány',2,'kötelező',NULL),(467,5,2009,2,'Haladó mikroökonómia',2,'kötelező',NULL),(468,6,2009,2,'Pénzügyi matematika 1',2,'kötelező',NULL),(469,3,2009,2,'Biztosítási matematika',2,'kötelező',NULL),(470,4,2009,2,'Információs rendszerek architektúrái',2,'kötelező',NULL),(471,6,2009,2,'Információs rendszerek a gyakorlatban',2,'kötelező',NULL),(472,4,2007,2,'Vezetői információs rendszerek 1',2,'kötelező',NULL),(473,4,2007,2,'Termelés informatika 1',2,'kötelező',NULL),(474,2,2007,2,'Informatikai jog',2,'kötelező',NULL),(475,3,2007,2,'Vezetői információs rendszerek 2',2,'kötelező',NULL),(476,3,2007,2,'Termelés informatika 2',2,'kötelező',NULL),(477,4,2007,2,'Számítógépes tervezőrendszerek',2,'kötelező',NULL),(478,5,2009,2,'Minőség menedzsment',2,'kötelező',NULL),(479,6,2009,2,'Önálló laboratórium 2',2,'kötelező',NULL),(480,4,2009,2,'Vezetői információs rendszerek 1',2,'kötelező',NULL),(481,4,2009,2,'Termelés informatika 1',2,'kötelező',NULL),(482,5,2009,2,'Termelés menedzsment',2,'kötelező',NULL),(483,3,2009,2,'Vezetői információs rendszerek 2',2,'kötelező',NULL),(484,3,2009,2,'Termelés informatika 2',2,'kötelező',NULL),(485,4,2009,2,'Számítógépes tervezőrendszerek',2,'kötelező',NULL),(486,4,2007,2,'Pénzügyi matematika',2,'kötelező',NULL),(487,4,2007,2,'Tudásalapú rendszerek',2,'kötelező',NULL),(488,4,2007,2,'Számvitel 2',2,'kötelező',NULL),(489,4,2007,2,'Vállalati pénzügyek 2',2,'kötelező',NULL),(490,4,2007,2,'Operációkutatás',2,'kötelező',NULL),(491,3,2007,2,'Stratégiai menedzsment',2,'kötelező',NULL),(492,3,2007,2,'SAP alkalmazások 2',2,'kötelező',NULL),(493,5,2010,2,'Pénzügyi matematika',2,'kötelező',NULL),(494,3,2010,2,'Tartalomszolgáltatás',2,'kötelező',NULL),(495,5,2010,2,'Számvitel 2',2,'kötelező',NULL),(496,4,2010,2,'Vállalati pénzügyek 2',2,'kötelező',NULL),(497,3,2010,2,'SAP alkalmazások 2',2,'kötelező',NULL),(498,3,2010,2,'Statisztika számítógéppel',2,'kötelező',NULL),(499,5,2010,2,'Operációkutatás',2,'kötelező',NULL),(500,3,2010,2,'Stratégiai menedzsment',2,'kötelező',NULL),(501,5,2010,2,'Tudásalapú rendszerek',2,'kötelező',NULL),(502,3,2007,2,'A programozás alapjai ea.',2,'kötelező',NULL),(503,2,2007,2,'A programozás alapjai gy.',2,'kötelező',NULL),(504,4,2007,2,'Multimédia ea.',2,'kötelező',NULL),(505,1,2007,2,'Multimédia gy.',2,'kötelező',NULL),(506,3,2007,2,'Dinamikus weblapok készítése',2,'kötelező',NULL),(507,2,2007,2,'Webdesign',2,'kötelező',NULL),(508,3,2007,2,'Programozás Java nyelven 2',2,'kötelező',NULL),(509,3,2007,2,'A szemantikus web alapjai',2,'kötelező',NULL),(510,2,2007,2,'Könyvtári alkalmazások készítése',2,'kötelező',NULL),(511,2,2007,2,'Az informatika múltja, jelene és jövője',2,'kötelező',NULL),(512,4,2009,2,'A programozás alapjai',2,'kötelező',NULL),(513,4,2009,2,'Multimédia',2,'kötelező',NULL),(514,4,2009,2,'Dinamikus weblapok készítése',2,'kötelező',NULL),(515,2,2009,2,'Webdesign',2,'kötelező',NULL),(516,4,2009,2,'Programozás Java nyelven 2',2,'kötelező',NULL),(517,4,2009,2,'A szemantikus web alapjai',2,'kötelező',NULL),(518,2,2009,2,'Könyvtári alkalmazások készítése',2,'kötelező',NULL),(519,2,2009,2,'Az informatika múltja, jelene és jövője',2,'kötelező',NULL),(521,4,2016,4,'Teszt tantargy 2',2,'kotelezo',1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` longtext NOT NULL,
  `timetable_responsible` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8w4fpjmte7t0nl8web2ywekhp` (`timetable_responsible`),
  CONSTRAINT `FK_8w4fpjmte7t0nl8web2ywekhp` FOREIGN KEY (`timetable_responsible`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Alkalmazott Matematika és Valószínűségszámítás',2);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_occupied`
--

DROP TABLE IF EXISTS `group_occupied`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_occupied` (
  `occupation_group` bigint(20) NOT NULL,
  `occupation` bigint(20) NOT NULL,
  KEY `FK_fj1mk6jyf2kr1ygweeevoptw3` (`occupation`),
  KEY `FK_b7e2iekqlioridnmqx86j7lr2` (`occupation_group`),
  CONSTRAINT `FK_b7e2iekqlioridnmqx86j7lr2` FOREIGN KEY (`occupation_group`) REFERENCES `occupation_group` (`id`),
  CONSTRAINT `FK_fj1mk6jyf2kr1ygweeevoptw3` FOREIGN KEY (`occupation`) REFERENCES `occupation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_occupied`
--

LOCK TABLES `group_occupied` WRITE;
/*!40000 ALTER TABLE `group_occupied` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_occupied` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `in_occupation_group`
--

DROP TABLE IF EXISTS `in_occupation_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `in_occupation_group` (
  `occupation_group` bigint(20) NOT NULL,
  `user` bigint(20) NOT NULL,
  KEY `FK_ljmsilu8u4ck974am3h61v0ng` (`user`),
  KEY `FK_5163vcsewweph36qsy2iuprxq` (`occupation_group`),
  CONSTRAINT `FK_5163vcsewweph36qsy2iuprxq` FOREIGN KEY (`occupation_group`) REFERENCES `occupation_group` (`id`),
  CONSTRAINT `FK_ljmsilu8u4ck974am3h61v0ng` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `in_occupation_group`
--

LOCK TABLES `in_occupation_group` WRITE;
/*!40000 ALTER TABLE `in_occupation_group` DISABLE KEYS */;
INSERT INTO `in_occupation_group` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `in_occupation_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `occupation`
--

DROP TABLE IF EXISTS `occupation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `occupation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_time` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `occupation`
--

LOCK TABLES `occupation` WRITE;
/*!40000 ALTER TABLE `occupation` DISABLE KEYS */;
INSERT INTO `occupation` VALUES (6,'2016-04-17 15:22:00','Test 1'),(7,'2016-04-14 15:23:00','Test 2');
/*!40000 ALTER TABLE `occupation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `occupation_group`
--

DROP TABLE IF EXISTS `occupation_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `occupation_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `occupation_group`
--

LOCK TABLES `occupation_group` WRITE;
/*!40000 ALTER TABLE `occupation_group` DISABLE KEYS */;
INSERT INTO `occupation_group` VALUES (1,'teszt elfoglaltsag csport');
/*!40000 ALTER TABLE `occupation_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `occupied`
--

DROP TABLE IF EXISTS `occupied`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `occupied` (
  `user` bigint(20) NOT NULL,
  `occupation` bigint(20) NOT NULL,
  KEY `FK_qjjy8gwt6vhiojsjxoqn0bg4d` (`occupation`),
  KEY `FK_on21v5mun2vygxc40ia8mp80l` (`user`),
  CONSTRAINT `FK_on21v5mun2vygxc40ia8mp80l` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_qjjy8gwt6vhiojsjxoqn0bg4d` FOREIGN KEY (`occupation`) REFERENCES `occupation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `occupied`
--

LOCK TABLES `occupied` WRITE;
/*!40000 ALTER TABLE `occupied` DISABLE KEYS */;
INSERT INTO `occupied` VALUES (2,7),(1,6);
/*!40000 ALTER TABLE `occupied` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach`
--

DROP TABLE IF EXISTS `teach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach` (
  `course` bigint(20) NOT NULL,
  `user` bigint(20) NOT NULL,
  `lecture_practice` varchar(255) NOT NULL,
  `modifier_name` varchar(255) NOT NULL,
  `more_course_code` int(11) DEFAULT NULL,
  `need_fulfillment` datetime NOT NULL,
  `neptun` bit(1) DEFAULT NULL,
  PRIMARY KEY (`course`,`user`),
  KEY `FK_7clxtec9lmewm3bmb5sxs4ktg` (`user`),
  CONSTRAINT `FK_7clxtec9lmewm3bmb5sxs4ktg` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_paorshaxvdkq3u4fdj0ko4joa` FOREIGN KEY (`course`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach`
--

LOCK TABLES `teach` WRITE;
/*!40000 ALTER TABLE `teach` DISABLE KEYS */;
INSERT INTO `teach` VALUES (1,1,'lecture','admin',NULL,'2015-01-01 00:00:00',NULL),(2,2,'lecture','admin',NULL,'2015-01-01 00:00:00',NULL);
/*!40000 ALTER TABLE `teach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `lecturer` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(64) DEFAULT NULL,
  `required_hours` int(11) DEFAULT NULL,
  `room_number` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `department` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1f1hbv3mg4nebcp616jfkdsvp` (`email_address`),
  KEY `FK_aht1eu3cyg114yvueeegg0gy4` (`department`),
  CONSTRAINT `FK_aht1eu3cyg114yvueeegg0gy4` FOREIGN KEY (`department`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'','admin@example.com','','admin',NULL,NULL,NULL,'admin',1),(2,'','lecturer@example.com','','lecturer',NULL,NULL,NULL,'lecturer',1),(6,NULL,'bela@example.com',NULL,'_asdASD123',NULL,NULL,NULL,'bela',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authorities`
--

DROP TABLE IF EXISTS `user_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_authorities` (
  `users` bigint(20) NOT NULL,
  `authorities` bigint(20) NOT NULL,
  KEY `FK_ond5jxped4i7mcewo4x530lri` (`authorities`),
  KEY `FK_osgcsifqlapxugjpvm29thffa` (`users`),
  CONSTRAINT `FK_ond5jxped4i7mcewo4x530lri` FOREIGN KEY (`authorities`) REFERENCES `authority` (`id`),
  CONSTRAINT `FK_osgcsifqlapxugjpvm29thffa` FOREIGN KEY (`users`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authorities`
--

LOCK TABLES `user_authorities` WRITE;
/*!40000 ALTER TABLE `user_authorities` DISABLE KEYS */;
INSERT INTO `user_authorities` VALUES (2,2),(1,1),(1,2),(1,5),(6,5);
/*!40000 ALTER TABLE `user_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'timetableplanner_big'
--

--
-- Dumping routines for database 'timetableplanner_big'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-17 18:06:24
