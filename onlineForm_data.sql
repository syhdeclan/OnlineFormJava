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
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data` (
  `id` mediumint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `form_id` mediumint(11) DEFAULT NULL COMMENT '所属表单ID',
  `data` text COMMENT '所填数据',
  `owner` int(11) unsigned DEFAULT NULL COMMENT '表单作者',
  `author_id` int(11) unsigned DEFAULT NULL COMMENT '填写者',
  `author_name` varchar(11) DEFAULT NULL COMMENT '填写者名称',
  `created_at` timestamp NULL DEFAULT NULL COMMENT '数据创建时间',
  `updated_at` timestamp NULL DEFAULT NULL COMMENT '数据修改时间',
  `is_delete` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
INSERT INTO `data` VALUES (59,7,'{\"unknown1\":\"申玉豪？\",\"unknown2\":\"欢迎大家测试！\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562632328850,\"author_name\":\"ç³\"}',NULL,70,'申','2019-07-09 00:32:08','2019-07-09 00:32:08',0),(60,7,'{\"unknown1\":\"1\",\"unknown2\":\"1\",\"appVersion\":\"5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562632328659,\"author_name\":\"Guest\"}',NULL,0,'Guest','2019-07-09 00:32:09','2019-07-09 00:32:09',0),(61,7,'{\"unknown1\":\"姓名先不要用汉字\",\"unknown2\":\"会乱吗\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562632373806,\"author_name\":\"ç³\"}',NULL,70,'申','2019-07-09 00:32:53','2019-07-09 00:32:53',0),(62,7,'{\"unknown1\":\"登录以后可以制作表单\",\"unknown2\":\"必须允许cookie才能访问\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562632570626,\"author_name\":\"ç³\"}',NULL,70,'申','2019-07-09 00:36:10','2019-07-09 00:36:10',0),(63,7,'{\"unknown1\":\"123\",\"unknown2\":\"321\",\"appVersion\":\"5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562632583698,\"author_name\":\"Guest\"}',NULL,71,'啦啦啦','2019-07-09 00:36:24','2019-07-09 00:36:24',0),(64,8,'{\"unknown1\":\"345\",\"appVersion\":\"5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562632605611,\"author_name\":\"Guest\"}',NULL,71,'啦啦啦','2019-07-09 00:36:46','2019-07-09 00:36:46',0),(65,7,'{\"unknown1\":\"没有开发手机端。。\",\"unknown2\":\"不好意思。。。\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562632624500,\"author_name\":\"ç³\"}',NULL,70,'申','2019-07-09 00:37:04','2019-07-09 00:37:04',0),(66,7,'{\"unknown1\":\"测试一下\",\"unknown2\":\"就这样吧啊\",\"appVersion\":\"5.0 (Linux; Android 9; MIX 2S Build/PKQ1.180729.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/044705 Mobile Safari/537.36 MMWEBID/4893 MicroMessenger/7.0.4.1420(0x2700043C) Process/tools NetType/4G Language/zh_CN\",\"commitTime\":1562632692490,\"author_name\":\"Guest\"}',NULL,0,'Guest','2019-07-09 00:38:12','2019-07-09 00:38:12',0),(67,10,'{\"unknown6\":\"wdasf\",\"unknown7\":\"fweg\",\"appVersion\":\"5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562633016557,\"author_name\":\"å¦å¦å¦\"}',NULL,71,'啦啦啦','2019-07-09 00:43:37','2019-07-09 00:43:37',0),(68,7,'{\"unknown1\":\"表单删除好像有点问题\",\"unknown2\":\"删除之后好像数量上。。有问题\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562633197250,\"author_name\":\"ç³\"}',NULL,70,'申','2019-07-09 00:46:37','2019-07-09 00:46:37',0),(69,7,'{\"unknown1\":\"版本号默认显示太碍眼了\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562633432824,\"author_name\":\"ç³\"}',NULL,70,'申','2019-07-09 00:50:32','2019-07-09 00:50:32',0),(70,7,'{\"unknown1\":\"点导航栏的表单才能正常功能！！\",\"unknown2\":\"点导航栏的表单才能正常功能！！\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562633458334,\"author_name\":\"ç³\"}',NULL,70,'申','2019-07-09 00:50:58','2019-07-09 00:50:58',0),(71,8,'{\"unknown1\":\"13132\",\"appVersion\":\"5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36\",\"commitTime\":1562634013918,\"author_name\":\"Guest\"}',NULL,79,'申玉豪','2019-07-09 01:00:12','2019-07-09 01:00:12',0),(72,7,'{\"unknown1\":\"切换页面丢失制作表单数据\",\"unknown2\":\"需要状态管理\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562634911076,\"author_name\":\"ç³\"}',NULL,70,'申','2019-07-09 01:15:11','2019-07-09 01:15:11',0),(73,11,'{\"appVersion\":\"5.0 (Linux; Android 8.0.0; HTC 2PZC100 Build/OPR6.170623.013; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/044705 Mobile Safari/537.36 V1_AND_SQ_7.1.0_0_TIM_D TIM/2.3.1.1834 QQ/6.5.5  NetType/WIFI WebP/0.3.0 Pixel/1440\",\"commitTime\":1562635324047,\"author_name\":\"Guest\"}',NULL,0,'Guest','2019-07-09 01:22:04','2019-07-09 01:22:04',0),(74,8,'{\"unknown1\":\"hey man\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562635697672,\"author_name\":\"Guest\"}',NULL,0,'Guest','2019-07-09 01:29:47','2019-07-09 01:29:47',0),(75,11,'{\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\",\"commitTime\":1562635992827,\"author_name\":\"Guest\"}',NULL,0,'Guest','2019-07-09 01:33:12','2019-07-09 01:33:12',0),(76,7,'{\"unknown1\":\"11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\",\"unknown2\":\"111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36\",\"commitTime\":1565005246034,\"author_name\":\"Guest\"}',NULL,0,'Guest','2019-08-05 11:40:46','2019-08-05 11:40:46',0),(77,7,'{\"unknown1\":\"huih\",\"unknown2\":\"fyfvuyt\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36\",\"commitTime\":1565076932299,\"author_name\":\"Guest\"}',NULL,0,'Guest','2019-08-06 07:35:32','2019-08-06 07:35:32',0),(78,15,'{\"unknown1\":\"syh\",\"unknown3\":\"提交责任数据页面内容没对齐\",\"unknown2\":\"责任部门用户的\",\"unknown4\":\"没什么\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36\",\"commitTime\":1567812187797,\"author_name\":\"ç³\"}',NULL,70,'申','2019-09-06 23:23:07','2019-09-06 23:23:07',0),(79,15,'{\"unknown3\":\"责任数据页面 通过后应该全部禁止填写\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36\",\"commitTime\":1567814135249,\"author_name\":\"ç³\"}',NULL,70,'申','2019-09-06 23:55:35','2019-09-06 23:55:35',0),(80,15,'{\"unknown1\":\"路欣负责\",\"unknown3\":\"学院管理页面删除学院之后转圈停不下来\",\"unknown2\":\"删除学院\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36\",\"commitTime\":1567861733577,\"author_name\":\"Guest\"}',NULL,70,'申','2019-09-07 13:08:53','2019-09-07 13:08:53',0),(81,15,'{\"unknown1\":\"路欣负责\",\"unknown3\":\"学院页面添加完之后转圈也不会消失，然后没有清空添加面板里面的内容\",\"unknown2\":\"添加学院之后又点添加学院\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36\",\"commitTime\":1567861962689,\"author_name\":\"Guest\"}',NULL,70,'申','2019-09-07 13:12:42','2019-09-07 13:12:42',0),(82,15,'{\"unknown3\":\"学院页面修改之后，没有实时更新页面，需要刷新才行\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36\",\"commitTime\":1567862144678,\"author_name\":\"Guest\"}',NULL,70,'申','2019-09-07 13:15:44','2019-09-07 13:15:44',0),(83,7,'{\"unknown1\":\"1\",\"unknown2\":\"111\",\"appVersion\":\"5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36\",\"commitTime\":1568260619678,\"author_name\":\"Guest\"}',NULL,0,'Guest','2019-09-12 03:57:02','2019-09-12 03:57:02',0),(84,8,'{\"unknown1\":\"123\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36\",\"commitTime\":1570589828836,\"author_name\":\"Guest\"}',NULL,0,'Guest','2019-10-09 02:57:08','2019-10-09 02:57:08',0),(85,16,'{\"unknown3\":\"啊啊啊啊\",\"appVersion\":\"5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36\",\"commitTime\":1570629962871,\"author_name\":\"ç³\"}',NULL,70,'申','2019-10-09 14:06:02','2019-10-09 14:06:02',0);
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-11 14:55:26
