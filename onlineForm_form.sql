-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 47.98.131.191    Database: onlineForm
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `form`
--

DROP TABLE IF EXISTS `form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form` (
  `id` mediumint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(15) DEFAULT NULL COMMENT '表单中文名',
  `intro` varchar(300) DEFAULT NULL COMMENT '表格介绍',
  `content` text COMMENT '表格内容',
  `code` varchar(11) DEFAULT NULL COMMENT '表格生成专有Code',
  `count` mediumint(11) unsigned DEFAULT '0',
  `author_id` int(11) DEFAULT NULL COMMENT '作者ID',
  `privilege` int(11) DEFAULT NULL COMMENT '权限设置',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0未删除 1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form`
--

LOCK TABLES `form` WRITE;
/*!40000 ALTER TABLE `form` DISABLE KEYS */;
INSERT INTO `form` VALUES (7,'bug反馈',NULL,'[{\"type\":1,\"label\":\"请大胆说出你发现的bug！\",\"key\":\"unknown1\",\"rules\":[{}],\"isFill\":true},{\"type\":1,\"label\":\"可以多说几个。。。\",\"key\":\"unknown2\",\"rules\":[{}],\"isFill\":true},{\"key\":\"noKey\",\"label\":\"\",\"isFill\":false},{\"key\":\"appVersion\",\"label\":\"版本\",\"isFill\":false},{\"key\":\"commitTime\",\"label\":\"提交时间\",\"isFill\":false},{\"key\":\"author_name\",\"label\":\"填写者\",\"isFill\":false}]','9BA6B3',14,70,NULL,'2019-07-09 08:30:14','2019-09-12 11:57:02',0),(8,'123',NULL,'[{\"type\":1,\"label\":\"111\",\"key\":\"unknown1\",\"rules\":[{}],\"isFill\":true},{\"key\":\"noKey\",\"label\":\"\",\"isFill\":false},{\"key\":\"appVersion\",\"label\":\"版本\",\"isFill\":false},{\"key\":\"commitTime\",\"label\":\"提交时间\",\"isFill\":false},{\"key\":\"author_name\",\"label\":\"填写者\",\"isFill\":false}]','51B7E1',4,72,NULL,'2019-07-09 08:35:29','2019-10-09 10:57:08',0),(9,'未命名表单4','777','[{\"type\":1,\"label\":\"未命名\",\"key\":\"unknown3\",\"rules\":[{}],\"isFill\":true},{\"type\":2,\"label\":\"未命名\",\"key\":\"unknown4\",\"rules\":[{}],\"isFill\":true},{\"key\":\"noKey\",\"label\":\"\",\"isFill\":false},{\"key\":\"appVersion\",\"label\":\"版本\",\"isFill\":false},{\"key\":\"commitTime\",\"label\":\"提交时间\",\"isFill\":false},{\"key\":\"author_name\",\"label\":\"填写者\",\"isFill\":false}]','74BCB6',0,74,NULL,'2019-07-09 08:36:56','2019-07-09 08:36:56',0),(10,'lalala','123','[{\"type\":1,\"label\":\"未命名\",\"key\":\"unknown6\",\"rules\":[{}],\"isFill\":true},{\"type\":1,\"label\":\"未命名\",\"key\":\"unknown7\",\"rules\":[{}],\"isFill\":true},{\"type\":2,\"label\":\"未命名\",\"key\":\"unknown8\",\"rules\":[{}],\"isFill\":true},{\"type\":2,\"label\":\"lalla\",\"key\":\"unknown4\",\"rules\":[{}],\"isFill\":true},{\"key\":\"noKey\",\"label\":\"\",\"isFill\":false},{\"key\":\"appVersion\",\"label\":\"版本\",\"isFill\":false},{\"key\":\"commitTime\",\"label\":\"提交时间\",\"isFill\":false},{\"key\":\"author_name\",\"label\":\"填写者\",\"isFill\":false}]','4E6B34',1,71,NULL,'2019-07-09 08:42:56','2019-07-09 08:43:37',0),(11,'这么强大的表单制作没人用！？',NULL,'[{\"type\":1,\"label\":\"我不高兴了啊！\",\"key\":\"unknown1\",\"rules\":[{}],\"isFill\":true},{\"key\":\"noKey\",\"label\":\"\",\"isFill\":false},{\"key\":\"appVersion\",\"label\":\"版本\",\"isFill\":false},{\"key\":\"commitTime\",\"label\":\"提交时间\",\"isFill\":false},{\"key\":\"author_name\",\"label\":\"填写者\",\"isFill\":false}]','DEAB02',2,70,NULL,'2019-07-09 08:54:07','2019-07-09 09:33:12',0),(12,'1221',NULL,'[{\"type\":2,\"label\":\"未命名\",\"key\":\"unknown2\",\"rules\":[{}],\"isFill\":true},{\"type\":1,\"label\":\"未命名\",\"key\":\"unknown1\",\"rules\":[{}],\"isFill\":true},{\"key\":\"noKey\",\"label\":\"\",\"isFill\":false},{\"key\":\"appVersion\",\"label\":\"版本\",\"isFill\":false},{\"key\":\"commitTime\",\"label\":\"提交时间\",\"isFill\":false},{\"key\":\"author_name\",\"label\":\"填写者\",\"isFill\":false}]','AA5C0E',0,72,NULL,'2019-07-09 09:03:44','2019-07-09 09:03:44',0),(13,'注册完以后要邮箱验证才能登录',NULL,'[{\"type\":1,\"label\":\"大家加油。。\",\"key\":\"unknown1\",\"rules\":[{}],\"isFill\":true},{\"key\":\"noKey\",\"label\":\"\",\"isFill\":false},{\"key\":\"appVersion\",\"label\":\"版本\",\"isFill\":false},{\"key\":\"commitTime\",\"label\":\"提交时间\",\"isFill\":false},{\"key\":\"author_name\",\"label\":\"填写者\",\"isFill\":false}]','D15760',0,70,NULL,'2019-07-09 09:05:44','2019-07-09 09:05:44',0),(14,'syh test1',NULL,'[{\"type\":1,\"label\":\"test\",\"key\":\"unknown2\",\"rules\":[{}],\"isFill\":true},{\"type\":1,\"label\":\"12312323\",\"key\":\"unknown1\",\"rules\":[{}],\"isFill\":true},{\"key\":\"noKey\",\"label\":\"\",\"isFill\":false},{\"key\":\"appVersion\",\"label\":\"版本\",\"isFill\":false},{\"key\":\"commitTime\",\"label\":\"提交时间\",\"isFill\":false},{\"key\":\"author_name\",\"label\":\"填写者\",\"isFill\":false}]','9FE0B0',0,70,NULL,'2019-07-17 13:57:39','2019-07-17 13:57:39',0),(15,'9.7指标系统bug提出','没什么用的东西。。','[{\"type\":1,\"label\":\"作者\",\"key\":\"unknown1\",\"rules\":[{}],\"isFill\":true},{\"type\":1,\"label\":\"bug描述\",\"key\":\"unknown3\",\"rules\":[{}],\"isFill\":true},{\"type\":1,\"label\":\"触发条件\",\"key\":\"unknown2\",\"rules\":[{}],\"isFill\":true},{\"type\":1,\"label\":\"备注\",\"key\":\"unknown4\",\"rules\":[{}],\"isFill\":true},{\"key\":\"noKey\",\"label\":\"\",\"isFill\":false},{\"key\":\"appVersion\",\"label\":\"版本\",\"isFill\":false},{\"key\":\"commitTime\",\"label\":\"提交时间\",\"isFill\":false},{\"key\":\"author_name\",\"label\":\"填写者\",\"isFill\":false}]','783C02',5,70,NULL,'2019-09-07 07:21:32','2019-09-07 21:15:44',0),(16,'syh test',NULL,'[{\"type\":1,\"label\":\"项目1\",\"key\":\"unknown3\",\"rules\":[{}],\"isFill\":true},{\"type\":2,\"label\":\"问题\",\"key\":\"unknown4\",\"rules\":[{}],\"isFill\":true},{\"key\":\"noKey\",\"label\":\"\",\"isFill\":false},{\"key\":\"appVersion\",\"label\":\"版本\",\"isFill\":false},{\"key\":\"commitTime\",\"label\":\"提交时间\",\"isFill\":false},{\"key\":\"author_name\",\"label\":\"填写者\",\"isFill\":false}]','C86ACF',1,70,NULL,'2019-10-09 22:05:38','2019-10-09 22:06:02',0);
/*!40000 ALTER TABLE `form` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-11 14:55:28
