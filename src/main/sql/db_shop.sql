-- MySQL dump 10.10
--
-- Host: localhost    Database: db_shop
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt

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
-- Table structure for table `tb_buy_history`
--

DROP TABLE IF EXISTS `tb_buy_history`;
CREATE TABLE `tb_buy_history` (
  `buy_id` int(11) NOT NULL auto_increment COMMENT '购买ID',
  `product_id` int(11) NOT NULL COMMENT '产品ID',
  `buyer_id` int(11) NOT NULL COMMENT '买家id',
  `buy_ammount` int(11) NOT NULL COMMENT '购买数量',
  `buy_time` varchar(50) NOT NULL COMMENT '购买时间',
  PRIMARY KEY  (`buy_id`),
  KEY `product_id` (`product_id`),
  KEY `buyer_id` (`buyer_id`),
  CONSTRAINT `tb_buy_history_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `tb_product` (`product_id`),
  CONSTRAINT `tb_buy_history_ibfk_2` FOREIGN KEY (`buyer_id`) REFERENCES `tb_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';

--
-- Dumping data for table `tb_buy_history`
--


/*!40000 ALTER TABLE `tb_buy_history` DISABLE KEYS */;
LOCK TABLES `tb_buy_history` WRITE;
INSERT INTO `tb_buy_history` VALUES (1,2,2,3,'2018-03-22 15:20:06'),(2,3,1,1,'2018-03-22 15:20:06'),(3,2,1,3,'2018-03-22 15:23:30'),(4,3,1,1,'2018-03-22 15:23:30'),(5,2,1,1,'2018-03-22 15:58:58'),(6,3,1,1,'2018-03-22 15:58:58'),(7,2,1,1,'2018-03-22 16:56:35'),(8,3,1,1,'2018-03-22 16:56:35'),(9,4,1,1,'2018-03-22 16:56:35'),(11,1,1,2,'2018-03-23 14:56:07'),(12,8,1,6,'2018-03-23 15:37:09'),(13,5,1,2,'2018-03-23 15:45:31'),(14,10,1,4,'2018-03-23 16:26:47'),(15,9,1,4,'2018-03-23 16:27:03'),(16,7,1,1,'2018-03-26 16:47:22'),(17,13,1,2,'2018-03-29 20:35:05'),(18,11,1,0,'2018-03-29 20:35:57'),(19,14,1,0,'2018-03-29 20:35:57'),(20,17,1,2,'2018-03-29 22:00:22'),(21,14,1,1,'2018-03-29 22:00:22'),(22,6,1,1,'2018-03-29 22:01:15'),(23,20,1,0,'2018-03-29 22:03:30');
UNLOCK TABLES;
/*!40000 ALTER TABLE `tb_buy_history` ENABLE KEYS */;

--
-- Table structure for table `tb_product`
--

DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `product_id` int(11) NOT NULL auto_increment COMMENT '产品ID',
  `title` varchar(80) NOT NULL COMMENT '标题',
  `summary` varchar(150) NOT NULL COMMENT '摘要',
  `image_url` varchar(600) NOT NULL COMMENT '图片网址',
  `detail` varchar(1000) NOT NULL COMMENT '详情',
  `price` int(11) NOT NULL COMMENT '价格',
  PRIMARY KEY  (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表';

--
-- Dumping data for table `tb_product`
--


/*!40000 ALTER TABLE `tb_product` DISABLE KEYS */;
LOCK TABLES `tb_product` WRITE;
INSERT INTO `tb_product` VALUES (1,'爱护水资源','爱护水资源，人人有责','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521558510705&di=d73c7072132541c270b109d3943b9db9&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F11%2F97%2F96%2F02V58PICJD3.jpg','爱护水资源，人人有责爱护水资源，人人有责爱护水资源，人人有责爱护水资源，人人有责爱护水资源，人人有责爱护水资源，人人有责.jpg',1),(2,'资源是有限的','资源是有限的，所以我们需要爱护','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521559533204&di=60f4875664476716966b27a12c8bef73&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F94%2F97%2F39G58PICdNf.jpg','资源是有限的，所以我们需要爱护',1),(3,'苹果','买苹果的老奶奶','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521560120170&di=b74b841f2c6a654275e0c6a860d12138&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0159cf5848d440a801219c77259a61.jpg%401280w_1l_2o_100sh.jpg','老奶奶说我的苹果特别好吃，小伙子你要不要买一个',1),(4,'星星之火，可以燎原','星星之火，可以燎原','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521560979631&di=443179c0ef522ed17f154c16c01f5633&imgtype=0&src=http%3A%2F%2Fu.rui2.net%2Fuploadfile%2Foutput%2F2016%2F0429%2F805f7f812c0d529c.jpg','星星之火，可以燎原',100),(5,'我就是火','张惠妹','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521560979631&di=443179c0ef522ed17f154c16c01f5633&imgtype=0&src=http%3A%2F%2Fu.rui2.net%2Fuploadfile%2Foutput%2F2016%2F0429%2F805f7f812c0d529c.jpg','我就是我，不一样的烟火，连我自己都恼火',80),(6,'资源论','资源是有效的论断','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521562211701&di=53718f1016d83fb689ae5126bb524720&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F94%2F97%2F39G58PICdNf.jpg','资源是有效的论断资源是有效的论断资源是有效的论断资源是有效的论断',99),(7,'资源无线论','资源无线论','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521559533204&di=60f4875664476716966b27a12c8bef73&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F94%2F97%2F39G58PICdNf.jpg','资源无线论资源无线论资源无线论资源无线论资源无线论资源无线论资源无线论资源无线论资源无线论资源无线论资源无线论资源无线论',54),(8,'我的话','故事要从我小时候说起','http://p1.qhimgs4.com/dmfd/160_90_/t015c2493182c7ab1af.jpg?size=600x433','故事要从我小时候说起故事要从我小时候说起故事要从我小时候说起故事要从我小时候说起故事要从我小时候说起故事要从我小时候说起故事要从我小时候说起故事要从我小时候说起',1),(9,'zhang','finder','/shop/uploadfiles/1522055131623.jpg','finderfinderfinderfinderfinder',55),(10,'测试','测试','https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3972795527,224032047&fm=173&app=12&f=JPEG?w=218&h=146&s=BEA3288E0F3A2B8C05DC7B890300708E','点对点',44),(11,'爱因斯坦','爱因斯坦的一生','https://img03.sogoucdn.com/v2/thumb/resize/w/120/h/120/ir/3/zi/on/iw/90/ih/90/crop/x/0/y/0/w/120/h/120?t=2&appid=200524&url=http%3A%2F%2Fimg02.store.sogou.com%2Fapp%2Fa%2F10010016%2Ffc0e29456d81b0afaaef5197efcb98b8','阿尔伯特·爱因斯坦，20世纪犹太裔理论物理学家，创立了相对论，现代物理学的两大支柱之一。 虽然爱因斯坦的质能方程 E = mc 最著称于世，他是因为“..',122),(12,'霍金','时间简史','https://ss0.baidu.com/73t1bjeh1BF3odCf/it/u=1565015822,2664922851&fm=85&s=60D23BC602B48DDE44F83D380300C0D2','《时间简史》是史蒂芬·霍金在1988年的愚人节这天送给了世人一件特殊的礼物。它回答了人们最感兴趣的问题：时间有初始吗？它又将在何地终结呢？宇宙',100),(13,'梨子的故事','梨子','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2550775051,1155613478&fm=27&gp=0.jpg','梨子梨子梨子梨子梨子梨子',12),(14,'测试权限','测试权限','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=252766956,2935499197&fm=173&app=25&f=JPEG?w=218&h=146&s=6A9059853A5258D458A400E003008012','测试权限测试权限测试权限',11),(17,'Java','Java','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3617341675,2047450312&fm=173&app=12&f=JPEG?w=218&h=146&s=E102D715C50DCCEE5385BDC1030070B3','Java',11),(19,'中国越来越好','中国越来越好','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3617341675,2047450312&fm=173&app=12&f=JPEG?w=218&h=146&s=E102D715C50DCCEE5385BDC1030070B3','中国越来越好',34),(20,'china','china','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1027743378,2978857662&fm=173&app=12&f=JPEG?w=218&h=146&s=7B105D85079A17C20B8D69930300C012','china',66);
UNLOCK TABLES;
/*!40000 ALTER TABLE `tb_product` ENABLE KEYS */;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(20) NOT NULL auto_increment COMMENT '用户ID',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `usertype` int(1) NOT NULL COMMENT '用户类型',
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

--
-- Dumping data for table `tb_user`
--


/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
LOCK TABLES `tb_user` WRITE;
INSERT INTO `tb_user` VALUES (1,'buyer','37254660e226ea65ce6f1efd54233424',0),(2,'seller','981c57a5cfb0f868e064904b8745766f',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

