/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.16 : Database - south_view
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`south_view` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `south_view`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论Id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `view_id` int(11) DEFAULT NULL COMMENT '景区Id',
  `store_id` int(11) DEFAULT NULL COMMENT '名店Id',
  `special_id` int(11) DEFAULT NULL COMMENT '特产Id',
  `content` varchar(100) DEFAULT NULL COMMENT '内容',
  `create_date` date DEFAULT NULL COMMENT '时间',
  `score` varchar(5) DEFAULT NULL COMMENT '分数',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`comment_id`),
  KEY `C_R_V_VID` (`view_id`),
  KEY `C_R_U_UID` (`user_id`),
  KEY `C_R_V_STID` (`store_id`),
  KEY `C_R_V_SPID` (`special_id`),
  CONSTRAINT `C_R_U_UID` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `C_R_V_SPID` FOREIGN KEY (`special_id`) REFERENCES `specialty` (`special_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `C_R_V_STID` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `C_R_V_VID` FOREIGN KEY (`view_id`) REFERENCES `views` (`view_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`comment_id`,`user_id`,`view_id`,`store_id`,`special_id`,`content`,`create_date`,`score`,`remark`) values (1,1,NULL,NULL,NULL,'dd','2015-12-08','4','ddd'),(3,NULL,NULL,9,NULL,'vvv','2016-01-20','7','nn'),(4,NULL,NULL,NULL,2,'sssss','2016-01-18','3','mm');

/*Table structure for table `specialty` */

DROP TABLE IF EXISTS `specialty`;

CREATE TABLE `specialty` (
  `special_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '特产Id',
  `special_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `special_info` varchar(500) DEFAULT NULL COMMENT '简介',
  `special_address` varchar(200) DEFAULT NULL COMMENT '地址',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`special_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `specialty` */

insert  into `specialty`(`special_id`,`special_name`,`special_info`,`special_address`,`create_date`,`remark`) values (1,'刚刚','哥哥','各个资源','2016-01-10','广告歌'),(2,'版本','并不','滨保','2016-01-10','不必');

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `store_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '名店Id',
  `store_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `store_info` varchar(500) DEFAULT NULL COMMENT '简介',
  `store_address` varchar(200) DEFAULT NULL COMMENT '地址',
  `store_time` varchar(50) DEFAULT NULL COMMENT '时间',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `store` */

insert  into `store`(`store_id`,`store_name`,`store_info`,`store_address`,`store_time`,`create_date`,`remark`) values (8,'发','发','发','2016-01-09','2016-01-10','发'),(9,'烦烦烦','上的','的','2016-01-10','2016-01-10','上的'),(10,'qweqwe','qwe','qwe','2016-01-16','2016-01-10','wqe'),(11,'ddddsdd得到','点点滴滴点点滴滴的的的的的的的的的的','顶顶顶顶顶','2016-01-01','2016-01-10','顶顶顶顶顶'),(13,'反反复复反反复复',' 反反复复反反复复发发发 岁的法国','反反复复烦烦烦','2016-01-03','2016-01-10',' 反反复复凤飞飞方法'),(14,'去','去','去','2016-01-02','2016-01-10','去'),(15,'我','我','我','2016-01-10','2016-01-10','我'),(16,'饿','饿','饿','2016-01-09','2016-01-10','饿'),(17,'日','日','日','2016-01-29','2016-01-10','日'),(18,'他','他','他','2016-01-06','2016-01-10','他'),(19,'一','一','一','2016-01-17','2016-01-10','一'),(20,'发发','发发','发发','2016-01-08','2016-01-10','发发');

/*Table structure for table `suggest` */

DROP TABLE IF EXISTS `suggest`;

CREATE TABLE `suggest` (
  `suggest_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `suggest_content` varchar(200) DEFAULT NULL COMMENT '内容',
  `create_date` date DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`suggest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `suggest` */

insert  into `suggest`(`suggest_id`,`user_id`,`suggest_content`,`create_date`) values (1,26,'我想要更新啊！','2016-03-21');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `account` varchar(25) DEFAULT NULL COMMENT '账号',
  `password` varchar(25) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(25) DEFAULT NULL COMMENT '昵称',
  `true_name` varchar(25) DEFAULT NULL COMMENT '姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `icon` varchar(200) DEFAULT NULL COMMENT '头像',
  `phone` varchar(25) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(25) DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(25) DEFAULT NULL COMMENT 'QQ号码',
  `wechat` varchar(25) DEFAULT NULL COMMENT '微信号',
  `sina` varchar(50) DEFAULT NULL COMMENT 'sina号',
  `info` varchar(200) DEFAULT NULL COMMENT '简介',
  `sign` int(11) DEFAULT NULL COMMENT '管理员标志',
  `token` varchar(200) DEFAULT NULL COMMENT '用户登录后的token',
  `type` varchar(10) DEFAULT NULL COMMENT '用户来源类型',
  `type_id` varchar(100) DEFAULT NULL COMMENT '来源Id',
  `login_sign` varchar(10) DEFAULT NULL COMMENT '用户是否登录标志',
  `create_date` date DEFAULT NULL COMMENT '注册日期',
  `last_update` date DEFAULT NULL COMMENT '更新日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`user_id`,`account`,`password`,`nick_name`,`true_name`,`sex`,`birthday`,`icon`,`phone`,`email`,`qq`,`wechat`,`sina`,`info`,`sign`,`token`,`type`,`type_id`,`login_sign`,`create_date`,`last_update`,`remark`) values (1,'zehao','zehao','则好','则好',1,'2015-12-27','./photoes/image_nanqu.png','1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',1,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(2,'222','222','则好2','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',1,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(3,'333','333','则好3','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(4,'444','444','则好4','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(5,'555','555','则好5','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(6,'666','666','则好6','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(7,'777','777','则好7','则好',0,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(8,'888','888','则好8','则好',0,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(9,'999','999','则好9','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(10,'www','www','则好w','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(11,'qqq','qqq','则好q','则好',0,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(12,'123','摸JJ基金经理爸','没看见考虑考虑联系联系啊',NULL,1,NULL,'./icons/1457623057855.jpg',NULL,NULL,NULL,NULL,NULL,NULL,3,NULL,'common','123','on','2016-03-10',NULL,'考虑考虑联系联系考虑考虑'),(13,'12345678','12345678','查流量',NULL,1,NULL,'./icons/1457623604951.jpg',NULL,NULL,NULL,NULL,NULL,NULL,3,NULL,'common','12345678','on','2016-03-10',NULL,'啊啦啦啦啦'),(14,'123456789','123456789','啊啦拉',NULL,1,NULL,'./icons/1457624079694.jpg',NULL,NULL,NULL,NULL,NULL,NULL,3,NULL,'common','123456789','on','2016-03-10',NULL,'鹅鹅鹅'),(15,'87654321','87654321','啊啊',NULL,1,NULL,'./icons/1457624846116.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'common','87654321','on','2016-03-10',NULL,'得得'),(16,'753159258','fdjfchfdg','qaz',NULL,0,NULL,'./icons/1457671214864.jpg',NULL,NULL,NULL,NULL,NULL,'sfdcgddgf',2,NULL,'common','753159258','off','2016-03-11',NULL,NULL),(17,'qefghfff','ttstyyyyy','rdgffgyy',NULL,0,NULL,'./icons/1457671867331.jpg',NULL,NULL,NULL,NULL,NULL,'fffhhg',2,NULL,'common','qefghfff','off','2016-03-11',NULL,NULL),(18,'524555555','fgxggxhgf','fgdgt',NULL,0,NULL,'./icons/1457672572632.jpg',NULL,NULL,NULL,NULL,NULL,'tffgff',2,NULL,'common','524555555','off','2016-03-11',NULL,NULL),(19,'txjffygf','dgxhffuy','dtrt',NULL,1,NULL,'./icons/1457672676496.jpg',NULL,NULL,NULL,NULL,NULL,'ttdttt',2,NULL,'common','txjffygf','off','2016-03-11',NULL,NULL),(20,'dgfdhfgf','Tddfhfggdd','ffhffhgf',NULL,0,NULL,'./icons/1457673810930.jpg',NULL,NULL,NULL,NULL,NULL,'gxggfhg',2,NULL,'common','dgfdhfgf','off','2016-03-11',NULL,NULL),(21,'tttttttttr','fdgdsfgd','dxgffggf',NULL,0,NULL,'./icons/1457673989994.jpg',NULL,NULL,NULL,NULL,NULL,'rsghdd',2,NULL,'common','tttttttttr','off','2016-03-11',NULL,NULL),(22,'gggggggg','tttttttttr','gfghggf',NULL,0,NULL,'./icons/1457674865443.jpg',NULL,NULL,NULL,NULL,NULL,'hggggg',2,NULL,'common','gggggggg','off','2016-03-11',NULL,NULL),(23,'rrrrrttttt','rrrrrttttt','rrrrrttttt',NULL,0,NULL,'./icons/1457674978760.jpg',NULL,NULL,NULL,NULL,NULL,'rrrrrttttt',2,NULL,'common','rrrrrttttt','off','2016-03-11',NULL,NULL),(24,'eeeewwww','eeeewwww','eeeewwww',NULL,0,NULL,'./icons/1457675299732.jpg',NULL,NULL,NULL,NULL,NULL,'eeeewwww',2,'7B89E4ACBF8C4B39A228181E7756CE38','common','eeeewwww','on','2016-03-11',NULL,NULL),(25,'aaaadddd','aaaadddd','aaaadddd',NULL,0,NULL,'./icons/1457675783650.jpg',NULL,NULL,NULL,NULL,NULL,'aaaadddd',2,'D549F544F10241F3B60A8937FFBDE44F','common','aaaadddd','on','2016-03-11',NULL,NULL),(26,'145767953826','145767953826','魑魅魍魉',NULL,1,NULL,'./icons/1458450008643.jpg',NULL,NULL,NULL,NULL,NULL,'我的QQ呵呵',2,'9C9D9BB268064F739245ABD0F7BCF666','QZone','C62E2073CD9428E6C9A53C1A82343889','on','2016-03-11','2016-03-20',NULL),(27,'145779880105','145779880105','手机用户2241070071',NULL,0,NULL,'./icons/1457680092068.jpg',NULL,NULL,NULL,NULL,NULL,'null',2,'AC13CEF2037946018F0C934052CB8E6F','SinaWeibo','2241070071','on','2016-03-11',NULL,NULL);

/*Table structure for table `view_image` */

DROP TABLE IF EXISTS `view_image`;

CREATE TABLE `view_image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '相片Id',
  `view_id` int(11) DEFAULT NULL COMMENT '景区Id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `village_id` int(11) DEFAULT NULL COMMENT '村庄Id',
  `image_info` varchar(100) DEFAULT NULL COMMENT '图片信息',
  `image_url` varchar(200) DEFAULT NULL COMMENT '图片URL',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`image_id`),
  KEY `VI_R_V_VID` (`view_id`),
  KEY `VI_R_U_UID` (`user_id`),
  KEY `VI_R_V_VAID` (`village_id`),
  CONSTRAINT `VI_R_U_UID` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `VI_R_V_VAID` FOREIGN KEY (`village_id`) REFERENCES `village` (`village_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `VI_R_V_VID` FOREIGN KEY (`view_id`) REFERENCES `views` (`view_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `view_image` */

insert  into `view_image`(`image_id`,`view_id`,`user_id`,`village_id`,`image_info`,`image_url`,`create_date`,`remark`) values (3,NULL,NULL,6,'','./photoes/1458046346067.png','2016-03-12',''),(4,NULL,NULL,6,'','./photoes/1458046352340.jpg','2016-03-12',''),(5,NULL,NULL,6,'','./photoes/1458046358199.jpg','2016-03-12',''),(6,NULL,NULL,7,'','./photoes/1458046364590.jpg','2016-03-12',''),(7,NULL,NULL,7,'','./photoes/1458046374975.jpg','2016-03-12',''),(8,NULL,NULL,7,'','./photoes/1458046381561.jpg','2016-03-12',''),(9,NULL,NULL,8,'','./photoes/1458046391744.png','2016-03-12',''),(10,NULL,NULL,8,'','./photoes/1458046400642.jpg','2016-03-12',''),(11,NULL,NULL,9,'','./photoes/1458046411674.jpg','2016-03-12',''),(12,NULL,NULL,9,'','./photoes/1458046421395.jpg','2016-03-12',''),(14,1,NULL,NULL,'','./photoes/1458046438250.jpg','2016-03-15',''),(15,1,NULL,NULL,'','./photoes/1458046444622.jpg','2016-03-15',''),(16,1,NULL,NULL,'','./photoes/1458046451602.jpg','2016-03-15',''),(17,13,NULL,NULL,'','./photoes/1458125921078.jpg','2016-03-16',''),(18,12,NULL,NULL,'','./photoes/1458125906566.jpg','2016-03-16',''),(19,10,NULL,NULL,'','./photoes/1458125939600.jpg','2016-03-16',''),(20,11,NULL,NULL,'','./photoes/1458125955323.jpg','2016-03-16',''),(21,13,NULL,NULL,'','./photoes/1458125972578.jpg','2016-03-16',''),(22,5,NULL,NULL,'','./photoes/1458126353569.jpg','2016-03-16',''),(23,5,NULL,NULL,'','./photoes/1458126363369.jpg','2016-03-16',''),(24,5,NULL,NULL,'','./photoes/1458126371530.jpg','2016-03-16',''),(25,NULL,26,NULL,NULL,'./icons/1458455347684.jpg','2016-03-20',NULL),(26,NULL,26,NULL,NULL,'./icons/1458456030099.jpg','2016-03-20',NULL),(27,NULL,26,NULL,NULL,'./icons/1458456040988.jpg','2016-03-20',NULL),(28,NULL,26,NULL,NULL,'./icons/1458456056313.jpg','2016-03-20',NULL),(29,NULL,26,NULL,NULL,'./icons/1458456065055.jpg','2016-03-20',NULL);

/*Table structure for table `view_voice` */

DROP TABLE IF EXISTS `view_voice`;

CREATE TABLE `view_voice` (
  `voice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '音频Id',
  `view_id` int(11) DEFAULT NULL COMMENT '景区Id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `voice_info` varchar(100) DEFAULT NULL COMMENT '音频信息',
  `voice_url` varchar(200) DEFAULT NULL COMMENT '音频地址',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`voice_id`),
  KEY `VO_R_V_VID` (`view_id`),
  KEY `VO_R_U_UID` (`user_id`),
  CONSTRAINT `VO_R_U_UID` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `VO_R_V_VID` FOREIGN KEY (`view_id`) REFERENCES `views` (`view_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `view_voice` */

/*Table structure for table `views` */

DROP TABLE IF EXISTS `views`;

CREATE TABLE `views` (
  `view_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '景区Id',
  `village_id` int(11) DEFAULT NULL COMMENT '村子Id',
  `view_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `view_address` varchar(200) DEFAULT NULL COMMENT '地址',
  `view_guide` varchar(500) DEFAULT NULL COMMENT '导语',
  `view_info` varchar(500) DEFAULT NULL COMMENT '简介',
  `view_logo` varchar(200) DEFAULT NULL COMMENT '标志',
  `open_time` varchar(50) DEFAULT NULL COMMENT '开放时间',
  `ticket` varchar(50) DEFAULT NULL COMMENT '票价',
  `phone` varchar(25) DEFAULT NULL COMMENT '联系电话',
  `like_num` int(11) DEFAULT NULL COMMENT '点赞数',
  `child_sign` varchar(10) DEFAULT NULL COMMENT '是否有子景点',
  `up_view` int(11) DEFAULT NULL COMMENT '所属景区的Id',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `view_person` varchar(500) DEFAULT NULL COMMENT '人物活动编辑',
  `view_action` varchar(500) DEFAULT NULL COMMENT '社会活动编辑',
  PRIMARY KEY (`view_id`),
  KEY `V_R_V_VID` (`village_id`),
  CONSTRAINT `V_R_V_VID` FOREIGN KEY (`village_id`) REFERENCES `village` (`village_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `views` */

insert  into `views`(`view_id`,`village_id`,`view_name`,`view_address`,`view_guide`,`view_info`,`view_logo`,`open_time`,`ticket`,`phone`,`like_num`,`child_sign`,`up_view`,`create_date`,`remark`,`view_person`,`view_action`) values (1,6,'沙涌','沙涌村位于中山市南区中心区','沙涌村位于中山市南区中心区','沙涌村位于中山市南区中心区，历史悠久，到现在已有800年的历史。','./photoes/1458046190174.jpg','无','无','0',4,'Y',NULL,'2016-03-12','沙涌村位于中山市南区中心区','沙涌村位于中山市南区中心区沙涌村位于中山市南区中心区沙涌村位于中山市南区中心区沙涌村位于中山市南区中心区','沙涌村位于中山市南区中心区沙涌村位于中山市南区中心区沙涌村位于中山市南区中心区沙涌村位于中山市南区中心区'),(2,6,'恒美','中山恒美','恒美村牌坊','恒美村是个侨乡，九成村民姓李。李氏大宗祠是恒美村民族亲拜祭、上香的场所，是一个多功能的建筑。','./photoes/1458046784687.jpg','无','无','0',2,'Y',NULL,'2016-03-12','中山恒美',NULL,NULL),(3,6,'竹秀园','距中山南区办事处1公里处','村中翠竹成林，景色秀丽','竹秀园村，距中山南区办事处1公里处，户籍人口约2000人，该村建于明朝。因村中翠竹成林，景色秀丽，故名“竹秀园”。','./photoes/1458046792308.jpg','无','无','0',1,'Y',NULL,'2016-03-12','因村中翠竹成林，景色秀丽，故名“竹秀园”。',NULL,NULL),(4,6,'渡头','中山市城区西南面7公里、南区办事处以西2. 5公里处','水陆交通方便，历称鱼米之乡。','社区旧村庄南倚梅岭，北依岐江南岸而建。水陆交通方便，历称鱼米之乡。','./photoes/1458046801773.jpg','无','无','0',1,'Y',NULL,'2016-03-12','社区旧村庄南倚梅岭，北依岐江南岸而建。水陆交通方便，历称鱼米之乡。',NULL,NULL),(5,8,'曹边武侯庙','曹边武侯庙','曹边武侯庙','武侯庙，是供奉诸葛亮、关公和张飞的。说起武侯庙，还专门有一首诗呢：剑江春水绿沄沄，五丈原头日又曛；旧业未能归后主，大星先已落前军；南阳祠宇空秋草，西蜀关山隔暮云；正统不慙传万古，莫将成败论三分。','./photoes/1458046227252.jpg','无','无','0',7,'N',NULL,'2016-03-12','经典古建','曹边武侯庙曹边武侯庙曹边武侯庙曹边武侯庙曹边武侯庙曹边武侯庙曹边武侯庙','曹边武侯庙曹边武侯庙曹边武侯庙曹边武侯庙曹边武侯庙曹边武侯庙曹边武侯庙曹边武侯庙曹边武侯庙曹边武侯庙'),(6,8,'曹边天后宫','曹边天后宫','曹边天后宫','天后宫供奉的是妈祖，在沿海的村镇有不少这样的妈祖庙呢！','./photoes/1458046860497.jpg','无','无','0',3,'N',NULL,'2016-03-12','经典古建','',''),(7,8,'北台康真君庙','北台康真君庙','北台康真君庙','康真君庙的正殿供奉康公真君，即汉代之帅李烈，保国有功，受封成为康公。左是南海广利洪圣大王，右为西山金圣候王，偏殿前为六祖圣佛，后为汉代神医华陀先师。','./photoes/1458046868801.jpg','无','无','0',2,'N',NULL,'2016-03-12','经典古建','',''),(8,8,'詹园','詹园','詹园','詹园位于中山市南区北台村，105国道旁，占地百亩，分为詹园祝寿、岐江廊桥、詹府种福三个区域。园建筑以苏杭园林为基调，综合中国古典园林之精髓，强调岭南水乡的布局脉络，结构简洁而凝重，风格古朴而洒脱。','./photoes/1458046877247.jpg','无','无','0',1,'N',NULL,'2016-03-12','名木古树','',''),(9,7,'下马岭茶亭','下马岭茶亭','下马岭茶亭','位于南区马岭村，建于明朝永乐年间，并于清朝同治年间、民国四年进行了2次重修。这座茶亭由庭院、茶亭、话茶山馆三部分组成，因近年翻修的缘故，其外形更像是普通的民居。除了提供茶水外，茶亭还有一样必不可少的事物，乃茶联是也。','./photoes/1458046272663.jpg','无','无','0',2,'N',NULL,'2016-03-12','民品民俗','',''),(10,6,'马公纪念堂','马公纪念堂','马公纪念堂','马公纪念堂又称一言堂、沙涌先施学校、妇儿院。位于沙涌村，始建于1933年，为先施公司创办人马应彪为纪念先父马在明而建。该建筑为仿意大利哥德式建筑，砖木及混凝土结合之结 构，建筑占地面积约1800平方米。现为沙涌小学和幼儿院。该建筑已列入《中国民居》辞典。','./photoes/1458046895368.jpg','无','无','0',4,'N',1,'2016-03-12','名人典故','马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂','马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂马公纪念堂'),(11,6,'宋帝遗迹牌坊','“宋帝遗迹，侍郎故里”牌坊','“宋帝遗迹，侍郎故里”牌坊','宋帝遗迹牌坊为纪念宋工部侍郎、邑人马南宝而建。“南宝大街”，正是以其名来命名的。','./photoes/1458046906744.jpg','无','无','0',3,'N',1,'2016-03-12','名人典故','“宋帝遗迹，侍郎故里”牌坊“宋帝遗迹，侍郎故里”牌坊“宋帝遗迹，侍郎故里”牌坊“宋帝遗迹，侍郎故里”牌坊','“宋帝遗迹，侍郎故里”牌坊“宋帝遗迹，侍郎故里”牌坊'),(12,6,'文笔塔','文笔塔','文笔塔','文笔塔位于南区沙涌村，建于清代，1988年重修，是沙涌村民为纪念马南宝抗元扶宋有功，为壮乡声，多出文人，在山巅建成此塔，故此山称为文笔山。','./photoes/1458046912926.jpg','无','无','0',3,'N',1,'2016-03-12','经典古建','文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔','文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔文笔塔'),(13,6,'镇龙阁','镇龙阁','镇龙阁','镇龙阁始建于清光绪十五年（1889年）。位于中山南区沙涌村始建于清光绪十五年（1889年），该阁原为平面六角形三层仿楼阁式砖木结构塔。','./photoes/1458046320758.jpg','无','无','0',5,'N',1,'2016-03-12','经典古建','镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁','镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁镇龙阁');

/*Table structure for table `village` */

DROP TABLE IF EXISTS `village`;

CREATE TABLE `village` (
  `village_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '村子Id',
  `village_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `village_address` varchar(200) DEFAULT NULL COMMENT '地址',
  `village_info` varchar(500) DEFAULT NULL COMMENT '简介',
  `village_logo` varchar(200) DEFAULT NULL COMMENT '标志',
  `history_record` varchar(500) DEFAULT NULL COMMENT '历史典故',
  `village_story` varchar(500) DEFAULT NULL COMMENT '记录',
  `like_num` int(11) DEFAULT NULL COMMENT '点赞数',
  `create_date` date DEFAULT NULL COMMENT '创建记录时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`village_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `village` */

insert  into `village`(`village_id`,`village_name`,`village_address`,`village_info`,`village_logo`,`history_record`,`village_story`,`like_num`,`create_date`,`remark`) values (6,'良都','中山市良都','中山市良都中学位于人杰地灵、名人辈出的中山市重点侨乡——南区。学校初创于1956年，办学历史上经过三次合并和较大规模的布局调整，2003年由原良都初级中学和南区职业中学合并。','./photoes/1457963511671.jpg','中山市良都中学位于人杰地灵、名人辈出的中山市重点侨乡——南区。学校初创于1956年，办学历史上经过三次合并和较大规模的布局调整，2003年由原良都初级中学和南区职业中学合并。','中山市良都中学位于人杰地灵、名人辈出的中山市重点侨乡——南区。学校初创于1956年，办学历史上经过三次合并和较大规模的布局调整，2003年由原良都初级中学和南区职业中学合并。',5,'2016-03-12','2016-03-12'),(7,'马岭','中山市马岭','马岭社区位于南区中部，东与五桂山交界接壤，南至北台社区，西与八乡一山相隔，北邻沙涌社区，由原龙环、芦溪、羊寮、板桥、梅坪五个自然村组成，辖区面积约7.7平方公里，常住人口1600人，流动人口1400多人，于2006年“村改居”转为社区居民委员会。','./photoes/1457963524348.jpg','马岭社区位于南区中部，东与五桂山交界接壤，南至北台社区，西与八乡一山相隔，北邻沙涌社区，由原龙环、芦溪、羊寮、板桥、梅坪五个自然村组成，辖区面积约7.7平方公里，常住人口1600人，流动人口1400多人，于2006年“村改居”转为社区居民委员会。','马岭社区位于南区中部，东与五桂山交界接壤，南至北台社区，西与八乡一山相隔，北邻沙涌社区，由原龙环、芦溪、羊寮、板桥、梅坪五个自然村组成，辖区面积约7.7平方公里，常住人口1600人，流动人口1400多人，于2006年“村改居”转为社区居民委员会。',1,'2016-03-12','2016-03-12'),(8,'城南','中山城南','中山市南区城南社区居民委员会位于地址,交通便利，我们这里物产丰富，人杰地灵，百姓和谐。在上级部门的关怀下，这里干群关系融洽，社会稳定，经济发展，热情欢迎各级领导前来指导。也欢迎社会各界前来投资兴业。','./photoes/1457963535181.jpg','中山市南区城南社区居民委员会位于地址,交通便利，我们这里物产丰富，人杰地灵，百姓和谐。在上级部门的关怀下，这里干群关系融洽，社会稳定，经济发展，热情欢迎各级领导前来指导。也欢迎社会各界前来投资兴业。','中山市南区城南社区居民委员会位于地址,交通便利，我们这里物产丰富，人杰地灵，百姓和谐。在上级部门的关怀下，这里干群关系融洽，社会稳定，经济发展，热情欢迎各级领导前来指导。也欢迎社会各界前来投资兴业。',6,'2016-03-12','2016-03-12'),(9,'北溪','中山北溪','在碧波荡漾的北溪河畔，绿树掩映着一排树皮盖顶，竹木结构的小屋，迎风招展的彩旗给这个古朴雅致的场所增添了几分喜庆的氛围！元月一日，北溪水寨将正式对外试营业，走在青砖铺就的百米小街上，让人有了亲切的温馨感的同时，就有了品尝美食的渴望！','./photoes/1457963549243.jpg','在碧波荡漾的北溪河畔，绿树掩映着一排树皮盖顶，竹木结构的小屋，迎风招展的彩旗给这个古朴雅致的场所增添了几分喜庆的氛围！元月一日，北溪水寨将正式对外试营业，走在青砖铺就的百米小街上，让人有了亲切的温馨感的同时，就有了品尝美食的渴望！','在碧波荡漾的北溪河畔，绿树掩映着一排树皮盖顶，竹木结构的小屋，迎风招展的彩旗给这个古朴雅致的场所增添了几分喜庆的氛围！元月一日，北溪水寨将正式对外试营业，走在青砖铺就的百米小街上，让人有了亲切的温馨感的同时，就有了品尝美食的渴望！',1,'2016-03-12','2016-03-12');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
